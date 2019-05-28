package com.nt.domain;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedNativeQuery;
import javax.persistence.QueryHint;
import javax.persistence.Table;


import org.hibernate.annotations.Type;
@Entity
@Table(name="Product")
/*@NamedNativeQuery(name = "CALL_FX", 
                  query = "{?=call Fx_GET_PRODUCTS_BY_PRICE_RANGE(?,?)}",
                  callable=true,
                  resultClass=Product.class)*/
@NamedNativeQuery(name="CALL_FX",
                   query = "{?=call Fx_GET_PRODUCTS_BY_PRICE_RANGE(?,?)}",
                   resultClass=Product.class,
                   hints={@QueryHint(name="org.hibernate.Callable",value="true")}
                   )
public class Product implements Serializable {
	private int pid ;
	private String pname;
	private float price;
	private int qty;
	
	public Product() {
		System.out.println("Product::0-param constructor");
	}

	@Id
	@Column(length=5)
	@Type(type="int")
	public int getPid() {
		return pid;
	}


	public void setPid(int pid) {
		this.pid = pid;
	}

	@Column(length=15,nullable=false)
	@Type(type="string")
	public String getPname() {
		return pname;
	}

	public void setPname(String pname) {
		this.pname = pname;
	}

	@Column(length=10,precision=2,nullable=false)
	@Type(type="float")
	public float getPrice() {
		return price;
	}

	public void setPrice(float price) {
		this.price = price;
	}

	@Column(length=10,nullable=false)
	@Type(type="int")
	public int getQty() {
		return qty;
	}

	public void setQty(int qty) {
		this.qty = qty;
	}

	@Override
	public String toString() {
		return "Product [pid=" + pid + ", pname=" + pname + ", price=" + price + ", qty=" + qty + "]";
	}
	
	

}
