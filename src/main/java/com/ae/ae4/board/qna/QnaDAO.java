package com.ae.ae4.board.qna;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ae.ae4.board.BoardDAO;
import com.ae.ae4.board.BoardDTO;

@Repository
public class QnaDAO implements BoardDAO {

	@Autowired
	private SqlSession sqlSession;
	
	private final String NAMESPACE = "com.ae.ae4.board.qna.QnaDAO.";
	
	@Override
	public Long getCount() throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<BoardDTO> getList() throws Exception {
		// TODO Auto-generated method stub
		return sqlSession.selectList(NAMESPACE+"getList");
	}

	@Override
	public BoardDTO getSelect(BoardDTO boardDTO) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int setInsert(BoardDTO boardDTO) throws Exception {
		// TODO Auto-generated method stub
		return 0;
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

	//답글달기
	public int setReply(QnaDTO qnaDTO) throws Exception{
		return 0;
	}
	
}
