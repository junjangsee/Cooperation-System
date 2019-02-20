package kogile.label.service;

import java.util.List;

import org.springframework.stereotype.Service;

import kogile.label.domain.LabelVO;
import kogile.label.mapper.LabelMapper;
import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class LabelServiceImpl implements LabelService {

	private LabelMapper mapper;
	
	@Override
	public List<LabelVO> listLabel(int pjt_no) {
		List<LabelVO> list = mapper.listLabel(pjt_no); 
		return list;
	}

	@Override
	public void insertLabel(LabelVO label) {
		mapper.insertLabel(label);
	}

	@Override
	public LabelVO detailLabel(int label_no) {
		LabelVO label = mapper.detailLabel(label_no);
		return label;
	}

	@Override
	public int deleteLabel(int label_no) {
		return mapper.deleteLabel(label_no);
	}

	@Override
	public int updateLabel(LabelVO label) {
		return mapper.updateLabel(label);
	}

	@Override
	public List<LabelVO> listLabelInfo(int p_no) {
		List<LabelVO> list = mapper.listLabelInfo(p_no);
		return list;
	}

	@Override
	public int selectLabel(LabelVO label) {
		return mapper.selectLabel(label);
	}

	@Override
	public int cancelLabel(LabelVO label_info) {
		
		return mapper.cancelLabel(label_info);
	}
	
	

}
