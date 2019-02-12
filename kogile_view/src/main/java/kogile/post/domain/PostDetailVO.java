package kogile.post.domain;

import lombok.Data;

@Data
public class PostDetailVO {

	private int p_no;
	private String p_title;
	private int p_position;
	private int c_no;
	private String p_description;
	private String p_dday;

	private String check_title;
	private String r_date;
	private String r_contents;

}
