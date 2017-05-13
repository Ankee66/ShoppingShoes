package com.niit.dao;

import java.util.List;

import com.niit.model.Categories;

public interface CategoryDAO 
{
	public List<Categories> getAll();
	
	public void save(Categories p);
	
	public void update(Categories p);
	
	public Categories getById(int id);
	
	public boolean delete(int id);
	
	public Categories getCategoryByName(String name );
}
