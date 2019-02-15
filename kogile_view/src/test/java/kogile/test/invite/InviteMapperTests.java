package kogile.test.invite;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import kogile.invite.domain.SearchListVO;
import kogile.invite.domain.SearchVO;
import kogile.invite.mapper.InviteMapper;
import lombok.Setter;
import lombok.extern.log4j.Log4j;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("file:src/main/webapp/WEB-INF/spring/root-context.xml")
@Log4j
public class InviteMapperTests {

	@Setter(onMethod_ = @Autowired)
	private InviteMapper mapper;
	
/*	@Test
	public void testSearchList(SearchVO search){
		
		mapper.searchList(search).forEach(searchList -> log.info(searchList));
		
	}*/
	
	@Test //�˻� ������ �Է� �׽�Ʈ
	public void testSearch(){
		
		SearchVO search = new SearchVO();
		search.setSearch("sohee");
		
		List<SearchListVO> list = mapper.searchList(search);
		
		list.forEach(searchList->log.info(searchList));
	}
}	
