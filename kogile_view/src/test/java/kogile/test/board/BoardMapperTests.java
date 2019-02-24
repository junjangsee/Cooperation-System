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
import kogile.board.mapper.BoardMapper;
import lombok.Setter;
import lombok.extern.log4j.Log4j;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("file:src/main/webapp/WEB-INF/spring/root-context.xml")
@Log4j
public class BoardMapperTests {
	
	@Setter(onMethod_ = @Autowired)
	private BoardMapper mapper;

//	@Test
//	public void insertTest() {
//		
//		BoardVO board = new BoardVO();
//		
//		board.setB_content("내용1010");
//		board.setB_title("제목1010");
//		board.setFname("작성자1010");
//		board.setInfo_no(1);
//		board.setRegdate(new Date(2019/02/02));
//		board.setUpdate_date(new Date(2019/03/03));
//		board.setPjt_no(1);
//		
//		mapper.insertBoard(board);
//	}
	
//	@Test
//	public void detailTest() {
//		
//		BoardVO board = new BoardVO();
//		
//		board.setB_no(4);
//		
//		log.info(board);
//		
//		mapper.detailBoard(board);
//	}
	
//	@Test
//	public void listTest() {
//		
//		List<BoardVO> list = mapper.listBoard(1);
//		
//		list.forEach(board -> log.info(list));
//	}
	
//	@Test
//	public void updateTest() {
//		
//		BoardVO board = new BoardVO();
//		
//		board.setB_no(4);
//		
//		board.setB_title("수정할거얌");
//		board.setB_content("수정이꾸요잇");
//		
//		mapper.updateBoard(board);
//	}
	
//	@Test
//	public void deleteTest() {
//		
//		BoardVO board = new BoardVO();
//		
//		board.setB_no(4);
//		
//		mapper.deleteBoard(board);
//	}
	
//	@Test
//	public void testPaging() {
//		
//		Criteria cri = new Criteria();
//		
//		List<BoardVO> list = mapper.listBoardWithPaging(cri);
//		
//		list.forEach(board -> log.info(list));
//	}
	
//	@Test
//	public void testPaging() {
//		
//		Criteria cri = new Criteria();
//		
//		// 10개씩 3페이지
//		cri.setPageNum(3);
//		cri.setAmount(10);
//		
//		List<BoardVO> list = mapper.listBoardWithPaging(cri);
//		
//		list.forEach(board -> log.info(board.getB_no()));
//	}
	
	@Test
	public void testList() {
		
	}

}
