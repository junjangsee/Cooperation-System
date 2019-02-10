package kogile.post.mapper;

import java.util.List;

import kogile.post.domain.PostVO;
import kogile.project.domain.CardVO;

public interface PostMapper {
	public List<CardVO> card_no_info(int pjt_no);
	public List<PostVO> list_post(int pjt_no);
}
