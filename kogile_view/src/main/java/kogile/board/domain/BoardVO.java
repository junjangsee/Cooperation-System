package kogile.board.domain;

import java.sql.Date;

import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.Data;

@Data
public class BoardVO {

	private int b_no;
	private String b_title;
	private String b_content;
	private int info_no;
	private String fname;
	
	@JsonFormat(pattern="yy-MM-dd", timezone="Asia/Seoul")
	private Date regdate;
	
	@JsonFormat(pattern="yy-MM-dd", timezone="Asia/Seoul")
	private Date update_date; 
	
	private int pjt_no;
}
