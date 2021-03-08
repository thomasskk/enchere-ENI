package dal.dao;

import java.util.List;
import org.jdbi.v3.core.Jdbi;
import org.jdbi.v3.sqlobject.config.RegisterBeanMapper;
import org.jdbi.v3.sqlobject.customizer.BindBean;
import org.jdbi.v3.sqlobject.statement.SqlQuery;
import org.jdbi.v3.sqlobject.statement.SqlUpdate;
import bo.Encheres;
import dal.ConnectDb;

public interface EncheresDAO {

	Jdbi jdbi = ConnectDb.getConnection();

	@RegisterBeanMapper(Encheres.class)
	public interface DAO {

		@SqlQuery("select * "
				+ "from ENCHERES "
				+ "where no_enchere = ?")
		Encheres selectById(int id);

		@SqlQuery("select * "
				+ "from ENCHERES")
		@RegisterBeanMapper(Encheres.class)
		List<Encheres> selectAll();

		@SqlUpdate("insert into ENCHERES "
				+ "values (:no_enchere, :date_enchere, :montant_enchere, :no_article, :no_utilisateur)")
		void insert(@BindBean Encheres enchere);

		@SqlUpdate("update ENCHERES "
				+ "set values(no_enchere =:no_enchere,date_enchere =:date_enchere,  "
				+ "montant_enchere =:montant_enchere, no_article =:no_article, no_utilisateur =:no_utilisateur) "
				+ "where no_enchere =:no_enchere")
		void update(@BindBean Encheres enchere);

		@SqlUpdate("delete from ENCHERES "
				+ "where no_enchere = ?")
		void delete(int id);
	}
}