package kogile.board.service;

import java.util.List;

import org.springframework.stereotype.Service;

import kogile.board.domain.BoardVO;
import kogile.board.mapper.BoardMapper;
import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
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
	public BoardVO detailBoard(BoardVO board) {
		
		return mapper.detailBoard(board);
	}

	@Override
	public int updateBoard(BoardVO board) {

		return mapper.updateBoard(board);
	}

	@Override
	public int deleteBoard(BoardVO board) {

		return mapper.deleteBoard(board);
	}

}
