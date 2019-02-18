package kogile.user.mapper;

import java.util.Map;

import kogile.user.domain.UserVO;

public interface UserMapper {
	public UserVO interMemLogin(Map<String, String> loginInfo);
	public String isMemberEmail(String email);
	public int getTotalMNoFromInterMem(int member_no);
	public int register(Map<String, String> registerInfo);
}
