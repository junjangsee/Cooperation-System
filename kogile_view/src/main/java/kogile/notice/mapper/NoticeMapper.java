package kogile.notice.mapper;

import java.util.List;

import kogile.notice.domain.NoticeVO;

public interface NoticeMapper {

	public List<NoticeVO> notice(int total_m_no);
	
	public int ntcUpdate(NoticeVO notice);
	
}
