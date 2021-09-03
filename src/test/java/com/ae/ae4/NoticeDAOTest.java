package com.ae.ae4;

import static org.junit.Assert.*;

import java.sql.Date;
import java.util.List;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.ae.ae4.notice.NoticeDAO;
import com.ae.ae4.notice.NoticeDTO;

public class NoticeDAOTest extends MyJunitTest {
	
	@Autowired
	private NoticeDAO noticeDAO;
	
	//@Test
	/*
	 * public void getListTest() {
	 * 
	 * List<NoticeDTO> list = noticeDAO.getList(); assertNotEquals(0, list.size());
	 * 
	 * }
	 */
	
	//@Test
	public void getSelectTest() {
		NoticeDTO noticeDTO = new NoticeDTO();
		noticeDTO.setNum(21L);
		noticeDTO = noticeDAO.getSelect(noticeDTO);
		assertNotNull(noticeDTO);
	}
	
	@Test
	public void setInsert() throws Exception {
		NoticeDTO noticeDTO = new NoticeDTO();
		for(int i=0; i<200; i++) {
			noticeDTO.setTitle("title"+i);
			noticeDTO.setContents("contents"+i);
			noticeDTO.setWriter("writer"+i);
			int result = noticeDAO.setInsert(noticeDTO);
			if(i%10==0) {
				Thread.sleep(500);
			}
		}
		System.out.println("===============");
		
	}
	
	//@Test
	public void setDeleteTest() {
		int result = noticeDAO.setDelete(42l);
		assertEquals(1, result);
	}
	
	//@Test
	public void setUpdate() {
		NoticeDTO noticeDTO = new NoticeDTO();
		noticeDTO.setNum(1);
		noticeDTO.setTitle("ag");
		noticeDTO.setContents("adhec");
		noticeDTO.setWriter("HI");
		noticeDTO.setHits(1L);
		
		int result = noticeDAO.setUpdate(noticeDTO);
		
		assertEquals(1, result);
	}
	
	
}
