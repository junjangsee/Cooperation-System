package kogile.reply.mapper;

import java.util.List;

import kogile.invite.domain.InviteVO;
import kogile.project.domain.UserVO;
import kogile.reply.domain.ReplyVO;
import kogile.reply.domain.TagVO;

public interface ReplyMapper {
	public int insertReply (ReplyVO vo);
	
	public int deleteReply (int r_no);
	
	public int updateReply (ReplyVO vo);
	
	public List<ReplyVO> replyList (int p_no);
	
	public List<ReplyVO> replyList2 (int p_no);
	
	public int writer_info (InviteVO invite);
	
	public int insertTag(TagVO vo);
	
	public int replyNum();
	
	public List<TagVO> tagMember(int pjt_no);
	
	public List<TagVO> tagMember2(int pjt_no);
	
	public int insertTagNotice(TagVO vo);
	
	public int tagNum();
	
}
