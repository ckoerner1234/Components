package myPackage;

//SWE645  Carolyn Koerner

import studentInfo.*;
import homework5.*;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang3.StringUtils;
import org.apache.struts2.interceptor.validation.SkipValidation;

import com.opensymphony.xwork2.ActionSupport;

import org.apache.struts2.interceptor.SessionAware;

import java.rmi.RemoteException;
import java.sql.*;

import javax.naming.*;
import javax.ejb.*;


public class ProcessSurveyFormDataAction extends ActionSupport implements SessionAware  {
	//public class ProcessSurveyFormDataAction extends ActionSupport implements ModelDriven{
	    
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
	private String date;
	private String greeting;
	private Collection<EmergencyContactInfo> ecis;

	private String rafflebox;

	private WinningResult winres;
	private Student student;
	private EmergencyContactInfo eci;
	private String ecifirstname;
	private String ecilastname;
	private String eciphone;
	private String eciemail;
	private Collection<Student> collectionOfStudents;
	
	private Map<Integer,Boolean> list_of_deleted_students;
	

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
	public EmergencyContactInfo getEci() {
		return eci;
	}
	public void setEci(EmergencyContactInfo eci) {
		this.eci = eci;
	}
	public String getEcifirstname() {
		return ecifirstname;
	}
	public void setEcifirstname(String ecifirstname) {
		this.ecifirstname = ecifirstname;
	}
	public String getEcilastname() {
		return ecilastname;
	}
	public void setEcilastname(String ecilastname) {
		this.ecilastname = ecilastname;
	}
	public String getEciphone() {
		return eciphone;
	}
	public void setEciphone(String eciphone) {
		this.eciphone = eciphone;
	}
	public String getEciemail() {
		return eciemail;
	}
	public void setEciemail(String eciemail) {
		this.eciemail = eciemail;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}

	public String getRafflebox() {
		return rafflebox;
	}
	public void setRafflebox(String rafflebox) {
		this.rafflebox = rafflebox;
	}
	public WinningResult getWinres() {
		return winres;
	}
	public void setWinres(WinningResult winres) {
		this.winres = winres;
	}
	public Student getStudent() {
		return student;
	}
	public void setStudent(Student student) {
		this.student = student;
	}	

	public Map<Integer, Boolean> getList_of_deleted_students() {
		return list_of_deleted_students;
	}
	public void setList_of_deleted_students(
			Map<Integer, Boolean> list_of_deleted_students) {
		this.list_of_deleted_students = list_of_deleted_students;
	}
	public Collection<Student> getCollectionOfStudents(){
		return collectionOfStudents;
	}
	public void setCollectionOfStudents(Collection<Student> collectionOfStudents){
		this.collectionOfStudents = collectionOfStudents;
	}

	public String getGreeting() {
		return greeting;
	}
	public void setGreeting(String greeting) {
		this.greeting = greeting;
	}
	public String execute() throws IOException, SQLException, NamingException{

		System.out.println("in execute ProcessSurveyFormData");
		InitialContext context = new InitialContext();
		
		//this one does not work here. don't use it.
		//SurveyDB dbserv = (SurveyDB)context.lookup("java:global/Assignment5WebServiceClientEAR/HW5_EJB/SurveyDBBean!homework5.SurveyDB"); 		
		SurveyDB dbserv = (SurveyDB)context.lookup("java:global/Assignment5WebServiceClientEAR/Assignment5/SurveyDBBean!homework5.SurveyDB"); 		

		eci = new EmergencyContactInfo(ecifirstname, ecilastname, eciphone, eciemail, studentid);
		ecis = new ArrayList<EmergencyContactInfo>();
		ecis.add(eci);
		student = new Student(firstname, lastname, studentid, streetaddress1,
				streetaddress2, city, state, zipcode, phone, email, url, ecis);

		System.out.println("Printing out the first and last name");
		System.out.println(student.getFirstname());
		System.out.println(student.getLastname());
		
		dbserv.saveToDatabaseJPA(student);

		System.out.println("Printing out the first and last name of Emergency Contact");
		System.out.println(eci.getFirstname());
		System.out.println(eci.getLastname());

		String[] numbers_string = rafflebox.split(",");
		double[] numbers = new double[numbers_string.length];
		for (int i=0; i<numbers_string.length; i++){
			numbers[i] = Double.parseDouble(numbers_string[i]);
		}
		DataProcessor dp = new DataProcessor();
		winres = dp.computeMeanAndSD(numbers);

		double mean = winres.getMean();
		double standardDeviation = winres.getSd();
		
		String address="error";

		if(mean < 90) {
			address = "simpleAcknowledgement";
		}
		if(mean >= 90) {
			address = "winnerAcknowledgement";
		}
				
		try{
			HiTryAgainStub stub = getStub();
			String name = firstname + lastname;
			System.out.println("name = " + name);
			System.out.println(getGreeting(stub,name));
			greeting = getGreeting(stub, name);
		} catch (Exception e){
			System.err.println("HiTryAgain error");
			e.printStackTrace();
		}
		
		

		return address;  
	}
	
	
	public static HiTryAgainStub getStub() throws Exception{
		String address="http://localhost:8080/TryThisAgain/services/HiTryAgain";
		//String address="http://ec2-54-165-77-194.compute-1.amazonaws.com/Assignment5WebService/services/SearchDatabase";
		HiTryAgainStub stub = new HiTryAgainStub(address);
		return (stub);
	}
	
