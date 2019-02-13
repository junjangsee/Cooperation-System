package kogile.invite.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
public class SearchListVO {
	
	private int no; //total_m_no
	private String name; //유저 이름
	private String mail; //이메일
	
}
