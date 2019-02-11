package kogile.checklist.service;

import java.util.List;

import kogile.checklist.domain.ChecklistVO;

public interface ChecklistService {
	
	public void register(ChecklistVO cvo);
	
	public ChecklistVO get(Long checklist_no);
	
	public boolean modify(ChecklistVO cvo);
	
	public boolean remove(Long checklist_no);
	
	public List<ChecklistVO> getList();

}
