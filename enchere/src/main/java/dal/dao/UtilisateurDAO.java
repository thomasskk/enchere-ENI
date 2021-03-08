package dal.dao;

import java.util.List;
import org.jdbi.v3.core.Jdbi;
import org.jdbi.v3.json.Json;
import org.jdbi.v3.sqlobject.config.RegisterBeanMapper;
import org.jdbi.v3.sqlobject.customizer.BindBean;
import org.jdbi.v3.sqlobject.statement.SqlQuery;
import org.jdbi.v3.sqlobject.statement.SqlUpdate;
import bo.Utilisateur;
import dal.ConnectDb;

public interface UtilisateurDAO {

	Jdbi jdbi = ConnectDb.getConnection();

	@RegisterBeanMapper(Utilisateur.class)
	public interface DAO {

		@SqlQuery("select * "
				+ "from UTILISATEURS "
				+ "where (pseudo = ? or email = ?) and mot_de_passe = ?")
		Utilisateur select(String pseudo, String email, String password);
		
		@SqlQuery("select * "
				+ "from UTILISATEURS "
				+ "where (pseudo = ? or email = ?)")
		Boolean check(String pseudo, String email);


		@SqlQuery("select * "
				+ "from UTILISATEURS "
				+ "where no_utilisateur = ?")
		Utilisateur selectById(int id);

		@SqlQuery("select * from UTILISATEURS")
		@RegisterBeanMapper(Utilisateur.class)
		List<Utilisateur> selectAll();

		@SqlUpdate("insert into UTILISATEURS "
				+ "values (:pseudo, :nom, :prenom, :email, :telephone, :rue, :code_postal, "
				+ ":ville, :mot_de_passe, :credit, " + ":administrateur)")
		void insert(@BindBean Utilisateur user);

		@SqlUpdate("update UTILISATEURS "
				+ "set pseudo = :pseudo, nom = :nom, prenom = :prenom, email = :email, "
				+ "telephone = :telephone, rue = :rue, code_postal = :code_postal, "
				+ "ville = :ville, mot_de_passe = :mot_de_passe, credit = :credit,administrateur = :administrateur "
				+ "where no_utilisateur = :no_utilisateur")
		void update(@BindBean Utilisateur user);

		@SqlUpdate("delete from UTILISATEURS "
				+ "where no_utilisateur = ?")
		void delete(int id);
	}
}