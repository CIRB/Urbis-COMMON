package helper;
import java.sql.Connection;
import java.sql.SQLException;

import javax.naming.Context;
import javax.naming.InitialContext;

import org.apache.log4j.Logger;
import org.apache.tomcat.dbcp.dbcp.BasicDataSource;

public class ConnectionHelper
{
	private static Logger logger = Logger.getLogger(ConnectionHelper.class.getName());
	private BasicDataSource ds;
	private static ConnectionHelper instance;

	private ConnectionHelper()
	{
		try {
			//récupération de la source de donnée
			Context initCtx = new InitialContext();
			ds = (BasicDataSource) initCtx.lookup("java:comp/env/jdbc/AASDB");
		} catch (Exception e) {
			logger.error(e);
		}
	}

	public static Connection getConnection() throws SQLException {
		if (instance == null) {
			instance = new ConnectionHelper();
		}
		try {
			return instance.ds.getConnection();
		} catch (SQLException e) {
			logger.error(e);
			throw e;
		}
	}
	
	public static void close(Connection connection)
	{
		try {
			if (connection != null) {
				connection.close();
			}
		} catch (SQLException e) {
			logger.error(e);
		}
	}

}