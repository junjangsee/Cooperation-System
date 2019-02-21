package kogile.board.mapper;

import java.util.List;

import kogile.board.domain.BoardVO;

public interface BoardMapper {

	// 게시글 삽입
	public int insertBoard(BoardVO board);
	
	// 게시글 전체 출력
	public List<BoardVO> listBoard(int pjt_no);
	
	// 게시글 상세 보기
	public BoardVO detailBoard(BoardVO board);
	
	// 게시글 수정
	public int updateBoard(BoardVO board);
	
	// 게시글 삭제
	public int deleteBoard(BoardVO board);
}
