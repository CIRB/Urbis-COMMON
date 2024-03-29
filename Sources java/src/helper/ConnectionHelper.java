package helper;
import java.sql.Connection;
import java.sql.SQLException;

import javax.naming.Context;
import javax.naming.InitialContext;

import org.apache.log4j.Logger;
import javax.sql.DataSource;

public class ConnectionHelper
{
	private static Logger logger = Logger.getLogger(ConnectionHelper.class.getName());
	private DataSource ds;
	private static ConnectionHelper instance;

	private ConnectionHelper()
	{
		try {
			//r�cup�ration de la source de donn�e
			Context initCtx = new InitialContext();
			ds = (DataSource) initCtx.lookup("java:comp/env/jdbc/database");
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