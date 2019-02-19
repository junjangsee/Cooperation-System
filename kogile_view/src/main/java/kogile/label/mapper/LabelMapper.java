package kogile.label.mapper;

import java.util.List;

import kogile.label.domain.LabelVO;

public interface LabelMapper {
	public List<LabelVO> listLabel(int pjt_no);
	public int insertLabel(LabelVO label);
	public LabelVO detailLabel(int label_no);
	public int deleteLabel(int label_no);
	public int updateLabel(LabelVO label);
	
	//label info 사용
	public List<LabelVO> listLabelInfo(int p_no);
	public int selectLabel(LabelVO label);
	public int cancelLabel(LabelVO label_info);
}
