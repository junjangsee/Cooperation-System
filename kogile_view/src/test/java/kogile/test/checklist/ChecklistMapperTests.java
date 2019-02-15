package kogile.test.checklist;


import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import kogile.checklist.domain.ChecklistVO;
import kogile.checklist.mapper.ChecklistMapper;
import lombok.Setter;
import lombok.extern.log4j.Log4j;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("file:src/main/webapp/WEB-INF/spring/root-context.xml")
@Log4j
public class ChecklistMapperTests {

	@Setter(onMethod_=@Autowired)
	private ChecklistMapper ckmapper;
	
	
	
	
	@Test
	public void testUpdate() {
		
		ChecklistVO cvo = new ChecklistVO();
		
		cvo.setP_no(1);
		cvo.setChecklist_no(4);
		cvo.setCheck_title("������ ����");
		
		int count = ckmapper.update(cvo);
		
		log.info("Update Count: " + count);
		
	}
	
/*	@Test
	public void testDelete() {
		
		
		log.info("Delete count: " + ckmapper.delete(182l));
	}*/
	
	
	
/*	@Test
	public void testRead() {
		
		ChecklistVO cvo = ckmapper.read(3l);
		
		log.info(cvo);
	}
	*/
	
	
/*	@Test
	public void testInsertSelectKey() {
		
		ChecklistVO cvo = new ChecklistVO();
		cvo.setChecklist_no(11L);
		cvo.setCheck_title("�׽�Ʈ");
		cvo.setP_no(2L);
		
		ckmapper.insertSelectKey(cvo);
	}
*/	
/*	@Test
	public void testInsert() {
		
		ChecklistVO cvo = new ChecklistVO();
		cvo.setChecklist_no(10L);
		cvo.setCheck_title("�׽�Ʈ");
		cvo.setP_no(2L);
		
		ckmapper.insert(cvo);
	}
*/	
/*	@Test
	public void testGetList() {
		
		ckmapper.getList().forEach(boa -> log.info(boa));
		
	}
*/
}
