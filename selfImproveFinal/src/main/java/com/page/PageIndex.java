package com.page;
/**
 * 开始页与结束页的封装
 * @author Edward
 *
 */
public class PageIndex {
	//开始页 12345中的1
	private int startPage;
	//结束页 12345中的5
	private int endPage;
	/**
	 * 当前页(中间) - 固定值 
	 * 5 3 12345 2 2
	 * 6 3 123456 2 3
	 *    4  234567 2 3
	 * @param viewPageCount
	 * @param currentPage
	 * @param totalPage
	 */
	public static PageIndex getPageIndex(int viewPageCount, int currentPage, int totalPage){
		int startPage = currentPage - 
				(viewPageCount%2==0?(viewPageCount/2 - 1) : viewPageCount/2);
		int endPage = currentPage + viewPageCount/2;
		
		if(startPage<1){
			startPage = 1;
			if(totalPage > viewPageCount){
				endPage = viewPageCount;
			}else{
				endPage = totalPage;
			}
		}
		if(endPage>totalPage){
			endPage = totalPage;
			if(totalPage > viewPageCount){
				startPage = endPage - viewPageCount + 1;
			}else{
				startPage = 1;
			}
		}
		return new PageIndex(startPage, endPage);
	}
	public PageIndex() {
		super();
	}
	public PageIndex(int startPage, int endPage) {
		super();
		this.startPage = startPage;
		this.endPage = endPage;
	}
	public int getStartPage() {
		return startPage;
	}
	public void setStartPage(int startPage) {
		this.startPage = startPage;
	}
	public int getEndPage() {
		return endPage;
	}
	public void setEndPage(int endPage) {
		this.endPage = endPage;
	}

}
