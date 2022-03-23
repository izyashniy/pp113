package jm.task.core.jdbc;

import jm.task.core.jdbc.service.UserServiceImpl;

import java.sql.SQLException;

import static jm.task.core.jdbc.util.Util.getNewConnection;

public class Main {
    public static void main(String[] args) {
        // реализуйте алгоритм здесь
        UserServiceImpl userService = new UserServiceImpl();
        userService.cleanUsersTable();
        userService.createUsersTable();
        userService.saveUser("Прохор", "Шаляпин", (byte) 52);
        userService.saveUser("Фёдор", "Достоевский", (byte) 35);
        userService.saveUser("Михаил", "Булгаков", (byte) 44);
        userService.saveUser("Иван", "Бездомный", (byte) 22);
        userService.getAllUsers();
        userService.cleanUsersTable();
        userService.dropUsersTable();


        try {
            getNewConnection().close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
