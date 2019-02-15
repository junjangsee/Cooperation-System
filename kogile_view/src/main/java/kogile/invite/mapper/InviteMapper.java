package kogile.invite.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import kogile.invite.domain.InviteVO;
import kogile.invite.domain.SearchListVO;
import kogile.invite.domain.SearchVO;

public interface InviteMapper {

	public List<SearchListVO> searchList(SearchVO search);
	
	public List<InviteVO> invite(int pjt_no);
}
