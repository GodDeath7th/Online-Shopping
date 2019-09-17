package util;

import java.io.IOException;
import java.io.InputStream;
import java.net.URISyntaxException;
import java.sql.*;
import java.util.Properties;
import org.postgresql.*;

import entity.User;

public class JdbcUtils {

    private static String url = null;
    private static String localurl = null;

    static{

        	url = "jdbc:postgresql://ec2-54-221-214-3.compute-1.amazonaws.com:5432/d1gm96c46b6ikh?sslmode=require&user=xhwdgutlrebzgc&password=c3b13cd8f5fdf82e4bd1fb4d57fe3ea3fce4b80be03a1daae4909a0902d3e729";

    }
    public static Connection getconn() throws URISyntaxException, SQLException {
        Connection connection = DriverManager.getConnection(url);
        System.out.println(connection);
        return connection;

    }

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