package datasource;

import java.net.URISyntaxException;
import java.sql.Connection;
import java.sql.SQLException;

import databaseconnection.DatabaseAccess;

/*
 * this class implements get and remove connection from database for all children class (xxx-mapper)
 */
public class Mapper {
	public Connection getConneciton() {
		try {
			return DatabaseAccess.getconn();
		}catch( URISyntaxException | SQLException error) {
			return null;
		}
	}
	
	public void closeConnection(Connection connection) {
		DatabaseAccess.close(connection);
	}
}
