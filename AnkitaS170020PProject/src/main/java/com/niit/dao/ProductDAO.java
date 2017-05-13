package com.niit.dao;

import com.niit.model.Product;

import java.util.List;

public interface ProductDAO 
{
	public List<Product> getAll();
	public boolean save(Product p);
	public boolean saveOrUpdate(Product p);
	public Product getById(String search_string);
	public void delete(String id);

}
