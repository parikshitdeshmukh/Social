package org.parik.restapi.messenger.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Profile {

	private int id;
	private String profileName;
	private String firstName;
	private String lastName;
	private int age;
	private Date created;
	private List<Link> links = new ArrayList<>();
	
	
	public Profile() {
		
	}
	
	public Profile(int id, String profileName, String firstName, String lastName, int age) {
		this.id = id;
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

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public List<Link> getLinks() {
		return links;
	}

	public void setLinks(List<Link> links) {
		this.links = links;
	}
	
	public void addLink(String link, String ref) {
		Link l = new Link();
		l.setLink(link);
		l.setRef(ref);
		links.add(l);
		
	}
	
	
}
