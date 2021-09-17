package com.ae.ae4.member;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/member/**")
public class MemberController {

	@Autowired
	private MemberService memberService;
	
	/*
	 * @GetMapping("delete") public ModelAndView setDelete(MemberDTO memberDTO)
	 * throws Exception{ int result = memberService.setDelete(memberDTO);
	 * ModelAndView mv = new ModelAndView(); mv.setViewName("redirect:../"); return
	 * mv; }
	 */
	
	@GetMapping("delete")
	public ModelAndView setDelete(HttpSession session) throws Exception{
		MemberDTO memberDTO = (MemberDTO)session.getAttribute("member");
		
		int result = memberService.setDelete(memberDTO);
		session.invalidate(); //또는 redirect를 로그아웃으로 보내기
		ModelAndView mv = new ModelAndView();
		mv.setViewName("redirect:../");
		return mv;
	}
	
	
	@GetMapping("myupdate")
	public ModelAndView setUpdate(MemberDTO memberDTO) throws Exception {
		ModelAndView mv = new ModelAndView();
		memberDTO = memberService.getLogin(memberDTO);
		//mv.addObject("dto", memberDTO);
		mv.setViewName("member/myupdate");
		return mv;
	}
	
	
	@PostMapping("myupdate")
	public ModelAndView setUpdate(MemberDTO memberDTO, HttpSession session) throws Exception {
		//수정전 데이터
		MemberDTO sessionDTO = (MemberDTO)session.getAttribute("member");
		//수정후 데이터
		memberDTO.setId(sessionDTO.getId());
		int result = memberService.setUpdate(memberDTO);
		memberDTO.setName(sessionDTO.getName());
		session.setAttribute("member", memberDTO);
		
		ModelAndView mv = new ModelAndView();
		mv.setViewName("redirect:./mypage");
		return mv;
	}
	
	@GetMapping("mypage")
	public ModelAndView mypage(HttpSession session) throws Exception {
		ModelAndView mv = new ModelAndView();
		MemberDTO memberDTO = (MemberDTO)session.getAttribute("member");
		MemberFilesDTO memberFilesDTO = memberService.getFile(memberDTO);
		//mv.addObject("files", memberFilesDTO);
		mv.setViewName("member/mypage");
		return mv;
	}
	
	
	@GetMapping("logout")
	public ModelAndView logout(HttpSession session) throws Exception{
		//1. session의 attribute를 없애는것
		//session.removeAttribute("member");
		
		//2.session이 일정시간이 지나면 죽이기 - session 시간을 0으로 만들기 -> 새로운 세션 - 멤버없음
		session.invalidate();
		
		
		ModelAndView mv = new ModelAndView();
		mv.setViewName("redirect:../");
		
		return mv;
	}
	
	
	@PostMapping("login")
	public ModelAndView login(MemberDTO memberDTO, HttpSession session) throws Exception{
		ModelAndView mv = new ModelAndView();
		//HttpSession session= request.getSession();
		
		memberDTO = memberService.getLogin(memberDTO);
		if(memberDTO != null) {
			System.out.println("로그인 성공");
			session.setAttribute("member", memberDTO);
		}else {
			System.out.println("로그인 실패");
		}
		
		mv.setViewName("redirect:../");
		return mv;
	}
	
	
	@GetMapping("login")
	public ModelAndView login() throws Exception{
		ModelAndView mv = new ModelAndView();
		mv.setViewName("member/login");
		return mv;
	}
	
	@GetMapping("idCheckAjax")
	public ModelAndView getIdCheckAjax(MemberDTO memberDTO) throws Exception{
		//중복검사할 아이디 출력
		System.out.println(memberDTO.getId());
		memberDTO = memberService.getIdCheck(memberDTO);
		//1 이면 사용 가능
		//0 이면 사용 불가(중복)
		int result = 0;
		if(memberDTO == null) {
			result = 1;
		}
		ModelAndView mv = new ModelAndView();
		mv.setViewName("common/ajaxResult");
		mv.addObject("result", result);
		
		return mv;
	}
	
	@GetMapping("idCheck")
	public ModelAndView getIdCheck(MemberDTO memberDTO) throws Exception{
		ModelAndView mv= new ModelAndView();
		memberDTO = memberService.getIdCheck(memberDTO);
		System.out.println("id 중복체크");
		
		mv.setViewName("member/idCheck");
		mv.addObject("dto", memberDTO);
		return mv;
	}
	
	
	@GetMapping("check")
	public ModelAndView check() throws Exception {
		ModelAndView mv= new ModelAndView();
		mv.setViewName("/member/check");
		return mv;
	}
	
	/*
	 * @GetMapping("join") public ModelAndView join()throws Exception{ ModelAndView
	 * mv = new ModelAndView(); mv.setViewName("member/join"); return mv; }
	 */
	
	@GetMapping("join")
	public ModelAndView setInsert()throws Exception{
		ModelAndView mv = new ModelAndView();
		mv.setViewName("member/join");
		return mv;
	}
	
	@PostMapping("join")
	public ModelAndView setInsert(MemberDTO memberDTO, MultipartFile photo, HttpSession session) throws Exception{
		ModelAndView mv= new ModelAndView();

		int result = memberService.setInsert(memberDTO, photo,session);
		
		String message = "회원가입 실패";
		if(result>0) {
			message="회원가입 성공";
		}
		
		mv.addObject("msg", message);
		mv.addObject("url", "../");
		mv.setViewName("common/result");
		return mv;
	}
	
}
