package com.service;

import java.util.List;

import com.dao.TeacherDao;
import com.entity.Teacher;

public class TeacherService {
	
	TeacherDao pd  = new TeacherDao();
	
	public String storeTeacher(Teacher teacher) {
		if(pd.storeTeacher(teacher)>0) {
			return "Teacher data stored successfully";
		}else {
			return "Teacher details didn't save correctly, please try again later";
		}
	}
	
	public List<Teacher> findAllTeacher() {
		return pd.findAllTeacher();
	}
	
	public String assignTeacherClass(int classid,int tid) {
		if(pd.assignTeachertoClass(classid,tid)>0) {
			return " Teacher data stored successfully ";
		}else {
			return " Teacher details didn't save correctcly, please try again later ";
		}
		
	}

}
