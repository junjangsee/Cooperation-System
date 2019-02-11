package kogile.checklist.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kogile.checklist.domain.ChecklistVO;
import kogile.checklist.mapper.ChecklistMapper;
import lombok.Setter;
import lombok.extern.log4j.Log4j;


@Log4j
@Service
public class ChecklistServiceImpl implements ChecklistService {

	@Setter(onMethod_= @Autowired)
	private ChecklistMapper mapper;
	
	@Override
	public void register(ChecklistVO cvo) {
		// TODO Auto-generated method stub

	}

	@Override
	public ChecklistVO get(Long checklist_no) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean modify(ChecklistVO cvo) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean remove(Long checklist_no) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public List<ChecklistVO> getList() {
		// TODO Auto-generated method stub
		return null;
	}

}
