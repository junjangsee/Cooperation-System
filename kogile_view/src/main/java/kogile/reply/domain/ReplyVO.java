package kogile.reply.domain;

import java.util.Date;

import lombok.Data;

@Data
public class ReplyVO {
	private int r_no;
	private String r_contents;
	private Date r_date;
	private int p_no;
	private int info_no;
	
	private String name;
	private String taged_name;
	
}
