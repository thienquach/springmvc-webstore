package com.webstore.console.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.MatrixVariable;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.webstore.common.domain.Category;
import com.webstore.common.domain.Product;
import com.webstore.console.editor.CategoryEditor;
import com.webstore.service.CategoryService;
import com.webstore.service.ProductService;

@Controller
@RequestMapping("/products")
public class ProductController {

	@Autowired
	private ProductService productService;
	@Autowired
	private CategoryService categoryService;

	@RequestMapping
	public String list(Model model) {
		model.addAttribute("products", productService.findAll());

		return "products";
	}

	@RequestMapping("/all")
	public String allProducts(Model model) {
		model.addAttribute("products", productService.findAll());

		return "products";
	}

	@RequestMapping("/{category}")
	public String getProductsByCategory(Model model,
			@PathVariable String category) {
		model.addAttribute("products",
				productService.findByCategory(category));

		return "products";
	}

	@RequestMapping("/filter/{ByCriteria}")
	public String getProductsByFilter(
			@MatrixVariable(pathVar = "ByCriteria") Map<String, List<String>> filterParams,
			Model model) {
		model.addAttribute("products",
				productService.getProductsByFilter(filterParams));

		return "products";
	}

	@RequestMapping("/product")
	public String getProductByCode(@RequestParam String code, Model model) {
		model.addAttribute("product", productService.findByCode(code));

		return "product";
	}
	
	@InitBinder
	public void initialiseBinder(WebDataBinder binder){
		binder.setDisallowedFields("unitsInOrder", "discontinued");
		binder.registerCustomEditor(Category.class, new CategoryEditor(categoryService));
		
	}
	
	@RequestMapping(value="/add", method= RequestMethod.GET)
	public String getAddNewProductForm(Model model){
		Product newProduct = new Product();
		model.addAttribute("newProduct", newProduct);
		model.addAttribute("products", productService.findAll());
		model.addAttribute("categories", categoryService.findAll());
		return "admin/addProduct";
	}
	
	@RequestMapping(value="/add", method = RequestMethod.POST)
	public String processAddNewProductForm(@ModelAttribute("newProduct") Product newProduct, BindingResult result){
		//Check if the FormBean contains disallowed fields from WebDataBinder
		String[] suppressFields = result.getSuppressedFields();
		if(suppressFields.length > 0){
			throw new RuntimeException("Attempting to bind disallowed fields: " + StringUtils.arrayToCommaDelimitedString(suppressFields));
		}
		productService.addProduct(newProduct);
		return "redirect:/products/add";
	}

}
