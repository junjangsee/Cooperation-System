package kogile.user.service;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kogile.user.domain.UserVO;
import kogile.user.mapper.ExternalUserMapper;
import lombok.Setter;

@Service
public class KakaoUserService implements ExternalUserService {
	
	@Setter(onMethod_={@Autowired})
	private ExternalUserMapper mapper;
	
	static final String INTERLINKEDTYPE = "KAKAO";
	@Override
	public void exterMemRegister(UserVO user) {
		user.setInterlinked_info_type(INTERLINKEDTYPE);
		mapper.exterMemRegister(user);
	}

	@Override
	public int getTotalMNoFromExterMem(Map<String, Object> interlinked_infoes) {
		interlinked_infoes.put("interlinked_info_type", INTERLINKEDTYPE);
		return mapper.getTotalMNoFromExterMem(interlinked_infoes);
	}

	//회원일때 T 회원이 아닐때 F
	@Override
	public boolean isKogileMember(Map<String, Object> interlinked_infoes) {
		interlinked_infoes.put("interlinked_info_type", INTERLINKEDTYPE);
		System.out.println(interlinked_infoes);
		return mapper.isKogileMember(interlinked_infoes).equals("T");
	}

	@Override
	public UserVO getExterMemInfo(Map<String, Object> interlinked_infoes) {
		interlinked_infoes.put("interlinked_info_type", INTERLINKEDTYPE);
		UserVO user = mapper.getExterMemInfo(interlinked_infoes);
		user.setInterMem(false);
		user.setTotal_m_no(getTotalMNoFromExterMem(interlinked_infoes));
		return user;
	}

	@Override
	public void updateAccessToken(Map<String, Object> interlinked_infoes, String access_token) {
		interlinked_infoes.put("interlinked_info_type", INTERLINKEDTYPE);
		interlinked_infoes.put("access_token", access_token);
		mapper.updateAccessToken(interlinked_infoes);
	}

	@Override
	public String getAccessToken(Map<String, Object> interlinked_infoes) {
		interlinked_infoes.put("interlinked_info_type", INTERLINKEDTYPE);
		return mapper.getAccessToken(interlinked_infoes);
	}

}
