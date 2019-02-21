package kogile.user.service;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kogile.user.domain.UserVO;
import kogile.user.mapper.UserMapper;
import lombok.Data;
import lombok.Setter;

@Service
@Data
public class UserServiceInpl implements UserService {

	@Setter(onMethod_ = { @Autowired })
	private UserMapper mapper;

	@Override
	public void interMemRegister(Map<String, String> userInfo) {
		String encrypedPw = Sha256Hash.sha256(userInfo.get("password"));
		userInfo.replace("password", encrypedPw);

		mapper.register(userInfo);
	}

	// 로그인
	@Override
	public void interMemLogin(Map<String, String> userInfo, HttpServletRequest request,
			HttpServletResponse response) {
		String encrypedPw = Sha256Hash.sha256(userInfo.get("password"));
		userInfo.replace("password", encrypedPw);

		UserVO user = null;
		System.out.println(userInfo);

		try {
			String email = userInfo.get("email");
			if (mapper.isMemberEmail(email).equals("F")) { // NULL이면 F, NULL이아니면 T
				System.out.println("ID가 존재하지 않습니다.");
				throw new NullPointerException();
			}

			//ID는 일치하지만, 비밀번호가 틀린경우
			user = mapper.interMemLogin(userInfo);
			
			int total_m_no = mapper.getTotalMNoFromInterMem(user.getIntermemNo());
			user.setTotal_m_no(total_m_no);
			user.setInterMem(true);
			System.out.println(user);

			HttpSession session = request.getSession();
			session.setAttribute("user", user);
		} catch (NullPointerException e) {
			e.printStackTrace();
			response.setStatus(404);
			System.out.println("유저를 찾을 수 없습니다!");
		}
	}

	/*
	 * 이미 가입된 이메일이면 T 없으면 F
	 */
	@Override
	public String isMemberEmail(String email) {
		return mapper.isMemberEmail(email).toString();
	}

}
