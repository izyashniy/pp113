package jm.task.core.jdbc.util;

import java.lang.reflect.InvocationTargetException;
import java.sql.*;

public class Util {
    public static Connection getNewConnection() {
        String url = "jdbc:mysql://localhost/mydb?allowPublicKeyRetrieval=true&useSSL=false";
        String login = "root";
        String pass = "btxff2rx";
        Connection connection = null;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            connection = DriverManager.getConnection(url, login, pass);
            //connection.setAutoCommit(false);
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return connection;
    }

    // реализуйте настройку соеденения с БД
}
