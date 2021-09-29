package com.ae.ae4.error;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/error/*")
public class FrontErrorController {
	
	@RequestMapping("error400")
	public ModelAndView error400() throws Exception{
		ModelAndView mv = new ModelAndView();
		
		mv.setViewName("error/front400");
		
		return mv;
	}
	
}
