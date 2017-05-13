package com.niit.dao;

import java.util.List;
import com.niit.model.Supplier;


public interface SpplierDAO {
	public List<Supplier> getAll();
	public void update(Supplier p);
	public Supplier getById(int id);
	public void delete(int id);
	public boolean save(Supplier spplier);
	public Supplier getByName(String Name );


	
}
