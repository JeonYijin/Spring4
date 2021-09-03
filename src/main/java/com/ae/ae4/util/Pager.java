package com.ae.ae4.util;

public class Pager {
	
	private Long pn;
	private Long perPage;
	private Long startRow;
	private Long lastRow;
	private Long startNum;
	private Long lastNum;
	
	public void makeRow() {
		startRow = (this.getPn()-1)*this.getPerPage()+1;
		lastRow = this.getPn()*this.getPerPage();
	}
	
	public void makeNum(){
		//1.총 개수 - 204개
		Long totalCount = 204L;
		
		//2. 한번에 10개씩 totalPage = 204/10 = 21개
		Long totalPage = totalCount/this.getPerPage();
		
		if(totalCount%this.getPerPage() !=0) {
			totalPage++;
		}
		
		//3. 10개씩 page버튼 만들기 totalBlock
		Long totalBlock = totalPage/10;
		if(totalPage%10 !=0) {
			totalBlock++;
		}
		
		//4. 현재 블럭 구하기
		Long curBlock = this.getPn()/10;
		if(this.getPn()%10 !=0) {
			curBlock++;
		}
		
		//5. curBlock으로 startNum, lastNum 구하기
		this.startNum = (curBlock-1)*10+1;
		this.lastNum = curBlock*10;
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

	public Long getPn() {
		if(this.pn==null || this.pn<=0) {
			this.pn=1L;
		}
		return pn;
	}
	public void setPn(Long pn) {
		this.pn = pn;
	}
	public Long getPerPage() {
		if(this.perPage == null || this.perPage<=0) {
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
	
	
	
	
}
