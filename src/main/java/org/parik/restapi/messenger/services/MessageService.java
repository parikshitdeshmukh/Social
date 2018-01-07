package org.parik.restapi.messenger.services;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collection;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

import org.parik.restapi.messenger.database.Dao;
import org.parik.restapi.messenger.exception.DataNotFoundException;
import org.parik.restapi.messenger.exception.FieldEmptyException;
import org.parik.restapi.messenger.model.Comment;
import org.parik.restapi.messenger.model.ErrorMessage;
import org.parik.restapi.messenger.model.Message;
import org.parik.restapi.messenger.model.Profile;

public class MessageService {
	
	
	
	private CommentService comServ = new CommentService();
	
	private Map<Integer, Message> messages = (Map<Integer, Message>) Dao.getMessages();
	private Map<Integer, Comment> comments = (Map<Integer, Comment>) Dao.getComments();

	
	public MessageService() {
			
		comments.put(1, new Comment(1, "Nice post for you!", "Alex"));
		
		messages.put(1,  new Message(1,"Hello One", "Parik",comments));
		messages.put(4,  new Message(4,"Hello Parik", "Parik", null));

		messages.put(2,  new Message(2,"Hello Two", "Ram", null));
		messages.put(3,  new Message(3,"Hello Three", "Raj", null));
		
		
		
	}
	
	
	public List<Message> getMessages(){
		
		return new ArrayList<Message>(messages.values());
	}
	
	public Message getMessageById(int id) {
		
		if(messages.get(id) == null) {
			
			throw new DataNotFoundException("Sorry! But this message id " + id + " does not exist in our database!");
		}
		
		return messages.get(id);
	}
	
	//This method is for adding more than one message at a time and returns total available messages
	//**** Also We have used here JAX_RS provided Web Application Exception class
	public List<Message> addMessage(List<Message> msg) {
		
		ErrorMessage err = new ErrorMessage("No Author", 402, "google.com");
		Response response = Response.status(Status.NOT_ACCEPTABLE).entity(err).build();
		
		for(Message m:msg) {
			
			if(m.getAuthor()==null){
				
				throw new WebApplicationException(response);
			}
			m.setId(messages.size() + 1);
			m.setCreated(new Date());
			messages.put(m.getId(), m);

		}

		return new ArrayList<Message>(messages.values());
	}
	
	// This method is for adding only one message and returns same message with msg Id and all of it's properties
	public Message addMessage(Message msg) {
		
		if(msg.getAuthor()== null) {
			
			throw new FieldEmptyException("Sorry but We don't permit Anonymous posts. Please enter Author Name!");
		}
		msg.setCreated(new Date());
		msg.setId(messages.size()+1);
		messages.put(msg.getId(), msg);
		return msg;
	
	}


	public List<Message> updateMessage(Message msg, int msgId) {
		// TODO Auto-generated method stub
			if(msg.getId() == msgId && msgId >=0) {
				messages.put(msg.getId(), msg);
				
			}
				
		return new ArrayList<Message>(messages.values());
	}


	public List<Message>  deleteMessage(int msgId) {
		// TODO Auto-generated method stub
		
		if(messages.remove(msgId) != null) {
		return new ArrayList<Message>(messages.values());
		
		}else {
			
			return null;
		}
	}


	public List<Message> getMessagesByYear(int year) {
		// TODO Auto-generated method stub
		
		List<Message> msgList = new ArrayList<>();
		Calendar cal = Calendar.getInstance();
		
		for(Message msg: messages.values()) {
			
			cal.setTime(msg.getCreated());
			if(cal.get(Calendar.YEAR) == year) {
				msgList.add(msg);
			}
			
		}
		if(msgList.isEmpty()) {
			return null;
		}else {
		return msgList;
		}
	}


	public List<Message> getPaginatedMessages(int start, int size) {
		// TODO Auto-generated method stub
		
		List<Message> msgList = new ArrayList<Message>(messages.values());
		
		return msgList.subList(start-1, (start + size)-1);
		
	}
	
	

	
	

}
