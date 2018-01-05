package org.parik.restapi.messenger.resources;

import java.util.List;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;

import org.parik.restapi.messenger.model.Profile;
import org.parik.restapi.messenger.services.ProfileService;

@Path("/profiles")
public class ProfileResource {
	
	ProfileService profileService = new ProfileService();
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public List<Profile> getProfiles(){
		
		
		return profileService.getProfiles();
		
	}
	
	@GET
	@Path("/{profileId}")
	@Produces(MediaType.APPLICATION_JSON)
	public Profile getProfileById( @PathParam("profileId") int profileId) {
		return profileService.getProfileById(profileId);
				
		
	}
	
/*	@GET
	@Path("/{profileName}")
	@Produces(MediaType.APPLICATION_XML)
	public Profile getProfileByProfileName( @PathParam("profileName") String profileName) {
		return profileService.getProfileByProfileName(profileName);
				
		
	}*/
	
	
	
	

}
