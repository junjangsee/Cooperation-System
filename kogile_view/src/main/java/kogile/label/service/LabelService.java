package kogile.label.service;

import java.util.List;

import kogile.label.domain.LabelVO;

public interface LabelService {
	public List<LabelVO> listLabel(int pjt_no);
	public void insertLabel(LabelVO label);
	public LabelVO detailLabel(int label_no);

}
