package kogile.test.post;

import java.sql.Date;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import kogile.post.domain.PostVO;
import kogile.post.mapper.PostMapper;
import kogile.project.mapper.ProjectMapper;
import lombok.Setter;
import lombok.extern.log4j.Log4j;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("file:src/main/webapp/WEB-INF/spring/root-context.xml")
@Log4j
public class PostMapperTests {
	
	@Setter(onMethod_ = @Autowired)
	private PostMapper mapper;
	
//	@Test
//	public void insertTest() {
//		
//		PostVO post = new PostVO();
//		
//		post.setP_title("포스트5-21");
//		post.setP_position(1);
//		post.setC_no(1);
//		post.setP_description("포스트5-11에 대한 내용");
////		post.setP_dday("19/03/01");
//		
//		mapper.insertPost(post);
//		
//		log.info(post);
//	}
	
//	@Test
//	public void updateTest() {
//		
//		PostVO post = new PostVO();
//		
//		post.setP_no(1);
//		post.setP_title("포스트5-1");
//		post.setC_no(1);
//		post.setP_position(1);
//		post.setP_description("포스트5-1에 대한 내용 수정");
//		post.setP_dday("19/03/20");
//
//		mapper.updatePost(post);
//		
//		log.info(post);
//	}
	
//	@Test
//	public void deleteTest() {
//		
//		PostVO post = new PostVO();
//		
//		post.setP_no(9);
//		
//		mapper.deletePost(post);
//		
//		log.info(post);
//	}
	
//	@Test
//	public void detailTest() {
//		
//		PostVO post = new PostVO();
//		
//		mapper.detailPost(2);
//		
//		log.info(post);
//		
//	}
	
//	@Test
//	public void insertDate() {
//		
//		PostVO post = new PostVO();
//		
//		post.setP_no(224);
//		post.setP_dday("19/03/01");
//		
//		mapper.insertDate(post);
//	}
	
//	@Test
//	public void detailDate() {
//		
//		mapper.detailDate(224);
//	}
	
//	@Test
//	public void deleteDate() {
//		
//		mapper.deleteDate(224);
//	}
	
//	@Test
//	public void updateTitle() {
//	
//		PostVO post = new PostVO();
//		
//		post.setP_no(222);
//		post.setP_title("수정한 제목이지롱");
//		
//		mapper.updatePostTitle(post);
//	}
	
//	@Test
//	public void updateDate() {
//	
//		PostVO post = new PostVO();
//		
//		post.setP_no(222);
//		post.setP_dday(new Date(19-03-01));
//		
//		mapper.updatePostDate(post);
//	}
	
	
	
}
