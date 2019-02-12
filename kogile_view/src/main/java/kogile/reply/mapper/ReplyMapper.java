package kogile.reply.mapper;

import java.util.List;

import kogile.reply.domain.ReplyVO;

public interface ReplyMapper {
	public int insertReply (ReplyVO vo);
	
	public int deleteReply (long r_no);
	
	public int updateReply (ReplyVO vo);
	
	public List<ReplyVO> replyList (long p_no);
	
	public List<ReplyVO> replyList2 (long p_no);
}
