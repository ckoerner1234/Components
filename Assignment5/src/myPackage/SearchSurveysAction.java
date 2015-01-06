package myPackage;

import homework5.SurveyDB;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Map;

import javax.naming.InitialContext;
import javax.naming.NamingException;

import studentInfo.*;
import webservice.SearchDatabaseStub;

import com.opensymphony.xwork2.ActionSupport;

import org.apache.struts2.interceptor.SessionAware;



public class SearchSurveysAction extends ActionSupport implements SessionAware {
	
	private String firstname;
	private String lastname;
	private String studentid;
	private String streetaddress1;
	private String streetaddress2;
	private String city;
	private String state;
	private String zipcode;
	private String phone;
	private String email;
	private String url;
	
	private Student student;

	private Collection<Student> collectionOfStudents;
	
	private List<String> studentlistfromwebservice;
	

	public String getFirstname() {
		return firstname;
	}




	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}




	public String getLastname() {
		return lastname;
	}




	public void setLastname(String lastname) {
		this.lastname = lastname;
	}




	public String getStudentid() {
		return studentid;
	}




	public void setStudentid(String studentid) {
		this.studentid = studentid;
	}




	public String getStreetaddress1() {
		return streetaddress1;
	}




	public void setStreetaddress1(String streetaddress1) {
		this.streetaddress1 = streetaddress1;
	}




	public String getStreetaddress2() {
		return streetaddress2;
	}




	public void setStreetaddress2(String streetaddress2) {
		this.streetaddress2 = streetaddress2;
	}




	public String getCity() {
		return city;
	}




	public void setCity(String city) {
		this.city = city;
	}




	public String getState() {
		return state;
	}




	public void setState(String state) {
		this.state = state;
	}




	public String getZipcode() {
		return zipcode;
	}




	public void setZipcode(String zipcode) {
		this.zipcode = zipcode;
	}




	public String getPhone() {
		return phone;
	}




	public void setPhone(String phone) {
		this.phone = phone;
	}




	public String getEmail() {
		return email;
	}




	public void setEmail(String email) {
		this.email = email;
	}




	public String getUrl() {
		return url;
	}




	public void setUrl(String url) {
		this.url = url;
	}


	public Student getStudent() {
		return student;
	}




	public void setStudent(Student student) {
		this.student = student;
	}

	public Collection<Student> getCollectionOfStudents() {
		return collectionOfStudents;
	}

	public void setCollectionOfStudents(Collection<Student> collectionOfStudents) {
		this.collectionOfStudents = collectionOfStudents;
	}

	
	public List<String> getStudentlistfromwebservice() {
		return studentlistfromwebservice;
	}




	public void setStudentlistfromwebservice(List<String> studentlistfromwebservice) {
		this.studentlistfromwebservice = studentlistfromwebservice;
	}




	public static SearchDatabaseStub getStub() throws Exception{
		System.out.println("in SearchDatabaseStub getStub()");
		//String address="http://localhost:8080/Assignment5WebService/services/SearchDatabase";
		String address="http://ec2-54-165-77-194.compute-1.amazonaws.com/Assignment5WebService/services/SearchDatabase";
		SearchDatabaseStub stub = new SearchDatabaseStub(address);
		System.out.println("in SearchDatabaseStub getStub()");
		return (stub);
	}
	
	public static List<Student> getStudents(SearchDatabaseStub stub, String firstname, String lastname, String city, String state) throws Exception{

		System.out.println("in List<Student> getStudents which calls the web service");
		System.out.println("firstname = " + firstname);
		System.out.println("lastname = " + lastname);
		System.out.println("city = " + city);
		System.out.println("state = " + state);
		SearchDatabaseStub.ListStudents request = new SearchDatabaseStub.ListStudents();
		request.setFirstname(firstname);
		request.setLastname(lastname);
		request.setCity(city);
		request.setState(state);
		SearchDatabaseStub.ListStudentsResponse response = stub.listStudents(request);
		System.out.println("6");
		SearchDatabaseStub.Student[] studentarray = response.get_return();
		int number = studentarray.length;
		int num;
		List<Student> studentlist = new ArrayList<Student>();
		Student stud = new Student();
		for(int i=0; i<number; i++){
			stud.setFirstname(studentarray[i].getFirstname());
			stud.setLastname(studentarray[i].getLastname());
			stud.setStudentid(studentarray[i].getStudentid());
			stud.setStreetaddress1(studentarray[i].getStreetaddress1());
			stud.setStreetaddress2(studentarray[i].getStreetaddress2());
			stud.setCity(studentarray[i].getCity());
			stud.setState(studentarray[i].getState());
			stud.setZipcode(studentarray[i].getZipcode());
			stud.setPhone(studentarray[i].getPhone());
			stud.setEmail(studentarray[i].getEmail());
			stud.setUrl(studentarray[i].getUrl());
			
			SearchDatabaseStub.Collection eciscollection = studentarray[i].getEcis();
			System.out.println(eciscollection.toString());
				
			studentlist.add(stud);
		}
		return (studentlist);
	}

	
	
	public static List<String> getStudentsAsStrings(SearchDatabaseStub stub, String firstname, String lastname, String city, String state) throws Exception{

		System.out.println("in List<String> getStudentsAsStrings which calls the web service");
		System.out.println("firstname = " + firstname);
		System.out.println("lastname = " + lastname);
		System.out.println("city = " + city);
		System.out.println("state = " + state);
		SearchDatabaseStub.ListStrings request = new SearchDatabaseStub.ListStrings();
		request.setFirstname(firstname);
		request.setLastname(lastname);
		request.setCity(city);
		request.setState(state);
		SearchDatabaseStub.ListStringsResponse response = stub.listStrings(request);
		System.out.println("after webservice call");
		String[] returnStringArray = response.get_return();
		int number = returnStringArray.length;
		List<String> studentstringlist = new ArrayList<String>();
		for(int i=0; i<number; i++){
			studentstringlist.add(returnStringArray[i]);
			System.out.println(returnStringArray[i]);
		}
		System.out.println("******************************************************************");
		for(String s : studentstringlist){
			System.out.println(s);
		}
		System.out.println("******************************************************************");
		return (studentstringlist);
	}	
	
	
	
	public String execute() throws NamingException{
		
		InitialContext context = new InitialContext();		
		SurveyDB dbserv = (SurveyDB)context.lookup("java:global/Assignment5WebServiceClientEAR/Assignment5/SurveyDBBean!homework5.SurveyDB"); 
		
		List<Student> studentlist = dbserv.searchBy(firstname, lastname, city, state);
		
		try{
			System.out.println("in SearchSurveysAction execute 1234567890000000");
			SearchDatabaseStub stub = getStub();
			//studentlist = getStudents(stub, firstname, lastname, city, state);
			studentlistfromwebservice = getStudentsAsStrings(stub, firstname, lastname, city, state);
			System.out.println("in SearchSurveysAction after getStudentsAsStrings");
			for(String s : studentlistfromwebservice){
				System.out.println(s);
			}

		} catch (Exception e){
			System.err.println("Web Service error");
			e.printStackTrace();
		}

		collectionOfStudents = studentlist;
		
		// Write to the session
		  session.put("studentlist_session",collectionOfStudents);

		String address="success";
		
		return address;  

	}
	
	// For SessionAware
	  Map<String, Object> session;
	  @Override
	  public void setSession(Map<String, Object> session) {
	    this.session = session;
	  }	


}
