package kogile.reply.mapper;

import java.util.List;

import kogile.project.domain.UserVO;
import kogile.reply.domain.ReplyVO;

public interface ReplyMapper {
	public int insertReply (ReplyVO vo);
	
	public int deleteReply (int r_no);
	
	public int updateReply (ReplyVO vo);
	
	public List<ReplyVO> replyList (int p_no);
	
	public List<ReplyVO> replyList2 (int p_no);
	
	public UserVO writer_info (int total_m_no);
}
