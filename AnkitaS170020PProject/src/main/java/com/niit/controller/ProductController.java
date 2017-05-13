package com.niit.controller;

import java.util.List;
import com.niit.model.Supplier;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.niit.dao.CategoryDAO;
import com.niit.dao.ProductDAO;
import com.niit.dao.SpplierDAO;
import com.niit.model.Categories;
import com.niit.model.Product;





@Controller
public class ProductController {

	private static Logger log = LoggerFactory.getLogger(ProductController.class);

	@Autowired(required = true)
	private ProductDAO productDAO;

	@Autowired(required = true)
	private CategoryDAO categoryDAO;
	
	@Autowired(required = true)
	private Product product;

	@Autowired(required = true)
	private SpplierDAO supplierDAO;

  private String path   ="D://Workspace//NIITWS//ShoppingCartWS//AnkitaS170020Project//src//main//webapp//resources//img";

    private Supplier supplier;
	
	
	
	@RequestMapping("/search_product/{search_string}")
	public ModelAndView getAllProductBySearchString(@PathVariable("search_string")
		String search_string)
	{
	  List<Product> products=	 productDAO.getAll();
	  ModelAndView mv= new ModelAndView("/home");
	  
	  if(products.isEmpty())
	  {
		  mv.addObject("msg", "No products are available with the search text :" +search_string );
	  }
	  else
	  {
		  mv.addObject("productList", products);
	  }
  
	  return mv;
	
	}
 	@RequestMapping(value = "/manage_products", method = RequestMethod.GET)
	public String listProducts(Model model) {
		log.debug("Starting of the method listProducts");
		model.addAttribute("product", new Product());
		model.addAttribute("category", new Categories());
		model.addAttribute("supplier", new Supplier());
		model.addAttribute("productList", this.productDAO.getAll());
		model.addAttribute("categoryList", this.categoryDAO.getAll());
		model.addAttribute("supplierList", this.supplierDAO.getAll());
		model.addAttribute("isAdminClickedProducts", "true");
		log.debug("Ending of the method listProducts");
		return "/Home";
	}

	// For add and update product both
	@RequestMapping(value = "/manage_product_add", method = RequestMethod.POST)
	public String addProduct(@ModelAttribute("product") Product product,
			 @RequestParam("image") MultipartFile file, Model model) {
	
		
		log.debug("Starting of the method addProduct");
		Categories category = categoryDAO.getCategoryByName(product.getCategory());
		// categoryDAO.saveOrUpdate(category); // why to save??

		supplier = supplierDAO.getByName(product.getSupplier());
		// supplierDAO.saveOrUpdate(supplier); // Why to save??
		String s=null;
		s=s.valueOf(category.getCid());
		product.setCategory_id(s);
		product.setSupplier(supplier.getName());
		String temp1=null;
		temp1=temp1.valueOf(category.getCid());
		product.setCategory_id(temp1);
		product.setSupplier_id(supplier .getId());
		String x=null;
		x=x.valueOf(product.getPid());
		/*int temp=Integer.parseInt(Util.removeComman(x));
		product.setPid(temp);*/
		productDAO.saveOrUpdate(product);

		//FileUtil.update(path, file, product.getPid() + ".jpg");
		log.debug("Ending of the method addProduct");
		model.addAttribute("isAdminClickedProducts", "true");
		model.addAttribute("productList", this.productDAO.getAll());
		model.addAttribute("product", new Product());
		model.addAttribute("categoryList", this.categoryDAO.getAll());
		model.addAttribute("category", new Categories());
		
		return "/home";
		// return "redirect:/uploadFile";

	}

	@RequestMapping("manage_product/remove/{id}")
	public String removeProduct(@PathVariable("id") String id, ModelMap model) throws Exception {
		log.debug("Starting of the method removeProduct");
		try {
			productDAO.delete(id);
			model.addAttribute("message", "Successfully Added");
		} catch (Exception e) {
			model.addAttribute("message", e.getMessage());
			e.printStackTrace();
		}
		log.debug("Ending of the method removeProduct");
		return "forward:/manage_products";
	}

	@RequestMapping("manage_product/edit/{id}")
	public String editProduct(@PathVariable("id") String id, Model model) {
		//categoryDAO.saveOrUpdate(category);
		log.debug(" Starting of the method editProduct");
		
		product = productDAO.getById(id);
		model.addAttribute("selectedProduct", product);
		log.debug(" End of the method editProduct");
		return "forward:/manage_products";
	}

	// Get select product details
	@RequestMapping("manage_product/get/{id}")
	public ModelAndView getSelectedProduct(@PathVariable("id") String id, RedirectAttributes redirectAttributes) {
		log.debug("Starting of the method getSelectedProduct");
		ModelAndView mv = new ModelAndView("redirect:/");
		redirectAttributes.addFlashAttribute("selectedProduct",  productDAO.getById(id));
		log.debug("Ending of the method getSelectedProduct");
		return mv;

	}

}
