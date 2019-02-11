package kogile.chat.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class ChatVO {
	private int pjt_no;
	private String writer, 
					chatContents;
}
