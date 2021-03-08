package Servlet;

import java.io.IOException;
import com.fasterxml.jackson.databind.ObjectMapper;
import bo.Utilisateur;
import dal.jdbc.UtilisateurDAOJdbcImpl;
import jakarta.json.JsonObject;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.Context;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import jakarta.ws.rs.core.Response.Status;

@Path("login")
public class LoginResgister {

	static void SessionCreation(HttpServletRequest req, Utilisateur user) {
		HttpSession session = req.getSession();
		session.setMaxInactiveInterval(5 * 60);
		session.setAttribute("user", user);
	}

	@POST
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public Response loginRequest(JsonObject data, @Context HttpServletRequest req) throws IOException {

		Utilisateur user = UtilisateurDAOJdbcImpl.getUser(data.getString("username"), "", data.getString("password"));
		if (user != null) {
			SessionCreation(req, user);
			String userJson = new ObjectMapper().writeValueAsString(user);
			
			return Response.status(Status.OK).entity(data.toString()).build();
		} else {
			return Response.status(Status.EXPECTATION_FAILED).build();
		}
	}

	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/register")
	public Response registerRequest(Utilisateur data, @Context HttpServletRequest req) throws IOException {
		if (UtilisateurDAOJdbcImpl.check(data.pseudo, data.email) == null) {
			UtilisateurDAOJdbcImpl.insert(data);
			Utilisateur user = UtilisateurDAOJdbcImpl.getUser(data.pseudo, data.email, data.mot_de_passe);
			String userJson = new ObjectMapper().writeValueAsString(user);
			SessionCreation(req, data);

			return Response.status(Status.OK).entity(userJson.toString()).build();
		} else {
			return Response.status(Status.EXPECTATION_FAILED).build();
		}
	}
}
