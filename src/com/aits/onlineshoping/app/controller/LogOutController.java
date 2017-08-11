package com.aits.onlineshoping.app.controller;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.aits.onlineshoping.app.model.LoginBean;

@Controller
public class LogOutController {
	@RequestMapping(value="logout",method=RequestMethod.GET)
	public String loginForm(Model model,HttpSession session){
		LoginBean loginBean=new LoginBean();
		model.addAttribute("loginBean", loginBean);
		session.removeAttribute("emailId");
		model.addAttribute("logOutMsg", "Your logged out Successfully.");
		return"common/login";
	}
}
