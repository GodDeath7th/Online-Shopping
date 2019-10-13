package databaseconnection;

import java.net.URISyntaxException;
import java.sql.*;

public class DatabaseAccess {

    private static String url = null;
    private static String localUrl = null;

    static{
            localUrl = "jdbc:postgresql://127.0.0.1:5432/postgres?user=postgres&password=696894";
        	url = "jdbc:postgresql://ec2-54-221-214-3.compute-1.amazonaws.com:5432/d1gm96c46b6ikh?sslmode=require&user=xhwdgutlrebzgc&password=c3b13cd8f5fdf82e4bd1fb4d57fe3ea3fce4b80be03a1daae4909a0902d3e729";

    }
    
    // generate connection to database
    public static Connection getconn() throws URISyntaxException, SQLException {
        Connection connection = DriverManager.getConnection(url);
        System.out.println(connection);
        return connection;
    }

    // close given connection
    public static void close(Connection connection){
    	/*
        if(statement != null) {
            try {
                statement.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }*/
        if(connection != null){
            try {
                connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
       
}