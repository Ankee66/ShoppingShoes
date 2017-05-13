package com.niit.controller;


import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.niit.dao.CategoryDAO;
import com.niit.model.Categories;


@Controller
public class CategoryController {
	
	
	private static  Logger log = LoggerFactory.getLogger(CategoryController.class);
	
	@Autowired  
	CategoryDAO categoryDAO;

	@Autowired  
	Categories category;
	@Autowired  
	HttpSession session;
	
	
	@RequestMapping("/manage_category_add")
	public ModelAndView  createCategory(@RequestParam("id") String id, 
			@RequestParam("name") String name,  @RequestParam("description") String desc)
	{
		
		log.debug("Starting of the method manageCategories");
		int cid=Integer.parseInt(id);
		category.setCid(cid);
		category.setCname(name);
		
		ModelAndView mv = new ModelAndView("Home");
		
		mv.addObject("isAdminClickedCategories", "true");
		mv.addObject("isAdmin", "true");
		
		//Before calling save method, check whether the category id already exist in db or not
		
		//if it is does not exist, then only call save method
		
		if (categoryDAO.getById(cid) !=null)
		{
			//category already exist
			mv.addObject("message", "Category already exist with teh id " +cid);
			return mv;
			
		}
		else  // actualy else is not required if return statement is there in if condition
		{
			categoryDAO.save(category);
			mv.addObject("message", "Category created successfuly ");
		}
		
		
		session.setAttribute("categoryList", categoryDAO.getAll());
		session.setAttribute("category", category);
		log.debug("End of the method manageCategories");
		
		return mv;
		
		
		
	}
	
	
	
	
	
	
	
	@RequestMapping("/manage_category_delete/{id}")
	public ModelAndView deleteCategory(@PathVariable("id") String cid)
	{
		int id=Integer.parseInt(cid);

		log.debug("Starting of the method deleteCategory");
		log.debug("You are going to delete " + id);
		ModelAndView mv = new ModelAndView("Home");
		 if( categoryDAO.delete(id))
		 {
			 mv.addObject("message", "successfully deleted the category");
		 }
		 else
		 {
			 mv.addObject("message", "Not able to delte the category");
		 }
		 
			session.setAttribute("categoryList", categoryDAO.getAll());
			session.setAttribute("category", category);
			log.debug("Ending of the method deleteCategory");
		 
		 return mv;
		
	}
	@RequestMapping("/manage_category_edit/{id}")
	public ModelAndView editcategory(@PathVariable("id")int id)
	{
		
		log.debug("starting of the method edit Category");
		log.debug(" goning to edit the category"+ id );
	
		category =categoryDAO.getById(id);
		ModelAndView mv = new ModelAndView ("forward;/managecategory");
		mv.addObject("selectedcategory",category);
		return mv;
	}
	@RequestMapping("/manage_category_update")
	public ModelAndView  updateCategory(@RequestParam("id") String id, 
			@RequestParam("name") String name,  @RequestParam("description") String desc)
	{
		
		log.debug("Starting of the method update Categories");
		int cid=Integer.parseInt(id);
		category.setCid(cid);
		category.setCname(name);
		
		ModelAndView mv = new ModelAndView("Home");
		
		mv.addObject("isAdminClickedCategories", "true");
		mv.addObject("isAdmin", "true");
		
		//Before calling save method, check whether the category id already exist in db or not
		
		//if it is does not exist, then only call save method
		
		if (categoryDAO.getById(cid) !=null)
		{
			//category already exist
			mv.addObject("message", "Category already exist with teh id " +cid);
			return mv;
			
		}
		else  // actualy else is not required if return statement is there in if condition
		{
			categoryDAO.update(category);
			mv.addObject("message", "Category created successfuly ");
		}
		
		
		session.setAttribute("categoryList", categoryDAO.getAll());
		session.setAttribute("category", category);
		
	
		
		log.debug("End of the method update Categories");
		
		return mv;
			
	}
	
}