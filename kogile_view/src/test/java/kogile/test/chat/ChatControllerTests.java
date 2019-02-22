package kogile.test.chat;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.HashMap;
import java.util.Map;

import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import com.google.gson.Gson;

import kogile.chat.domain.ChatVO;
import lombok.Setter;
import lombok.extern.log4j.Log4j;

@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
@ContextConfiguration({"file:src/main/webapp/WEB-INF/spring/root-context.xml",
		"file:src/main/webapp/WEB-INF/spring/appServlet/servlet-context.xml"})
@Log4j

public class ChatControllerTests {
	
	@Setter(onMethod_={@Autowired})
	private WebApplicationContext ctx;
	
	private MockMvc mockMvc;
	@Before
	public void set() {
		this.mockMvc = MockMvcBuilders.webAppContextSetup(ctx).build();
	}
	
	@Ignore
	@Test
	public void sendChatTest() throws Exception {
		ChatVO chat = new ChatVO(1, 1, 1,"soheemon", "helloworld!", "2019-01-01");
		String jsonStr = new Gson().toJson(chat);
		
		log.info(jsonStr);
		
		mockMvc.perform(post("/chat/sendchat")
				.contentType(MediaType.APPLICATION_JSON)
				.content(jsonStr)).andExpect(status().is(200));
	}
	
	//@Ignore
	@Test
	public void recieveChatTest() throws Exception {
		Map<String, String> userInfo = new HashMap<>();
		userInfo.put("pjt_no", "1");
		userInfo.put("chat_no", "1");
		
		String jsonStr = new Gson().toJson(userInfo);
		
		log.info(jsonStr);
		
		MvcResult result = 
		mockMvc.perform(post("/chat/recievechat")
				.contentType(MediaType.APPLICATION_JSON)
				.content(jsonStr)).andDo(print()).andReturn();
		
		String content = result.getResponse().getContentAsString();
		System.out.println(content);
	}
	
	@Ignore
	@Test
	public void initChatCtnTest() throws Exception {
		mockMvc.perform(get("/chat/initChatCtn/3")).andExpect(status().is(200));
	}
}

