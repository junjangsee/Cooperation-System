package kogile.invite.service;

import java.util.List;

import kogile.invite.domain.InviteVO;
import kogile.invite.domain.SearchListVO;
import kogile.invite.domain.SearchVO;

public interface InviteService {

	public List<SearchListVO> searchList(SearchVO search);
	public List<SearchListVO> searchPjt(SearchVO search);
	
	public List<InviteVO> invite(int pjt_no);
	
	public void insertInvite(InviteVO invite);
	
	public int deleteInvite(InviteVO invite);
}
