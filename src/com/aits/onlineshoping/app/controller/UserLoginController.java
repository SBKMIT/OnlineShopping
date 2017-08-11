package com.aits.onlineshoping.app.controller;

import java.util.List;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.apache.tomcat.jni.Local;
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
public class UserLoginController {

	@Autowired
	private UserServiceInterface userService;
	int userId;
	@RequestMapping(value="loginForm",method=RequestMethod.GET)
	public String loginForm(Model model){
		LoginBean loginBean=new LoginBean();
		model.addAttribute("loginBean", loginBean);

		return"common/login";
	}


	@RequestMapping(value="login",method=RequestMethod.POST)
	public String doLogin(@Valid @ModelAttribute("loginBean")LoginBean loginBean,BindingResult result,Model model,HttpSession session){
		if(result.hasErrors()){

			return"common/login";
		}else{
			boolean user=userService.userLogin(loginBean);
			if(user==false){
				return"redirect:/loginError";
			}else{

				UserBean userBean=userService.getUserByEmailId(loginBean.getEmail());	
				List productList=userService.productList();
				model.addAttribute("productList", productList);
				session.setAttribute("userBean",userBean);
				session.setAttribute("emailId", loginBean.getEmail());

				return"products/products";

			}

		}
	}

	@RequestMapping(value="/loginError",method=RequestMethod.GET)
	public String loginError(Model model){

		LoginBean loginBean=new LoginBean();
		model.addAttribute("loginBean", loginBean);
		model.addAttribute("msg","Email ID or password is incorrect");
		return"common/login";
	}

}
