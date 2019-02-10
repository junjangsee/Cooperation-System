package kogile.test.jdbc;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import kogile.post.mapper.PostMapper;
import kogile.project.mapper.ProjectMapper;
import lombok.Setter;
import lombok.extern.log4j.Log4j;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("file:src/main/webapp/WEB-INF/spring/root-context.xml")
@Log4j
public class MapperTests {
	@Setter(onMethod_ = @Autowired)
	private ProjectMapper mapper;
	
	@Setter(onMethod_ = @Autowired)
	private PostMapper mapper2;
	
	@Test
	public void test() {
		mapper.list(1);
	}
	
	@Test
	public void test2() {
		mapper2.list_post(1);
		mapper2.card_no_info(1);
	}
	


}
