package com.dao;

import java.util.List;

import javax.persistence.TypedQuery;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.entity.Classes;
import com.entity.Students;

import com.resource.DbResource;

public class ClassesDao {
	
	public int storeClasses(Classes classes) {
		try {
		SessionFactory sf = DbResource.getSessionFactory();
		Session session = sf.openSession();
		Transaction tran = session.getTransaction();
		tran.begin();
			session.save(classes);
		tran.commit();
		
		return 1;
		}catch(Exception e) {
			return 0;
		}
	}
	
	public List<Classes> findAllClasses() {
		SessionFactory sf = DbResource.getSessionFactory();
		Session session = sf.openSession();
		TypedQuery tq = session.createQuery("from Classes");
		List<Classes> lstofclasses = tq.getResultList();
		return lstofclasses;
	}
	

	  public int assignClassToTeacher(int classid,int tid) {
		   try {
				SessionFactory sf1 = DbResource.getSessionFactory();
				Session session1 = sf1.openSession();
				Transaction tran1 = session1.getTransaction();
				
				Classes emp1 = session1.get(Classes.class, classid);
				
				if(emp1==null) {
					System.out.println("Record not present");
				}else {
					tran1.begin();
					emp1.setTclassid1(tid);
					session1.update(emp1);
					tran1.commit();
					
				}
		  return 1;
		}catch(Exception e) {
		  return 0;
	   }
	  }
}
	

