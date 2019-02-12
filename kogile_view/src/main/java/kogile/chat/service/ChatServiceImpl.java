package kogile.chat.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;

import kogile.chat.domain.ChatVO;
import kogile.chat.mapper.ChatMapper;
import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j;

@Log4j
@Service
@AllArgsConstructor
public class ChatServiceImpl implements ChatService {
	
	private ChatMapper mapper;

	//ä���� �ְ���, ������Ʈ�� ������ ä�ù�ȣ�� ������Ʈ ���ش�.
	
	@Override
	public boolean chatSendService(ChatVO chat) {
		mapper.chatRegister(chat);
		
		return mapper.updateLastChatNo(chat.getPjt_no()) == 1;
	}

	//����ڰ� ������ ä�óѹ���, DB�󿡼��� �ֽ� ä�óѹ��� ���ؼ�
	//�� ����� return ���ش�.
	@Override
	public List<ChatVO> getChatListService(Map<String, String> arg) {
		
		int pjt_no = Integer.parseInt(arg.get("pjt_no"));
		//������ �������ִ� ������ ä�� ��ȣ
		int userChatCnt = Integer.parseInt(arg.get("chat_no"));
		//argMap���� chat_no��, ������ ��ȸ�� �ֽ� ä�óѹ���, ����ڿ��� �ѷ��� ä�ø���Ʈ�� �����´�.
		
		Map<String, String> getChatListArg = new HashMap<>();
		getChatListArg.put("pjt_no", pjt_no + "");
		getChatListArg.put("chat_no", userChatCnt + "");
		
		//������ ������ �ִ� ä�ù�ȣ���� ���Ŀ� ������ ä���� �ִٸ� ����Ʈ�� ���� ��ȯ�Ѵ�.
		return mapper.getChatList(getChatListArg);
	}
	
	@Override
	public void initChatCtn(int pjt_no){

		if(mapper.IsThereAnyChat(pjt_no).equals("F")){
			//ä�ó����� ä�ñ���� �ϳ��� ���ٸ�
			mapper.initChatCtn(pjt_no); //tbl_chat_ctn�� pjt_num�� �־��ش�.
		}
	}
}
