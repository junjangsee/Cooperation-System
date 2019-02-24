package kogile.notice.domain;

import lombok.Data;

@Data
public class NoticeVO {

	private int notice_no;
	private int invite_no;
	private int tag_no;
	private String ntc_cont;
	private String day;
	private int total_m_no;
	private int flag;
}
