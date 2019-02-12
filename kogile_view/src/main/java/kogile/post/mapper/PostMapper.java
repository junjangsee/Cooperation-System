package kogile.post.mapper;

import java.util.List;

import kogile.post.domain.PostDetailVO;
import kogile.post.domain.PostVO;
import kogile.project.domain.CardVO;

public interface PostMapper {
	public List<CardVO> card_no_info(int pjt_no);

	public List<PostVO> list_post(int pjt_no);
	
	public PostVO showDescription (int p_no);
	
	public int updateDescription(PostVO vo);

	// Post 삽입
	public void insertPost(PostVO post);

	// Post 읽기
	public List<PostDetailVO> detailPost(int p_no);

	// Post 수정
	public void updatePost(PostVO post);

	// Post 삭제
	public void deletePost(PostVO post);
}
