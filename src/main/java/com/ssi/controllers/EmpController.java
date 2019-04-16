package com.ssi.controllers;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.ssi.dao.EmpDAO;
import com.ssi.entities.Emp;
@Controller
public class EmpController {

	@Autowired
	 EmpDAO empdao;
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
	public ModelAndView saveEmpData(@ModelAttribute("emp") Emp emp){
	empdao.addEmp(emp);
		ModelAndView mv=new ModelAndView("empenterysuccess");
		return mv;
	}
@RequestMapping("newemp")	
public String showEmpEnteryform(){
	return "empentery";
	
}
      
      
}
