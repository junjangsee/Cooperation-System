package kogile.checklist.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Select;

import kogile.checklist.domain.ChecklistVO;

public interface ChecklistMapper {

//	@Select("select * from checklist where checklist_no > 0")
	public List<ChecklistVO> getList();
	
	public void insert(ChecklistVO cvo);
	
	public void insertSelectKey(ChecklistVO cvo);
	
	public ChecklistVO read(Long checklist_no);
	
	public int delete(Long checklist_no);
	
	public int update(ChecklistVO cvo);
	
	
}
