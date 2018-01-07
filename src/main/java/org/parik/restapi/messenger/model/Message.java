package org.parik.restapi.messenger.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

@XmlRootElement
public class Message {
	
	private int id;
	private String msg;
	private Date created;
	private String author;
	private List<Comment> cmtList = new ArrayList<>();
	private Map<Integer, Comment> comments;
	private List<Link> links = new ArrayList<Link>();

	
	public Message(int id, String msg,  String author, Map<Integer, Comment> comments) {
		this.id = id;
		this.msg = msg;
		this.created = new Date();
		this.author = author;
		this.comments = comments;
	}
	
	
	
	@XmlTransient
	public Map<Integer, Comment> getComments() {
		return comments;
	}

	public void setComments(Map<Integer, Comment> comments) {
		this.comments = comments;
	}

	public Message() {
		
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getMsg() {
		return msg;
	}
	public void setMsg(String msg) {
		this.msg = msg;
	}
	public Date getCreated() {
		return created;
	}
	public void setCreated(Date created) {
		this.created = created;
	}
	public String getAuthor() {
		return author;
	}
	public void setAuthor(String author) {
		this.author = author;
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



	public List<Comment> getCmtList() {
		return cmtList;
	}



	public void setCmtList(List<Comment> cmtList) {
		this.cmtList = cmtList;
	}
	
	

}
