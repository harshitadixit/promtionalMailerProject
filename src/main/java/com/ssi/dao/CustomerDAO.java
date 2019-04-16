package com.ssi.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.ssi.entities.Customer;
import com.ssi.entities.Scheme;

@Component
public class CustomerDAO {

	@Autowired
	SessionFactory sessionFactory;
	
	public void removeCustomer(String cid){
		Session session=sessionFactory.openSession();
		Transaction tr=session.beginTransaction();
		Customer customer=new Customer(); 
		customer.setCid(cid);
		session.delete(customer);
		tr.commit();
		session.close();
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
