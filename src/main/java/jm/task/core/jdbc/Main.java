package jm.task.core.jdbc;

import jm.task.core.jdbc.model.User;
import jm.task.core.jdbc.service.UserServiceImpl;
import jm.task.core.jdbc.util.Util;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        UserServiceImpl service = new UserServiceImpl();

        service.createUsersTable();

        service.saveUser("Ivan", "Ivanov", (byte) 25);
        System.out.println("User с именем – Ivan добавлен в базу данных");

        service.saveUser("Petr", "Petrov", (byte) 31);
        System.out.println("User с именем – Petr добавлен в базу данных");

        service.saveUser("Anna", "Sidorova", (byte) 22);
        System.out.println("User с именем – Anna добавлен в базу данных");

        service.saveUser("Olga", "Smirnova", (byte) 28);
        System.out.println("User с именем – Olga добавлен в базу данных");


        List<User> users = service.getAllUsers();
        users.forEach(System.out::println);

        service.cleanUsersTable();
        service.dropUsersTable();

        Util.getSessionFactory().close();
    }
}
