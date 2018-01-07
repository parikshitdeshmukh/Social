package org.parik.restapi.messenger.services;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.parik.restapi.messenger.database.Dao;
import org.parik.restapi.messenger.model.Message;
import org.parik.restapi.messenger.model.Profile;

public class ProfileService {
	
	
	
	
	private Map<String, Profile> profiles = Dao.getProfiles();
	
	public ProfileService() {
		
		profiles.put("Parik", new Profile(1,"Parik","Parikshit", "Deshmukh", 25));
		profiles.put("Raj", new Profile(2,"Raj", "Raj", "Sharma", 23));
		profiles.put("Ram", new Profile(3, "Ram", "Ram", "Verma", 26));	
		
	}
	
	
	MessageService msgService = new MessageService();
	List<Message> msgList = msgService.getMessages();
	
	
	
	
	public Map<Profile, ArrayList<Integer>> getProfiles(){
		
		Map<Profile, ArrayList<Integer> > profileMsg = new HashMap<Profile, ArrayList<Integer>>();
		Map<String, ArrayList<Integer>> msgMap= new HashMap<String, ArrayList<Integer>>();
		
		for(int i=0; i<msgList.size(); i++) {
			
			if(!msgMap.containsKey(msgList.get(i).getAuthor())){
				
				List<Integer> msgL= new ArrayList<>();
				msgL.add(msgList.get(i).getId());
				msgMap.put(msgList.get(i).getAuthor(), (ArrayList<Integer>) msgL);
			}else{
				
				ArrayList<Integer> msgL = msgMap.get(msgList.get(i).getAuthor());
				msgL.add(msgList.get(i).getId());
				msgMap.put(msgList.get(i).getAuthor(), msgL);
				
			}
					
		}
		
		for(String key: profiles.keySet()) {
			
			if(msgMap.containsKey(key)) {
				
				profileMsg.put(profiles.get(key), msgMap.get(key));
				
			}else {
				
				profileMsg.put(profiles.get(key), null);

			}
			
			
		}
		
		
		return profileMsg;
	}
	
/*	public Profile getProfileById(Integer profileId) {
		
		return profiles.get(profileId);
		
	}*/
	
	public Profile getProfileByProfileName( String profileName) {
		
		
		for( Profile p: profiles.values()) {
			
			if(p.getprofileName().equalsIgnoreCase(profileName)) {
				return p;
			}
			
		}
		return null;
		
		//return profiles.get(profileName);
		
				
	}


	public List<Profile> addProfiles(List<Profile> profiles2) {
		// TODO Auto-generated method stub
		
		for(Profile prof:profiles2) {
			
			prof.setId(profiles.size()+1);
			prof.setCreated(new Date());
			profiles.put(prof.getprofileName(), prof);
			
		}
		return new ArrayList<Profile>(profiles.values());
	}


	public List<Profile> updateProfiles(Profile profile2, String profName) {
		// TODO Auto-generated method stub

		if(profile2.getCreated() == null) {
		profile2.setCreated(new Date());
		}
		if(!(profile2.getId() > 0 )) {
		profile2.setId(profiles.get(profName).getId());
		}
			
		profile2.setprofileName(profName);
		
					
		profiles.put(profName, profile2);
		return new ArrayList<Profile>(profiles.values());
	}


	public List<Profile> deleteProfiles(String profileName) {
		// TODO Auto-generated method stub
		if(profiles.get(profileName) != null) {
			
			profiles.remove(profileName);
			return new ArrayList<Profile>(profiles.values());
		}
		
		return null;
	}
	
	

}
