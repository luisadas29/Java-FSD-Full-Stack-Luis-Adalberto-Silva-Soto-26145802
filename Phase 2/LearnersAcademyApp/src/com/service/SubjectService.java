package com.service;

import java.util.List;

import com.dao.SubjectDao;
import com.entity.Subject;

public class SubjectService {
	
	SubjectDao pd  = new SubjectDao();
	
	public String storeSubject(Subject subject) {
		if(pd.storeSubject(subject)>0) {
			return "Subject data stored successfully";
		}else {
			return "Subject details didn't save correctly, please try again later";
		}
	}
	
	public List<Subject> findAllSubject() {
		return pd.findAllSubjects();
	}
	
	public String assignTeacherToSubjects(int subid,int tid) {
		if(pd.assignTeachertoSubject(subid,tid)>0) {
			return " Teacher data stored successfully ";
		}else {
			return " Teacher details didn't save correctcly, please try again later ";
		}
		
	}
	
	public String assignSubjectToClass(int subid,int classid) {
		if(pd.assignTeachertoSubject(subid,classid)>0) {
			return " Teacher data stored successfully ";
		}else {
			return " Teacher details didn't save correctcly, please try again later ";
		}
		
	}

}
