package com.page;
/**
 * 页面显示效果类
 * @author Edward
 *
 * @param <T>
 */
public class PageModel<T> {
	//汉字 上一页 下一页
	public static final int TEXT_MODEL = 1;
	//数字 123
	public static final int NUM_MODEL = 2;
	//默认模型
	private int model =1;
	//无参 b.page
	private String url;
	private Page page = null;
	//构造分页的html
	private StringBuffer strHtml = null;
	//显示的页数 12
	private int viewPageCount = 2;
	public PageModel(String url, Page page) {
		super();
		this.url = url;
		this.page = page;
	}
	public PageModel(int model, String url, Page page) {
		super();
		this.model = model;
		this.url = url;
		this.page = page;
	}
	public PageModel(int model, String url, Page page, int viewPageCount) {
		super();
		this.model = model;
		this.url = url;
		this.page = page;
		this.viewPageCount = viewPageCount;
	}
	
	public String getPageModel(){
		createURL();
		return createModel();
	}
	
	private void createURL(){
		//b.page?&page=4 与b.page?page=4 效果相同
		url = url.contains("?") ? url+"&page=" : url+"?page=";
	}
	
	private String createModel(){
		strHtml = new StringBuffer();
		switch (model) {
		case TEXT_MODEL:
					buildTextModel();
					break;
		case NUM_MODEL:
					buildNumModel();
					break;
		default:
					buildTextModel();
					break;
		}
		return strHtml.toString();
	}
	
	private void buildNumModel(){
		int currentPage = page.getCurrentPage();
		int countPage = page.getCountPage();
		strHtml.append("<table width='100%'  border='0' cellspacing='0' cellpadding='0'>")  
                .append("<tr><td height='24' align='center'>");
		if(currentPage > 1){
			strHtml.append("<a href='").append(url).append(1).append("'>首页</a>&nbsp;");
		}
		PageIndex pageIndex = PageIndex.getPageIndex(viewPageCount, currentPage, countPage);
		if(currentPage <= countPage){
			for (int i = pageIndex.getStartPage(); i <= pageIndex.getEndPage(); i++) {
				if(i == currentPage){
					strHtml.append("<b>").append(currentPage).append("</b>&nbsp;");
				}else{
					strHtml.append("<a href='").append(url).append(i).append("'>").append(i).append("</a>&nbsp;");
				}
			}
		}
		if(currentPage<countPage){
			strHtml.append("<a href='").append(url).append(countPage).append("'>末页</a>&nbsp;");
		}
		strHtml.append(currentPage).append("<span>").append("/").append(countPage).append("页").append("</span>");
		strHtml.append("</td></tr></table>"); 
	}
	
	public void buildTextModel(){
		int currentPage = page.getCurrentPage();
		int countPage = page.getCountPage();
		strHtml.append("<table width='100%'  border='0' cellspacing='0' cellpadding='0'>")  
        .append("<tr><td height='24' align='center'>");
		if(currentPage > 1){
			strHtml.append("<a href='").append(url).append(1).append("'>首页</a>&nbsp;");
			strHtml.append("<a href='").append(url).append(currentPage - 1).append("'>").append("上一页</a>&nbsp;");
		}
		if(currentPage < countPage){
			strHtml.append("<a href='").append(url).append(currentPage + 1).append("'>").append("下一页</a>&nbsp;");
			strHtml.append("<a href='").append(url).append(countPage).append("'>末页</a>&nbsp;");
		}
		strHtml.append(currentPage).append("<span>").append("/").append(countPage).append("页").append("</span>");
		   strHtml.append("</td></tr></table>"); 
	}
	
	public int getModel() {
		return model;
	}
	public void setModel(int model) {
		this.model = model;
	}
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	public Page getPage() {
		return page;
	}
	public void setPage(Page page) {
		this.page = page;
	}
	public StringBuffer getStrHtml() {
		return strHtml;
	}
	public void setStrHtml(StringBuffer strHtml) {
		this.strHtml = strHtml;
	}
	public int getViewPageCount() {
		return viewPageCount;
	}
	public void setViewPageCount(int viewPageCount) {
		this.viewPageCount = viewPageCount;
	}

}
