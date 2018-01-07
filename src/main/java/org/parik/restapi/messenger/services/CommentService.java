package org.parik.restapi.messenger.services;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.parik.restapi.messenger.database.Dao;
import org.parik.restapi.messenger.model.Comment;
import org.parik.restapi.messenger.model.Message;

public class CommentService {
	
	private Map<Integer, Comment> comments =  (Map<Integer, Comment>) Dao.getComments();
	private Map<Integer, Message> messages = (Map<Integer, Message>) Dao.getMessages();

	
	public CommentService() {
		
		comments.put(1, new Comment(1, "Nice post for you!", "Alex"));
		
		messages.put(1,  new Message(1,"Hello One", "Parik",comments));
		messages.put(2,  new Message(2,"Hello Two", "Ram", Collections.EMPTY_MAP));
		messages.put(3,  new Message(3,"Hello Three", "Sham", null));
		
	}
	

	public List<Comment> getCommentsForMessage(int msgId) {
		// TODO Auto-generated method stub
		
		
		Message msg = messages.get(msgId);
		comments= msg.getComments();
		if(comments.isEmpty()) {
			return null;
		}else {
		return new ArrayList<Comment>(comments.values());
		}
	}


	public List<Comment> addCommentForMessage(int msgId, Comment cmt) {
		// TODO Auto-generated method stub
		
		Message msg = messages.get(msgId);
		comments.putAll(msg.getComments());
		cmt.setId(comments.size()+1);
		cmt.setCreated(new Date());
		comments.put(comments.size()+1, cmt);
		msg.setComments(comments);
		messages.put(msg.getId(), msg);
			
		return new ArrayList<Comment>(msg.getComments().values());

	}

}
