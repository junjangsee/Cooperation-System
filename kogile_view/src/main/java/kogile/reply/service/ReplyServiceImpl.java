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
	public int register(ReplyVO vo) {
		
		return mapper.insertReply(vo);
	}

	@Override
	public int remove(ReplyVO vo) {
		
		return mapper.deleteReply(vo);
	}

	@Override
	public int modify(ReplyVO vo) {
		
		return mapper.updateReply(vo);
	}

	@Override
	public List<ReplyVO> list(long p_no) {
		List<ReplyVO> list = mapper.replyList(p_no);
		List<ReplyVO> list2 = mapper.replyList2(p_no);
		list.addAll(list2);
		return list;
	}


}
