package com.ae.ae4.board;

import static org.junit.Assert.*;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.ae.ae4.MyJunitTest;
import com.ae.ae4.board.notice.NoticeDAO;
import com.ae.ae4.board.qna.QnaDAO;

public class CommentDAOTest extends MyJunitTest{

	@Autowired
	NoticeDAO noticeDAO;
	@Autowired
	QnaDAO qnaDAO;
	
	@Test
	public void test() throws Exception {
		for(int i=0; i<100; i++) {
			CommentsDTO commentsDTO = new CommentsDTO();
			commentsDTO.setNum(261L);
			commentsDTO.setWriter("AE11");
			commentsDTO.setContents("comments"+i);
			commentsDTO.setBoard("Q");
			qnaDAO.setComment(commentsDTO);
			if(i%10==0) {
				Thread.sleep(1000);
			}
			
		}
	
		System.out.println("Finish");
	}

}
