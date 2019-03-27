package kogile.description.mapper;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import kogile.post.domain.PostVO;
import kogile.post.mapper.PostMapper;
import lombok.Setter;
import lombok.extern.log4j.Log4j;

@Log4j
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("file:/src/main/webapp/WEB-INF/spring/root-context.xml")
public class DescriptionMapperTest {
	
	@Setter(onMethod_=@Autowired)
	private PostMapper mapper;
	
	@Test
	public void testShow() {
		int p_no = 1;
		PostVO vo =  mapper.showDescription(p_no);
		log.info(vo);
	}
//	@Test
//	public void testUpdate() {
//		PostVO vo = new PostVO();
//		
//		vo.setP_no(1);
//		vo.setP_description("나는 기능이 보여주기 수정밖에없어");
//		int count = mapper.updateDescription(vo);
//		log.info("수정된 글갯수 @@@@"+count);
//	}
	
}
