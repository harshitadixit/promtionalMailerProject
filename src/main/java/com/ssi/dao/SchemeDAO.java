package com.ssi.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.ssi.entities.Scheme;
@Component
public class SchemeDAO {
  
	@Autowired
	SessionFactory sessionFactory;
	SchemeDAO schemedao;
	
	public Scheme getSchemeById(String sid){
		Session session=sessionFactory.openSession();
		Scheme scheme=session.get(Scheme.class, sid);
		session.close();
		return scheme;
		
	}
	public String getSchemeList(){
		Session session=sessionFactory.openSession();
		Criteria cr=session.createCriteria(Scheme.class);
		List<Scheme> scheme=cr.list();
		String s="Our Scheme discount : \n";
		for(Scheme schemes:scheme){
			s=s+schemes.getSdes()+","+schemes.getSdis()+"\n";
		     
		}
		
		return s;
	}
	
	public void removeScheme(String sid){
		Session session=sessionFactory.openSession();
		Transaction tr=session.beginTransaction();
		Scheme scheme=new Scheme(); 
		scheme.setSid(sid);
		session.delete(scheme);
		tr.commit();
		session.close();
	}
	public List<Scheme> getAllScheme(){
		Session session=sessionFactory.openSession();
		Criteria cr=session.createCriteria(Scheme.class);
		List<Scheme> schemeList=cr.list();
		session.close();
		return schemeList;
		
	}
	public void addScheme(Scheme scheme){
		
		   Session session=sessionFactory.openSession();
		  Transaction tr=session.beginTransaction();
		 session.saveOrUpdate(scheme);
		 tr.commit();
		 session.close();
		 
	}
}
