package kogile.project.mapper;

import java.util.List;

import kogile.invite.domain.InviteVO;
import kogile.project.domain.Prj_infoVO;
import kogile.project.domain.ProjectVO;

public interface ProjectMapper {
	
	public List<ProjectVO> list(int total_m_no);
	public int insert(ProjectVO project);
	public int insert_invite(InviteVO invite);
	public int insert_prjinfo(Prj_infoVO prj_info);
}
