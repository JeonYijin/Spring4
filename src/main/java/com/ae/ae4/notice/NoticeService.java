package com.ae.ae4.notice;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ae.ae4.util.Pager;

@Service
public class NoticeService {
	
	@Autowired
	private NoticeDAO noticeDAO;
	
	public List<NoticeDTO> getList(Pager pager) {
		pager.makeRow();
		pager.makeNum();
		return noticeDAO.getList(pager);
	}
	
	public NoticeDTO getSelect(NoticeDTO noticeDTO) {
		return noticeDAO.getSelect(noticeDTO);
	}
	
	public int setInsert(NoticeDTO noticeDTO) {
		return noticeDAO.setInsert(noticeDTO);
	}
	
	public int setDelete(Long num) {
		return noticeDAO.setDelete(num);
	}
	
	public int setUpdate(NoticeDTO noticeDTO) {
		return noticeDAO.setUpdate(noticeDTO);
	}
}
