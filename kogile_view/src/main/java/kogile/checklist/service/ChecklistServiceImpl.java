package kogile.checklist.service;

import org.springframework.stereotype.Service;

import kogile.checklist.domain.ChecklistVO;
import kogile.checklist.mapper.ChecklistMapper;
import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j;


@Log4j
@Service
@AllArgsConstructor
public class ChecklistServiceImpl implements ChecklistService {

	private ChecklistMapper mapper;
	
	@Override
	public void register(ChecklistVO cvo) {
		
		log.info("register..." + cvo);
		
		mapper.insert(cvo);
		
		
	}

}
