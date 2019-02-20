package kogile.reply.service;

import java.util.List;

import org.springframework.stereotype.Service;

import kogile.invite.domain.InviteVO;
import kogile.project.domain.UserVO;
import kogile.reply.domain.ReplyVO;
import kogile.reply.domain.TagVO;
import kogile.reply.mapper.ReplyMapper;
import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j;

@Log4j
@Service
@AllArgsConstructor
public class ReplyServiceImpl implements ReplyService {

	private ReplyMapper mapper;
	
	@Override
	public int registerReply(ReplyVO vo) {
		
		return mapper.insertReply(vo);
	}

	@Override
	public int removeReply(int r_no) {
		
		return mapper.deleteReply(r_no);
	}

	@Override
	public int modifyReply(ReplyVO vo) {
		
		return mapper.updateReply(vo);
	}

	@Override
	public List<ReplyVO> replyList(int p_no) {
		List<ReplyVO> list = mapper.replyList(p_no);
		List<ReplyVO> list2 = mapper.replyList2(p_no);
		list.addAll(list2);
		return list;
	}

	@Override
	public int writer_info(InviteVO invite) {
		
		return mapper.writer_info(invite);
	}

	@Override
	public int registerTag(TagVO vo) {
		
		return mapper.insertTag(vo);
	}

	@Override
	public List<TagVO> tagList(int pjt_no) {
		List<TagVO> list = mapper.tagMember(pjt_no);
		List<TagVO> list2 = mapper.tagMember2(pjt_no);
		list.addAll(list2);
		return list;
	}

	@Override
	public int replyNum() {
		
		return mapper.replyNum();
	}

	@Override
	public int insertTagNotice(TagVO vo) {
		
		return mapper.insertTagNotice(vo);
	}

	@Override
	public int tagNum() {
		
		return mapper.tagNum();
	}



}
