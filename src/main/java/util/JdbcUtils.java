package util;

import java.io.IOException;
import java.io.InputStream;
import java.sql.*;
import java.util.Properties;

public class JdbcUtils {

    private static String url = null;
    private static String user = null;
    private static String password = null;
    private static String dv = null;

    static{
        Properties prop = new Properties();
        InputStream in = JdbcUtils.class.getResourceAsStream("/a.properties");


        try {
            prop.load(in);
            System.out.println(in);
            user = prop.getProperty("username");
            password = prop.getProperty("password");
            url = prop.getProperty("url");
            dv = prop.getProperty("driver");

            Class.forName(dv);
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }

    }
    public static Connection getconn() throws SQLException {
        Connection connection = DriverManager.getConnection(url,user,password);
        System.out.println(connection);
        return connection;

    }

    public static void close(Statement statement, Connection connection){
        if(statement != null) {
            try {
                statement.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        if(connection != null){
            try {
                connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    public static void close(PreparedStatement preparedStatement, Connection connection, ResultSet result) {
        if(preparedStatement != null){
            try {
                preparedStatement.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        if(connection != null){
            try {
                connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        if(result != null){
            try {
                result.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}