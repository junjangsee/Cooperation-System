package kogile.test.checklist;

import static org.junit.Assert.*;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import kogile.checklist.domain.ChecklistVO;
import kogile.checklist.service.ChecklistService;
import lombok.Setter;
import lombok.extern.log4j.Log4j;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("file:src/main/webapp/WEB-INF/spring/root-context.xml")
@Log4j
public class ChecklistServiceTests {

	@Setter(onMethod_ = @Autowired)
	private ChecklistService  service;
	
	
	
	
	
/*	@Test
	public void testExist() {
		
		log.info(service);
		assertNotNull(service);
	}*/
	
	
//	@Test
//	public void testUpdate() {
//		
//		ChecklistVO cvo = service.get(3);
//		
//		if(cvo == null){
//			return;
//		}
//		
//		cvo.setCheck_title("내용수정");
//		log.info("Modify result:" + service.modify(cvo));
//		
//	}
	
	
/*	@Test
	public void testDelete() {
		
		log.info("Remove Result: " + service.remove(4l));
	}*/
	
	
/*	@Test
	public void testGet(){
		
		log.info(service.get(1L));
	}*/
	
	
	
/*	@Test
	public void testGetList(){
		
		service.getList().forEach(boa -> log.info(boa));
	}*/
	
	
	
/*	@Test
	public void testRegister(){
		
		ChecklistVO cvo = new ChecklistVO();
		cvo.setChecklist_no(5l);
		cvo.setCheck_title("새로작성하는제목");
		cvo.setP_no(3l);
		
		service.register(cvo);
	}*/

}
