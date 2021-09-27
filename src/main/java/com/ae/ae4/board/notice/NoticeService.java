package com.ae.ae4.board.notice;

import java.io.File;
import java.util.HashMap;
import java.util.List;
import java.util.UUID;

import javax.servlet.ServletContext;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.ae.ae4.board.BoardDTO;
import com.ae.ae4.board.BoardFilesDTO;
import com.ae.ae4.board.BoardService;
import com.ae.ae4.board.CommentsDTO;
import com.ae.ae4.board.util.FileManager;
import com.ae.ae4.board.util.Pager;

@Service
public class NoticeService implements BoardService {
	
	@Autowired
	private NoticeDAO noticeDAO;

	@Autowired
	private ServletContext servletContext;
	@Autowired
	private FileManager fileManager;
	
	public int setCommentUpdate(CommentsDTO commentsDTO) throws Exception{
		return noticeDAO.setCommentUpdate(commentsDTO);
	}
	
	public int setCommentDelete(CommentsDTO commentsDTO) throws Exception{
		return noticeDAO.setCommentDelete(commentsDTO);
	}
	
	public List<CommentsDTO> getComment(CommentsDTO commentsDTO, Pager pager) throws Exception{
		
		
		pager.setPerPage(5L);
		pager.makeRow();
		//전체 댓글의 갯수
		Long count = noticeDAO.getCommentCount(commentsDTO);
		pager.makeNum(count);
		//System.out.println(count);
		HashMap<String, Object> map = new HashMap<String, Object>();
		map.put("comments", commentsDTO);
		map.put("pager", pager);
		return noticeDAO.getComment(map);
	}
	
	
	public int setComment(CommentsDTO commentsDTO) throws Exception{
		return noticeDAO.setComment(commentsDTO);
	}
	public int setFileDelete(BoardFilesDTO boardFilesDTO)throws Exception{
		//폴더에서 파일 삭제
		String realPath = servletContext.getRealPath("/resources/upload/notice/");
		File file = new File(realPath, boardFilesDTO.getFileName());
		fileManager.fileDelete(file);
		return noticeDAO.setFileDelete(boardFilesDTO);
	}
	
	public List<BoardFilesDTO> getFiles(BoardDTO boardDTO) throws Exception{
		
		return noticeDAO.getFiles(boardDTO);
	}
	
	@Override
	public List<BoardDTO> getList(Pager pager) throws Exception {

		Long totalCount = noticeDAO.getCount(pager);
		pager.makeNum(totalCount);
		pager.makeRow();
		return noticeDAO.getList(pager);
	}

	@Override
	public BoardDTO getSelect(BoardDTO boardDTO) throws Exception {
		
		//List<BoardFilesDTO> ar = noticeDAO.getFiles(boardDTO);
		
		noticeDAO.setHitUpdate(boardDTO);
		return noticeDAO.getSelect(boardDTO);
	}

	@Override
	public int setInsert(BoardDTO boardDTO, MultipartFile[] files) throws Exception {
		//1. 어느 폴더에 저장할것인지
		// /resources/upload/notice/
		String realPath = servletContext.getRealPath("/resources/upload/notice/");
		System.out.println(realPath);
		//폴더가 없으면 생성해주기
		File file = new File(realPath);
		
		System.out.println("Before Num: " + boardDTO.getNum());
		int result = noticeDAO.setInsert(boardDTO);
		// 번호 가져오기 
		System.out.println("After Num: "+ boardDTO.getNum());
		
		for(MultipartFile multipartFile: files) {
			 String fileName = fileManager.fileSave(multipartFile, file);
			 System.out.println(fileName);
			 BoardFilesDTO boardFilesDTO = new BoardFilesDTO();
			 boardFilesDTO.setFileName(fileName);
			 boardFilesDTO.setOriName(multipartFile.getOriginalFilename());
			 boardFilesDTO.setNum(boardDTO.getNum());
			 
			result = noticeDAO.setFile(boardFilesDTO);
		}
		
		
		
		
		
		return result;
	}

	@Override
	public int setDelete(BoardDTO boardDTO) throws Exception {
		
		String realPath = servletContext.getRealPath("/resources/upload/notice");
		List<BoardFilesDTO> ar = noticeDAO.getFiles(boardDTO);
		//File file = new File(realPath);
		
		//fileManager.fileDelete(ar, file);
		
		
		for(BoardFilesDTO files : ar) {
			File file = new File(realPath, files.getFileName());
			file.delete();
		}
		
		return noticeDAO.setDelete(boardDTO);
	}

	@Override
	public int setUpdate(BoardDTO boardDTO, MultipartFile[] files) throws Exception {

		String realPath = servletContext.getRealPath("/resources/upload/notice/");
		File file = new File(realPath);
		int result = noticeDAO.setUpdate(boardDTO);
		for(MultipartFile multipartFile: files) {
			String fileName = fileManager.fileSave(multipartFile, file);
			BoardFilesDTO boardFilesDTO = new BoardFilesDTO();
			boardFilesDTO.setFileName(fileName);
			boardFilesDTO.setOriName(multipartFile.getOriginalFilename());
			boardFilesDTO.setNum(boardDTO.getNum());
			
			result = noticeDAO.setFile(boardFilesDTO);
		}
		
		return result;
	}

}
