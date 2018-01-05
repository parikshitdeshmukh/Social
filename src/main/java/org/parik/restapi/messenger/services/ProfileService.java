package org.parik.restapi.messenger.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.parik.restapi.messenger.database.Dao;
import org.parik.restapi.messenger.model.Profile;

public class ProfileService {
	
	
	
	
	private Map<Integer, Profile> profiles = Dao.getProfiles();
	
	public ProfileService() {
		
		profiles.put(1, new Profile("Parik","Parikshit", "Deshmukh", 25));
		profiles.put(2, new Profile("Raj", "Raj", "Sharma", 23));
		profiles.put(3, new Profile("Ram", "Ram", "Verma", 26));	
		
	}
	
	
	public List<Profile> getProfiles(){
		
		return new ArrayList<Profile>(profiles.values());
	}
	
	public Profile getProfileById(Integer profileId) {
		
		return profiles.get(profileId);
		
	}
	
	public Profile getProfileByProfileName( String profileName) {
		
		
		for( Profile p: profiles.values()) {
			
			if(p.getprofileName().equals(profileName)) {
				return p;
			}
			
		}
		return null;
				
	}
	
	

}
