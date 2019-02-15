package kogile.checklist.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import kogile.checklist.domain.ChecklistVO;
import kogile.checklist.domain.Criteria;

public interface ChecklistMapper {

	
	public int insert(ChecklistVO cvo);
	public ChecklistVO read(int checklist_no);
	public int delete(int checklist_no);
	public int update(ChecklistVO cvo);
	
	public List<ChecklistVO> getListWithPaging(
			@Param("cri") Criteria cri,
			@Param("p_no") int p_no);
			
}
