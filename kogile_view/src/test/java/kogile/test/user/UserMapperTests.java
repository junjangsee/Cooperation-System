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
 * Mapper�׽�Ʈ. Mapper�� ������ �׽�Ʈ�� Service�׽�Ʈ���� �����Ѵ�.
 */
public class UserMapperTests {

	@Setter(onMethod_ = { @Autowired })
	private UserMapper mapper;

	/*
	 * �α��� Mapper �׽�Ʈ -ID/PW ��ġ�� �α��� ���� -��ġ�ϴ� ID�� ���� -pw�� ���� ����
	 */

	// 1) ID/PW��ġ�� �α��� ����
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
			log.info("�α��� ����");
			fail();
		} else {
			log.info("�α��� ����");
			log.info(userInfo);
		}
	}

	// 1) ID/PW����ġ�� �α��� ����
	@Ignore
	@Test
	public void loginFailtest() {

		// ȸ����ϰ� ��ġ���� �ʴ� ������
		Map<String, String> loginInfo = new HashMap<>();
		loginInfo.put("email", "sohyun");
		loginInfo.put("password", "sohyun");

		Map<String, String> userInfo = mapper.interMemLogin(loginInfo);

		if (userInfo != null) {
			log.info("�α��� ����");
			fail();
		} else {
			log.info("�α��� ����");
		}
	}

	@Ignore
	@Test
	public void idNotFoundtest() {
		String email = "NotFound@test.com";
		String res = mapper.isMemberEmail(email);
		if (res.equals("F")) {
			log.info("���������ʴ� email�Դϴ�.");
		} else {
			fail();
		}

	}

	// 2)��ġ�ϴ� ���̵� ����(���̵� Ȯ�ε� ����)
	@Ignore
	@Test
	public void idExistTest() {
		String email = "test@test.com";
		String res = mapper.isMemberEmail(email);
		if (res.equals("T")) {
			log.info("�����ϴ� email�Դϴ�.");
		} else {
			fail();
		}

	}

	/*
	 * ȸ������ Mapper �׽�Ʈ
	 */
	// 1)DB�� ID�� ��й�ȣ ����.
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

	// Hash �Լ� �׽�Ʈ - �������� �ؽ�������, ���� �ؽ����� �������� Ȯ��.
	@Ignore
	@Test
	public void Sha256HashTest() {
		String plainPw = "HwangSohee BaBo!";
		String answer = "42d15a54b9fcf17bca7d794ae77b800868e9b91e8436df1b6c00001cf9e03e30"; // ������
																							// �ؽ���

		String hashedPw = Sha256Hash.sha256(plainPw);

		if (!(hashedPw.equals(answer))) {
			log.info("HashTestFail!");
			fail();
		}
	}
	
	//����ó���� Service�׽�Ʈ�� �ش�!
	
	//��� �����ϴ� �н����带 �Է������� 
	@Ignore
	@Test
	public void passwordValidationAllPassTest() {
		String pw = "soheemon1!";
	}

	// 8-20�� �� �ش����� �ʴ� �н����带 �Է�������
	@Ignore
	@Test
	public void passwordValidationNTest() {
		String pw1 = "test1234";
	}
	
	// 3) EMAIL�� �������� ����
	// 4) PASSWORD�� �������� ����
	// 8-20�� �̳�
	// ���� �ȵ�.
	// �����ִ�
	// Ư������ �ִ�.
	// 5) NAME�� �������� ����
	// 2���̻� 20�� ����
	// Ư������ �ȵ�.

}
