package kogile.user.controller;

import java.util.Map;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.extern.log4j.Log4j;

@Log4j
@RestController
@RequestMapping("/login/external")
public class UserRedirectController {
	
	@GetMapping("/kakaoOauth")
	public void kakaoOauth(){
		System.out.println("Igotit!");
		//System.out.println(req);
	}

}
