package kogile.chat.service;

import java.util.List;
import java.util.Map;

import kogile.chat.domain.ChatVO;

public interface ChatService {
	public boolean chatSendService(ChatVO chat);
	public List<ChatVO> getChatListService(Map<String, String> arg);
	
	public void initChatCtn(int pjt_no);
	
}
