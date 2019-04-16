package com.ssi.controllers;

import java.util.List;




import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.ssi.dao.CustomerDAO;
import com.ssi.dao.SchemeDAO;
import com.ssi.entities.Customer;
import com.ssi.entities.Scheme;

@Controller
public class CustomerController {

	@Autowired
	CustomerDAO dao;
	
	
	@RequestMapping("deletescustomer")
	public ModelAndView removecustomer(@RequestParam("cid") String cid){
		dao.removeCustomer(cid);
		ModelAndView mv=new ModelAndView("redirect:viewallcustomer");
		return mv;
	}
	
	@RequestMapping("newcustomer")
	 public String showCustomerForm(){
		 return "Customerform";
	}
		 
	
	@RequestMapping("viewallcustomer")
	public ModelAndView showcustomerList(){
		List<Customer> List=dao.getAllCustomer();
		ModelAndView mv=new ModelAndView("CustomerList");
		mv.addObject("customer", List);
		return mv;
	}
	
	@RequestMapping("savecustomer")
	public ModelAndView saveschemeData(@ModelAttribute("customer") Customer customer)
	{
		/*if(result.hasErrors()){
			ModelAndView mv=new ModelAndView("errorpage");
			return mv;
		}*/
	    dao.savecustomer(customer);
		ModelAndView mv=new ModelAndView("newcustomerEntersuccess");
			return mv;
	}
}
