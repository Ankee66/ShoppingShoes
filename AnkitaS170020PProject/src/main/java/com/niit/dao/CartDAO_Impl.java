package com.niit.dao;
import java.io.IOException;
import java.util.List;

import javax.persistence.criteria.Order;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.niit.model.Cart;

@Repository("cartDAO")
@Transactional
public class CartDAO_Impl implements CartDAO{

	@Autowired	
	private SessionFactory sessionFactory;
	
	@SuppressWarnings({ "unchecked", "deprecation" })

	@Override
	public Cart getCartById(int cartId) {
		// TODO Auto-generated method stub
		Cart p = (Cart) sessionFactory.getCurrentSession().get(Cart.class, new Integer(cartId));
		// Product p = (Product) session1.load(Product.class, new Integer(id));

		return p;
	}

	@Override
	public Cart validate(int cartId) throws IOException {

		/*Cart cart = getCartById(cartId);
		if (cart == null || cart.getCartItems().size() == 0) {
			throw new IOException(cartId + "");
		}

		update(cart);*/
		return null;

	}

	@Override
	public void update(Cart cart) {
		sessionFactory.getCurrentSession().saveOrUpdate(cart);
		
	}

	@Override
	public List<Cart> getAll(String name) {
		// TODO Auto-generated method stub
		return sessionFactory.getCurrentSession().createQuery("FROM Cart where user = "+name).list();
	}

	@Override
	public Integer getTotalAmount(String id)
	{
		
		
		return 0;
		
	}

	/*@Override
	public void update(Cart cart) {

		int cartId = cart.getCartId();
		double grandTotal = Order.GetCustomerOrderGrandTotal(cartId);
		cart.setGrandTotal(grandTotal);

		session.getCurrentSession().saveOrUpdate(cart);

	}
	*/

}
