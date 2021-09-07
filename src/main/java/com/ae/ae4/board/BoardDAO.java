package com.ae.ae4.board;

import java.util.List;

import com.ae.ae4.board.util.Pager;

public interface BoardDAO {
	
	//전체갯수
	public Long getCount(Pager pager) throws Exception;
	
	//조회수 업데이트
	public int setHitUpdate(BoardDTO boardDTO) throws Exception;
	
	//List
	public abstract List<BoardDTO> getList(Pager pager) throws Exception; 
	
	//select 상세
	public abstract BoardDTO getSelect(BoardDTO boardDTO) throws Exception;
	
	//글쓰기
	public int setInsert(BoardDTO boardDTO) throws Exception;
	
	//삭제
	public int setDelete(BoardDTO boardDTO) throws Exception;
	
	//수정
	public int setUpdate(BoardDTO boardDTO) throws Exception;
	
}
