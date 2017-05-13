package com.niit.dao;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;
import com.niit.model.User;

@Repository("userDAO")
@Transactional
public class UserDAO_Impl implements UserDAO 
  
{
	private SessionFactory sessionFactory;
 
	@Override
	public void insertUser(UserDAO user) {
		// TODO Auto-generated method stub
		sessionFactory.getCurrentSession().persist(user);
	}

	@Override
	public User  getUserDetails(String userid)
	{
		User user =(User) sessionFactory.getCurrentSession().get(User.class, new String(userid));	
		return user;
	}
	@Override
	public User getUById(int customerId) {
		
		// TODO Auto-generated method stub
		User u = (User) sessionFactory.getCurrentSession().get(User.class, new Integer(customerId));
		return  u;
	}

	@Override
	public List<User> getAllCustomers() {
		// TODO Auto-generated method stub
		return sessionFactory.getCurrentSession().createQuery("from User").list();

	}

	/*@Override
	public User getCustomerByUsername(String username)
	{
		Query query = sessionFactory.getCurrentSession().createQuery("from User WHERE email=?");
		query.setParameter(0, username);
		return (User) query .getSingleResult();
	}*/


	//@Override
	public boolean voildate(String user, String password) {
		// TODO Auto-generated method stub
		return false;
	}//

	@Override
	public User getCustomerByUsername(String username) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public User get(String name) {
		// TODO Auto-generated method stub
		return null;
	}
	

	
	

}
