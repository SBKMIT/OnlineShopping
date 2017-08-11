package com.aits.onlineshoping.app.dao;

import java.util.List;

import org.apache.catalina.User;
import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.aits.onlineshoping.app.model.LoginBean;
import com.aits.onlineshoping.app.model.OrderBean;
import com.aits.onlineshoping.app.model.ProductBean;
import com.aits.onlineshoping.app.model.UserBean;

@Repository
public class UserDAOImple implements UserDAO {

	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public void userRegistration(UserBean user) {
		// TODO Auto-generated method stub
		LoginBean loginBean=new LoginBean();
		loginBean.setEmail(user.getEmailId());
		loginBean.setPassword(user.getPassword());
		sessionFactory.getCurrentSession().save(loginBean);
		sessionFactory.getCurrentSession().save(user);
	}

	@Override
	public boolean userLogin(LoginBean loginBean) {
		// TODO Auto-generated method stub

		//sessionFactory.getCurrentSession().createQuery("from LoginBean where emailId:")

		Session session=sessionFactory.openSession();

		String hql = "Select log.email from LoginBean log where log.email=:email and log.password=:password"; 
		Query query=session.createQuery(hql);
		query.setParameter("email", loginBean.getEmail());
		query.setParameter("password",loginBean.getPassword());

		List<ProductBean> userDatalist=query.list();

		if(userDatalist.isEmpty()){
			return false;
		}
		else{
			return true;

		}


	}

	@Override
	public UserBean getUserByEmailId(String emailId) {
		// TODO Auto-generated method stub

		Session session=sessionFactory.openSession();
		Criteria criteria=session.createCriteria(UserBean.class);
		Criterion criterion=Restrictions.eq("emailId",emailId);
		criteria.add(criterion);
		UserBean userBean=(UserBean) criteria.uniqueResult();
		return userBean;
	}

	@Override
	public List<ProductBean> productList() {
		// TODO Auto-generated method stub
		return sessionFactory.getCurrentSession().createQuery("from ProductBean").list();
	}

	@Override
	public void orderTheProduct(OrderBean orderBean) {
		// TODO Auto-generated method stub
		sessionFactory.getCurrentSession().save(orderBean);
	}

	@Override
	public ProductBean getProductById(int pid) {
		// TODO Auto-generated method stub
		return (ProductBean) sessionFactory.getCurrentSession().get(ProductBean.class,pid);
	}

	@Override
	public List productIds(UserBean userBean) {
		Session session=sessionFactory.openSession();

		/*String hql = "Select o.pid from OrderBean o where o.uId=:uId"; 
		Query query=session.createQuery(hql);
		query.setParameter("uId", userBean.getuId());
	
		List<OrderBean> userDatalist=(List<OrderBean>) query.uniqueResult();*/
		
		Criteria criteria=session.createCriteria(OrderBean.class);
		Criterion criterion=Restrictions.eq("userBean.uId",userBean.getuId());
		criteria.add(criterion);
		List<OrderBean> userDatalist=criteria.list();
		
		
		
		return userDatalist;
	}

}