	public static String getGreeting(HiTryAgainStub stub, String name) throws Exception{
		HiTryAgainStub.HelloWorld3 request = new HiTryAgainStub.HelloWorld3();
		request.setName(name);
		HiTryAgainStub.HelloWorld3Response response = stub.helloWorld3(request);
		return (response.get_return());
	}
		
	
	@SkipValidation
	public String listStudents()  throws IOException, SQLException, NamingException{
				
		System.out.println("In listStudents");
		InitialContext context = new InitialContext();
		SurveyDB dbserv = (SurveyDB)context.lookup("java:global/Assignment5WebServiceClientEAR/Assignment5/SurveyDBBean!homework5.SurveyDB"); 
		List<Student> studentlist;
		studentlist = dbserv.getFromDatabaseJPA();
	
		collectionOfStudents = studentlist;
		
		// Write to the session
		  session.put("studentlist_session",collectionOfStudents);
		  
		
		for(Student s : studentlist){
			for(EmergencyContactInfo ec : s.getEcis()){
				System.out.println("Emergency Contact: " + ec.getFirstname() + "  " + ec.getLastname());
			}
		}
		
		
		return "success";
	}

	@SkipValidation
	public String deleteStudents()  throws NamingException{
		System.out.println("in deleteStudents()");
		// Read from the session
		  if (session.containsKey("studentlist_session"))
		    collectionOfStudents=(Collection<Student>)session.get("studentlist_session");
		
			for(Student s : collectionOfStudents){
				System.out.println(s.getFirstname() + "  " + s.getLastname());
			}
				  
			Map<Integer,Student> studentmap = new HashMap<Integer,Student>();
			Integer i = 0;
			for (Student student : collectionOfStudents) {
				studentmap.put(i, student);
				i=i+1;
			}
  
		
		System.out.println("********************");
						
		InitialContext context = new InitialContext();
		SurveyDB dbserv = (SurveyDB)context.lookup("java:global/Assignment5WebServiceClientEAR/Assignment5/SurveyDBBean!homework5.SurveyDB"); 
		//Map<Integer,Student> studentmap = dbserv.getFromDatabaseJPA_int();
		Map<String,Student> deleted_student_map = new HashMap<String,Student>();
		List<Integer> keys = new ArrayList<Integer>(list_of_deleted_students.keySet());
		boolean temp;
		Student temp_student;
		List<Student> kept_students = new ArrayList<Student>();
		for (Integer key: keys) {
		    temp = list_of_deleted_students.get(key);			
		    System.out.println(key + ": " + temp);
		    if(temp == true) {
			    temp_student = studentmap.get(key);
			    System.out.println("deleted student id : " + temp_student.getStudentid());
		    	deleted_student_map.put(temp_student.getStudentid(), temp_student);
		    }
		    if(temp == false){
		    	temp_student = studentmap.get(key);
		    	kept_students.add(temp_student);
		    }
		}
		
		dbserv.deleteFromDatabaseJPA(deleted_student_map);
		List<Student> studentlist2 = dbserv.getFromDatabaseJPA();

		System.out.println("In listStudents after call to getFromDatabaseJPA");
		//collectionOfStudents = studentlist2;
		collectionOfStudents = kept_students;
		// Write to the session
		  session.put("studentlist_session",collectionOfStudents);
			
		return "success";
	}	
	
	public void validate(){
		System.out.println("in validate");
		
		String rafflestring = getRafflebox();
		String[] stringNumbers = rafflestring.split(",");
		int maximum = 0;
		int totalNum = stringNumbers.length;
		int minNum=10;
		
		if(totalNum < minNum) 
		{
			addFieldError("rafflebox","You must have at least 10 numbers entered here");
		}
		
		if(totalNum >= minNum)  maximum = calculateMax(stringNumbers);
		if(maximum > 100) 
			addFieldError("rafflebox","You are not allowed to enter any numbers greater than 100");
		
		if(StringUtils.isEmpty(getFirstname())){
			addFieldError("firstname","First Name cannot be blank");
		}
		if(StringUtils.isEmpty(getLastname())){
			addFieldError("lastname","Last Name cannot be blank");
		}
		if(StringUtils.isEmpty(getStudentid())){
			addFieldError("studentid","Student ID cannot be blank");
		}
		if(StringUtils.isEmpty(getStreetaddress1())){
			addFieldError("streetaddress1","Street Address cannot be blank");
		}
		if(StringUtils.isEmpty(getCity())){
			addFieldError("city","City cannot be blank");
		}
		if(StringUtils.isEmpty(getState())){
			addFieldError("state","State cannot be blank");
		}
		if(StringUtils.isEmpty(getZipcode())){
			addFieldError("zipcode","Zip Code cannot be blank");
		}
		if(StringUtils.isEmpty(getPhone())){
			addFieldError("phone","Phone cannot be blank");
		}
		if(StringUtils.isEmpty(getEmail())){
			addFieldError("email","Email cannot be blank");
		}

	}
	
	private int calculateMax(String[] stringNumbers){
		int number;
		Double double_number;
		int maximum = Integer.parseInt(stringNumbers[0]);
		int totalNum = stringNumbers.length;

		for(int i=0; i< totalNum; i++)
		{
			number = Integer.parseInt(stringNumbers[i]);
			double_number=Double.valueOf(stringNumbers[i]);

			if(number < 1 || number > 100 || Double.isNaN(double_number) ) 
			{     
				addFieldError("rafflebox","Only integers between 1 and 100");

				return -1;
			}
			if(number > maximum) maximum=number;

		}
		return maximum;		
	}
	
	// For SessionAware
	  Map<String, Object> session;
	  @Override
	  public void setSession(Map<String, Object> session) {
	    this.session = session;
	  }	
	
/*

	@Override
	public Object getModel() {
		System.out.println("in getModel ProcessSurveyFormDataAction");
		student = getStudent();
		System.out.println(student.getFirstname());
		return student;
	}
*/
}

