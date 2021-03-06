package com.ae.ae4.board.qna;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
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

@Controller
@RequestMapping("/qna/**")
public class QnaController {
	
	@Autowired
	private QnaService qnaService;
	
	@ModelAttribute("board")
	public String getBoard() {
		return "qna";
	}
	
	@GetMapping("getCommentList")
	public ModelAndView getCommentList(CommentsDTO commentsDTO, Pager pager)throws Exception{
		commentsDTO.setBoard("Q");
		List<CommentsDTO> ar = qnaService.getComment(commentsDTO, pager);
		ModelAndView mv = new ModelAndView();
		mv.addObject("comments", ar);
		mv.addObject("pager", pager);
		mv.setViewName("common/ajaxList");
		return mv;
	}
	
	//setComment
		@PostMapping("comment")
		public ModelAndView setComment(CommentsDTO commentsDTO)throws Exception{
			commentsDTO.setBoard("Q");
			ModelAndView mv = new ModelAndView();
			int result = qnaService.setComment(commentsDTO);

			mv.setViewName("common/ajaxResult");
			mv.addObject("result", result);

			return mv;
		}
	
	
	
	@GetMapping("delete")
	public ModelAndView setDelete(BoardDTO boardDTO) throws Exception{
		ModelAndView mv= new ModelAndView();
		int result = qnaService.setDelete(boardDTO);
		mv.setViewName("redirect:./list");
		return mv;
	}
	
	@PostMapping("reply")
	public ModelAndView setReply(QnaDTO qnaDTO) throws Exception{
		ModelAndView mv = new ModelAndView();
		int result = qnaService.setReply(qnaDTO);
		mv.setViewName("redirect:./list");
		return mv;
	}
	
	@GetMapping("reply")
	public ModelAndView setReply() throws Exception{
		ModelAndView mv = new ModelAndView();
		mv.setViewName("board/reply");
		return mv;
	}
	
	@GetMapping("select")
	public ModelAndView getSelect(BoardDTO boardDTO) throws Exception {
		ModelAndView mv = new ModelAndView();
		boardDTO = qnaService.getSelect(boardDTO);
		List<BoardFilesDTO> ar = qnaService.getFiles(boardDTO);
		//mv.addObject("fileList", ar);
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
		ModelAndView mv = new ModelAndView();
		int result = qnaService.setInsert(boardDTO,files);
		mv.setViewName("redirect:./list");
		return mv;
	}

	@GetMapping("list")
	public ModelAndView getList(Pager pager) throws Exception {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("board/list");
		List<BoardDTO> ar = qnaService.getList(pager);
		mv.addObject("list", ar);
		mv.addObject("pager", pager);
		return mv;
	}
	
}
