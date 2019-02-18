package kogile.user.mapper;

import java.util.Map;

public interface UserMapper {
	public Map<String, String> interMemLogin(Map<String, String> loginInfo);
	public String isMemberEmail(String email);
	
	public int register(Map<String, String> registerInfo);
}
