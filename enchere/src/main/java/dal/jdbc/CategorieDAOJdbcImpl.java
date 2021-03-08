package dal.jdbc;

import java.util.List;
import bo.Categorie;
import dal.dao.CategorieDAO;

public class CategorieDAOJdbcImpl implements CategorieDAO {

	public static Categorie getUserByID(int id) {
		return jdbi.withExtension(DAO.class, DAO -> DAO.selectById(id));
	}

	public static List<Categorie> selectAll() {
		return jdbi.withExtension(DAO.class, DAO -> DAO.selectAll());
	}

	public static void insert(Categorie categorie) {
		jdbi.useExtension(DAO.class, DAO -> DAO.insert(categorie));
	}

	public static void update(Categorie categorie) {
		jdbi.useExtension(DAO.class, DAO -> DAO.update(categorie));
	}

	public static void delete(int id) {
		jdbi.useExtension(DAO.class, DAO -> DAO.delete(id));
	}
}