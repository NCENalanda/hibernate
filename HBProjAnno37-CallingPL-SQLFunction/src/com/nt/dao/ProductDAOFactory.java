package com.nt.dao;

public class ProductDAOFactory {
 public static ProductDAO getInstance(){
	 return  new ProductDAOImpl();
 }
}
