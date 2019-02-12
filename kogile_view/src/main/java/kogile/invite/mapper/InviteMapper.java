package kogile.invite.mapper;

import java.util.List;

import kogile.invite.domain.SearchListVO;
import kogile.invite.domain.SearchVO;

public interface InviteMapper {

	public List<SearchListVO> searchList(SearchVO search);
}
