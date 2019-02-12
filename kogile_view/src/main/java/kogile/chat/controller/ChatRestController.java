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
	
	// 1)채팅방으로 이동하기.(jsp) => CommonController
	// 2)채팅 보내기 sendChat - ChatVo객체를 받는다.
	@PostMapping(value = "/sendchat", produces = "application/json; charset=utf-8")
	public void sendChat(@RequestBody ChatVO chat) {
		//1)잘 받니
		System.out.println(chat);
		
		//2)이제 service 해보자.
		service.chatSendService(chat);
	}
	// 3)채팅 받기 recevieChat
	//사용자 num이랑 pjt_no랑 유저 채팅번호를 보내준다.
	@PostMapping(value = "/recievechat", produces = "application/json; charset=utf-8")
	public List<ChatVO> recieveChat(@RequestBody Map<String, String> userInfo) {
		System.out.println(userInfo);
		return null;
		//return service.getChatListService(userInfo);
	}
	
	// 4)최초 채팅방 생성시 초기화
	@GetMapping("/initChatCtn/{pjt_no}")
	public void initChatCtn(@PathVariable("pjt_no") Integer pjt_no) {
		service.initChatCtn(pjt_no);
	}
}
