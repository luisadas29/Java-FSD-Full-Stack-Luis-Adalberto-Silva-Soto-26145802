package com.service;

import java.util.List;

import com.dao.ClassesDao;
import com.entity.Classes;
import com.entity.Students;

public class ClassesService {
	
	ClassesDao pd  = new ClassesDao();
	
	public String storeClasses(Classes classes) {
		if(pd.storeClasses(classes)>0) {
			return "Class data stored successfully";
		}else {
			return "Class details didn't save correctly, please try again later";
		}
	}
	
	public List<Classes> findAllClasses() {
		return pd.findAllClasses();
	}
	
	public String assignClasstoTeachers(int classid, int studentid) {
		if(pd.assignClassToTeacher((classid),studentid)>0) {
			return "  Class data stored successfully   ";
		}else {
			return "  Class details didn't save correctly, please try again late r  ";
		}
		
	}

}
