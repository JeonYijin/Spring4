package com.ae.ae4.board.util;

import java.io.File;
import java.util.UUID;

import org.springframework.stereotype.Component;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.multipart.MultipartFile;

@Component
public class FileManager {

	//fileSave 파일저장하는 메서드 만들기
	//파일 저장하기
	
	
	public String fileSave(MultipartFile multipartFile, File file) throws Exception {
		if(!file.exists()) {
			file.mkdirs();
		}
		
		//3. 파일 이름
		String fileName = UUID.randomUUID().toString();
		fileName = fileName+"-"+multipartFile.getOriginalFilename();
		//System.out.println(fileName);
		
		file = new File(file,fileName);
		
		//저장 방법 1 : FileCopyUtils
		//FileCopyUtils.copy(multipartFile.getBytes(), file);
		
		//4. 파일 저장방법 2: transferTo
		multipartFile.transferTo(file);
		
		return fileName;
	}
}
