package jm.task.core.jdbc.dao;

import jm.task.core.jdbc.model.User;
import org.hibernate.Session;
import org.hibernate.query.Query;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import static jm.task.core.jdbc.util.Util.getSessionFactory;

public class UserDaoHibernateImpl implements UserDao {
    public UserDaoHibernateImpl() {

    }


    @Override
    public void createUsersTable() {
        String sqlCommand = "CREATE TABLE IF NOT EXISTS User (Id INT PRIMARY KEY AUTO_INCREMENT, name VARCHAR(200), " +
                "lastName VARCHAR(200), age INT)";
        try (Session session = getSessionFactory().openSession()) {
            session.beginTransaction();
            Query query = session.createSQLQuery(sqlCommand).addEntity(User.class);
            System.out.println("Database: create table!");
            session.getTransaction().commit();
        }
    }

    @Override
    public void dropUsersTable() {
        String sqlCommand = "DROP TABLE User";
        try (Session session = getSessionFactory().openSession()) {
            session.beginTransaction();
            Query query = session.createSQLQuery(sqlCommand).addEntity(User.class);
            System.out.println("Database: drop table!");
            session.getTransaction().commit();
        }
    }

    @Override
    public void saveUser(String name, String lastName, byte age) {
        String sqlCommand = "INSERT User(name, lastName, age) VALUES (?, ?, ?)";
        try (Session session = getSessionFactory().openSession()) {
            session.beginTransaction();
            Query query = session.createSQLQuery(sqlCommand).addEntity(User.class);
            query.setParameter(1, name);
            query.setParameter(2, lastName);
            query.setParameter(3, age);
            System.out.println("Database: save user!");
            session.getTransaction().commit();
        }
    }

    @Override
    public void removeUserById(long id) {
        String sqlCommand = "DELETE FROM User WHERE Id = id";
        try (Session session = getSessionFactory().openSession()) {
            session.beginTransaction();
            Query query = session.createSQLQuery(sqlCommand).addEntity(User.class);
            System.out.println("Database: delete user!");
            session.getTransaction().commit();
        }
    }

    @Override
    public List<User> getAllUsers() {
        String sqlCommand = "SELECT u FROM User u";
         try (Session session = getSessionFactory().openSession()) {
             session.beginTransaction();
            return session.createQuery(sqlCommand, User.class).list();
        }
    }


    @Override
    public void cleanUsersTable() {
        String sqlCommand = "TRUNCATE TABLE Users";
        try (Session session = getSessionFactory().openSession()) {
            session.beginTransaction();
            Query query = session.createSQLQuery(sqlCommand).addEntity(User.class);
            System.out.println("Database: clean table!");
            session.getTransaction().commit();
        }
    }
}
