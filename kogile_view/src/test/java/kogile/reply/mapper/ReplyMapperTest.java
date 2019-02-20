package kogile.reply.mapper;

import java.util.List;
import java.util.stream.IntStream;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

import kogile.reply.domain.ReplyVO;
import kogile.reply.domain.TagVO;
import lombok.AllArgsConstructor;
import lombok.Setter;
import lombok.extern.log4j.Log4j;

@RunWith(SpringRunner.class)
@ContextConfiguration("file:src/main/webapp/WEB-INF/spring/root-context.xml")
@Log4j
public class ReplyMapperTest {
	
	@Setter(onMethod_=@Autowired)
	private ReplyMapper mapper;
	
//	@Test
//	public void testMapper() {
//		log.info(mapper);
//	}
//	@Test
//	public void testCreate() {
//		ReplyVO vo = new ReplyVO();
//		
//		vo.setP_no(1);
//		vo.setInfo_no(2);
//		vo.setR_contents("메퍼연결작성테스트");
//		
//		mapper.insertReply(vo);
//	}
//	@Test
//	public void testList() {
//		long p_no=6;
//		List<ReplyVO> replies= mapper.replyList(p_no);
//		List<ReplyVO> replies2= mapper.replyList2(p_no);
//		
//		replies.forEach(reply -> log.info(reply));
//		replies2.forEach(reply2 -> log.info(reply2));
//		
//	}
//	@Test
//	public void testUpdate() {
//		ReplyVO vo = new ReplyVO();
//		vo.setR_no(61);
//		vo.setR_contents("수정합니다.");
//		int count = mapper.updateReply(vo);
//		
//		log.info("수정된글갯수="+count);
//	}
//	@Test
//	public void testDelete() {
//		long r_no = 41;
//		
//		int count = mapper.deleteReply(r_no);
//		
//		log.info("삭제된글갯수="+count);
//	}
//	@Test
//	public void testReplyNum() {
//		int replyNum=mapper.replyNum();
//		log.info(replyNum);
//	}
//	@Test
//	public void testCreatTag() {
//		TagVO vo = new TagVO();
//		vo.setR_no(2);
//		vo.setInfo_no(1);
//		mapper.insertTag(vo);
//	}
//	@Test
//	public void testTagMemberList() {
//		int pjt_no=1;
//		List<TagVO>list= mapper.tagMember(pjt_no);
//		List<TagVO>list2=mapper.tagMember2(pjt_no);
//		list.addAll(list2);
//		list.forEach(mem ->log.info(mem));
//	}
//	@Test
//	public void testTagNoticeInsert() {
//		TagVO vo= new TagVO();
//		vo.setTag_no(1);
//		vo.setTotal_m_no(1);
//		mapper.insertTagNotice(vo);
//	}
//	@Test
//	public void testTagNoticeMember() {
//		TagVO vo =new TagVO();
//		int info_no=1;
//		mapper.tag_total_m_no(info_no);
//		
//	}
//	@Test
//	public void testTagNum() {
//		int tagNum = mapper.tagNum();
//		log.info(tagNum);
//	}
}
