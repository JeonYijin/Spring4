package com.ae.ae4.board;

import java.util.List;

import org.springframework.web.multipart.MultipartFile;

import com.ae.ae4.board.util.Pager;

public interface BoardService {

		//List
		public abstract List<BoardDTO> getList(Pager pager) throws Exception; 
		
		//select 상세
		public abstract BoardDTO getSelect(BoardDTO boardDTO) throws Exception;
		
		//글쓰기
		public int setInsert(BoardDTO boardDTO, MultipartFile[] files) throws Exception;
		
		//삭제
		public int setDelete(BoardDTO boardDTO) throws Exception;
		
		//수정
		public int setUpdate(BoardDTO boardDTO, MultipartFile[] files) throws Exception;
	
}
