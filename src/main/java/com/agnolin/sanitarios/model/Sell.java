package com.agnolin.sanitarios.model;

import java.io.Serializable;
import java.util.Date;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;


@Entity
public class Sell implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = javax.persistence.GenerationType.AUTO )
	private int sellId;
	
	private Date creationDate;
	
	@ManyToOne
	@JoinColumn(name="userId")
	private User client;
	
	@OneToMany(cascade= CascadeType.ALL, mappedBy = "sell",fetch = FetchType.LAZY)
	private Set<SellDetail> sellDetail;
	
	private double total;
	
	public int getSellId() {
		return sellId;
	}
	public void setSellId(int sellId) {
		this.sellId = sellId;
	}
	public Set<SellDetail> getSellDetail() {
		return sellDetail;
	}
	public void setSellDetail(Set<SellDetail> sellDetail) {
		this.sellDetail = sellDetail;
	}
	
	public int getSaleId() {
		return sellId;
	}
	public void setSaleId(int sellId) {
		this.sellId = sellId;
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
