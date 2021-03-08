package Servlet;

import java.io.IOException;

import bo.Utilisateur;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.core.Context;
import jakarta.ws.rs.core.Response;
import jakarta.ws.rs.core.Response.Status;

@Path("session")
public class Session {

	@GET
	public Response isSessionOpen(@Context HttpServletRequest req) throws IOException {
		if (req.getSession(false).getId().equals(req.getRequestedSessionId())) {
			return Response.status(Status.OK).build();
		} else {
			System.out.println();
			return Response.status(Status.EXPECTATION_FAILED).build();
		}
	}
	
	@Path("/admin")
	@GET
	public Response isAdmin(@Context HttpServletRequest req) throws IOException {
		
		HttpSession session = req.getSession(false);
		Utilisateur user = (Utilisateur) session.getAttribute("user");
		if (user.administrateur == 1) {
			return Response.status(Status.OK).build();
		} else {
			return Response.status(Status.EXPECTATION_FAILED).build();
		}
 	}
	

}


