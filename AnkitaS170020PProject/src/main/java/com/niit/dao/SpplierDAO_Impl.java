package com.niit.dao;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.niit.model.Supplier;

@Repository("supplierDAO")
@Transactional
public class SpplierDAO_Impl implements SpplierDAO {
	@Autowired	
	private SessionFactory sessionFactory;
	
	@Override
	public boolean save(Supplier p) {
		sessionFactory.getCurrentSession().persist(p);
		return true;
	}
	@Override
	public List<Supplier> getAll() {
		// TODO Auto-generated method stub
		return sessionFactory.getCurrentSession().createQuery("FROM Supplier").list();
	}
	@Override
	public void update(Supplier p) {
		// TODO Auto-generated method stub
		sessionFactory.getCurrentSession().update(p);
	}
	@Override
	public Supplier getById(int id) {
		// TODO Auto-generated method stub
		return (Supplier) sessionFactory.getCurrentSession().get(Supplier.class,id);
	}
	@Override
	public void delete(int id) {
		// TODO Auto-generated method stub
		sessionFactory.getCurrentSession().delete(getById(id));
		
	}
	@Override
	public Supplier getByName(String Name) {
		// TODO Auto-generated method stub
		return (Supplier) sessionFactory.getCurrentSession().get(Supplier.class, Name);
		
		
	}
	
}
	


