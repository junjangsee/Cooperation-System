package kogile.checklist.service;

import java.util.List;

import kogile.checklist.domain.ChecklistVO;

public interface ChecklistService {
	
	public int register(ChecklistVO cvo);
	
//	public ChecklistVO get(int checklist_no);
	
	public int modify(ChecklistVO cvo);
	
	public int remove(int checklist_no);
	
	public List<ChecklistVO> getList(int p_no);
//	public List<ChecklistVO> getList();

	
}
