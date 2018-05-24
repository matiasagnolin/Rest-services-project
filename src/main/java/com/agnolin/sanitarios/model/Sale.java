package com.agnolin.sanitarios.model;

import java.io.Serializable;
import java.util.Date;

public class Sale implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int saleId;
	private Date creationDate;
	private User client;
	private double total;
	public int getSaleId() {
		return saleId;
	}
	public void setSaleId(int saleId) {
		this.saleId = saleId;
	}
	public Date getCreationDate() {
		return creationDate;
	}
	public void setCreationDate(Date creationDate) {
		this.creationDate = creationDate;
	}
	public User getClient() {
		return client;
	}
	public void setClient(User client) {
		this.client = client;
	}
	public double getTotal() {
		return total;
	}
	public void setTotal(double total) {
		this.total = total;
	}
	
	
}
