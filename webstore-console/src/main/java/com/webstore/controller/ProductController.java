package com.webstore.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.MatrixVariable;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.webstore.domain.Product;
import com.webstore.service.ProductService;

@Controller
@RequestMapping("/products")
public class ProductController {

	@Autowired
	private ProductService productService;

	@RequestMapping
	public String list(Model model) {
		model.addAttribute("products", productService.getAllProducts());

		return "products";
	}

	@RequestMapping("/all")
	public String allProducts(Model model) {
		model.addAttribute("products", productService.getAllProducts());

		return "products";
	}

	@RequestMapping("/{category}")
	public String getProductsByCategory(Model model,
			@PathVariable String category) {
		model.addAttribute("products",
				productService.getProductsByCategory(category));

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
		model.addAttribute("product", productService.getProductByCode(code));

		return "product";
	}
	
	@RequestMapping(value="/add", method= RequestMethod.GET)
	public String getAddNewProductForm(Model model){
		Product newProduct = new Product();
		model.addAttribute("newProduct", newProduct);
		return "addProduct";
	}
	
	@RequestMapping(value="/add", method = RequestMethod.POST)
	public String processAddNewProductForm(@ModelAttribute("newProduct") Product newProduct){
		System.out.println("Add");
		productService.addProduct(newProduct);
		return "redirect:/products";
	}

}
