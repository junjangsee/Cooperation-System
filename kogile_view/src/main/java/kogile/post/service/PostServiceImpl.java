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

}
