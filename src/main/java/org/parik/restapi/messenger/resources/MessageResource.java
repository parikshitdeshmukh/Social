package org.parik.restapi.messenger.resources;

import java.awt.TrayIcon.MessageType;
import java.net.URI;
import java.util.List;

import javax.ws.rs.*;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;
import javax.ws.rs.core.UriInfo;

import org.parik.restapi.messenger.model.Message;
import org.parik.restapi.messenger.services.MessageService;

@Path("/messages")
public class MessageResource {
	
	MessageService messageService = new MessageService();
	
/*	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public List<Message> getMessages(){
		
		
		return messageService.getMessages();
		
	}*/
	
	// Filter by year
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public List<Message> getMessagesByParams(@BeanParam FilterBean bean){
		
		if(bean.getYear()>0) {
			
			return messageService.getMessagesByYear(bean.getYear());
		}
		if(bean.getStart() > 0 && bean.getSize() > 0) {
			return messageService.getPaginatedMessages(bean.getStart(), bean.getSize());
		}

		return messageService.getMessages();
	}
	
	
	/// Get message by ID
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/{messageId}")
	public Message getMessageById(@BeanParam FilterBean bean, @Context UriInfo uriInfo) {
		
		Message msg = messageService.getMessageById(bean.getMsgId());
		
		String msgLink = getURIForMessage(uriInfo, msg);
							
		msg.addLink(msgLink, "Self");
		
		String profileLink = getURIForProfile(uriInfo, msg);
		
		msg.addLink(profileLink, "Author_Profile");
		
		String commentLink = getURIForComment(uriInfo, msg);																																																																																																																																																																																																																																																																																													
		msg.addLink(commentLink, "Comments");
				
		
		return msg;

	}

	private String getURIForComment(UriInfo uriInfo, Message msg) {
		
		String profileLink = uriInfo.getBaseUriBuilder()
				.path(MessageResource.class)
				.path(MessageResource																																																																																																																																																																																																																																																																																																																																																																																				.class, "getCommentResource")
				.path(CommentResource.class)
				.resolveTemplate("messageId", msg.getId())
				.build()
				.toString();
		return profileLink;
	}

	private String getURIForProfile(UriInfo uriInfo, Message msg) {
		String profileLink = uriInfo.getBaseUriBuilder()
				.path(ProfileResource.class)
				.path(msg.getAuthor()).build().toString();
		return profileLink;
	}


	private String getURIForMessage(UriInfo uriInfo, Message msg) {
		String msgLink = uriInfo.getBaseUriBuilder()
							.path(MessageResource.class)
							.path(String.valueOf(msg.getId())).build().toString();
		return msgLink;
	}

	
	
	///For sending proper Status Code 201 for adding or creating the message
/*	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Response addMessage(List<Message> msg) {
						
		return Response.status(Status.CREATED)
						.entity(messageService.addMessage(msg))
						.build();
		
	}*/
	
	
	///For Sending URI of the added Message in the Location header Plus Sending Status code Created 201 same time.
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Response addMessage(Message msg, @Context UriInfo uriInfo) {
		
		Message message = messageService.addMessage(msg);
		URI uri = uriInfo.getAbsolutePathBuilder().path(String.valueOf(msg.getId())).build();
						
		return Response.created(uri)
						.entity(message)
						.build();
		
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
	
	@Path("/{messageId}/comments")
	public CommentResource getCommentResource() {
		
		return new CommentResource();
	}
	
	
	

}
