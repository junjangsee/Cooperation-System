package kogile.post.domain;

import java.sql.Date;



import lombok.Data;

@Data
public class PostVO {
	private int p_no;
	private String p_title;
	private int p_position;
	private int c_no;
	private String p_description;
	private Date p_dday;
	
	private int c_position;
	
	private String date;

}
