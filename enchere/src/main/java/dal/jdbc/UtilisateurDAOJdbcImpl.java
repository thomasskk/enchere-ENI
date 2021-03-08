package dal.jdbc;

import java.util.List;
import bo.Utilisateur;
import dal.dao.UtilisateurDAO;

public class UtilisateurDAOJdbcImpl implements UtilisateurDAO {
	
	public static Boolean check(String pseudo, String email) {
		return jdbi.withExtension(DAO.class, DAO -> DAO.check(pseudo, email));
	}

	public static Utilisateur getUser(String pseudo, String email, String password) {
		return jdbi.withExtension(DAO.class, DAO -> DAO.select(pseudo, email, password));
	}

	public static Utilisateur getUserByID(int id) {
		return jdbi.withExtension(DAO.class, DAO -> DAO.selectById(id));
	}

	public static List<Utilisateur> selectAll() {
		return jdbi.withExtension(DAO.class, DAO -> DAO.selectAll());
	}

	public static void insert(Utilisateur user) {
		jdbi.useExtension(DAO.class, DAO -> DAO.insert(user));
	}

	public static void update(Utilisateur user) {
		jdbi.useExtension(DAO.class, DAO -> DAO.update(user));
	}

	public static void delete(int id) {
		jdbi.useExtension(DAO.class, DAO -> DAO.delete(id));
	}
}