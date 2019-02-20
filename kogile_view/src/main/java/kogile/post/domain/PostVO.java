package kogile.post.domain;

import java.sql.Date;
import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.Data;

@Data
public class PostVO {
	private int p_no;
	private String p_title;
	private int p_position;
	private int c_position;
	private int c_no;
	private String p_description;
	
	@JsonFormat(pattern="yyyy-MM-dd", timezone="Asia/Seoul")
	private Date p_dday;

}
