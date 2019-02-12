package kogile.chat.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@AllArgsConstructor
@ToString
public class ChatVO {
	
	public ChatVO() {}
	private int pjt_no,
				chat_no,
			total_m_no;
	
	private String writer, 
					chatContents;
}
