package com.revature.projectdemo.util;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.activation.DataSource;
import javax.naming.Context;

/**
 * ConnectionUtil
 */
public class ConnectionUtil {
    private Connection connection;
    private String url, user, password;

    public ConnectionUtil() throws FileNotFoundException{
        try {

            Class.forName("org.postgresql.Driver");
            Properties properties = new Properties();
            // properties.load(new FileReader("application.properties"));
            // this.url = properties.getProperty("url");
            // this.user = properties.getProperty("user");
            // this.password = properties.getProperty("password");
            this.connection = DriverManager.getConnection("jdbc:postgresql://192.168.99.100:5432/project1db", "project1db", "project1db");
            // Context initCtx = new InitialContext();
            // Context envCtx = (Context) initCtx.lookup("java:comp/env/jdbc/postgres");
            // DataSource ds = (DataSource)
            // envCtx.lookup("jdbc/postgres");
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public Connection getConnection() {
        return connection;
    }

    public void close() {
        try {
            this.connection.close();
        } catch (SQLException e) {

        }
    }
}