package com.ae.ae4.board.qna;

import java.io.File;
import java.util.List;

import javax.servlet.ServletContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.ae.ae4.board.BoardDTO;
import com.ae.ae4.board.BoardFilesDTO;
import com.ae.ae4.board.BoardService;
import com.ae.ae4.board.util.FileManager;
import com.ae.ae4.board.util.Pager;

@Service
public class QnaService implements BoardService {

	@Autowired
	private QnaDAO qnaDAO;
	
	@Autowired
	private ServletContext servletContext;
	@Autowired
	private FileManager fileManager;
	
	@Override
	public List<BoardDTO> getList(Pager pager) throws Exception {
		Long totalCount = qnaDAO.getCount(pager);
		pager.makeNum(totalCount);
		pager.makeRow();
		return qnaDAO.getList(pager);
	}

	public List<BoardFilesDTO> getFiles(BoardDTO boardDTO) throws Exception{
		return qnaDAO.getFiles(boardDTO);
	}
	
	@Override
	public BoardDTO getSelect(BoardDTO boardDTO) throws Exception {
		qnaDAO.setHitUpdate(boardDTO);
		return qnaDAO.getSelect(boardDTO);
	}

	@Override
	public int setInsert(BoardDTO boardDTO, MultipartFile[] files) throws Exception {
		
		//폴더명 /resources/upload/qna/
		String realPath = servletContext.getRealPath("/resources/upload/qna");
		System.out.println(realPath);
		int result = qnaDAO.setInsert(boardDTO);
		File file = new File(realPath);
		
		for(MultipartFile multipartFile: files) {
			String fileName = fileManager.fileSave(multipartFile, file);
			BoardFilesDTO boardFilesDTO = new BoardFilesDTO();
			boardFilesDTO.setFileName(fileName);
			boardFilesDTO.setOriName(multipartFile.getOriginalFilename());
			boardFilesDTO.setNum(boardDTO.getNum());
			
			result = qnaDAO.setFile(boardFilesDTO);
		}
		
		
		return result;
	}

	@Override
	public int setDelete(BoardDTO boardDTO) throws Exception {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int setUpdate(BoardDTO boardDTO) throws Exception {
		// TODO Auto-generated method stub
		return 0;
	}

	public int setReply(QnaDTO qnaDTO) throws Exception {
		//1. 부모의 정보 조회
		System.out.println(qnaDTO.getNum());
		QnaDTO parent = (QnaDTO)qnaDAO.getSelect(qnaDTO);
		//System.out.println(parent.getNum());
		qnaDTO.setRef(parent.getRef());
		qnaDTO.setStep(parent.getStep()+1);
		qnaDTO.setDepth(parent.getDepth()+1);
		
		//2. update
		int result = qnaDAO.setReplyUpdate(parent);
		
		//3. insert
		result = qnaDAO.setReply(qnaDTO);
		return result;
	}
	
}
