package kogile.test.chat;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.fail;

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
import kogile.chat.service.ChatService;
import lombok.Setter;
import lombok.extern.log4j.Log4j;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("file:src/main/webapp/WEB-INF/spring/root-context.xml")
@Log4j

public class ChatServiceTests {

	@Setter(onMethod_={@Autowired})
	private ChatService service;
	
	@Test
	public void initChatCtnTest() {
		int pjt_no = 2;
		service.initChatCtn(pjt_no);
	}
	

	@Test
	public void chatSendServiceTest() {
		ChatVO chat = new ChatVO(2,1,"황소희", "아겁나짜증날라그래222222");
		if(!service.chatSendService(chat)){
			System.out.println("update Fail!");
			fail();
		}
	}

	@Test
	public void getChatListServiceTest() {
		Map<String, String> Userarg = new HashMap<>();
		
		//유저가 조회할 채팅은, 1번 프로젝트에서 1번 이후의 채팅내역을 조회한다.
		Userarg.put("pjt_no", "2");
		Userarg.put("chat_no", "1");
		
		List<ChatVO> list = service.getChatListService(Userarg);
		for(ChatVO chat:list) {
			System.out.println(chat);
		}
	}

}
