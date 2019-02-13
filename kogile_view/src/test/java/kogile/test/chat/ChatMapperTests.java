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
	
	@Ignore
	@Test
	public void getNewChatListTest() {
		
		Map<String, String> arg = new HashMap<>();
		arg.put("pjt_no", "1");
		arg.put("chat_no", "1");
		
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

	@Test
	public void insertChatTest() {
		int res = mapper.chatRegister(new ChatVO(1, 2,1 ,"sohyun", "HwangSoheeBabo"));
		if(res < 0) {
			fail();
		}
	}
	

	//최초 1회, 프로젝트가 생성될때 tbl_chat_ctn테이블에 pjt_num을 insert 해준다.
	@Ignore
	@Test
	public void insertLastChatNumTest(){
		int pjt_no = 2;
		if(mapper.IsThereAnyChat(pjt_no).equals("F")){
			//채팅내역에 채팅기록이 하나도 없다면
			mapper.initChatCtn(pjt_no); //tbl_chat_ctn에 pjt_num만 넣어준다.
		}else {
			fail();
		}
	}
	
	//3)새로운 채팅 insert후, 
	//채팅 테이블에서 pjt별 채팅 갯수를 count한 후,
	//최근채팅번호를 저장하는 테이블에 pjt별 최근채팅번호를 업데이트 한다.
	//서비스 테스트 순서 insert 후 아래 쿼리를 날려줘야 함!
	
	
	@Test
	public void updateLastChatNumTest() {
		mapper.updateLastChatNo(2);
//		if(res < 0) {
//			fail();
//		}else {
//			log.info("update LastChatNum!"+ res);
//		}
	}
	@Ignore
	@Test
	public void getLastChatNumFromTableTest() {
		 int lastChatNo =  mapper.selectLastChatNo(1);
	}
	
}
