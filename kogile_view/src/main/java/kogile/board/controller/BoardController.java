package kogile.board.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import kogile.board.domain.BoardVO;
import kogile.board.service.BoardService;
import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j;

@Log4j
@Controller
@AllArgsConstructor
@RequestMapping("/kogile/board/*")
public class BoardController {

	private BoardService service;
	
	@GetMapping("/list")
	public void list_board(int pjt_no, Model model) {
		
		List<BoardVO> list = service.listBoard(pjt_no);
		
		model.addAttribute("list", list);
	}
	
}
