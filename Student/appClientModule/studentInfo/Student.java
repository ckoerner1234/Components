package studentInfo;
import studentInfo.EmergencyContactInfo;

import java.io.Serializable;
import java.util.Collection;

import javax.persistence.*;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

@XmlRootElement(name="Student")
@XmlType(name = "Student")
@Entity
public class Student implements Serializable {
	
	String firstname;
	String lastname;
	@Id
	String studentid;
	String streetaddress1;
	String streetaddress2;
	String city;
	String state;
	String zipcode;
	String phone;
	String email;
	String url;
	
	@OneToMany(cascade={CascadeType.ALL}, fetch=FetchType.EAGER)
	@JoinColumn(name="studentid")
	private Collection<EmergencyContactInfo> ecis;
	public Collection<EmergencyContactInfo> getEcis(){
		return ecis;
	}
	public void setEcis(Collection<EmergencyContactInfo> ecis){
		this.ecis = ecis;
	}
	
	public Student() {
		
	}

	public Student(String firstname, String lastname, String studentid, String address1,
			String address2, String city, String state, String zipcode, String phone, String email,
			String url, Collection<EmergencyContactInfo> ecis) {
		this.firstname = firstname;
		this.lastname = lastname;
		this.studentid = studentid;
		this.streetaddress1 = address1;
		this.streetaddress2 = address2;
		this.city = city;
		this.state = state;
		this.zipcode = zipcode;
		this.phone = phone;
		this.email = email;
		this.url = url;
		this.ecis = ecis;
	}

	@XmlElement(name = "firstname")
	public String getFirstname(){
		return firstname;
	}

	public void setFirstname(String x){
		this.firstname = x;
	}

	@XmlElement(name = "lastname")
	public String getLastname(){
		return lastname;
	}

	public void setLastname(String x){
		this.lastname = x;
	}

	@XmlElement(name = "studentid")
	public String getStudentid(){
		return studentid;
	}

	public void setStudentid(String x){
		this.studentid = x;
	}

	@XmlElement(name = "streetaddress1")
    public String getStreetaddress1(){
    	return streetaddress1;
    }
    
    public void setStreetaddress1(String x){
    	this.streetaddress1 = x;
    }
    
    public String getStreetAddress2(){
    	return streetaddress2;
    }
    
    public void setStreetaddress2(String x){
    	this.streetaddress2 = x;
    }
    
	@XmlElement(name = "city")
    public String getCity(){
    	return city;
    }
    
    public void setCity(String x){
    	this.city = x;
    }
    
	@XmlElement(name = "state")
    public String getState(){
    	return state;
    }
    
    public void setState(String x){
    	this.state = x;
    }
    
    public String getZipcode(){
    	return zipcode;
    }
    
    public void setZipcode(String x){
    	this.zipcode = x;
    }
    
    public String getEmail(){
    	return email;
    }
    
    public void setEmail(String x){
    	this.email = x;
    }
    
    public String getUrl(){
    	return url;
    }
    
    public void setUrl(String x){
    	this.url = x;
    }
    
    public String getPhone(){
    	return phone;
    }
    
    public void setPhone(String x){
    	this.phone = x;
    }
    
    public void printHello(){
    	System.out.println("Hello from Student");
    }
    

	
}
