

package com.ssi.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Query;
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
	public Emp getEmpById(String eid){
		Session session=sessionFactory.openSession();
		Emp emp=session.get(Emp.class, eid);
		session.close();
		return emp;
	}
	
	
	
	public boolean verifyEmp(Emp emp){
		Session session=sessionFactory.openSession();
		String hql="from Emp where email=:email and epassword=:epassword";
		Query query=session.createQuery(hql);
		query.setParameter("email", emp.getEmail());
		query.setParameter("epassword", emp.getEpassword());
		List<Emp> userList=query.list();
		int no=userList.size();
		session.close();
		if(no==0){
			return false;
		}else{
			return true;
		}
	}

	
public String[] getAllEmpEmails(){
		Session session=sessionFactory.openSession();
		Query query=session.createQuery("from Emp");
		List<Emp> emp=query.list();
		int size=emp.size();
		String emails[]=new String[size];
		for(int i=0; i<emp.size();i++){
			emails[i]=emp.get(i).getEmail();
		}
		return emails;
	}
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
	session.saveOrUpdate(emp);
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
