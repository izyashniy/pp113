package jm.task.core.jdbc.service;

import jm.task.core.jdbc.dao.UserDaoJDBCImpl;
import jm.task.core.jdbc.model.User;

import java.util.ArrayList;
import java.util.List;

public class UserServiceImpl implements UserService {
    private UserDaoJDBCImpl daoJDBC = new UserDaoJDBCImpl();
    public void createUsersTable() {
        daoJDBC.createUsersTable();
    }

    public void dropUsersTable() {
        daoJDBC.dropUsersTable();
    }

    public void saveUser(String name, String lastName, byte age) {
        daoJDBC.saveUser(name, lastName, age);
    }

    public void removeUserById(long id) {
        daoJDBC.removeUserById(id);
    }

    public List<User> getAllUsers() {
        List<User> list = daoJDBC.getAllUsers();
        for (User user : list) {
            System.out.println(user);
        }
        return daoJDBC.getAllUsers();
    }

    public void cleanUsersTable() {
        daoJDBC.cleanUsersTable();
    }
}
