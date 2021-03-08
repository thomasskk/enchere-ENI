package dal.dao;

import org.jdbi.v3.core.Jdbi;
import org.jdbi.v3.sqlobject.config.RegisterBeanMapper;
import org.jdbi.v3.sqlobject.customizer.BindBean;
import org.jdbi.v3.sqlobject.statement.SqlQuery;
import org.jdbi.v3.sqlobject.statement.SqlUpdate;
import bo.Article;
import dal.ConnectDb;

public interface ArticleDAO {

	Jdbi jdbi = ConnectDb.getConnection();

	@RegisterBeanMapper(Article.class)
	public interface DAO {

		@SqlQuery("select * "
				+ "from ARTICLES_VENDUS "
				+ "where no_article = ?")
		Article selectById(int id);

		@SqlQuery("select * "
				+ "from ARTICLES_VENDUS")
		@RegisterBeanMapper(Article.class)
		List<Article> selectAll();

		@SqlUpdate("insert into ARTICLES_VENDUS "
				+ "values (:nom_article, :description, :date_debut_encheres, "
				+ ":date_fin_encheres, :prix_initial, :prix_vente, " + ":no_utilisateur, :no_categorie)")
		void insert(@BindBean Article article);

		@SqlUpdate("update ARTICLES_VENDUS "
				+ "set values (no_article =:nom_article, description =:description, "
				+ "date_debut_encheres =:date_debut_encheres, date_fin_encheres =:date_fin_encheres,"
				+ "prix_initial =:prix_initial, prix_vente =:prix_vente,no_utilisateur =:no_utilisateur, "
				+ "no_categorie =:no_categorie "
				+ "where no_article =:no_article)")
		void update(@BindBean Article article);

		@SqlUpdate("delete from ARTICLES_VENDUS where no_article = ?")
		void delete(int id);
	}
}