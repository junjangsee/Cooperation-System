package kogile.checklist.domain;

import lombok.Data;

@Data
public class ListVO {
	
	private Long list_no;
	private String list_info;
	private Long checked;
	private Long checklist_no;
	
	
}
