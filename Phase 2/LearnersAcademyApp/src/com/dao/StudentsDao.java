package com.dao;

import java.util.Iterator;
import java.util.List;

import javax.persistence.TypedQuery;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.entity.Classes;
import com.entity.Students;
import com.resource.DbResource;
import com.service.ClassesService;

public class StudentsDao {
	

	public int storeStudents(Students student) {
		try {
		SessionFactory sf = DbResource.getSessionFactory();
		Session session = sf.openSession();
		Transaction tran = session.getTransaction();
		tran.begin();
			session.save(student);
		tran.commit();
		
		return 1;
		}catch(Exception e) {
			return 0;
		}
	}
	
	public List<Students> findAllStudents() {
		SessionFactory sf = DbResource.getSessionFactory();
		Session session = sf.openSession();
		TypedQuery tq = session.createQuery("from Students");
		List<Students> lstOfStudents = tq.getResultList();
		

		return lstOfStudents;
	}

   public int assignStudenttoClass(int classid,int studentid) {
	    try {
	    SessionFactory sf = DbResource.getSessionFactory();
		Session session = sf.openSession();
		Transaction tran = session.getTransaction();
		
	     
		Students emp = session.get(Students.class, studentid);

		
	     if(emp==null) {
			System.out.println("Record not present");
		}else {
			tran.begin();
					emp.setTstudentid(classid);
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