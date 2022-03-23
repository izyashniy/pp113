package jm.task.core.jdbc;

import jm.task.core.jdbc.dao.UserDaoHibernateImpl;
import jm.task.core.jdbc.service.UserServiceImpl;
import org.hibernate.Session;

import java.sql.SQLException;

import static jm.task.core.jdbc.util.Util.getNewConnection;
import static jm.task.core.jdbc.util.Util.getSessionFactory;

public class Main {
    public static void main(String[] args) {
        // реализуйте алгоритм здесь
        UserDaoHibernateImpl user = new UserDaoHibernateImpl();
        user.createUsersTable();
        user.saveUser("Ivan", "Lebedkin", (byte) 20);

    }
}
