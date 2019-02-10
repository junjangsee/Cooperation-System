package kogile.post.domain;

import lombok.Data;

@Data
public class PostVO {
	private int p_no;
	private String p_title;
	private int p_position;
	private int c_no;
	private String p_description;
	private String p_dday;

}
