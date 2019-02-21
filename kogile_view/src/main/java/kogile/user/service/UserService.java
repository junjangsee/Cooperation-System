package kogile.user.service;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kogile.user.domain.UserVO;

public interface UserService {
	public String isMemberEmail(String email);
	public void interMemRegister(Map<String, String> userInfo);
	public void interMemLogin(Map<String, String> userInfo, HttpServletRequest request,HttpServletResponse response);
}
