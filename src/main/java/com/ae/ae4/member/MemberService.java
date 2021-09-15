package com.ae.ae4.member;

import java.io.File;
import java.util.UUID;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.multipart.MultipartFile;

@Service
public class MemberService {

	@Autowired
	private MemberDAO memberDAO;
	@Autowired
	private HttpSession session;
	@Autowired
	private ServletContext servletContext;
	
	public MemberDTO getIdCheck(MemberDTO memberDTO) throws Exception {
		return memberDAO.getIdCheck(memberDTO);
	}
	
	public MemberDTO getLogin(MemberDTO memberDTO) throws Exception{
		return memberDAO.getLogin(memberDTO);
	}
	
	public int setInsert(MemberDTO memberDTO, MultipartFile photo, HttpSession session) throws Exception{
		
		int result = memberDAO.setInsert(memberDTO);
		
		if(photo != null) {
		//1. 어느폴더에 저장
		// /resources/upload/member
		//2. application(ServletContext) 객체 필요 - 운영체제를 연결해줄 객체
		//객체로 저장할 실제 경로 구하기
		//ServletContext sContext = this.session.getServletContext();
		String realPath = this.servletContext.getRealPath("/resources/upload/member/");
		System.out.println("realPath: "+realPath);
		//3. 폴더확인
		File file = new File(realPath);
		if(!file.exists()) {
			file.mkdirs();
		}
		//4. 중복되지 않는 파일이름 생성
		//a. 시간-> 밀리세컨즈
		//b. UUID
		String fileName= UUID.randomUUID().toString();
		fileName = fileName+"_"+photo.getOriginalFilename();
		System.out.println(fileName);
		
		//폴더경로와 파일명의 정보를 가진 file 객체
		file = new File(file, fileName);
		//5. 폴더에 파일 저장
		//1) MultipartFile의 transferTo 메서드 사용
		//photo.transferTo(file);
		
		//2) Spring의 API FileCopyUtils의 copy static 메서드 사용 
		FileCopyUtils.copy(photo.getBytes(), file);
		
		MemberFilesDTO memberFilesDTO = new MemberFilesDTO();
		memberFilesDTO.setId(memberDTO.getId());
		memberFilesDTO.setFileName(fileName);
		memberFilesDTO.setOriName(photo.getOriginalFilename());
		result = memberDAO.setFileInsert(memberFilesDTO);
		}
		return result;
		
		
	}
	
	public MemberFilesDTO getFile(MemberDTO memberDTO) throws Exception{
		return memberDAO.getFile(memberDTO);
	}
	
	public int setUpdate(MemberDTO memberDTO) throws Exception{
		return memberDAO.setUpdate(memberDTO);
	}
	
	public int setDelete(MemberDTO memberDTO) throws Exception{
		//1. 어느 폴더에 있는 이미지를 삭제할건지
		String realPath = servletContext.getRealPath("/resources/upload/member/");
		
		//2. 어느 파일을 삭제할건지
		MemberFilesDTO memberFilesDTO = memberDAO.getFile(memberDTO);
		
		//3. 파일 삭제
		File file = new File(realPath, memberFilesDTO.getFileName());
		file.delete();
		return memberDAO.setDelete(memberDTO);
	}
}
