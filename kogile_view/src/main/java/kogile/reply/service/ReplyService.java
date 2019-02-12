package kogile.reply.service;

import java.util.List;

import kogile.reply.domain.ReplyVO;

public interface ReplyService {
	
	public int registerReply (ReplyVO vo);
	
	public int removeReply (long r_no);
	
	public int modifyReply (ReplyVO vo);
	
	public List<ReplyVO> replyList (long p_no);

}
