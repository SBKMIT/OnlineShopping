package com.aits.onlineshoping.app.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.aits.onlineshoping.app.model.OrderBean;
import com.aits.onlineshoping.app.model.ProductBean;
import com.aits.onlineshoping.app.model.UserBean;
import com.aits.onlineshoping.app.service.UserServiceInterface;

@Controller
public class OrderController {

	@Autowired
	private UserServiceInterface userservice;

	@RequestMapping(value="order",method=RequestMethod.GET)
	public String saveOrder(Model model,@RequestParam int productId,HttpSession session){

		System.out.println("PID="+productId);
		String emailId=(String) session.getAttribute("emailId");
		UserBean userBean=userservice.getUserByEmailId(emailId);
		ProductBean productBean=userservice.getProductById(productId);
		OrderBean orderBean=new OrderBean();
		orderBean.setUserBean(userBean);
		orderBean.setProductBean(productBean);
		userservice.orderTheProduct(orderBean);

		List productList=userservice.productList();
		model.addAttribute("productList", productList);

		return"products/products";
	}

	@RequestMapping(value="showOrder",method=RequestMethod.GET)
	public String showOrder(Model model,HttpSession session){

       float totalPrize=0;
		
		String emailId=(String) session.getAttribute("emailId");
		UserBean userBean=userservice.getUserByEmailId(emailId);

		List<OrderBean> cartList=userservice.productIds(userBean);

		model.addAttribute("cartList", cartList);
		
		
		for(OrderBean orderBean:cartList){
			totalPrize=totalPrize+orderBean.getProductBean().getPrice();
			
		}
		
		model.addAttribute("totalPrize", totalPrize);
		return"products/PlaceOrderPage";
	}



}
