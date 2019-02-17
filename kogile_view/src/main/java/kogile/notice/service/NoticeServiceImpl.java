package kogile.notice.service;

import java.util.List;

import org.springframework.stereotype.Service;

import kogile.notice.domain.NoticeVO;
import kogile.notice.mapper.NoticeMapper;
import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j;

@Log4j
@Service
@AllArgsConstructor
public class NoticeServiceImpl implements NoticeService {

	private NoticeMapper mapper;
	
	@Override
	public List<NoticeVO> notice(int total_m_no) {
		log.info("notice..........");
		return mapper.notice(total_m_no);
	}

}
