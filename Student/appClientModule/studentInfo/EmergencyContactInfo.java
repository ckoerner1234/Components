package studentInfo;

import java.io.Serializable;

import javax.persistence.*;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

import static javax.persistence.GenerationType.IDENTITY;


@XmlRootElement(name="EmergencyContactInfo")
@XmlType(name = "EmergencyContactInfo")
@Entity
public class EmergencyContactInfo implements Serializable {
	private String firstname;
	private String lastname;
	private String phone;
	private String email;
	private String studentid;
	@Id @GeneratedValue
	private int emergencycontactid;

	public EmergencyContactInfo() {

	}
	
	public EmergencyContactInfo(String firstname, String lastname, String phone, String email, String studentid){
		this.firstname = firstname;
		this.lastname = lastname;
		this.phone = phone;
		this.email = email;
		this.studentid = studentid;
	}

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

	public int getEmergencycontactid() {
		return emergencycontactid;
	}

	public void setEmergencycontactid(int emergencycontactid) {
		this.emergencycontactid = emergencycontactid;
	}


}
