package dal.dao;

import java.util.List;
import org.jdbi.v3.core.Jdbi;
import org.jdbi.v3.sqlobject.config.RegisterBeanMapper;
import org.jdbi.v3.sqlobject.customizer.BindBean;
import org.jdbi.v3.sqlobject.statement.SqlQuery;
import org.jdbi.v3.sqlobject.statement.SqlUpdate;
import bo.Categorie;
import dal.ConnectDb;

public interface CategorieDAO {

	Jdbi jdbi = ConnectDb.getConnection();

	@RegisterBeanMapper(Categorie.class)
	public interface DAO {

		@SqlQuery("select * "
				+ "from CATEGORIES "
				+ "where no_article = ?")
		Categorie selectById(int id);

		@SqlQuery("select * "
				+ "from CATEGORIES")
		@RegisterBeanMapper(Categorie.class)
		List<Categorie> selectAll();

		@SqlUpdate("insert into CATEGORIES "
				+ "values (:libelle)")
		void insert(@BindBean Categorie categorie);

		@SqlUpdate("update CATEGORIES "
				+ "set values(libelle =:libelle) "
				+ "where no_categorie =:no_categorie")
		void update(@BindBean Categorie categorie);

		@SqlUpdate("delete from CATEGORIES "
				+ "where no_categorie = ?")
		void delete(int id);
	}
}