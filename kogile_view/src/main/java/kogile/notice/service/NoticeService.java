package kogile.notice.service;

import java.util.List;

import kogile.notice.domain.NoticeVO;

public interface NoticeService {

	public List<NoticeVO> notice(int total_m_no);
	
	public int ntcUpdate(NoticeVO notice);
	
}
