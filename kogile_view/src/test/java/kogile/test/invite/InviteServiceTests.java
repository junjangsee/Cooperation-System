package kogile.test.invite;

import static org.junit.Assert.assertNotNull;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import kogile.invite.domain.SearchVO;
import kogile.invite.service.InviteService;
import lombok.Setter;
import lombok.extern.log4j.Log4j;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("file:src/main/webapp/WEB-INF/spring/root-context.xml")
@Log4j
public class InviteServiceTests {

	@Setter(onMethod_ = {@Autowired})
	private InviteService service;
	
	@Test
	public void testExist(){
	
		log.info(service);
		assertNotNull(service);
	}
	
	@Test
	public void testInviteList(SearchVO search){
		
		service.searchList(search).forEach(searchList -> log.info(searchList));
	}
}
