package com.ae.ae4.member;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/member/**")
public class MemberController {

	@GetMapping("check")
	public ModelAndView check() throws Exception {
		ModelAndView mv= new ModelAndView();
		mv.setViewName("/member/check");
		return mv;
	}
	
	@GetMapping("join")
	public ModelAndView join()throws Exception{
		ModelAndView mv = new ModelAndView();
		mv.setViewName("member/join");
		return mv;
	}
}
