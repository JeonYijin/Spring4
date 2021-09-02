package com.ae.ae4;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.ae.ae4.notice.NoticeDAO;
import com.ae.ae4.notice.NoticeDTO;

public class NoticeDAOTest extends MyJunitTest {
	
	@Autowired
	private NoticeDAO noticeDAO;
	
	//@Test
	public void getListTest() {
		
	List<NoticeDTO> list = noticeDAO.getList();
	assertNotEquals(0, list.size());
	
	}
	
	@Test
	public void getSelectTest() {
		NoticeDTO noticeDTO = new NoticeDTO();
		noticeDTO.setNum(21L);
		noticeDTO = noticeDAO.getSelect(noticeDTO);
		assertNotNull(noticeDTO);
	}
	
}
