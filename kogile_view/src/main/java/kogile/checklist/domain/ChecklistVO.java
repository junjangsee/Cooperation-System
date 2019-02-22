package kogile.checklist.domain;

import lombok.Data;

@Data
public class ChecklistVO {
	
	private int checklist_no;
	private String check_title;
	private int p_no;
	
	//checklist 완료율
	private int completePercent;
}
