package com.ssi.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.ssi.entities.Customer;


@Component
public class CustomerDAO {
	


	@Autowired
	SessionFactory sessionFactory;
	public Customer getCustomerById(String cid){
		Session session=sessionFactory.openSession();
		Customer customer=session.get(Customer.class, cid);
		session.close();
		return customer;
	}
	
	
	public void removeCustomer(String cid){
		Session session=sessionFactory.openSession();
		Transaction tr=session.beginTransaction();
		Customer customer=new Customer(); 
		customer.setCid(cid);
		session.delete(customer);
		tr.commit();
		session.close();
	}
	
	public boolean verifyCustomer(Customer customer){
		Session session=sessionFactory.openSession();
		String hql="from Customer where cemail=:email and password=:cpassword";
		Query query=session.createQuery(hql);
		query.setParameter("email", customer.getCemail());
		query.setParameter("password", customer.getCpassword());
		List<Customer> CustomerList=query.list();
		int no=CustomerList.size();
		session.close();
		if(no==0){
			return false;
		}else{
			return true;
		}
	}

public void savecustomer(Customer customer)
{
	Session session=sessionFactory.openSession();
	Transaction tr=session.beginTransaction();
	session.save(customer);
	tr.commit();
	session.close();
}


public List<Customer> getAllCustomer(){
	Session session=sessionFactory.openSession();
	Criteria cr=session.createCriteria(Customer.class);
	List<Customer> customerList=cr.list();
	session.close();
	return customerList;
	
}
}
