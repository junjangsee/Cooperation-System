package kogile.user.mapper;

import java.util.Map;

import org.apache.ibatis.annotations.Select;

import kogile.user.domain.UserVO;

public interface ExternalUserMapper {
	// 세션에 회원정보 넣어줄때 isInterMem false로 넣어줘야 함.
	public void exterMemRegister(UserVO user);

	// 외부자체ID넘버와 외부연동서비스 이름을 조합해서 Total회원넘버 가져옴.
	public int getTotalMNoFromExterMem(Map<String, Object> test);

	// 가입된 외부회원인지 조회한다.
	public String isKogileMember(Map<String, Object> interlinked_infoes);

	// 회원정보를 가져온다.
	public UserVO getExterMemInfo(Map<String, Object> interlinked_infoes);

	// accessToken을 업데이트 한다.
	public void updateAccessToken(Map<String, Object> interlinked_infoes);

	@Select("select ACCESS_TOKEN from EXTERNAL_M_INFO where interlinked_info_type = #{interlinked_info_type} AND interlinked_info = #{interlinked_info}")
	public String getAccessToken(Map<String, Object> interlinked_infoes);
}
