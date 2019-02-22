package kogile.board.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import kogile.board.domain.BoardVO;

public interface BoardMapper {

	// 게시글 삽입
	public int insertBoard(BoardVO board);
	
	// 게시글 전체 출력
	public List<BoardVO> listBoard(int pjt_no);
	
	// 게시글 페이징 처리 출력
//	public List<BoardVO> listBoardWithPaging(Criteria cri);
	
	// 게시글 상세 보기
	public BoardVO detailBoard(int b_no);
	
	// 게시글 수정
	public int updateBoard(BoardVO board);
	
	// 게시글 삭제
	public int deleteBoard(int b_no);
}
