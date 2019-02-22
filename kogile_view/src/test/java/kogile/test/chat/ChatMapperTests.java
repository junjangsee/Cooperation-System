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
 * ä�� �׽�Ʈ.
 */

public class ChatMapperTests {
	
	@Setter(onMethod_={@Autowired})
	ChatMapper mapper;
	
	//1)���� Ŭ���̾�Ʈ�� ������ �ִ� ������ ä�ù�ȣ��
	//������Ʈ�� ������ ä�ù�ȣ�� ���ؼ�(4�� TC ����)
	//������ ��ŭ�� list�� ��ȯ�Ѵ�.
	
	@Ignore
	@Test
	public void getNewChatListTest() {
		
		Map<String, String> arg = new HashMap<>();
		arg.put("pjt_no", "1");
		arg.put("chat_no", "1");
		
		List<ChatVO> list = mapper.getChatList(arg);
		
		if(list != null) {
			for(ChatVO chat:list) {
				System.out.println("�迭������:" + list.size());
				System.out.println(chat);
			}
		}else{
			log.info("getNewChatListTest Fail!");
			fail();
		}
	}
	
	//2)���ο� ä���� insert�ϴµ� �����Ѵ�.

	@Test
	public void insertChatTest() {
		int res = mapper.chatRegister(new ChatVO(1, 2,1 ,"sohyun", "HwangSoheeBabo", "2019-01-01"));
		if(res < 0) {
			fail();
		}
	}
	

	//���� 1ȸ, ������Ʈ�� �����ɶ� tbl_chat_ctn���̺� pjt_num�� insert ���ش�.
	@Ignore
	@Test
	public void insertLastChatNumTest(){
		int pjt_no = 2;
		if(mapper.IsThereAnyChat(pjt_no).equals("F")){
			//ä�ó����� ä�ñ���� �ϳ��� ���ٸ�
			mapper.initChatCtn(pjt_no); //tbl_chat_ctn�� pjt_num�� �־��ش�.
		}else {
			fail();
		}
	}
	
	//3)���ο� ä�� insert��, 
	//ä�� ���̺��� pjt�� ä�� ������ count�� ��,
	//�ֱ�ä�ù�ȣ�� �����ϴ� ���̺� pjt�� �ֱ�ä�ù�ȣ�� ������Ʈ �Ѵ�.
	//���� �׽�Ʈ ���� insert �� �Ʒ� ������ ������� ��!
	
	
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

