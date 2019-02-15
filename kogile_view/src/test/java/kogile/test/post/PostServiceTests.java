package kogile.test.post;

import static org.junit.Assert.*;

import java.sql.Date;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import kogile.post.domain.PostVO;
import kogile.post.service.PostService;
import lombok.Setter;
import lombok.extern.log4j.Log4j;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("file:src/main/webapp/WEB-INF/spring/root-context.xml")
@Log4j
public class PostServiceTests {
	
	@Setter(onMethod_ = @Autowired)
	private PostService service;

//	@Test
//	public void insertTest() {
//		
//		PostVO post = new PostVO();
//		
//		post.setP_title("포스트8-1");
//		post.setP_position(1);
//		post.setC_no(1);
//		post.setP_description("포스트5-1에 대한 내용");
//		post.setP_dday("19/03/01");
//		
//		service.insertPost(post);
//		
//		log.info(post);
//	}
	
//	@Test
//	public void updateTest() {
//		
//		PostVO post = new PostVO();
//		
//		post.setP_no(223);
//		post.setP_title("포스트5-1");
//		post.setC_no(1);
//		post.setP_position(1);
//		post.setP_description("포스트5-1에 대한 내용 수정");
//		post.setP_dday("19/03/20");
//		
//		service.updatePost(post);
//		
//		log.info(post);
//	}
	
//	@Test
//	public void deleteTest() {
//		
//		PostVO post = new PostVO();
//		
//		post.setP_no(61);
//		
//		service.deletePost(post);
//		
//		log.info(post);
//	}
	
//	@Test
//	public void detailTest() {
//		
//		PostDetailVO postDetailVO = new PostDetailVO();
//		
//		service.detailPost(1);
//		
//		log.info(postDetailVO);
//	}
	
//	@Test
//	public void insertDate() {
//		
//		PostVO post = new PostVO();
//		
//		post.setP_no(224);
//		post.setP_dday("19/03/01");
//		
//		service.insertDate(post);
//	}
	
//	@Test
//	public void detailDate() {
//		
//		PostVO post = new PostVO();
//		
//		service.detailDate(224);
//		
//		log.info(post);
//	}
	
//	@Test
//	public void deleteDate() {
//		
//		PostVO post = new PostVO();
//		
//		service.deleteDate(224);
//		
//		log.info(post);
//	}
	
//	@Test
//	public void updateTitle() {
//		
//		PostVO post = new PostVO();
//		
//		post.setP_no(222);
//		post.setP_title("서비스 수정");
//		
//		service.updatePostTitle(post);
//		
//		log.info(post);
//	}
	
//	@Test
//	public void updateDate() {
//		
//		PostVO post = new PostVO();
//		
//		post.setP_no(222);
//		post.setP_dday(new Date(19/05/01));
//		
//		service.updatePostDate(post);
//	}
	

}
