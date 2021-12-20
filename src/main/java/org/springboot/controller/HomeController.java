package org.springboot.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {

	@GetMapping("/")
	public String index() {
		 
		System.out.println("메인페이지 확인");
		 
		return "index";
	}
	
	
}
