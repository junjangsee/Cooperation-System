package kogile.test.chat;

import static org.junit.Assert.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import kogile.chat.domain.ChatVO;
import kogile.chat.mapper.ChatMapper;
import lombok.Setter;
import lombok.extern.log4j.Log4j;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("file:src/main/webapp/WEB-INF/spring/root-context.xml")
@Log4j

/*
 * 채팅 테스트.
 */

public class ChatMapperTests {
	
	@Setter(onMethod_={@Autowired})
	ChatMapper mapper;
	
	//1)현재 클라이언트가 가지고 있는 마지막 채팅번호와
	//프로젝트의 마지막 채팅번호를 비교해서(4번 TC 참조)
	//나머지 만큼을 list로 반환한다.
	
	@Test
	public void getNewChatListTest() {
		
		Map<String, String> arg = new HashMap<>();
		arg.put("pjt_no_input", "1");
		arg.put("chat_no_input", "1");
		
		List<ChatVO> list = mapper.getChatList(arg);
		
		if(list != null) {
			for(ChatVO chat:list) {
				System.out.println("배열사이즈:" + list.size());
				System.out.println(chat);
			}
		}else{
			log.info("getNewChatListTest Fail!");
			fail();
		}
	}
	
	//2)새로운 채팅을 insert하는데 성공한다.
	@Ignore
	@Test
	public void insertChatTest() {
		int res = mapper.chatRegister(new ChatVO(1, "sohee", "HwangSoheeBabo"));
		if(res < 0) {
			fail();
		}
	}
	
	//3)새로운 채팅 insert후, 
	//채팅 테이블에서 pjt별 채팅 갯수를 count한 후,
	//최근채팅번호를 저장하는 테이블에 pjt별 최근채팅번호를 업데이트 한다.
	//서비스 테스트 순서 insert 후 아래 쿼리를 날려줘야 함!
	@Ignore
	@Test
	public void updateLastChatNumTest() {
		int res = mapper.updateLastChatNo(1);
		if(res < 0) {
			fail();
		}else {
			log.info("update LastChatNum!"+ res);
		}
	}
	@Ignore
	@Test
	public void getLastChatNumFromTableTest() {
		 int lastChatNo =  mapper.selectLastChatNo(1);
	}
	
}
