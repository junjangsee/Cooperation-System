package kogile.reply.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/kogile/")
public class A {
	@GetMapping("/ex")
	public void ex() {
		System.out.println("가라");
	}
}
