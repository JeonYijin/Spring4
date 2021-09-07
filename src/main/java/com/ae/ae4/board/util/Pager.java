package com.ae.ae4.board.util;

public class Pager {

	private String kind;
	private String search;
	
	private Long pn;
	private Long perPage;
	private Long perBlock;
	
	private Long startRow;
	private Long lastRow;
	
	private Long startNum;
	private Long lastNum;
	
	private Long totalPage;
	
	public void makeRow() {
		this.startRow = (this.getPn()-1)*this.perPage+1;
		this.lastRow= this.getPn()*this.getPerPage();
	}
	
	public void makeNum(Long totalCount) {
		//1. totalCount 구하기
		//2. totalPage 구하기
		totalPage = totalCount/this.getPerPage();
		if(totalCount%this.getPerPage() !=0) {
			totalPage++;
		}
		//3. totalBlock 구하기
		Long totalBlock = totalPage/this.getPerBlock();
		if(totalPage%this.getPerBlock() !=0) {
			totalBlock++;
		}
		//데이터가 끝난 후에 다음 페이지로 넘어가지 않게함
		if(totalPage<this.getPn()) {
			this.setPn(totalPage);
		}
		//4. curBlock 구하기
		Long curBlock = this.getPn()/this.getPerBlock();
		if(this.getPn()%this.getPerBlock() !=0) {
			curBlock++;
		}
		//5. curBlock으로 startNum, lastNum 구하기
		
		this.startNum= (curBlock-1)*this.getPerBlock()+1;
		this.lastNum = curBlock*this.getPerBlock();
		
		//6. curBlock이 마지막 Block일때 lastNum 변경
		if(curBlock==totalBlock) {
			this.lastNum=totalPage;
		}
	}
	
	
	
	public Long getPerBlock() {
		if(this.perBlock == null || this.perBlock==0) {
			this.perBlock=5L;
		}
		return perBlock;
	}

	public void setPerBlock(Long perBlock) {
		this.perBlock = perBlock;
	}

	public String getKind() {
		return kind;
	}

	public void setKind(String kind) {
		this.kind = kind;
	}

	public String getSearch() {
		if(this.search==null) {
			this.search="";
		}
		return search;
	}

	public void setSearch(String search) {
		this.search = search;
	}

	public Long getTotalPage() {
		return totalPage;
	}
	public Long getPn() {
		if(this.pn==null|| this.pn<=0) {
			this.pn=1L;
		}
		return pn;
	}
	

	public void setPn(Long pn) {
		this.pn = pn;
	}
	public Long getPerPage() {
		if(this.perPage==null||this.perPage==0) {
			this.perPage=10L;
		}
		
		return perPage;
	}
	public void setPerPage(Long perPage) {
		this.perPage = perPage;
	}
	public Long getStartRow() {
		return startRow;
	}
	public void setStartRow(Long startRow) {
		this.startRow = startRow;
	}
	public Long getLastRow() {
		return lastRow;
	}
	public void setLastRow(Long lastRow) {
		this.lastRow = lastRow;
	}
	public Long getStartNum() {
		return startNum;
	}
	public void setStartNum(Long startNum) {
		this.startNum = startNum;
	}
	public Long getLastNum() {
		return lastNum;
	}
	public void setLastNum(Long lastNum) {
		this.lastNum = lastNum;
	}
	
	
}
