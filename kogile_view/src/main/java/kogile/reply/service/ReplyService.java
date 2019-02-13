package kogile.reply.service;

import java.util.List;

import kogile.project.domain.UserVO;
import kogile.reply.domain.ReplyVO;

public interface ReplyService {
	
	public int registerReply (ReplyVO vo);
	
	public int removeReply (int r_no);
	
	public int modifyReply (ReplyVO vo);
	
	public List<ReplyVO> replyList (int p_no);
	
	public UserVO writer_info (int total_m_no);

}
