package org.parik.restapi.messenger.database;

import java.util.HashMap;
import java.util.Map;

import org.parik.restapi.messenger.model.Comment;
import org.parik.restapi.messenger.model.Message;
import org.parik.restapi.messenger.model.Profile;

public class Dao {
	
	private static Map<String, Profile> profiles = new HashMap<>();
	private static Map<Integer, Message> messages = new HashMap<>();
	private static Map<Integer, Comment> comments = new HashMap<>();
	

	public static Map<String, Profile> getProfiles() {
		return profiles;
	}

	public static Map<Integer, Message> getMessages() {
		return messages;
	}

	public static Map<Integer, Comment> getComments() {
		return comments;
	}

	
	

}
