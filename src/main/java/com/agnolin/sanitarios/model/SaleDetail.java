package com.agnolin.sanitarios.model;

import java.io.Serializable;
import java.util.List;

public class SaleDetail implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private Sale sale;
	private int saleDetailId;
	private List<Product> items;
	private long subTotal;
	public Sale getSale() {
		return sale;
	}
	public void setSale(Sale sale) {
		this.sale = sale;
	}
	public int getSaleDetailId() {
		return saleDetailId;
	}
	public void setSaleDetailId(int saleDetailId) {
		this.saleDetailId = saleDetailId;
	}
	public List<Product> getItems() {
		return items;
	}
	public void setItems(List<Product> items) {
		this.items = items;
	}
	public long getSubTotal() {
		return subTotal;
	}
	public void setSubTotal(long subTotal) {
		this.subTotal = subTotal;
	}
	
	
	

}
