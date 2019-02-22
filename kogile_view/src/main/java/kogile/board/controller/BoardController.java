package kogile.board.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import kogile.board.domain.BoardVO;
import kogile.board.domain.Criteria;
import kogile.board.domain.PageDTO;
import kogile.board.service.BoardService;
import kogile.user.domain.UserVO;
import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j;

@Log4j
@Controller
@AllArgsConstructor
@RequestMapping("/kogile/board/*")
@SessionAttributes({"pjt_no", "user"})
public class BoardController {

	private BoardService service;
	
	@GetMapping("/list")
	public void list_board(@ModelAttribute("pjt_no") int pjt_no, Model model) {

		model.addAttribute("list", service.listBoard(pjt_no));
	}

	@GetMapping("/detailBoard")
	public void detail_board(int b_no, Model model) {
		
		BoardVO board = service.detailBoard(b_no);
		
		model.addAttribute("board", board);
	}

	@PostMapping("/updateBoard")
	public String update_board(BoardVO board) {
		
		service.updateBoard(board);
		
		return "redirect:/kogile/board/detailBoard?b_no="+board.getB_no();
	}

	@GetMapping("/deleteBoard")
	public String delete_board(int b_no) {
		
		service.deleteBoard(b_no);
		
		return "redirect:/kogile/board/list";
	}
	
	@GetMapping("/insertBoardForm")
	public void insert_board_form() {
		
	}
	
	@PostMapping("/insertBoard")
	public String insert_board(BoardVO board, @ModelAttribute("pjt_no") int pjt_no, @ModelAttribute("user") UserVO user) {
		
		board.setWriter(user.getName());
		board.setPjt_no(pjt_no);
		
		service.insertBoard(board);
		
		return "redirect:/kogile/board/list";
	}
}
