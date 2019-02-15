package kogile.user.domain;

import org.springframework.stereotype.Repository;

import lombok.Data;
import lombok.ToString;

/*
 * EXTER_M_NO number
 * EXTER_MEM_NAME varchar
 * EXTER_M_EMAIL
 * INTERLINKED_INFO_TYPE VARCHAR
 * INTERLINKED_INFO NUMBER
 */

/*
 * 내부멤버인 경우에 total_m_no, isInterMem, email, name을 가집니다.
 * 외부멤버는 email을 제외한 나머지 값들을 가집니다.
 */
@Data
@ToString
public class UserVO {
	private int total_m_no;
	private boolean isInterMem; // 외부멤버인지 아닌지
	private String email;
	private String name;
	private long interlinked_info; //카카오 자체 회원번호
	private String interlinked_info_type; //카카오인지..
	private String access_token;
					
}
