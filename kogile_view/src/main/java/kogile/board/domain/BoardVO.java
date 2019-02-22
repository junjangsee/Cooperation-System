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
	private String writer;
	private String fname;
	
	private Date regdate;
	private Date update_date; 
	
	private int pjt_no;
	
}
