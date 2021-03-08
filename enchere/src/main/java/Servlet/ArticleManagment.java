package Servlet;

import java.io.IOException;
import java.util.List;
import bo.Categorie;
import dal.jdbc.ArticleDAOJdbcImpl;
import dal.jdbc.CategorieDAOJdbcImpl;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import jakarta.ws.rs.core.Response.Status;
import bo.Article;

@Path("article")
public class ArticleManagment {

	    @Path("categorie")
		@GET
		@Produces(MediaType.APPLICATION_JSON)
		public Response categorieRequest() throws IOException {
	    	
			List<Categorie> categorie = CategorieDAOJdbcImpl.selectAll();	
			return Response.status(Status.OK).entity(categorie).build();
		}
	    
		@GET
		@Produces(MediaType.APPLICATION_JSON)
		public Response ArticleRequest() throws IOException {
			
			List<Article> article = ArticleDAOJdbcImpl.selectAll();
			return Response.status(Status.OK).entity(article).build();
		}
}