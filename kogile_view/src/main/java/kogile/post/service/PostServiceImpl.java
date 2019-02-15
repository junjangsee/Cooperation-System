package kogile.post.service;


import java.util.List;

import org.springframework.stereotype.Service;

import kogile.post.domain.PostVO;
import kogile.post.mapper.PostMapper;
import kogile.project.domain.CardVO;
import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class PostServiceImpl implements PostService {

	private PostMapper mapper;
	
	@Override
	public List<PostVO> list_post(int pjt_no) {
		List<PostVO> list = mapper.list_post(pjt_no); 
		return list;
	}

	@Override
	public List<CardVO> list_card(int pjt_no) {
		List<CardVO> list = mapper.card_no_info(pjt_no);
		return list;
	}
	
//	설명수정
	@Override
	public int modifyDescription(PostVO vo) {
		int modifyCount = mapper.updateDescription(vo);
		return modifyCount;
	}
	
//	설명보기
	@Override
	public PostVO showDescription(int p_no) {
		PostVO vo = mapper.showDescription(p_no);
		return vo;
	}
	
	// post 삽입
	@Override
	public void insertPost(PostVO post) {

		mapper.insertPost(post);
	}

	// post 수정
	@Override
	public int updateDate(PostVO post1) {
		PostVO post = mapper.detailPost(post1.getP_no());
//		post.setDate(post1.getDate());
		post.setDate(post1.getDate());
		
		System.out.println(post);

		return mapper.updatePost(post);
	}

	// post 삭제
	@Override
	public int deletePost(int p_no) {
		return mapper.deletePost(p_no);
	}

	// post 읽기
	@Override
	public PostVO detailPost(int p_no) {
		
		PostVO post = mapper.detailPost(p_no);
				
		return post;
	}

	// Date 삽입, 수정, 삭제
//	@Override
//	public int updateDate(PostVO post) {
//
//		return mapper.updateDate(post);
//	}

	// Date 출력
	@Override
	public PostVO detailDate(int p_no) {

		PostVO post = mapper.detailDate(p_no);
		
		return post;
	}

}
