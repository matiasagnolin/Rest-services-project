package com.agnolin.sanitarios.model;

import java.io.Serializable;


import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;



@Entity
public class SellDetail implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	
	@ManyToOne(cascade= CascadeType.ALL)
	@JoinColumn(name="sellId",nullable=false)
	private Sell sell;
	
	@Id
	@GeneratedValue(strategy = javax.persistence.GenerationType.AUTO )
	private int sellDetailId;
		
	private long subTotal;
	
	@OneToOne(cascade=CascadeType.ALL)
	@JoinColumn(name="productId")
	private Product product;
	
	public Sell getSale() {
		return sell;
	}
	public void setSale(Sell sell) {
		this.sell = sell;
	}
	public int getSaleDetailId() {
		return sellDetailId;
	}
	public void setSaleDetailId(int saleDetailId) {
		this.sellDetailId = saleDetailId;
	}

	public long getSubTotal() {
		return subTotal;
	}
	public void setSubTotal(long subTotal) {
		this.subTotal = subTotal;
	}
	
	
	

}
