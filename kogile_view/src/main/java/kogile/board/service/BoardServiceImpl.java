package kogile.board.service;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.SessionAttributes;

import kogile.board.domain.BoardVO;
import kogile.board.mapper.BoardMapper;
import kogile.invite.domain.InviteVO;
import kogile.reply.mapper.ReplyMapper;
import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
@SessionAttributes("total_m_no")
public class BoardServiceImpl implements BoardService {
	
	private BoardMapper mapper;

	@Override
	public int insertBoard(BoardVO board) {
		return mapper.insertBoard(board);
	}

	@Override
	public List<BoardVO> listBoard(int pjt_no) {

		return mapper.listBoard(pjt_no);
	}

	@Override
	public BoardVO detailBoard(int b_no) {
		
		return mapper.detailBoard(b_no);
	}

	@Override
	public int updateBoard(BoardVO board) {

		return mapper.updateBoard(board);
	}

	@Override
	public int deleteBoard(int b_no) {

		return mapper.deleteBoard(b_no);
	}


//	@Override
//	public List<BoardVO> listBoardWithPaging(Criteria cri) {
//
//		return mapper.listBoardWithPaging(cri);
//	}

}
