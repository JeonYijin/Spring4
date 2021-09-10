package com.ae.ae4.member;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class MemberDAO {

	@Autowired
	private SqlSession sqlSession;
	
	private final String NAMESPACE="com.ae.ae4.member.MemberDAO.";
	
	public MemberDTO getIdCheck(MemberDTO memberDTO) throws Exception {
		return	sqlSession.selectOne(NAMESPACE+"getIdCheck", memberDTO );
	}
	
	public MemberDTO getLogin(MemberDTO memberDTO) throws Exception{
		return sqlSession.selectOne(NAMESPACE+"getLogin", memberDTO);
	}
}
