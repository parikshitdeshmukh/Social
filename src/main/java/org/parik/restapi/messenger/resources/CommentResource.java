package org.parik.restapi.messenger.resources;

import java.util.List;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;

import org.parik.restapi.messenger.model.Comment;
import org.parik.restapi.messenger.services.CommentService;

@Path("/")
public class CommentResource {
	

	CommentService commentService = new CommentService();
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public List<Comment> getCommentsForMessage(@BeanParam FilterBean bean) {
		
		return commentService.getCommentsForMessage(bean.getMsgId());
	}
	
	@POST
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public List<Comment> addCommentForMessage(@BeanParam FilterBean bean, Comment cmt) {
		
		return commentService.addCommentForMessage(bean.getMsgId(), cmt);
	}
	
	@GET
	@Produces(MediaType.TEXT_PLAIN)
	@Path("/{commentId}")
	public String getCommentById(@BeanParam FilterBean bean) {
		
		return Integer.toString(bean.getCmtId()) +" "+ Integer.toString(bean.getMsgId());
	}
	

}
