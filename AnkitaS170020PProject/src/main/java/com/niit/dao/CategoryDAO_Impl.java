package com.niit.dao;

import java.util.List;

import javax.transaction.Transactional;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.niit.model.Categories;

@Repository("categoryDAO")
public class CategoryDAO_Impl implements CategoryDAO {
	
	@Autowired	
	private SessionFactory sessionFactory;

	public CategoryDAO_Impl(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	@Transactional
	public List<Categories> getAll() {
		@SuppressWarnings("unchecked")
		List<Categories> lst = sessionFactory.getCurrentSession().createQuery("From Categories").list();
		return lst;
	}

	@Transactional
	public void update(Categories p) {
		sessionFactory.getCurrentSession().update(p);
	}

	@Transactional
	public Categories getById(int id) {
		return (Categories) sessionFactory.getCurrentSession().get(Categories.class,id);
	}

	@Transactional
	public boolean delete(int id) {
		sessionFactory.getCurrentSession().delete(getById(id));
		return true;
	}

	@Transactional
	public Categories getCategoryByName(String Name )
	{
		return(Categories) sessionFactory.getCurrentSession().get(Categories.class, Name);
     }

	@Transactional
	public void save(Categories p) {
		sessionFactory.getCurrentSession().persist(p);	
	}
}