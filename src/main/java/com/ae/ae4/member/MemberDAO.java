package com.ae.ae4.member;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class MemberDAO {

	@Autowired
	private SqlSession sqlSession;
	
	private final String NAMESPACE="com.ae.ae4.member.MemberDAO.";
	
	public MemberFilesDTO getFile(MemberDTO memberDTO) throws Exception{
		return sqlSession.selectOne(NAMESPACE+"getFile", memberDTO);
	}
	
	public MemberDTO getIdCheck(MemberDTO memberDTO) throws Exception {
		return	sqlSession.selectOne(NAMESPACE+"getIdCheck", memberDTO );
	}
	
	public MemberDTO getLogin(MemberDTO memberDTO) throws Exception{
		return sqlSession.selectOne(NAMESPACE+"getLogin", memberDTO);
	}
	
	public int setFileInsert(MemberFilesDTO memberFilesDTO) throws Exception{
		return sqlSession.insert(NAMESPACE+"setFileInsert", memberFilesDTO);
	}
	
	
	public int setInsert(MemberDTO memberDTO) throws Exception{
		return sqlSession.insert(NAMESPACE+"setInsert", memberDTO);
	}
	
	public int setUpdate(MemberDTO memberDTO) throws Exception{
		return sqlSession.update(NAMESPACE+"setUpdate", memberDTO);
	}
	
	public int setDelete(MemberDTO memberDTO) throws Exception{
		return sqlSession.delete(NAMESPACE+"setDelete", memberDTO);
	}
 }
