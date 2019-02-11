package kogile.project.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import kogile.invite.domain.InviteVO;
import kogile.project.domain.CardVO;
import kogile.project.domain.DragVO;
import kogile.project.domain.Prj_infoVO;
import kogile.project.domain.ProjectVO;
import kogile.project.domain.UserVO;
import kogile.project.mapper.ProjectMapper;
import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class ProjectServiceImpl implements ProjectService {
	
	private ProjectMapper mapper;

	@Override
	public List<ProjectVO> list(int total_m_no) {
		List<ProjectVO> list = mapper.list(total_m_no);
		return list;
	}

	@Transactional(propagation = Propagation.REQUIRED,
			rollbackFor = {Exception.class})
	@Override
	public void insert(ProjectVO project) {
		mapper.insert(project);
		mapper.insert_card(project.getPjt_no());
		InviteVO invite = new InviteVO();
		invite.setGrade("master");
		invite.setPjt_no(project.getPjt_no());
		invite.setTotal_m_no(project.getTotal_m_no());
		mapper.insert_invite(invite);
		Prj_infoVO prj_info = new Prj_infoVO();
		prj_info.setInvite_no(invite.getInvite_no());
		mapper.insert_prjinfo(prj_info);
	}

	@Override
	public void drag_post(DragVO drag) {
		mapper.drag_post(drag);
		
	}

	@Override
	public ProjectVO project_info(int pjt_no) {
		ProjectVO project = mapper.project_info(pjt_no);
		return project;
	}

	@Override
	public void modify(ProjectVO project) {
		mapper.modify(project);
	}

	@Override
	public UserVO master_info(int total_m_no) {
		UserVO master = mapper.master_info(total_m_no);
				
		return master;
	}

	@Override
	public void delete(int pjt_no) {
		mapper.delete(pjt_no);
	}

	
	
	

}
