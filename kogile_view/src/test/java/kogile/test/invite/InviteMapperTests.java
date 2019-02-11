package kogile.test.invite;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import kogile.invite.mapper.InviteMapper;
import lombok.Setter;
import lombok.extern.log4j.Log4j;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("file:src/main/webapp/WEB-INF/spring/root-context.xml")
@Log4j
public class InviteMapperTests {

	@Setter(onMethod_ = @Autowired)
	private InviteMapper mapper;
	
	@Test
	public void testSearchList(){
		
		mapper.searchList().forEach(searchList -> log.info(searchList));
		
	}
}
