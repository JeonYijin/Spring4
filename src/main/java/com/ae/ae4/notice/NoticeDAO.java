package com.ae.ae4.notice;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ae.ae4.util.Pager;

@Repository
public class NoticeDAO {
	
	@Autowired
	private SqlSession sqlSession;
	
	private final String NAMESPACE="com.ae.ae4.notice.NoticeDAO.";

	public List<NoticeDTO> getList(Pager pager) {
		return sqlSession.selectList(NAMESPACE+"getList", pager);
	}
	
	public NoticeDTO getSelect(NoticeDTO noticeDTO) {
		return sqlSession.selectOne(NAMESPACE+"getSelect", noticeDTO);
	}
	
	public int setInsert(NoticeDTO noticeDTO) {
		return sqlSession.insert(NAMESPACE+"setInsert", noticeDTO);
	}
	
	public int setDelete(Long num) {
		return sqlSession.delete(NAMESPACE+"setDelete", num);
	}
	
	public int setUpdate(NoticeDTO noticeDTO) {
		return sqlSession.update(NAMESPACE+"setUpdate", noticeDTO);
	}
}
