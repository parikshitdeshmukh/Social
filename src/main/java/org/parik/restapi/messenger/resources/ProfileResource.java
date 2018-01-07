package org.parik.restapi.messenger.resources;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.ws.rs.*;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.UriInfo;

import org.parik.restapi.messenger.model.Profile;
import org.parik.restapi.messenger.services.ProfileService;

@Path("/profiles")
public class ProfileResource {
	
	ProfileService profileService = new ProfileService();
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public List<Profile> getProfiles(@Context UriInfo uriInfo){
		
		Map<Profile, ArrayList<Integer>> profileMsgIds=profileService.getProfiles();
		
		for(Profile p:profileMsgIds.keySet()) {
			
			if(profileMsgIds.get(p)!=null) {
			
				for(int i=0; i< profileMsgIds.get(p).size(); i++) {
					
					String link = uriInfo.getBaseUriBuilder()
										.path(MessageResource.class)
										.path(String.valueOf(profileMsgIds.get(p).get(i)))
										.build()
										.toString();
	
					p.addLink(link, "Messages Posted by "+ p.getFirstName());
				
				}
			}else {
				
				p.addLink(null, "No messages posted by "+ p.getFirstName() + " till the date");

				
			}
			
		}
		
		
		return new ArrayList<Profile>(profileMsgIds.keySet());
		
	}
	
/*	@GET
	@Path("/{profileId}")
	@Produces(MediaType.APPLICATION_JSON)
	public Profile getProfileById( @PathParam("profileId") int profileId) {
		return profileService.getProfileById(profileId);
				
		
	}*/
	
	@GET
	@Path("/{profileName}")
	@Produces(MediaType.APPLICATION_JSON)
	public Profile getProfileByProfileName( @PathParam("profileName") String profileName, @Context UriInfo uriInfo) {
		
		Profile prof = profileService.getProfileByProfileName(profileName);
		
		
		return prof;
				
		
	}
	
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public List<Profile> addProfiles(List<Profile> profiles){
		
		return profileService.addProfiles(profiles);
	}

	@PUT
	@Path("/{profileName}")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public List<Profile> updateProfiles(Profile profiles, @PathParam("profileName") String profileName){
		
		return profileService.updateProfiles(profiles, profileName);
	}
	
	
	@DELETE
	@Path("/{profileName}")
	@Produces(MediaType.APPLICATION_JSON)
	public List<Profile> deleteProfiles(@PathParam("profileName") String profileName){
		
		return profileService.deleteProfiles(profileName);
	}
	

}
