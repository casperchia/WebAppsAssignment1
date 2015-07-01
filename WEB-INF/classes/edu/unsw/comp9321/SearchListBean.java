package edu.unsw.comp9321;

import java.util.ArrayList;

public class SearchListBean {

	private ArrayList<ResultBean> searchList;
	
	public SearchListBean(){
		searchList = new ArrayList<ResultBean>();
	}
	
	public ArrayList<ResultBean> getSearchList() {
		return searchList;
	}
	
	public void setSearchList(ArrayList<ResultBean> searchList) {
		this.searchList = searchList;
	}
}
