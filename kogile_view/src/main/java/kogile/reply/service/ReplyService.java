package kogile.reply.service;

import java.util.List;

import kogile.invite.domain.InviteVO;
import kogile.project.domain.UserVO;
import kogile.reply.domain.ReplyVO;
import kogile.reply.domain.TagVO;

public interface ReplyService {
	
	public int registerReply (ReplyVO vo);
	
	public int removeReply (int r_no);
	
	public int modifyReply (ReplyVO vo);
	
	public List<ReplyVO> replyList (int p_no);
	
	public int writer_info (InviteVO invite);
	
	public int registerTag (TagVO vo);
	
	public List<TagVO> tagList(int pjt_no);
	
	public int replyNum();
	
	public int insertTagNotice(TagVO vo);
	
	public int tagNum();
	
	
}
