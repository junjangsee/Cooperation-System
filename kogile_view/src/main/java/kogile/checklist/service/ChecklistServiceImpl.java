package kogile.checklist.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestParam;

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
		
		log.info("register..." + cvo);
		mapper.insertSelectKey(cvo);

	}

	@Override
	public ChecklistVO get(Long checklist_no) {
		// TODO Auto-generated method stub
		
		log.info("get..." + checklist_no);
		
		return mapper.read(checklist_no);
	}

	@Override
	public boolean modify(ChecklistVO cvo) {
		
		log.info("modify..." + cvo);
		
		return mapper.update(cvo) == 1;
	}

	@Override
	public boolean remove(Long checklist_no) {
		
		log.info("remove..." + checklist_no);
		
		return mapper.delete(checklist_no) == 1;
	}

	@Override
	public List<ChecklistVO> getList() {
		
		log.info("getList....");
		// TODO Auto-generated method stub
		return mapper.getList();
	}

}
