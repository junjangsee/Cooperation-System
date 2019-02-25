package kogile.invite.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import kogile.invite.domain.InviteVO;
import kogile.invite.domain.SearchListVO;
import kogile.invite.domain.SearchVO;
import kogile.notice.domain.NoticeVO;

public interface InviteMapper {

	public List<SearchListVO> searchList(SearchVO search);
	public List<SearchListVO> searchPjt(SearchVO search);
	
	public List<InviteVO> invite(int pjt_no);
	
	public int insertInvite(InviteVO invite);
	
	public int insertNotice(NoticeVO notice);
	
	public int deleteInvite(InviteVO invite);
	
	public int insertPrjInfo(int invite_no);
}
