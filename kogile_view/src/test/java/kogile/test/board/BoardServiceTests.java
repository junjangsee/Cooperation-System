package kogile.test.board;

import static org.junit.Assert.*;

import java.sql.Date;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import kogile.board.domain.BoardVO;
import kogile.board.service.BoardService;
import lombok.Setter;
import lombok.extern.log4j.Log4j;

@RunWith(SpringJUnit4ClassRunner.class)
@Log4j
@ContextConfiguration("file:src/main/webapp/WEB-INF/spring/root-context.xml")
public class BoardServiceTests {
	
	@Setter(onMethod_ = @Autowired)
	private BoardService service;

//	@Test
//	public void InsertTest() {
//		
//		BoardVO board = new BoardVO();
//		
//		board.setB_content("내용1111");
//		board.setB_title("제목1111");
//		board.setFname("작성자1111");
//		board.setInfo_no(1);
//		board.setRegdate(new Date(2019/02/02));
//		board.setUpdate_date(new Date(2019/03/03));
//		board.setPjt_no(1);
//		
//		service.insertBoard(board);
//	}
	
//	@Test
//	public void detailTest() {
//		
//		BoardVO board = new BoardVO();
//		
//		board.setB_no(6);
//		
//		service.detailBoard(board);
//		
//		log.info(board);
//	}
	
//	@Test
//	public void listTest() {
//		
//		List<BoardVO> list = service.listBoard(1);
//		
//		list.forEach(board -> log.info(list));
//	}
	
//	@Test
//	public void updateTest() {
//		
//		BoardVO board = new BoardVO();
//		
//		board.setB_no(5);
//		
//		board.setB_title("수정기기창");
//		board.setB_content("수정개주왱");
//		
//		service.updateBoard(board);
//	}
	
//	@Test
//	public void deleteTest() {
//		
//		BoardVO board = new BoardVO();
//		
//		board.setB_no(5);
//		
//		service.deleteBoard(board);
//	}
	
//	@Test
//	public void ListTest() {
//		
//		service.listBoardWithPaging(new Criteria(1, 10)).forEach(board -> log.info(board));
//	}

}
