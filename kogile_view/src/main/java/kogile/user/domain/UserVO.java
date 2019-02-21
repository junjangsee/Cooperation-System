package kogile.user.domain;

import org.springframework.stereotype.Repository;

import lombok.Data;
import lombok.ToString;

/*
 * EXTER_M_NO number
 * EXTER_MEM_NAME varchar
 * EXTER_M_EMAIL
 * INTERLINKED_INFO_TYPE VARCHAR
 * INTERLINKED_INFO NUMBER
 */

/*
 * ���θ���� ��쿡 total_m_no, isInterMem, email, name�� �����ϴ�.
 * �ܺθ���� email�� ������ ������ ������ �����ϴ�.
 */
@Data
@ToString
public class UserVO {
	private int total_m_no;
	private int intermemNo;
	private boolean isInterMem; // �ܺθ������ �ƴ���
	private String email;
	private String name;
	private long interlinked_info; //īī�� ��ü ȸ����ȣ
	private String interlinked_info_type; //īī������..
	private String access_token;
	
	private String fname;
					
}
