package com.ssi.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
@Controller
public class MessageController {
	
	@RequestMapping("messageform")
	  public String showMessageForm(){
		return "messageform";
		  
		  
	  }

}
