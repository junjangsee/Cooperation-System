package kogile.reply.service;

import java.util.List;

import org.springframework.stereotype.Service;

import kogile.reply.domain.ReplyVO;
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
	public int removeReply(long r_no) {
		
		return mapper.deleteReply(r_no);
	}

	@Override
	public int modifyReply(ReplyVO vo) {
		
		return mapper.updateReply(vo);
	}

	@Override
	public List<ReplyVO> replyList(long p_no) {
		List<ReplyVO> list = mapper.replyList(p_no);
		List<ReplyVO> list2 = mapper.replyList2(p_no);
		list.addAll(list2);
		return list;
	}


}
