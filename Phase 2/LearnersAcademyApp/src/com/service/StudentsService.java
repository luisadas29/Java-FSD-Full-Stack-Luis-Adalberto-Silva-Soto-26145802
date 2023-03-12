package com.service;

import java.util.List;

import com.dao.StudentsDao;
import com.entity.Students;

public class StudentsService {
	
	StudentsDao pd  = new StudentsDao();
	
	public String storeStudents(Students student) {
		if(pd.storeStudents(student)>0) {
			return "Student data stored successfully";
		}else {
			return "Student details didn't save correctly, please try again later";
		}
	}
	
	public List<Students> findAllStudents() {
		return pd.findAllStudents();
	}
	
	public String assignStudentClass(int classid,int studentid) {
		if(pd.assignStudenttoClass(classid,studentid)>0) {
			return " Student data stored successfully ";
		}else {
			return " Student details didn't save correctcly, please try again later ";
		}
		
	}

}
