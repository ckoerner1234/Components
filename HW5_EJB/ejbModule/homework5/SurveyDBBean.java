package homework5;


import java.sql.*;
import java.util.*;

import javax.naming.InitialContext;
import javax.persistence.*;
import javax.ejb.Stateless;

import homework5.SurveyDB;
import studentInfo.*;

@Stateless
public class SurveyDBBean implements SurveyDB {
	
	@PersistenceContext(unitName="Assignment4") 
	private EntityManager entityManager;

	
	public List<Student> getFromDatabaseJPA(){
		System.out.println("in getFromDatabaseJPA() SURVEYDBBEAN");
		System.out.println("in getFromDatabaseJPA entityManager = " + entityManager);
		Query q = entityManager.createQuery("select s From Student s order by s.lastname");
		List<Student> studentlist = q.getResultList();
		for (Student student : studentlist) {
			System.out.println(student.getFirstname() + "  " + student.getLastname());
		}
		return studentlist;
	}
	

	public Map<Integer,Student> getFromDatabaseJPA_int(){
		Map<Integer,Student> studentmap = new HashMap<Integer,Student>();
		Query q = entityManager.createQuery("select s From Student s order by s.lastname");
		List<Student> studentList = q.getResultList();
		Integer i = 0;
		for (Student student : studentList) {
			studentmap.put(i, student);
			i=i+1;
		}
		return studentmap;
	}
	
	public void saveToDatabaseJPA(Student student){
		System.out.println("in saveToDatabaseJPA entityManager = " + entityManager);
		System.out.println(student.getFirstname());
		System.out.println(student.getLastname());
		entityManager.persist(student);
		entityManager.merge(student);
	}

	public void saveToDatabaseJPA(EmergencyContactInfo eci){
		//don't use this method
		System.out.println(eci.getFirstname());
		System.out.println(eci.getLastname());
		entityManager.persist(eci);
	}

	public void deleteFromDatabaseJPA(Map<String,Student> deleted_student_map){
		//Query q = entityManager.createQuery("Delete From Student s where s.studentid = :id");
		System.out.println("in deleteFromDatabaseJPA()");
		Set<String> list_of_ids = deleted_student_map.keySet();
		Student delstud;
		for(String id : list_of_ids){
			delstud = entityManager.find(Student.class, id);
			entityManager.remove(delstud);
		    System.out.println("deleted student : " + deleted_student_map.get(id).getFirstname() + "  " + deleted_student_map.get(id).getLastname());
		    //q.setParameter("id", id).executeUpdate();
		}
		
	}


	public Map<String,Student> searchBySearchString(String searchString){
		//don't use this method
		Map<String,Student> studentmap = new HashMap<String,Student>();
		Query q = entityManager.createQuery("Select hw4student From Student hw4student " + searchString);
		List<Student> studentList = q.getResultList();
		for (Student student : studentList) {
			studentmap.put(student.getLastname(), student);
		}
		return studentmap;	
	}

	public List<Student> searchBy(String firstname, String lastname, String city, String state){		
		
		System.out.println("in searchBy entityManager = " + entityManager);
		firstname = firstname.trim();
		lastname = lastname.trim();
		city = city.trim();
		state = state.trim();
		
		if(firstname.equals("")) firstname="%";
		if(lastname.equals("")) lastname="%";
		if(city.equals("")) city = "%";
		if(state.equals("")) state = "%";
		
		int index = firstname.indexOf("*");
		if (index >= 0) {
			firstname = firstname.replaceAll("\\*", "%");
		}

		index = lastname.indexOf("*");
		if (index >= 0) {
			lastname = lastname.replaceAll("\\*", "%");
		}

		index = city.indexOf("*");
		if (index >= 0) {
			city = city.replaceAll("\\*", "%");
		}

		index = state.indexOf("*");
		if (index >= 0) {
			state = state.replaceAll("\\*", "%");
		}


		Query q = entityManager.createQuery("Select s From Student s where s.firstname like :firstname and s.lastname like :lastname and s.city like :city and s.state like :state order by s.lastname");
		q.setParameter("firstname", firstname);
		q.setParameter("lastname", lastname);
		q.setParameter("city", city);
		q.setParameter("state", state);
		List<Student> studentList = q.getResultList();
		if(studentList == null)System.out.println("studentList is null");
		System.out.println("in searchBy()");
		for (Student student : studentList) {
			System.out.println(student.getFirstname() + "  " + student.getLastname());
		}
		return studentList;	
	}
	
	
}
