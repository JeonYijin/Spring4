package com.ae.ae4.board.qna;

import java.util.List;

import com.ae.ae4.board.BoardDTO;
import com.ae.ae4.board.BoardFilesDTO;

public class QnaDTO extends BoardDTO{
	

	private List<BoardFilesDTO> files;
	
	
	
	public List<BoardFilesDTO> getFiles() {
		return files;
	}
	public void setFiles(List<BoardFilesDTO> files) {
		this.files = files;
	}
	private Long ref;
	private Long step;
	private Long depth;
	public Long getRef() {
		return ref;
	}
	public void setRef(Long ref) {
		this.ref = ref;
	}
	public Long getStep() {
		return step;
	}
	public void setStep(Long step) {
		this.step = step;
	}
	public Long getDepth() {
		return depth;
	}
	public void setDepth(Long depth) {
		this.depth = depth;
	}
	
	
}
