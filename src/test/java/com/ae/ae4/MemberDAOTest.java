package com.ae.ae4;


import static org.junit.Assert.assertNotNull;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.ae.ae4.member.MemberDAO;
import com.ae.ae4.member.MemberDTO;


public class MemberDAOTest extends MyJunitTest {
	
	@Autowired
	private MemberDAO memberDAO;
	
	@Test
	public void getIdCheckTest() throws Exception {
		MemberDTO memberDTO = new MemberDTO();
		memberDTO.setId("AE31");
		memberDTO = memberDAO.getIdCheck(memberDTO);
		
		assertNotNull(memberDTO);
	}

}
