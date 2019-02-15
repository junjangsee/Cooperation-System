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
		ChatVO chat = new ChatVO(2,1,1,"Ȳ����", "�ư̳�¥������׷�222222");
		if(!service.chatSendService(chat)){
			System.out.println("update Fail!");
			fail();
		}
	}

	@Test
	public void getChatListServiceTest() {
		Map<String, String> Userarg = new HashMap<>();
		
		//������ ��ȸ�� ä����, 1�� ������Ʈ���� 1�� ������ ä�ó����� ��ȸ�Ѵ�.
		Userarg.put("pjt_no", "2");
		Userarg.put("chat_no", "1");
		
		List<ChatVO> list = service.getChatListService(Userarg);
		for(ChatVO chat:list) {
			System.out.println(chat);
		}
	}

}

