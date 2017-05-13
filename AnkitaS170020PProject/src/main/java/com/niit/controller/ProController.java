package com.niit.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.niit.dao.*;
import com.niit.model.*;

@Controller
public class ProController 
{
	@Autowired
	ProductDAO p= new ProductDAO_Impl();
	@RequestMapping(value={"/v/get"})
	@ResponseBody List<Product> view()
	{
		return  p.getAll();
	}
	@RequestMapping(value = "/xplor/{id}")
	public String gotreg(@PathVariable("id") String id, Model model){
		model.addAttribute("product", p.getById(id));
		return "redirect:/viewdetail";
	}
}
