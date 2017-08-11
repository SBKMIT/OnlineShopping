package com.aits.onlineshoping.app.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;


@Controller
public class HomePageController {

	@RequestMapping(value="/",method=RequestMethod.GET)
	public String homePage(Model model){
		
		return "common/index";
	}
}
