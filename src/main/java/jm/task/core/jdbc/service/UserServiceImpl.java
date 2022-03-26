package jm.task.core.jdbc.service;

import jm.task.core.jdbc.dao.UserDao;
import jm.task.core.jdbc.dao.UserDaoHibernateImpl;
import jm.task.core.jdbc.dao.UserDaoJDBCImpl;
import jm.task.core.jdbc.model.User;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;

public class UserServiceImpl implements UserService {
    private UserDao userDAO = new UserDaoHibernateImpl();
    @Transactional
    public void createUsersTable() {
        userDAO.createUsersTable();
    }
    @Transactional
    public void dropUsersTable() {

        userDAO.dropUsersTable();
    }
    @Transactional
    public void saveUser(String name, String lastName, byte age) {
        userDAO.saveUser(name, lastName, age);
    }
    @Transactional
    public void removeUserById(long id) {
        userDAO.removeUserById(id);
    }
    @Transactional
    public List<User> getAllUsers() {
        return userDAO.getAllUsers();
    }

    public void cleanUsersTable() {
        userDAO.cleanUsersTable();
    }
}
