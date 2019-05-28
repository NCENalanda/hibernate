package com.nt.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Type;

@Entity
@Table(name="Product")
@NamedQueries({@NamedQuery(name="ALL_PRODUCTS",query="from Product"),
               @NamedQuery(name="UPDATE_TO_GST_PRICE",query="update Product set price=(price+price*0.05) where price>=:startRange")
              })
public class Product {
	
	private int pid;
	private String pname;
	private float price;
	private int qty;
	
	public Product() {
		System.out.println("Product:: 0-param constructor");
	}
	
	@Id
	@Type(type="int")
	@GenericGenerator(name="gen1",strategy="increment")
	@GeneratedValue(generator="gen1")
	public int getPid() {
		return pid;
	}
	
	
	public void setPid(int pid) {
		this.pid = pid;
	}
	
	@Column(length=10)
	@Type(type="string")
	public String getPname() {
		return pname;
	}
	public void setPname(String pname) {
		this.pname = pname;
	}
	
	@Column(length=10,precision=2)
	@Type(type="float")
	public float getPrice() {
		return price;
	}
	public void setPrice(float price) {
		this.price = price;
	}
	
	@Column(length=10)
	@Type(type="int")
	public int getQty() {
		return qty;
	}
	public void setQty(int qty) {
		this.qty = qty;
	}

}
