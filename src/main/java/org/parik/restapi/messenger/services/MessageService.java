package org.parik.restapi.messenger.services;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

import org.parik.restapi.messenger.database.Dao;
import org.parik.restapi.messenger.model.Message;
import org.parik.restapi.messenger.model.Profile;

public class MessageService {
	
	
	
	
	private Map<Integer, Message> messages = (Map<Integer, Message>) Dao.getMessages();
	
	public MessageService() {
	
		messages.put(1,  new Message(1,"Hello One", "Parik"));
		messages.put(2,  new Message(2,"Hello Two", "Ram"));
		messages.put(3,  new Message(3,"Hello Three", "Sham"));
		
	}
	
	
	public List<Message> getMessages(){
		
		return new ArrayList<Message>(messages.values());
	}
	
	public List<Message> addMessage(List<Message> msg) {
		
		for(Message m:msg) {
			
			m.setId(messages.size() + 1);
			m.setCreated(new Date());
			messages.put(m.getId(), m);

		}

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
	
	

	
	

}
