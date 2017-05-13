package com.niit.dao;

import java.util.List;

import javax.transaction.Transactional;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.niit.model.Product;
@Repository("productDAO")
@Transactional
public class ProductDAO_Impl implements ProductDAO{

	@Autowired	
	private SessionFactory sessionFactory;
	
	@Override
	public boolean save(Product p) {
	
		sessionFactory.getCurrentSession().persist(p);
		return true;
	}
	@Override
	public List<Product> getAll() {
		// TODO Auto-generated method stub
		return sessionFactory.getCurrentSession().createQuery("FROM Product").list();
	}
	@Override
	public boolean saveOrUpdate(Product p) 
	{
		// TODO Auto-generated method stub
		 sessionFactory.getCurrentSession().update(p);
		 return true;
	}
	@Override
	public Product getById(String id) {
		// TODO Auto-generated method stub
		return (Product) sessionFactory.getCurrentSession().get(Product.class,id);
	}
	@Override
	public void delete(String id) {
		// TODO Auto-generated method stub
		sessionFactory.getCurrentSession().delete(getById(id));		}
	
}
