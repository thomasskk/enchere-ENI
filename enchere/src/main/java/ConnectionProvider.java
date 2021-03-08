
import java.sql.SQLException;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;
import org.jdbi.v3.core.Jdbi;
import org.jdbi.v3.jackson2.Jackson2Plugin;
import org.jdbi.v3.sqlobject.SqlObjectPlugin;


public abstract class ConnectionProvider {
	private static DataSource ds;

	static {
		try {
			Context context = new InitialContext();
			ds = (DataSource) context.lookup("java:comp/env/jdbc/pool_cnx");
		}catch (NamingException ex) {
			ex.printStackTrace();		
			throw new RuntimeException("Database access impossible");
		}
	}

	public static Jdbi getConnection() throws SQLException{
		return Jdbi.create(ds).installPlugin(new SqlObjectPlugin());
	}
}
