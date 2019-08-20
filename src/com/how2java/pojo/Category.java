package com.how2java.pojo;

import java.util.Set;

/**
 * Category 实体类对应表 category_
 * @author Administrator
 *
 */
public class Category {
	int id;
	String name;
	Set<Product> products;
	
	public Set<Product> getProducts() {
		return products;
	}
	public void setProducts(Set<Product> products) {
		this.products = products;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
}
