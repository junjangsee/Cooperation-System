package kogile.chat.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import kogile.chat.domain.ChatVO;
import kogile.chat.service.ChatService;
import lombok.Setter;
import lombok.extern.log4j.Log4j;

@RestController
@RequestMapping("/chat")
@Log4j
public class ChatRestController {
	
	@Setter(onMethod_={@Autowired})
	private ChatService service;
	
	// 1)ä�ù����� �̵��ϱ�.(jsp) => CommonController
	// 2)ä�� ������ sendChat - ChatVo��ü�� �޴´�.
	@PostMapping(value = "/sendchat", produces = "application/json; charset=utf-8")
	public void sendChat(@RequestBody ChatVO chat) {
		//1)�� �޴�
		System.out.println(chat);
		
		//2)���� service �غ���.
		service.chatSendService(chat);
	}
	// 3)ä�� �ޱ� recevieChat
	//����� num�̶� pjt_no�� ���� ä�ù�ȣ�� �����ش�.
	@PostMapping(value = "/recievechat", produces = "application/json; charset=utf-8")
	public List<ChatVO> recieveChat(@RequestBody Map<String, String> userInfo) {
		return service.getChatListService(userInfo);
	}
	
	// 4)���� ä�ù� ������ �ʱ�ȭ
	@GetMapping("/initChatCtn/{pjt_no}")
	public void initChatCtn(@PathVariable("pjt_no") Integer pjt_no) {
		service.initChatCtn(pjt_no);
	}
}
