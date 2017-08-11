package com.aits.onlineshoping.app.service;

import java.util.List;

import javax.transaction.Transactional;

import org.apache.catalina.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.aits.onlineshoping.app.dao.UserDAO;
import com.aits.onlineshoping.app.model.LoginBean;
import com.aits.onlineshoping.app.model.OrderBean;
import com.aits.onlineshoping.app.model.ProductBean;
import com.aits.onlineshoping.app.model.UserBean;

@Service
@Transactional
public class UserServiceImplemetion implements UserServiceInterface {

	@Autowired
	private UserDAO userDAO;
	
	@Override
	public void userRegistration(UserBean user) {
		// TODO Auto-generated method stub
		userDAO.userRegistration(user);
	}

	@Override
	public boolean userLogin(LoginBean loginBean) {
		// TODO Auto-generated method stub
		return userDAO.userLogin(loginBean);
	}

	@Override
	public UserBean getUserByEmailId(String emailId) {
		// TODO Auto-generated method stub
		
		return userDAO.getUserByEmailId(emailId);
	}

	@Override
	public List<ProductBean> productList() {
		// TODO Auto-generated method stub
		return userDAO.productList();
	}

	@Override
	public void orderTheProduct(OrderBean orderBean) {
		// TODO Auto-generated method stub
		userDAO.orderTheProduct(orderBean);
	}

	@Override
	public ProductBean getProductById(int pid) {
		// TODO Auto-generated method stub
		return userDAO.getProductById(pid);
	}

	@Override
	public List productIds(UserBean userBean) {
		// TODO Auto-generated method stub
		return userDAO.productIds(userBean);
	}

	

}
