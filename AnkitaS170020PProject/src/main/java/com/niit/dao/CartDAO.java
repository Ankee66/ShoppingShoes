package com.niit.dao;

import java.io.IOException;
import java.util.List;

import com.niit.model.Cart;
import com.niit.model.Product;

public interface CartDAO {
	public List<Cart> getAll(String id);
    Cart getCartById(int cartId);

    Cart validate(int cartId) throws IOException;

    void update(Cart cart);
   
    public Integer getTotalAmount(String id );

}
