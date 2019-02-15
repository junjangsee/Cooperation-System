package kogile.label.mapper;

import java.util.List;

import kogile.label.domain.LabelVO;

public interface LabelMapper {
	public List<LabelVO> listLabel(int pjt_no);
	
}
