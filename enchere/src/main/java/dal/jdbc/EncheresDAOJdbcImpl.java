package dal.jdbc;

import java.util.List;
import bo.Encheres;
import dal.dao.EncheresDAO;

public class EncheresDAOJdbcImpl implements EncheresDAO {

	public static Encheres getUserByID(int id) {
		return jdbi.withExtension(DAO.class, DAO -> DAO.selectById(id));
	}

	public static List<Encheres> selectAll() {
		return jdbi.withExtension(DAO.class, DAO -> DAO.selectAll());
	}

	public static void insert(Encheres encheres) {
		jdbi.useExtension(DAO.class, DAO -> DAO.insert(encheres));
	}

	public static void update(Encheres encheres) {
		jdbi.useExtension(DAO.class, DAO -> DAO.update(encheres));
	}

	public static void delete(int id) {
		jdbi.useExtension(DAO.class, DAO -> DAO.delete(id));
	}
}