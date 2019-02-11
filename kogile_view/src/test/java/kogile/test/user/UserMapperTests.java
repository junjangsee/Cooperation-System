package kogile.test.user;

import static org.junit.Assert.*;

import java.util.HashMap;
import java.util.Map;

import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import kogile.user.mapper.UserMapper;
import kogile.user.service.Sha256Hash;
import lombok.Setter;
import lombok.extern.log4j.Log4j;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("file:src/main/webapp/WEB-INF/spring/root-context.xml")
@Log4j

/*
 * Mapper테스트. Mapper를 조합한 테스트는 Service테스트에서 진행한다.
 */
public class UserMapperTests {

	@Setter(onMethod_ = { @Autowired })
	private UserMapper mapper;

	/*
	 * 로그인 Mapper 테스트 -ID/PW 일치시 로그인 성공 -일치하는 ID가 없음 -pw가 맞지 않음
	 */

	// 1) ID/PW일치시 로그인 성공
	@Ignore
	@Test
	public void loginSuccesstest() {
		// select email, name from intermem- where id = #{id} AND password =
		// #{password};
		Map<String, String> loginInfo = new HashMap<>();
		loginInfo.put("email", "ppoppy@kogile.com");
		loginInfo.put("password", "21341234");

		Map<String, String> userInfo = mapper.interMemLogin(loginInfo);

		if (userInfo == null) {
			log.info("로그인 실패");
			fail();
		} else {
			log.info("로그인 성공");
			log.info(userInfo);
		}
	}

	// 1) ID/PW불일치시 로그인 실패
	@Ignore
	@Test
	public void loginFailtest() {

		// 회원목록과 일치하지 않는 데이터
		Map<String, String> loginInfo = new HashMap<>();
		loginInfo.put("email", "sohyun");
		loginInfo.put("password", "sohyun");

		Map<String, String> userInfo = mapper.interMemLogin(loginInfo);

		if (userInfo != null) {
			log.info("로그인 성공");
			fail();
		} else {
			log.info("로그인 실패");
		}
	}

	@Ignore
	@Test
	public void idNotFoundtest() {
		String email = "NotFound@test.com";
		String res = mapper.isMemberEmail(email);
		if (res.equals("F")) {
			log.info("존재하지않는 email입니다.");
		} else {
			fail();
		}

	}

	// 2)일치하는 아이디가 있음(아이디만 확인된 상태)
	@Ignore
	@Test
	public void idExistTest() {
		String email = "test@test.com";
		String res = mapper.isMemberEmail(email);
		if (res.equals("T")) {
			log.info("존재하는 email입니다.");
		} else {
			fail();
		}

	}

	/*
	 * 회원가입 Mapper 테스트
	 */
	// 1)DB에 ID랑 비밀번호 넣음.
	@Ignore
	@Test
	public void registerTest() {

		Map<String, String> registerInfo = new HashMap<>();
		registerInfo.put("email", "sohyun@naver.com");
		registerInfo.put("name", "sohyun");
		registerInfo.put("password", "@sohyun2019");

		int res = mapper.register(registerInfo);
		if (res < 0) {
			log.info("register Fail!");
			fail();
		}
	}

	// Hash 함수 테스트 - 같은평문을 해싱했을때, 같은 해쉬값이 나오는지 확인.
	@Ignore
	@Test
	public void Sha256HashTest() {
		String plainPw = "HwangSohee BaBo!";
		String answer = "42d15a54b9fcf17bca7d794ae77b800868e9b91e8436df1b6c00001cf9e03e30"; // 위에꺼
																							// 해쉬값

		String hashedPw = Sha256Hash.sha256(plainPw);

		if (!(hashedPw.equals(answer))) {
			log.info("HashTestFail!");
			fail();
		}
	}
	
	//예외처리는 Service테스트에 해당!
	
	//모두 만족하는 패스워드를 입력했을때 
	@Ignore
	@Test
	public void passwordValidationAllPassTest() {
		String pw = "soheemon1!";
	}

	// 8-20자 에 해당하지 않는 패스워드를 입력했을때
	@Ignore
	@Test
	public void passwordValidationNTest() {
		String pw1 = "test1234";
	}
	
	// 3) EMAIL이 적합하지 않음
	// 4) PASSWORD가 적합하지 않음
	// 8-20자 이내
	// 공백 안됨.
	// 숫자있니
	// 특수문자 있니.
	// 5) NAME이 적합하지 않음
	// 2자이상 20자 이하
	// 특수문자 안됨.

}
