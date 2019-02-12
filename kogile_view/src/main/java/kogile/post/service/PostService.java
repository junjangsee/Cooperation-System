package kogile.post.service;

import java.util.List;

import kogile.post.domain.PostVO;
import kogile.project.domain.CardVO;

public interface PostService {
	public List<PostVO> list_post(int pjt_no);
	public List<CardVO> list_card(int pjt_no);
	
	public int modifyDescription (PostVO vo);
	
	public PostVO showDescription(int p_no);
}
