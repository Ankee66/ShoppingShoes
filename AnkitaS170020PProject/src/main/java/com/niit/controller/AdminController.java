package com.niit.controller;

import java.io.BufferedOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.MultipartFile;

import com.niit.dao.ProductDAO;
import com.niit.model.Categories;
import com.niit.model.Product;


@RequestMapping("/admin")
@Controller
public class AdminController {

	@Autowired
   ProductDAO productDAO;
	
	
	@RequestMapping(value = "/delete/{id}")
	public String deletedata(@PathVariable("id") String st) {
		productDAO.delete(st);	
		return "redirect:/admin/viewall";
	}
	@RequestMapping(value = "/viewall")
	public String all(Model model) {
		model.addAttribute("product", new Product());
		model.addAttribute("products",productDAO.getAll());
		return "admin";
	}
	
	@RequestMapping(value = "/insert", method = RequestMethod.POST)
	public String insert(@Valid @ModelAttribute("product") Product product,BindingResult results, Model model,HttpServletRequest request) {
		if(results.hasErrors())
		{
			model.addAttribute("product",product);
			model.addAttribute("products",productDAO.getAll());
			return "redirect:/admin/viewall";
		}
		
		if (product.getPid() == 0) {
			
			productDAO.save(product);
			
			
			MultipartFile file = product.getFile();

			String originalfile = file.getOriginalFilename();

			String filepath = request.getSession().getServletContext().getRealPath("/resources/images/product/");

			System.out.println("Path of file " + filepath);
			String filename = filepath + "\\" + product.getPid() + ".jpg";
			System.out.println("File Path File " + filepath);

			try {
				byte imagebyte[] = product.getPname().getBytes();
				BufferedOutputStream fos = new BufferedOutputStream(new FileOutputStream(filename));
				fos.write(imagebyte);
				fos.close();

			} catch (IOException e) {
				e.printStackTrace();
			} catch (Exception e) {


				e.printStackTrace();
			}

		} else 
		{

			productDAO.saveOrUpdate(product);
		}		
		return "redirect:/admin/viewall";
	}
	@RequestMapping(value="/edit/{id}", method= RequestMethod.GET)
	public String editProduct(@PathVariable("id") String id, Model model) {
		model.addAttribute("product", productDAO.getById(id));
		model.addAttribute("products", productDAO.getAll());
		return "admin";
	}
	
	@RequestMapping(value = "/addc")
	public String gotreg(Model model){
		model.addAttribute("c1", new Categories());
		return "addcategory";
	}

}

