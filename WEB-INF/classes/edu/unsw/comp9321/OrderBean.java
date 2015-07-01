package edu.unsw.comp9321;

import java.util.ArrayList;

public class OrderBean {

	private ArrayList<ResultBean> orders;
	
	public OrderBean(){
		orders = new ArrayList<ResultBean>();
	}
	
	public ArrayList<ResultBean> getOrders() {
		return orders;
	}

	public void setOrders(ArrayList<ResultBean> orders) {
		this.orders = orders;
	}
}
