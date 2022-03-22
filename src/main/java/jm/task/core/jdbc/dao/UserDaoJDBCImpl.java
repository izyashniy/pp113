package jm.task.core.jdbc.dao;

import jm.task.core.jdbc.model.User;
import jm.task.core.jdbc.util.Util;

import static jm.task.core.jdbc.util.Util.getNewConnection;


import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class UserDaoJDBCImpl implements UserDao {
    private Connection conn = getNewConnection();
    public UserDaoJDBCImpl() {

    }

    public void createUsersTable() {
        String sqlCommand = "CREATE TABLE IF NOT EXISTS Users (Id INT PRIMARY KEY AUTO_INCREMENT, name VARCHAR(200), " +
                "lastName VARCHAR(200), age INT)";
        try(PreparedStatement preparedStatement = getNewConnection().prepareStatement(sqlCommand)) {
            conn.setAutoCommit(false);
            preparedStatement.executeUpdate();
            System.out.println("Database: create table!");
            conn.commit();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void dropUsersTable() {
        String sqlCommand = "DROP TABLE Users";
        try (PreparedStatement preparedStatement = getNewConnection().prepareStatement(sqlCommand)) {
            conn.setAutoCommit(false);
            preparedStatement.executeUpdate();
            System.out.println("Database: drop table!");
            conn.commit();
        } catch (SQLException e) {
            System.out.println("Unknown table");
        }
    }

    public void saveUser(String name, String lastName, byte age) {
        String sqlCommand = "INSERT Users(name, lastName, age) VALUES (?, ?, ?)";
        try (PreparedStatement preparedStatement = getNewConnection().prepareStatement(sqlCommand)) {
            conn.setAutoCommit(false);
            preparedStatement.setString(1, name);
            preparedStatement.setString(2, lastName);
            preparedStatement.setInt(3, age);
            preparedStatement.executeUpdate();
            System.out.println("Database: save user!");
            conn.commit();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void removeUserById(long id) {
        String sqlCommand = "DELETE FROM Users WHERE Id = id";
        try (PreparedStatement preparedStatement = getNewConnection().prepareStatement(sqlCommand)) {
            conn.setAutoCommit(false);
            preparedStatement.executeUpdate();
            System.out.println("Database: delete user!");
            conn.commit();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public List<User> getAllUsers() {
        List<User> list = new ArrayList<>();
        String sqlCommand = "SELECT * FROM Users";
        try (PreparedStatement preparedStatement = getNewConnection().prepareStatement(sqlCommand)) {
            conn.setAutoCommit(false);
            ResultSet resultSet = preparedStatement.executeQuery();
            while(resultSet.next()) {
                User user = new User();
                user.setId(resultSet.getLong("Id"));
                user.setName(resultSet.getString("name"));
                user.setLastName(resultSet.getString("lastName"));
                user.setAge(resultSet.getByte("age"));
                list.add(user);
            }
            conn.commit();
            // получение содержимого строк
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }

    public void cleanUsersTable() {
        String sqlCommand = "TRUNCATE TABLE Users";
        try (PreparedStatement preparedStatement = getNewConnection().prepareStatement(sqlCommand)) {
            conn.setAutoCommit(false);
            preparedStatement.executeUpdate();
            System.out.println("Database: clean table!");
            conn.commit();
        } catch (SQLException e) {
            System.out.println("Nothing to clean");
        }
    }
}
