package dal;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;
import org.jdbi.v3.core.Jdbi;
import org.jdbi.v3.gson2.Gson2Config;
import org.jdbi.v3.gson2.Gson2Plugin;
import org.jdbi.v3.sqlobject.SqlObjectPlugin;
import lombok.SneakyThrows;

public class ConnectDb {
	
	@SneakyThrows
	public static Jdbi getConnection() {
		Context context = new InitialContext();
		DataSource ds = (DataSource) context.lookup("java:comp/env/jdbc/pool_cnx");
		return Jdbi.create(ds).installPlugin(new SqlObjectPlugin());
	}
}
