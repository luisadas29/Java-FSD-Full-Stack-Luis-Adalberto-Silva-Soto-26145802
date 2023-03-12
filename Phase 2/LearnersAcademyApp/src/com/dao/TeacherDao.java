package com.dao;

import java.util.List;

import javax.persistence.TypedQuery;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.entity.Students;
import com.entity.Teacher;
import com.resource.DbResource;

public class TeacherDao {
	SessionFactory sf;
	public TeacherDao() {			
		sf = DbResource.getSessionFactory();
	}
	
	public int storeTeacher(Teacher teacher) {
		try {
			Session session = sf.openSession();
			Transaction tran = session.getTransaction();
			tran.begin();
				session.save(teacher);
			tran.commit();
		return 1;
		}catch(Exception e) {
			System.out.println(e);
			return 0;
		}
	}
	
	public List<Teacher> findAllTeacher() {
		Session session = sf.openSession();
		TypedQuery tq = session.createQuery("from Teacher");
		List<Teacher> lstofTeachers = tq.getResultList();
		return lstofTeachers;
	}
	
	   public int assignTeachertoClass(int classid,int tid) {
		    try {
		    SessionFactory sf = DbResource.getSessionFactory();
			Session session = sf.openSession();
			Transaction tran = session.getTransaction();
		     
			Teacher emp = session.get(Teacher.class, tid);
			int temp = classid;
			
		     if(emp==null) {
				System.out.println("Record not present");
			}else {
				tran.begin();
						emp.setTtid(temp);
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
