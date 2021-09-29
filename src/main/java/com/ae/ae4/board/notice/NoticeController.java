package com.ae.ae4.board.notice;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.ae.ae4.board.BoardDTO;
import com.ae.ae4.board.BoardFilesDTO;
import com.ae.ae4.board.CommentsDTO;
import com.ae.ae4.board.util.Pager;
import com.ae.ae4.member.MemberDTO;

@Controller
@RequestMapping("/notice/**")
public class NoticeController {
	
	@Autowired
	private NoticeService noticeService;
	
	@ModelAttribute("board")
	public String getBoard() {
		return "notice";
	}
	
	@PostMapping("fileDelete")
	public ModelAndView setFileDelete(BoardFilesDTO boardFilesDTO) throws Exception{
		int result = noticeService.setFileDelete(boardFilesDTO);
		ModelAndView mv = new ModelAndView();
		
		mv.setViewName("common/ajaxResult");
		mv.addObject("result", result);
		return mv;
	}
	
	public ModelAndView setUpdate(BoardDTO boardDTO, MultipartFile[] files) throws Exception{
		ModelAndView mv = new ModelAndView();
		int result = noticeService.setUpdate(boardDTO, files);
		mv.setViewName("./select");
		
		return mv;
	}
	
	@GetMapping("update")
	public ModelAndView setUpdate(BoardDTO boardDTO)throws Exception{
		ModelAndView mv = new ModelAndView();
		boardDTO = noticeService.getSelect(boardDTO);
		mv.addObject("dto", boardDTO);
		mv.setViewName("board/update");
		
		return mv;
	}
	
	@PostMapping("commentUpdate")
	public ModelAndView setCommentUpdate(CommentsDTO commentsDTO) throws Exception{
		ModelAndView mv = new ModelAndView();
		
		int result = noticeService.setCommentUpdate(commentsDTO);
		mv.setViewName("common/ajaxResult");
		mv.addObject("result", result);
		return mv;
	}
	
	@PostMapping("commentDel")
	public ModelAndView setDeleteComment(CommentsDTO commentsDTO) throws Exception{
		ModelAndView mv = new ModelAndView();
		int result = noticeService.setCommentDelete(commentsDTO);
		mv.setViewName("common/ajaxResult");
		mv.addObject("result", result);
		return mv;
	}
	
//	@GetMapping("comment")
//	public ModelAndView setComment(CommentsDTO commentsDTO, ModelAndView mv,Pager pager) throws Exception{
//		
//		List<CommentsDTO> ar = noticeService.getComment(commentsDTO);
//		mv.addObject("comment", ar );
//		mv.setViewName("board/select");
//		//mv.setViewName("redirect:./select");
//		return mv;
//	}
	
	@GetMapping("getCommentList")
	public ModelAndView getCommentList(CommentsDTO commentsDTO, Pager pager)throws Exception{
		commentsDTO.setBoard("N");
		List<CommentsDTO> ar = noticeService.getComment(commentsDTO, pager);
		ModelAndView mv = new ModelAndView();
		mv.addObject("comments", ar);
		mv.addObject("pager", pager);
		mv.setViewName("common/ajaxList");
		return mv;
	}
	
	//setComment
	@PostMapping("comment")
	public ModelAndView setComment(CommentsDTO commentsDTO)throws Exception{
		commentsDTO.setBoard("N");
		ModelAndView mv = new ModelAndView();
		int result = noticeService.setComment(commentsDTO);
		//System.out.println(result);
		
		//mv.setViewName("board/select");
		mv.setViewName("common/ajaxResult");
		mv.addObject("result", result);
		
		//System.out.println(commentsDTO.getNum());
		//System.out.println(commentsDTO.getWriter());
		return mv;
	}
	
	
	@GetMapping("down")
	public ModelAndView fileDown(BoardFilesDTO boardFilesDTO) throws Exception{
		ModelAndView mv = new ModelAndView();
		mv.addObject("dto", boardFilesDTO);
		mv.setViewName("fileDown");
		
		return mv;
	}
	
	
	@GetMapping("delete")
	public ModelAndView setDelete(BoardDTO boardDTO) throws Exception{
		ModelAndView mv = new ModelAndView();
		int result = noticeService.setDelete(boardDTO);
		String message = "Delete Fail";
		
		if(result>0) {
			message = "Delete Sucess";
		}
		
		mv.addObject("msg", message);
		mv.addObject("url", "./list");
		mv.setViewName("common/result");
		
		return mv;
		
	}
	
	@GetMapping("select")
	public ModelAndView getSelect(BoardDTO boardDTO, Pager pager) throws Exception {
		ModelAndView mv = new ModelAndView();
		boardDTO = noticeService.getSelect(boardDTO);
		//List<BoardFilesDTO> ar = noticeService.getFiles(boardDTO);
		//mv.addObject("fileList", ar);
//		List<CommentsDTO> ar = noticeService.getComment(pager);
//		mv.addObject("pager", pager);
//		mv.addObject("comment", ar );
		mv.addObject("dto", boardDTO);
		mv.setViewName("board/select");
		return mv;
	}
	
	
	@GetMapping("insert")
	public ModelAndView setInsert() throws Exception{
		ModelAndView mv= new ModelAndView();
		mv.setViewName("board/insert");
		return mv;
	}
	
	@PostMapping("insert")
	public ModelAndView setInsert(BoardDTO boardDTO, MultipartFile[] files) throws Exception{
		//original file name 출력
		for(MultipartFile muFile: files) {
			System.out.println(muFile.getOriginalFilename());
		}
		ModelAndView mv = new ModelAndView();
		int result = noticeService.setInsert(boardDTO, files);
		mv.setViewName("redirect:./list");
		return mv;
	}
	
	
	@GetMapping("list")
	public ModelAndView getList(Pager pager) throws Exception {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("board/list");
		
		List<BoardDTO> ar =noticeService.getList(pager);
		mv.addObject("list", ar);
		mv.addObject("pager", pager);
		
		return mv;
	}
	

	
	
}
