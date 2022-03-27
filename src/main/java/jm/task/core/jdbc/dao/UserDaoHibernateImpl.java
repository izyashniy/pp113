package jm.task.core.jdbc.dao;

import jm.task.core.jdbc.model.User;
import org.hibernate.Session;
import org.hibernate.Transaction;
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
        Session session = getSessionFactory().openSession();
        try {
            session.beginTransaction();
            session.createSQLQuery(sqlCommand).executeUpdate();
            System.out.println("Database: create table!");
            session.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
            session.getTransaction().rollback();
        } finally {
            session.close();
        }
    }

    @Override
    public void dropUsersTable() {
        String sqlCommand = "DROP TABLE IF EXISTS User";
        Session session = getSessionFactory().openSession();
        try {
            session.beginTransaction();
            session.createSQLQuery(sqlCommand).executeUpdate();
            System.out.println("Database: drop table!");
            session.getTransaction().commit();
        } catch (Exception e) {
            System.out.println("Unknown table");
            session.getTransaction().rollback();
        } finally {
            session.close();
        }
    }

    @Override
    public void saveUser(String name, String lastName, byte age) {
        Session session = getSessionFactory().openSession();
        try {
            User user = new User(name, lastName, age);
            session.beginTransaction();
            session.save(user);
            System.out.println("Database: save user!");
            session.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
            session.getTransaction().rollback();
        } finally {
            session.close();
        }
    }

    @Override
    public void removeUserById(long id) {
        Session session = getSessionFactory().openSession();
        try {
            User user = new User();
            user.setId(id);
            session.beginTransaction();
            session.delete(user);
            System.out.println("Database: delete user!");
            session.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
            session.getTransaction().rollback();
        } finally {
            session.close();
        }
    }

    @Override
    public List<User> getAllUsers() {
        List<User> list = new ArrayList<>();
        String sqlCommand = "FROM User";
        Session session = getSessionFactory().openSession();
        try {
            list = session.createQuery(sqlCommand, User.class).list();
        } catch (Exception e) {
            e.printStackTrace();
            session.getTransaction().rollback();
        } finally {
            session.close();
        }
        return list;
    }


    @Override
    public void cleanUsersTable() {
        String sqlCommand = "DELETE FROM User";
        Session session = getSessionFactory().openSession();
        try {
            session.beginTransaction();
            session.createQuery(sqlCommand).executeUpdate();
            System.out.println("Database: clean table!");
            session.getTransaction().commit();
        } catch (Exception e) {
            System.out.println("Nothing to clean");
            session.getTransaction().rollback();
        } finally {
            session.close();
        }
    }
}
