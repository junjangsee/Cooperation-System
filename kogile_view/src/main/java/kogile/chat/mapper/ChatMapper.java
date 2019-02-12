package kogile.chat.mapper;

import java.util.List;
import java.util.Map;

import kogile.chat.domain.ChatVO;

public interface ChatMapper {
	public List<ChatVO> getChatList(Map<String, String> arg);
	public int chatRegister(ChatVO chat);
	
	public int updateLastChatNo(int pjt_no);
	public int selectLastChatNo(int pjt_no);
	
	public void initChatCtn(int pjt_no);
	public String IsThereAnyChat(int pjt_no);
}
