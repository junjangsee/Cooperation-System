package kogile.chat.service;

import static org.junit.Assert.fail;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import kogile.chat.domain.ChatVO;
import kogile.chat.mapper.ChatMapper;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.extern.log4j.Log4j;

@Log4j
@Service
@AllArgsConstructor
public class ChatServiceImpl implements ChatService {
	
	private ChatMapper mapper;

	//채팅을 넣고나서, 프로젝트의 마지막 채팅번호를 업데이트 해준다.
	
	@Override
	public boolean chatSendService(ChatVO chat) {
		mapper.chatRegister(chat);
		
		return mapper.updateLastChatNo(chat.getPjt_no()) == 1;
	}

	//사용자가 보내준 채팅넘버와, DB상에서의 최신 채팅넘버를 비교해서
	//그 결과를 return 해준다.
	@Override
	public List<ChatVO> getChatListService(Map<String, String> arg) {
		
		int pjt_no = Integer.parseInt(arg.get("pjt_no"));
		//유저가 가지고있는 마지막 채팅 번호
		int userChatCnt = Integer.parseInt(arg.get("chat_no"));
		//argMap에서 chat_no와, 위에서 조회한 최신 채팅넘버로, 사용자에게 뿌려줄 채팅리스트를 가져온다.
		
		Map<String, String> getChatListArg = new HashMap<>();
		getChatListArg.put("pjt_no", pjt_no + "");
		getChatListArg.put("chat_no", userChatCnt + "");
		
		//유저가 가지고 있는 채팅번호보다 이후에 생성된 채팅이 있다면 리스트로 만들어서 반환한다.
		return mapper.getChatList(getChatListArg);
	}
	
	@Override
	public void initChatCtn(int pjt_no){

		if(mapper.IsThereAnyChat(pjt_no).equals("F")){
			//채팅내역에 채팅기록이 하나도 없다면
			mapper.initChatCtn(pjt_no); //tbl_chat_ctn에 pjt_num만 넣어준다.
		}
	}
}
