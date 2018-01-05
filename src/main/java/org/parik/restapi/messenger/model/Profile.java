package org.parik.restapi.messenger.model;

import java.util.Date;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Profile {

	private String profileName;
	private String firstName;
	private String lastName;
	private int age;
	private Date created;
	
	
	public Profile() {
		
	}
	
	public Profile(String profileName, String firstName, String lastName, int age) {
		this.profileName = profileName;
		this.firstName= firstName;
		this.lastName = lastName;
		this.age = age;
		this.created = new Date();
	}
	


	public String getprofileName() {
		return profileName;
	}
	public void setprofileName(String profileName) {
		this.profileName = profileName;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public Date getCreated() {
		return created;
	}
	public void setCreated(Date created) {
		this.created = created;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	
	
}
