package kr.kosta.coffeeorder.dto;

import java.util.List;

public class PageResult<T> {

	private SearchCond search;
	
	private int totalCount;
	
	private List<T> results; 

	
	
	public SearchCond getSearch() {
		return search;
	}

	public void setSearch(SearchCond search) {
		this.search = search;
	}

	public int getTotalCount() {
		return totalCount;
	}

	public void setTotalCount(int totalCount) {
		this.totalCount = totalCount;
	}

	public List<T> getResults() {
		return results;
	}

	public void setResults(List<T> results) {
		this.results = results;
	}
	
	public int getTotalPage(){
		int totalPage=0;
		int startPage =0;
		int endPage=0;
		if(totalCount == 0 ) {
			totalPage=1;
			startPage=1;
			endPage=1;
		}else{
			totalPage = (int)Math.ceil(totalCount)/this.search.getLimit()+1;
			startPage = search.getPage() - (search.getShowPageNum()/2);
			endPage = search.getPage() + (search.getShowPageNum()/2);
			
			if(startPage < 1){
				startPage = 1;
			}
			if(endPage < 5){
				endPage = 5;
			}
			
			if(endPage>totalPage){
				endPage=totalPage;
			}
		}
		search.setStartPage(startPage);
		search.setEndPage(endPage);
		return totalPage;
		
	}

	
	
}
