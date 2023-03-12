package com.dao;

import java.util.List;

import javax.persistence.TypedQuery;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.entity.Subject;
import com.entity.Teacher;
import com.resource.DbResource;

public class SubjectDao {
	
	public int storeSubject(Subject subject) {
		try {
		SessionFactory sf = DbResource.getSessionFactory();
		Session session = sf.openSession();
		Transaction tran = session.getTransaction();
		tran.begin();
			session.save(subject);
		tran.commit();
		
		return 1;
		}catch(Exception e) {
			return 0;
		}
	}
	
	public List<Subject> findAllSubjects() {
		SessionFactory sf = DbResource.getSessionFactory();
		Session session = sf.openSession();
		TypedQuery tq = session.createQuery("from Subject");
		List<Subject> lstofsubjects = tq.getResultList();
		return lstofsubjects;
	}
	
	   public int assignTeachertoSubject(int subid,int tid) {
		    try {
		    SessionFactory sf = DbResource.getSessionFactory();
			Session session = sf.openSession();
			Transaction tran = session.getTransaction();
		     
			Subject emp = session.get(Subject.class, subid);
			
		     if(emp==null) {
				System.out.println("Record not present");
			}else {
				tran.begin();
						emp.setTsud1(tid);
						session.update(emp);
				tran.commit();
		   
			}
		     return 1;
		}catch(Exception e) {
			System.out.println(e);
		   return 0;
	   }
	   }
		    
			   public int assignSubjectToClass(int subid,int classid) {
				    try {
				    SessionFactory sf = DbResource.getSessionFactory();
					Session session = sf.openSession();
					Transaction tran = session.getTransaction();
				     
					Subject emp = session.get(Subject.class, classid);
					
				     if(emp==null) {
						System.out.println("Record not present");
					}else {
						tran.begin();
								emp.setTsud(classid);
								session.update(emp);
						tran.commit();
				   
					}
				     return 1;
				}catch(Exception e) {
					System.out.println(e);
				   return 0;
			   }

	   }

}
