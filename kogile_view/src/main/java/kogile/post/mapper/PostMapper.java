package kogile.post.mapper;

import java.util.List;

import kogile.post.domain.PostVO;

public interface PostMapper {
	public List<PostVO> list_post(int c_no);
}
