package com.ssi.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.ssi.entities.Emp;
import com.ssi.entities.Scheme;

@Component


public class EmpDAO {
	@Autowired
	SessionFactory sessionFactory;
	public void removeEmp(String eid){
		Session session=sessionFactory.openSession();
		Transaction tr=session.beginTransaction();
		Emp emp=new Emp();
		emp.setEid(eid);
		session.delete(emp);
		tr.commit();
		session.close();
	}
public void addEmp(Emp emp){
	Session session=sessionFactory.openSession();
	Transaction tr=session.beginTransaction();
	session.save(emp);
	tr.commit();
	session.close();
}
public List<Emp> getAllEmp(){
	Session session=sessionFactory.openSession();
	Criteria cr=session.createCriteria(Emp.class);
	List<Emp> empList=cr.list();
	session.close();
	return empList;
	
}
	
}
