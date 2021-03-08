package Servlet;

import java.io.IOException;
import com.fasterxml.jackson.databind.ObjectMapper;
import bo.Utilisateur;
import dal.jdbc.UtilisateurDAOJdbcImpl;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.Context;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import jakarta.ws.rs.core.Response.Status;

@Path("user")

public class UserManagment {

	
	@Path("/remove")
	@Consumes(MediaType.APPLICATION_JSON)
	@POST
	public void removeUser(int data, @Context HttpServletRequest req) throws IOException {
		
		System.out.println(data);
		HttpSession session = req.getSession(false);
		session.invalidate();
		UtilisateurDAOJdbcImpl.delete(data);
	}
	
	@Path("/udpate")
	@Consumes(MediaType.APPLICATION_JSON)
	@POST
	public void updateUser(Utilisateur user) throws IOException {
		
		UtilisateurDAOJdbcImpl.update(user);
		
	}
	
	@Path("/info")
	@Produces(MediaType.APPLICATION_JSON)
	@GET
	public Response getInfo(@Context HttpServletRequest req) throws IOException {
		
		HttpSession session = req.getSession(false);
		Utilisateur user = (Utilisateur) session.getAttribute("user");
		String userJson = new ObjectMapper().writeValueAsString(user);
		
		return Response.status(Status.OK).entity(userJson.toString()).build();
	}
	
	
	

	


}
