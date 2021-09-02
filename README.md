# Spring4

## Board

### Notice

 글번호, 글제목, 글내용, 작성자, 작성일, 조회수
	 1	  a     a     a     오늘   0
	 2	  a     a     a     오늘   0

1. 테이블 생성
   NOTICE 테이블명
   NUM  CONSTRAINTS NOTICE_NUM_PK PRIMARY KEY
   TITLE
   CONTENTS
   WRITER
   REGDATE
   HITS
   
2. Notice Sequence 생성
notice_seq

3. 기능
	1) List
		/notice/list
		/WEB-INF/views/board/list.jsp
	2) 상세 페이지
		/notice/select
		/WEB-INF/views/board/select.jsp
		파라미터로 num 넘기기
	3) 글쓰기
	4) 삭제
	5) 수정
4. 순서
1) DTO, DAO, MAPPER, TEST CASE 테스트 수행
2) 수행 끝나면 SERVICE, CONTROLLER, JSP 만들어서 최종 연결