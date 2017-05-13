package com.niit.controller;

import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.niit.dao.CategoryDAO;
import com.niit.dao.UserDAO;
import com.niit.model.Categories;
import com.niit.model.User;





@Controller
public class UserController {
	
	
	private static Logger log = LoggerFactory.getLogger(UserController.class);
	
	@Autowired UserDAO userDAO;
	@Autowired User  user;
	
	
	@Autowired CategoryDAO categoryDAO;
	
	@Autowired  Categories  category;
	@Autowired  HttpSession session;
	
	@RequestMapping("validate")
	public ModelAndView login(@RequestParam("userName") String id, 
			@RequestParam("password") String password)
	
	{
		
		log.debug("Starting of the method login");
		
		log.info("You are login with the id "+id);
		ModelAndView mv = new ModelAndView("/Home");
		 if(userDAO.voildate(id, password)==true)
		 {
			 log.debug("Valid credentials");
			 
			 user = userDAO.get(id);
			 
			 //${message}  - to display in the Home.jsp
			 mv.addObject("message", " Welcom " + user.getName());
			 
			 mv.addObject("categoryList", categoryDAO.getAll());
			 mv.addObject("category", category);
			 
			 
			 //check whether user is customer or admin
			 
			 if(user.getRole().equals("ROLE_ADMIN"))
			 {
				 log.debug("You are admin");
				 mv.addObject("isAdmin", "true");
			 }
			 else
			 {
				 log.debug("You are customer");
				 mv.addObject("isAdmin", "false");
			 }
			 
			 
		 }
		 else
		 {
			 log.debug("Invalid user");
			 mv.addObject("message", "Invalid credentials..please try again.");
		 }
		 
		 log.debug("Ending of the method login");
		 return mv;
		
	}
	
	
	
	
	
	
	

}
