package org.lee.messenger.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.ws.rs.NotFoundException;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

import org.lee.messenger.database.DatabaseClass;
import org.lee.messenger.model.Comment;
import org.lee.messenger.model.ErrorMessage;
import org.lee.messenger.model.Message;

public class CommentService {
	
	private Map<Long, Message> messages = DatabaseClass.getMessages();
	
	public List<Comment> getAllComments(long messageId) {
		Message message = messages.get(messageId);
		Map<Long, Comment> comments = message.getComments();
		return new ArrayList<Comment>(comments.values());
	}
	
	public Comment getComment(long messageId, long commentId) {
		ErrorMessage errorMsg = new ErrorMessage("Not found", 404, "http://");
		Response response = Response.status(Status.NOT_FOUND)
									.entity(errorMsg)
									.build();
		Message message = messages.get(messageId);
		if(message == null){
			throw new NotFoundException(response);
		}
		Map<Long, Comment> comments = message.getComments();
		if(comments == null || comments.isEmpty()){
			throw new NotFoundException(response);
		}
		return comments.get(commentId);
	}
	
	public Comment addComment(long messageId, Comment comment) {
		Map<Long, Comment> comments = messages.get(messageId).getComments();
		comment.setId(comments.size() + 1);
		comments.put(comment.getId(), comment);
		return comment;
	}
	
	public Comment updateComment(long messageId, Comment comment) {
		Map<Long, Comment> comments = messages.get(messageId).getComments();
		if (comment.getId() <= 0) {
			return null;
		}
		comments.put(comment.getId(), comment);
		return comment;
	}
	
	public Comment removeComment(long messageId, long commentId) {
		Map<Long, Comment> comments = messages.get(messageId).getComments();
		return comments.remove(commentId);
	}
		
}
