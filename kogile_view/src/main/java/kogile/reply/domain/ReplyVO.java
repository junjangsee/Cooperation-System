package kogile.reply.domain;

import java.util.Date;

import lombok.Data;

@Data
public class ReplyVO {
	private long r_no;
	private String r_contents;
	private Date r_date;
	private long p_no;
	private long info_no;
	
	private String name;
	
}
