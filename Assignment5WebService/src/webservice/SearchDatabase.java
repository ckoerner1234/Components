package webservice;

import homework5.*;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.EJB;
import javax.jws.WebMethod;
import javax.naming.InitialContext;
import javax.naming.NamingException;


public class SearchDatabase {
	
//	@EJB
//	SurveyDB dbserv;

	public SearchDatabase() {
		// TODO Auto-generated constructor stub
	}
	
	@WebMethod
	public List<String> listStrings(String firstname, String lastname, String city, String state){

		System.out.println("in List<Strint> listStrings(String firstname, String lastname, String city, String state)");
		InitialContext context;
		List<String> returnList = new ArrayList<String>();
		List<Student> studentlist = new ArrayList<Student>();
		Student stud = new Student();
		try{
			context = new InitialContext();
			SurveyDB dbserv = (SurveyDB)context.lookup("java:global/Assignment5WebServiceEAR/Assignment5WebService/SurveyDBBean!homework5.SurveyDB"); 
		studentlist = dbserv.searchBy(firstname, lastname, city, state);
		for(Student student : studentlist){
			returnList.add(student.getFirstname() + "  " +
					student.getLastname() + "  " + 
					student.getStudentid() + " " +
					student.getCity() + "  " + 
					student.getState() + "  " +
					student.getZipcode() + "  " +
					student.getEmail());
		}
		} catch(Exception e){
			System.err.println("listStrings error");
			e.printStackTrace();
		}

		return returnList;
	}
	
	@WebMethod
	public List<Student> listStudents(String firstname, String lastname, String city, String state){
		System.out.println("in List<Student> listStudents(String firstname, String lastname, String city, String state)");
		InitialContext context;
		System.out.println("firstname   lastname   city    state  ");
        System.out.println(firstname + " " + lastname + " " + city +" " + state);
		List<Student> studentlist = new ArrayList<Student>();
		Student stud = new Student();
		try {
			context = new InitialContext();
			SurveyDB dbserv = (SurveyDB)context.lookup("java:global/Assignment5WebServiceEAR/Assignment5WebService/SurveyDBBean!homework5.SurveyDB"); 
			System.out.println("dbserv = " + dbserv);
			studentlist = dbserv.searchBy(firstname, lastname, city, state);
			for(Student student : studentlist){
				System.out.println(student.getFirstname());
				System.out.println(student.getLastname());
				System.out.println(student.getStudentid());
				stud = student;
			}
		} catch (NamingException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}		

		return studentlist;
	}
	
	@WebMethod
	public void getStudents(){
		
		InitialContext context;
		try{		
			context = new InitialContext();
			SurveyDB dbserv = (SurveyDB)context.lookup("java:global/Assignment5WebServiceEAR/Assignment5WebService/SurveyDBBean!homework5.SurveyDB"); 
			System.out.println("dbserv = " + dbserv);		
			List<Student> studentlist = dbserv.getFromDatabaseJPA();
			for(Student student : studentlist){
			System.out.println(student.getFirstname());
			System.out.println(student.getLastname());
			System.out.println(student.getStudentid());
		}
		} catch(Exception e){
			System.err.println("getStudents error");
			e.printStackTrace();
		}
		
	}


}
