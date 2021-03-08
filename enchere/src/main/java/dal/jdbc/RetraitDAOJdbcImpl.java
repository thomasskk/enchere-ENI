package dal.jdbc;

import java.util.List;
import bo.Retrait;
import dal.dao.RetraitDAO;

public class RetraitDAOJdbcImpl implements RetraitDAO {

	public static Retrait getUserByID(int id) {
		return jdbi.withExtension(DAO.class, DAO -> DAO.selectById(id));
	}

	public static List<Retrait> selectAll() {
		return jdbi.withExtension(DAO.class, DAO -> DAO.selectAll());
	}

	public static void insert(Retrait retrait) {
		jdbi.useExtension(DAO.class, DAO -> DAO.insert(retrait));
	}

	public static void update(Retrait retrait) {
		jdbi.useExtension(DAO.class, DAO -> DAO.update(retrait));
	}

	public static void delete(int id) {
		jdbi.useExtension(DAO.class, DAO -> DAO.delete(id));
	}
}