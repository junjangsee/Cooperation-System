package kogile.checklist.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import kogile.checklist.domain.ChecklistVO;
import kogile.checklist.domain.Criteria;
import kogile.checklist.domain.ListVO;

public interface ChecklistMapper {

	
	public int insert(ChecklistVO cvo);
	public int delete(int checklist_no);
	public int update(ChecklistVO cvo);
	public List<ChecklistVO> read(int p_no);
			
//	listLIs
	public int insertList(ListVO list);
	public List<ListVO> listList(int checklist_no);
	public int deleteList(int list_no);
	public int updateList(ListVO list);
	
	public int updateCheck(ListVO list);
	public int percent(int checklist_no);
}
