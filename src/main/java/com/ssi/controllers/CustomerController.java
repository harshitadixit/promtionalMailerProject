package com.ssi.controllers;

import java.util.List;






import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.ssi.dao.CustomerDAO;
import com.ssi.entities.Customer;

@Controller
public class CustomerController {
@Autowired
	CustomerDAO customerdao;
	@RequestMapping("verifyCustomer")
	public ModelAndView verifyCustomerData(@ModelAttribute("customer") Customer customer, HttpServletRequest request){	
		boolean success=customerdao.verifyCustomer(customer);
		if(success){
		HttpSession session=request.getSession();
		session.setAttribute("cid", customer.getCemail());
		session.setAttribute("cpassword", customer.getCpassword());
		ModelAndView mv=new ModelAndView("viewallcustomer");
		return mv;
		}else{
			ModelAndView mv=new ModelAndView("viewallcustomer");
			return mv;
		}
	}
	@Autowired
	CustomerDAO dao;
	@RequestMapping("savechange")
	public ModelAndView saveChanges(@ModelAttribute("customer") Customer customer){
		dao.savecustomer(customer);
		ModelAndView mv=new ModelAndView("redirect:viewallcustomer");
		return mv;
	}
	
	
      @RequestMapping("updatecustomer")
	public ModelAndView showUpdateCustomerform(@RequestParam("cid") String cid){
		Customer customer=customerdao.getCustomerById(cid);
		ModelAndView mv=new ModelAndView("customerupdateform");
		mv.addObject("customer",customer);
		return mv;
	}
	
	
	
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
