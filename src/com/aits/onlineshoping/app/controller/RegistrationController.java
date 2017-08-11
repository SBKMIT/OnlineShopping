package com.aits.onlineshoping.app.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.aits.onlineshoping.app.model.LoginBean;
import com.aits.onlineshoping.app.model.UserBean;
import com.aits.onlineshoping.app.service.UserServiceInterface;

@Controller
public class RegistrationController {

	@Autowired
	private UserServiceInterface userService;

	@RequestMapping(value="register",method=RequestMethod.GET)
	public String registerForm(Model model){
		UserBean userBean=new UserBean();
		model.addAttribute("userBean", userBean);

		return"common/register";
	}

	@RequestMapping(value="saveRegister",method=RequestMethod.POST)
	public String saveRegister(@Valid @ModelAttribute("userBean")UserBean userBean,BindingResult result, Model model){

		if(result.hasErrors()){
			return"common/register";
		}else{
			userService.userRegistration(userBean);
            model.addAttribute("registerSuccessMsg","Your registration done. thank you");
			return"common/index";
		}
	}



}
