package com.ssi.controllers;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.ssi.dao.EmpDAO;
import com.ssi.dao.SchemeDAO;
import com.ssi.entities.Emp;
@Controller
public class EmpController {
	@Autowired
 JavaMailSender jms;
	@Autowired
	 EmpDAO empdao;
	@Autowired
	SchemeDAO schemeDAO;
	@RequestMapping("sendschemedislist")
	public String sendMailForScheme(){
		String ids[]=empdao.getAllEmpEmails();
		//for(String id:ids){
		String msg=schemeDAO.getSchemeList();
		SimpleMailMessage smm=new SimpleMailMessage();
		smm.setTo(ids);
		smm.setTo(ids);
		smm.setSubject("Updated scheme List");
		smm.setText(msg);
		jms.send(smm);
		return "MailForm";
			}
	@RequestMapping("deleteemp")
	public ModelAndView removeEmp(@RequestParam("eid") String eid){
		empdao.removeEmp(eid);
		ModelAndView mv=new ModelAndView("redirect:ViewAllEmp");
		return mv;
	}
	@RequestMapping("ViewAllEmp")
	public ModelAndView showEmpList(){
		List<Emp> list=empdao.getAllEmp();
		
		ModelAndView mv=new ModelAndView("Emplist");
		mv.addObject("emp",list);
		return mv;
	}
	@RequestMapping("saveemp")
	public ModelAndView saveEmpData(@ModelAttribute("emp") Emp emp,BindingResult result){
		if(result.hasErrors()){
		
		}
	empdao.addEmp(emp);
		ModelAndView mv=new ModelAndView("empenterysuccess");
		return mv;
	}
@RequestMapping("newemp")	
public String showEmpEnteryform(){
	return "empentery";
	
}
      
      
}
