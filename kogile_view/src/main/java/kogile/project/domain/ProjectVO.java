package kogile.project.domain;

import java.util.Date;

import lombok.Data;

@Data
public class ProjectVO {
	private int pjt_no;
	private Date pjt_date;
	private String pjt_title;
	private int total_m_no;
	private String pjt_contents;
	
}
