package kogile.invite.service;

import java.util.List;

import org.springframework.stereotype.Service;

import kogile.invite.domain.InviteVO;
import kogile.invite.domain.SearchListVO;
import kogile.invite.domain.SearchVO;
import kogile.invite.mapper.InviteMapper;
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
	public List<InviteVO> invite(int pjt_no){
		log.info("inviteList.............");
		return mapper.invite(pjt_no);
	}

	@Override
	public int insertInvite(InviteVO invite) {
		log.info("insertList.............");
		return mapper.insertInvite(invite);
	}
	
	

}
