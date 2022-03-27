package jm.task.core.jdbc;

import jm.task.core.jdbc.dao.UserDaoHibernateImpl;
import jm.task.core.jdbc.service.UserServiceImpl;
import org.hibernate.Session;

import java.sql.SQLException;
import static jm.task.core.jdbc.util.Util.getSessionFactory;

public class Main {
    public static void main(String[] args) {
        // реализуйте алгоритм здесь
        UserDaoHibernateImpl user = new UserDaoHibernateImpl();

        user.createUsersTable();
        user.saveUser("Franc", "Kafka", (byte) 20);
        user.saveUser("Platon", "Platonovich", (byte) 20);
        user.saveUser("Emanuel", "Kant", (byte) 20);
        user.saveUser("Naruto", "Uzumaki", (byte) 20);
        user.removeUserById(3);
        user.getAllUsers();
        user.cleanUsersTable();
        user.dropUsersTable();




    }
}
