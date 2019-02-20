package kogile.user.controller;

import java.util.Enumeration;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.google.gson.internal.LinkedTreeMap;

import kogile.user.domain.UserVO;
import kogile.user.service.KakaoUserService;
import kogile.user.service.RestTemplateService;
import lombok.Setter;

@Controller
@RequestMapping("/login/external")
public class ExterUserController {

	private RestTemplateService restService = RestTemplateService.getInstance();
	@Setter(onMethod_ = { @Autowired })
	private KakaoUserService service;

	@GetMapping("/kakaoOauth")
	public String kakaoOauth(@RequestParam("code") String code, HttpServletRequest request) {

		HttpSession session = request.getSession();
		String command = (String) session.getAttribute("command");
		String accessToken = restService.getAccessToken(code);

		String redirectPath = "";
		switch (command) {

		case "register":
			redirectPath = "/login/external/registerKogileWithKakao/" + accessToken;
			break;
		case "login":
			redirectPath = "/login/external/loginKogileWithKakao/" + accessToken;
			break;
		default:
			break;
		}
		
		session.removeAttribute("command");
		return "redirect:" + redirectPath;
	}

	// 카카오톡으로 로그인하게 하기. 이쪽으로 다이렉트로 오면 안됩니다.
	@GetMapping("/kakaoLogin")
	public String kakaoLogin() {

		return "redirect:https://kauth.kakao.com/oauth/authorize?" + "client_id=e16764ac8ecc77d571c58088d37b119b&"
				+ "redirect_uri=http://localhost:8082/login/external/kakaoOauth&" + "response_type=code";
	}

	@GetMapping("/loginKogileWithKakao")
	public String loginKogileWithKakao(HttpServletRequest request) {
		HttpSession session = request.getSession();
		session.setAttribute("command", "login");
		return "redirect:/login/external/kakaoLogin";
	}

	@GetMapping("/loginKogileWithKakao/{accessToken}")
	public String loginKogileWithKakao(@PathVariable("accessToken") String accessToken, HttpServletRequest request) {
		HttpSession session = request.getSession();
		Enumeration<String> attributeNames = session.getAttributeNames();

		while (attributeNames.hasMoreElements()) {
			if (attributeNames.nextElement().equals("user")) {
				System.out.println("이미 로그인이 되어있네요...");
				return "redirect:/kogile/startPage";
			}
		}

		Map<String, Object> res = restService.getKakaoMemInfo(accessToken);
		long kakaoId = Double.valueOf((double) res.get("id")).longValue();

		Map<String, Object> interlinked_info = new HashMap<>();
		interlinked_info.put("interlinked_info", kakaoId);

		// true=회원이다 false=회원이 아니다.
		if (service.isKogileMember(interlinked_info) == true) {
			int total_m_no = service.getTotalMNoFromExterMem(interlinked_info);

			UserVO user = service.getExterMemInfo(interlinked_info);
			user.setTotal_m_no(total_m_no);
			user.setInterMem(false);
			session.setAttribute("user", user);

			// AccessToken 갱신
			service.updateAccessToken(interlinked_info, accessToken);
		} else {
			System.out.println("가입이 안되어있네요....");
			return "redirect:/login/external/registerKogileWithKakao";
		}

		return "redirect:/kogile/startPage";
	}

	@GetMapping("/registerKogileWithKakao")
	public String registerKogileWithKakao(HttpServletRequest request) {
		HttpSession session = request.getSession();
		session.setAttribute("command", "register");

		System.out.println("파라미터 없는경우.");
		return "redirect:/login/external/kakaoLogin";
	}

	@GetMapping("/registerKogileWithKakao/{accessToken}")
	public String registerKogileWithKakao(@PathVariable("accessToken") String accessToken) {

		// kakao 사용자 정보 가져오기. 카카오톡에 로그인만해도 자동가입됩니다.
		Map<String, Object> res = restService.getKakaoMemInfo(accessToken);
		long kakaoId = Double.valueOf((double) res.get("id")).longValue();
		// kakaoId + kakao로 intermem에 중복되는 내용이 있는지 확인합니다.
		Map<String, Object> interlinked_info = new HashMap<>();
		interlinked_info.put("interlinked_info", kakaoId);

		// true=회원이다 false=회원이 아니다.
		if (service.isKogileMember(interlinked_info) == false) {
			LinkedTreeMap<String, String> properties = (LinkedTreeMap<String, String>) res.get("properties");
			LinkedTreeMap<String, String> kakao_account = (LinkedTreeMap<String, String>) res.get("kakao_account");
			String nickName = properties.get("nickname");
			String email = kakao_account.get("email");

			UserVO user = new UserVO();
			user.setEmail(email);
			user.setInterlinked_info(kakaoId);
			user.setName(nickName);
			user.setAccess_token(accessToken);
			System.out.println(user);
			service.exterMemRegister(user);
			System.out.println("가입이 완료되었습니다.");
			return "redirect:/login/external/loginKogileWithKakao/" + accessToken;
		} else {
			System.out.println("이미 가입된 계정입니다.");
			return "redirect:/login/external/loginKogileWithKakao/" + accessToken;
		}
	}
	
	@GetMapping("/logoutKogileWithKakao")
	public String logoutKogileWithKakao(HttpServletRequest request) {
		HttpSession session = request.getSession();
		Enumeration<String> attributeNames = session.getAttributeNames();

		boolean isLogined = false;
		long kakaoId=0;

		while (attributeNames.hasMoreElements()) {
			if (attributeNames.nextElement().equals("user")) {
				UserVO user = (UserVO) session.getAttribute("user");
				kakaoId = user.getInterlinked_info();
				String type = user.getInterlinked_info_type();
				isLogined = true;
			}
		}

		if (isLogined == false) {
			return "redirect:/login/external/loginKogileWithKakao";
		}
		Map<String, Object> interlinked_info = new HashMap<>();
		interlinked_info.put("interlinked_info", kakaoId);

		String accessToken = service.getAccessToken(interlinked_info);
		restService.logOut(accessToken); // kakao에서 로그아웃

		session = request.getSession();
		session.invalidate();// kogile에서 로그아웃.

		return "redirect:/kogile/login";
	}
	
	// public String withdrawalKogileWithKakao(HttpServletRequest request) {
	// restService.withdrawal(); // 카카오에서 탈퇴
	// kakaoService.kakaoMemWithdrawal(kakaoId); //kogile에서 DB 정보 지우기.
	// return "redirect:/kogile/startPage";
	// }
}