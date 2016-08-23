package com.page;

import java.util.List;

import com.common.dao.TestDao;
/**
 * 页有关
 * 当前页数，一页数(一般固定)---->start,end
 * 总记录数---->总页数
 * @author Edward
 *
 * @param <T>
 */
public class Page<T> {
	//总页数
	private int countPage;
	//总记录数
	private int countRecord;
	//当前页数
	private int currentPage = 1;
	private List<T> list = null;
	//一页显示的记录数
	private int onePageCount = 4;
	//分页的开始与结束 between start and end
	private int start;
	private int end;
	

	public Page() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public Page(int countRecord, int currentPage) {
		super();
		this.countRecord = countRecord;
		this.currentPage = currentPage;
		caculate();
	}
	
	public Page(int countRecord, int currentPage, int onePageCount) {
		super();
		this.countRecord = countRecord;
		this.currentPage = currentPage;
		this.onePageCount = onePageCount;
		caculate();
	}
	
	private void caculate(){
		try {
			start = (currentPage -1) * onePageCount + 1;
			end = currentPage * onePageCount;
			countPage = (int)Math.ceil(countRecord / onePageCount);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	public int getCountPage() {
		return countPage;
	}
	public void setCountPage(int countPage) {
		this.countPage = countPage;
	}
	public int getCountRecord() {
		return countRecord;
	}
	public void setCountRecord(int countRecord) {
		this.countRecord = countRecord;
	}
	public int getCurrentPage() {
		return currentPage;
	}
	public void setCurrentPage(int currentPage) {
		this.currentPage = currentPage;
	}
	public List<T> getList() {
		return list;
	}
	public void setList(List<T> list) {
		this.list = list;
	}
	public int getOnePageCount() {
		return onePageCount;
	}
	public void setOnePageCount(int onePageCount) {
		this.onePageCount = onePageCount;
	}
	public int getStart() {
		return start;
	}
	public void setStart(int start) {
		this.start = start;
	}
	public int getEnd() {
		return end;
	}

	public void setEnd(int end) {
		this.end = end;
	}

	
}
