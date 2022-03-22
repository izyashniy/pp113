package jm.task.core.jdbc.util;

import java.lang.reflect.InvocationTargetException;
import java.sql.*;
import java.util.Properties;
import java.util.logging.Logger;

public class Util {
    public static Connection getNewConnection() {
        String url = "jdbc:mysql://localhost/mydb?allowPublicKeyRetrieval=true&useSSL=false";
        String login = "root";
        String pass = "btxff2rx";
        Connection connection = null;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver").getDeclaredConstructor().newInstance();
            connection = DriverManager.getConnection(url, login, pass);
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        }
        return connection;
    }
    // реализуйте настройку соеденения с БД
}
