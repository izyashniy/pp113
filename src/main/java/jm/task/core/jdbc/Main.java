package jm.task.core.jdbc;

import jm.task.core.jdbc.service.UserServiceImpl;
import org.hibernate.Session;

import java.sql.SQLException;

import static jm.task.core.jdbc.util.Util.getNewConnection;
import static jm.task.core.jdbc.util.Util.getSessionFactory;

public class Main {
    public static void main(String[] args) {
        // реализуйте алгоритм здесь
        Session session = getSessionFactory().openSession();
    }
}
