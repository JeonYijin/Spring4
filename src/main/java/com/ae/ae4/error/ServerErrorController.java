package com.ae.ae4.error;

import java.sql.SQLException;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.ModelAndView;

@ControllerAdvice
public class ServerErrorController {

	//예외처리 메서드
	@ExceptionHandler(Exception.class)
	public ModelAndView getException() {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("error/serverError");
		return mv;
	}
	
	//예외처리 메서드
	@ExceptionHandler(SQLException.class)
	public ModelAndView getSQLException() {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("error/serverError");
		return mv;
	}
	
	@ExceptionHandler(NullPointerException.class)
	public ModelAndView getNullException() {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("error/serverError");
		return mv;
	}
	
}
