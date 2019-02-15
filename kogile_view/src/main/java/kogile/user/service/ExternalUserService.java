package kogile.user.service;

import java.util.Map;

import kogile.user.domain.UserVO;

public interface ExternalUserService {
	public void exterMemRegister(UserVO user);
	public int getTotalMNoFromExterMem(Map<String, Object> interlinked_infoes);
	public boolean isKogileMember(Map<String, Object> interlinked_infoes);
	public UserVO getExterMemInfo(Map<String, Object> interlinked_infoes);
	public void updateAccessToken(Map<String, Object> interlinked_infoes, String access_token);
	public String getAccessToken(Map<String, Object> interlinked_infoes);
}
