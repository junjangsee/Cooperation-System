package kogile.label.domain;

import lombok.Data;

@Data
public class LabelVO {
	private int label_no;
	private String label_text;
	private int color_no;
	private int pjt_no;
	
	//label info 테이블 사용 시
	private int p_no;
	
	public LabelVO() {};

	public LabelVO(String label_text, int color_no, int pjt_no) {
		super();
		this.label_text = label_text;
		this.color_no = color_no;
		this.pjt_no = pjt_no;
	}
	
	
}
