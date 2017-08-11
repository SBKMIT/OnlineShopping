package com.aits.onlineshoping.app.dao;

import java.util.List;

import org.apache.catalina.User;

import com.aits.onlineshoping.app.model.LoginBean;
import com.aits.onlineshoping.app.model.OrderBean;
import com.aits.onlineshoping.app.model.ProductBean;
import com.aits.onlineshoping.app.model.UserBean;

public interface UserDAO {
	public void userRegistration(UserBean user);
	public boolean userLogin(LoginBean loginBean);
	public  UserBean getUserByEmailId(String emailId);
	public List<ProductBean>productList();
	public void orderTheProduct(OrderBean orderBean);
	public ProductBean getProductById(int pid);
	public List productIds(UserBean userBean);
}
