package jm.task.core.jdbc.service;

import jm.task.core.jdbc.dao.UserDao;
import jm.task.core.jdbc.dao.UserDaoHibernateImpl;
import jm.task.core.jdbc.dao.UserDaoJDBCImpl;
import jm.task.core.jdbc.model.User;

import java.util.ArrayList;
import java.util.List;

public class UserServiceImpl implements UserService {
    private UserDaoHibernateImpl user = new UserDaoHibernateImpl();
    public void createUsersTable() {
        user.createUsersTable();
    }

    public void dropUsersTable() {

        user.dropUsersTable();
    }

    public void saveUser(String name, String lastName, byte age) {
        user.saveUser(name, lastName, age);
    }

    public void removeUserById(long id) {
        user.removeUserById(id);
    }

    public List<User> getAllUsers() {
        List<User> list = user.getAllUsers();
        for (User user : list) {
            System.out.println(user);
        }
        return user.getAllUsers();
    }

    public void cleanUsersTable() {
        user.cleanUsersTable();
    }
}
