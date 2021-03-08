package dal.dao;

import java.util.List;
import org.jdbi.v3.core.Jdbi;
import org.jdbi.v3.sqlobject.config.RegisterBeanMapper;
import org.jdbi.v3.sqlobject.customizer.BindBean;
import org.jdbi.v3.sqlobject.statement.SqlQuery;
import org.jdbi.v3.sqlobject.statement.SqlUpdate;
import bo.Retrait;
import dal.ConnectDb;

public interface RetraitDAO {

	Jdbi jdbi = ConnectDb.getConnection();

	@RegisterBeanMapper(Retrait.class)
	public interface DAO {

		@SqlQuery("select * "
				+ "from RETRAITS "
				+ "where no_article = ?")
		Retrait selectById(int id);

		@SqlQuery("select * "
				+ "from RETRAITS")
		@RegisterBeanMapper(Retrait.class)
		List<Retrait> selectAll();

		@SqlUpdate("insert into RETRAITS "
				+ "values (:no_article, :rue, :code_postal, :ville)")
		void insert(@BindBean Retrait retrait);

		@SqlUpdate("update RETRAITS "
				+ "set values(no_article =:no_article, rue =:rue, "
				+ "code_postal =:code_postal, ville =:ville) "
				+ "where no_enchere =:no_enchere")
		void update(@BindBean Retrait retrait);

		@SqlUpdate("delete from RETRAITS "
				+ "where no_article = ?")
		void delete(int id);
	}
}