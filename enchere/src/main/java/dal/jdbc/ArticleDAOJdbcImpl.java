package dal.jdbc;

import java.util.List;
import bo.Article;
import dal.dao.ArticleDAO;

public class ArticleDAOJdbcImpl implements ArticleDAO {

	public static Article getUserByID(int id) {
		return jdbi.withExtension(DAO.class, DAO -> DAO.selectById(id));
	}

	public static List<Article> selectAll() {
		return jdbi.withExtension(DAO.class, DAO -> DAO.selectAll());
	}

	public static void insert(Article article) {
		jdbi.useExtension(DAO.class, DAO -> DAO.insert(article));
	}

	public static void update(Article article) {
		jdbi.useExtension(DAO.class, DAO -> DAO.update(article));
	}

	public static void delete(int id) {
		jdbi.useExtension(DAO.class, DAO -> DAO.delete(id));
	}
}