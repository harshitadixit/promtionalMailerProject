package com.ssi.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.ssi.dao.SchemeDAO;
import com.ssi.entities.Scheme;

@Controller

public class SchemeController {
	

	
	
	@RequestMapping("deletescheme")
	public ModelAndView removescheme(@RequestParam("sid") String sid){
		schemeDAO.removeScheme(sid);
		ModelAndView mv=new ModelAndView("redirect:viewallscheme");
		return mv;
	}
	
	
	
	@Autowired
	SchemeDAO schemeDAO;
	@RequestMapping("saveschemechanges")
	public ModelAndView saveschemechanges(@ModelAttribute("scheme") Scheme scheme){
		 schemeDAO.addScheme(scheme);
		 ModelAndView mv=new ModelAndView("redirect:ViewAllscheme");
		 return mv;
		 
	}
	@RequestMapping("updatescheme")
	public ModelAndView showupdateschemeForm(@RequestParam("sid") String sid){
		
		Scheme scheme=schemeDAO.getSchemeById(sid);
		ModelAndView mv=new ModelAndView("schemeupdateform");
		mv.addObject("scheme",scheme);
		return mv;
	}
	@RequestMapping("viewallscheme")
	public ModelAndView showSchemeList(){
		List<Scheme> List=schemeDAO.getAllScheme();
		ModelAndView mv=new ModelAndView("SchemeList");
		mv.addObject("scheme", List);
		return mv;
	}
	@RequestMapping("savechanges")
	public ModelAndView savechanges(@ModelAttribute("scheme") Scheme scheme){
		schemeDAO.addScheme(scheme);
		ModelAndView mv=new ModelAndView("redirect:viewallscheme");
		return mv;
		
	}
	@RequestMapping("savescheme")
	public ModelAndView saveschemeData(@ModelAttribute("scheme") Scheme scheme)
	{
		schemeDAO.addScheme(scheme);
		ModelAndView mv=new ModelAndView("newschemesuccess");
		return mv;
	}
	@RequestMapping("newschemes")
	 public String ShowSchemeEnteryForm(){
		 
		 return "newschemes";
	 }
		@RequestMapping("adminhome")
			public String showAdminHome(){
				return "adminhome";
			}
}