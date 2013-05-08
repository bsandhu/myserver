package com.bsandhu.controllers;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.bsandhu.services.MyService;

@Controller
public class MyController {

	static Logger logger = Logger.getLogger(MyController.class);
	private MyService service;

	@Autowired
	public MyController(MyService service) {
		logger.info(">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>");
		this.service = service;
	}

	@RequestMapping("/myfoo")
	public String simple(Model model) {
		logger.info(" >>> Processing request myserver");
		model.addAttribute("foo", service.getName());
		return "home";
	}

}