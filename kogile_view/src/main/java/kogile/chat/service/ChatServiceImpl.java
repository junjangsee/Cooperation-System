package kogile.chat.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;

import kogile.chat.domain.ChatVO;
import kogile.chat.mapper.ChatMapper;
import lombok.AllArgsConstructor;


@Service
@AllArgsConstructor
public class ChatServiceImpl implements ChatService {
	
	private ChatMapper mapper;

	@Override
	public boolean chatSendService(ChatVO chat) {
		mapper.chatRegister(chat);
		
		return mapper.updateLastChatNo(chat.getPjt_no()) == 1;
	}

	@Override
	public List<ChatVO> getChatListService(Map<String, String> arg) {
		
		int pjt_no = Integer.parseInt(arg.get("pjt_no"));
		int userChatCnt = Integer.parseInt(arg.get("chat_no"));

		Map<String, String> getChatListArg = new HashMap<>();
		getChatListArg.put("pjt_no", pjt_no + "");
		getChatListArg.put("chat_no", userChatCnt + "");
		
		return mapper.getChatList(getChatListArg);
	}
	
	@Override
	public void initChatCtn(int pjt_no){

		if(mapper.IsThereAnyChat(pjt_no).equals("F")){
			mapper.initChatCtn(pjt_no);
		}
	}
}
