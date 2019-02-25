package kogile.invite.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import kogile.invite.domain.InviteVO;
import kogile.invite.domain.SearchListVO;
import kogile.invite.domain.SearchVO;
import kogile.invite.mapper.InviteMapper;
import kogile.notice.domain.NoticeVO;
import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j;

@Log4j
@Service
@AllArgsConstructor
public class InviteServiceImpl implements InviteService {

	private InviteMapper mapper;
	
	@Override
	public List<SearchListVO> searchList(SearchVO search) {
		log.info("getList...............");
		return mapper.searchList(search);
	}
	
	@Override
	public List<SearchListVO> searchPjt(SearchVO search) {
		log.info("getList...............");
		return mapper.searchPjt(search);
	}

	@Override
	public List<InviteVO> invite(int pjt_no){
		log.info("inviteList.............");
		return mapper.invite(pjt_no);
	}
	
	@Transactional(propagation = Propagation.REQUIRED,
			rollbackFor  = {Exception.class})
	@Override
	public void insertInvite(InviteVO invite) {

		mapper.insertInvite(invite);
		
		NoticeVO notice = new NoticeVO();
		
		notice.setInvite_no(invite.getInvite_no());
		System.out.println("notice.inv �� : " + notice.getInvite_no());
		notice.setTotal_m_no(invite.getTotal_m_no());
		System.out.println("notice.tot �� : " + notice.getTotal_m_no());
		mapper.insertPrjInfo(invite.getInvite_no());
		
		mapper.insertNotice(notice);
	}
	
	@Override
	public int deleteInvite(InviteVO invite) {
		
	 return	mapper.deleteInvite(invite);
	}
}
