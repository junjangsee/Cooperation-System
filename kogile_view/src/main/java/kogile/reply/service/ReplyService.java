package kogile.reply.service;

import java.util.List;

import kogile.reply.domain.ReplyVO;

public interface ReplyService {
	
	public int register (ReplyVO vo);
	
	public int remove (ReplyVO vo);
	
	public int modify (ReplyVO vo);
	
	public List<ReplyVO> list (long p_no);

}
