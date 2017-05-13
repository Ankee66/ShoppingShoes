package com.niit.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.niit.dao.*;

import com.niit.model.Categories;

@Controller
public class HomeController {

	@Autowired
	CategoryDAO categoryDAO;
	@Autowired
	ProductDAO productDAO;
	@Autowired
	CartDAO cartDAO;
	@Autowired
	SpplierDAO supplierDAO;
	@Autowired
	UserDAO userDAO;
	@RequestMapping("/")
		public  String goToHome(Model model)
		{
			System.out.println("In controller");
			model.addAttribute("message", "Thank you for visiting Shopping Cart");
			return "Home";
		}
	
 	
    	@RequestMapping("/admin")
    	public String adminPage(Model model)
    	{
    		model.addAttribute("isUserClickedRegister", "true");
	
    		return "Admin";
    	}


    @RequestMapping("/LoginPage")
   public String loginPage(Model model)
    {
    	model.addAttribute("isUserClickedLogin", "true");

    	return "Login";
    }

    @RequestMapping("/RegistrationPage")
    public String registrationPage(Model model)
    {
    	model.addAttribute("isUserClickedRegister", "true");
	
    	return "Registration";
    }

	@RequestMapping("/listall/{man}")
	public String MANPage(@PathVariable("man") String man,Model model)
	{
		model.addAttribute("man",man);
		
		return "product";
	}


    @RequestMapping("/aboutus")
    public String aboutusPage(Model model)
    {
    	model.addAttribute("isUserClickedRegister", "true");
	
    	return "AboutUs";
    }
    

     @RequestMapping("/contactus")
     public String contactUsPage(Model model)
  {
	  model.addAttribute("isUserClickedRegister", "true");

	   return "ContactUs";
   }
}


