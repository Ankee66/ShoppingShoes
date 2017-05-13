package com.niit.controller;

import java.security.Principal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.niit.dao.CartDAO;
import com.niit.dao.UserDAO;
import com.niit.model.User;

@Controller
public class CartController {

	 @Autowired
	 private UserDAO userDAO;
	

	 @GetMapping("addToCart(x.id)")
	 public String getCart(Principal principal, Model model){
	    User customer = userDAO.get(principal.getName());
		 model.addAttribute("customer", customer);
		 model.addAttribute("cartId", customer.getUid());
	     return "cart";
	 }
	
	

}
