package com.webstore.console.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.webstore.service.CustomerService;

@Controller
public class CustomerController {
	
//	@Autowired
//	private CustomerService CustomerService;

	@RequestMapping("/customers")
	private String list(Model model){
//		model.addAttribute("customers", CustomerService.getAllCustomers());
		
		return "customers";
	}
}
