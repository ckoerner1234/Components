package homework5;

import java.util.*;

import javax.ejb.*;

import studentInfo.*;



@Local
public interface SurveyDB {
	//public Map<String,Student> searchBy(String firstname, String lastname, String city, String state);	
	public List<Student> searchBy(String firstname, String lastname, String city, String state);	
	//public Map<String,Student> getFromDatabaseJPA();
	public List<Student> getFromDatabaseJPA();
	public Map<Integer,Student> getFromDatabaseJPA_int();
	
	public void saveToDatabaseJPA(Student student);
	public void saveToDatabaseJPA(EmergencyContactInfo eci);
	public void deleteFromDatabaseJPA(Map<String,Student> deleted_student_map);
}
