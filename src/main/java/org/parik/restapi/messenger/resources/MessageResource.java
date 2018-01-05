package org.parik.restapi.messenger.resources;

import java.util.List;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;

import org.parik.restapi.messenger.model.Message;
import org.parik.restapi.messenger.services.MessageService;

@Path("/messages")
public class MessageResource {
	
	MessageService messageService = new MessageService();
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public List<Message> getMessages(){
		
		
		return messageService.getMessages();
		
	}
	
	
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public List<Message> addMessage(List<Message> msg) {
		
		return messageService.addMessage(msg);
		
	}
	
	@PUT
	@Path("/{messageId}")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public List<Message> updateMessage(Message msg, @PathParam("messageId") int msgId) {
		
		return messageService.updateMessage(msg, msgId);
		
	}	
	
	@DELETE
	@Path("/{messageId}")
	@Produces(MediaType.APPLICATION_JSON)
	public List<Message>  deleteMessage( @PathParam("messageId") int msgId) {
		
		return messageService.deleteMessage(msgId);
		
		
	}
	

}
