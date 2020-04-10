package com.hrm.domain;


import static com.hrm.util.Constants.PAGE_DEFAULT_SIZE;

public class PageModel{
	//首页
	private int pageIndex;
	//总记录数
	private int totalRecordSum;
	//每页纪录数
	private int pageSize;
	//总页数
	private int totalPageSum;

	public int getPageIndex() {
		
		//越界情况
		this.pageIndex=this.pageIndex<=1 ? 1:this.pageIndex;
		
		this.pageIndex=this.pageIndex>=getTotalPageSum() ? getTotalPageSum():this.pageIndex;
				
		return pageIndex;
	}

	public void setPageIndex(int pageIndex) {
		this.pageIndex = pageIndex;
	}

	public int getTotalRecordSum() {
		return totalRecordSum;
	}

	public void setTotalRecordSum(int totalRecordSum) {
		this.totalRecordSum = totalRecordSum;
	}

	public int getPageSize() {
		
		//每页记录数
		this.pageSize=PAGE_DEFAULT_SIZE;
		
		return pageSize;
	}

	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}

	public int getTotalPageSum() {
		
		if(this.getTotalRecordSum()<=0)
		{
			this.totalPageSum=0;
		}else
		{
			//计算总页数
			this.totalPageSum=((this.getTotalRecordSum()-1)/this.getPageSize())+1;
		}
		return totalPageSum;
	}

	public void setTotalPageSum(int totalPageSum) {
		this.totalPageSum = totalPageSum;
	}
	
	//获取数据表查询的起始位置
	public int getStartRowNum(){
		
		return (getPageIndex()-1)*this.getPageSize();
	
	}
}
