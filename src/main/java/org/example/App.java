package org.example;

import org.example.dao.UserDao;
import org.example.entities.User;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.List;
import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("spring.xml");
        UserDao userDao = (UserDao) context.getBean("userDao");

        Scanner in = new Scanner(System.in);
        int t = 0;
        while (t != 6) {
            System.out.println("PRESS 1 for adding new user : ");
            System.out.println("PRESS 2 for getting all users : ");
            System.out.println("PRESS 3 for getting single user details : ");
            System.out.println("PRESS 4 for deleting existing user : ");
            System.out.println("PRESS 5 for updating existing user : ");
            System.out.println("PRESS 6 for exit : ");
            t = in.nextInt();

            if (t == 1) {
                System.out.print("Enter user name : ");
                in.nextLine();
                String name = in.nextLine();
                System.out.print("Enter user email : ");
                String email = in.nextLine();
                System.out.print("Enter user gender : ");
                String gender = in.nextLine();
                System.out.print("Enter user password : ");
                String password = in.nextLine();
                System.out.print("Confirm user password : ");
                String cpassword = in.nextLine();
                while (!password.equals(cpassword) && !password.equals("0")) {
                    System.out.print("password does not match enter new password or enter 0 for exit: ");
                    password = in.nextLine();
                    System.out.print("Confirm user password : ");
                    cpassword = in.nextLine();
                }
                User user = new User(name, email, gender, password);
                int r = userDao.insert(user);
                System.out.println("inserted record " + r);
            } else if (t == 2) {
                List<User> users = userDao.getUsers();
                for (User u : users) {
                    System.out.println(u);
                }
            } else if (t == 3) {
                System.out.println("enter user id for getting details : ");
                int id = in.nextInt();
                User user = userDao.getUser(id);
                System.out.println(user);
            } else if (t == 4) {
                System.out.println("enter user id for deleting user : ");
                int id = in.nextInt();
                int r = userDao.delete(id);
                System.out.println("deleted record " + r);
            } else if (t == 5) {
                System.out.println("enter user id for updating user details : ");
                int id = in.nextInt();
                User user = userDao.getUser(id);
                if (user == null) {
                    System.out.println("user does not exit ");
                } else {
                    System.out.println(user);
                    System.out.print("Enter user new name : ");
                    in.nextLine();
                    String name = in.nextLine();
                    System.out.print("Enter user new email : ");
                    String email = in.nextLine();
                    System.out.print("Enter user new gender : ");
                    String gender = in.nextLine();
                    System.out.print("Enter user new password : ");
                    String password = in.nextLine();
                    System.out.print("Confirm user password : ");
                    String cpassword = in.nextLine();
                    while (!password.equals(cpassword)) {
                        System.out.print("password does not match enter new password or enter 0 for exit: ");
                        password = in.nextLine();
                        if (password.equals("0")) break;
                        System.out.print("Confirm user password : ");
                        cpassword = in.nextLine();

                    }
                    if (password.equals(cpassword)) {
                        user = new User(id, name, email, gender, password);
                        int r = userDao.update(user);
                        System.out.println("updated record " + r);
                    }
                }
            }
        }

    }
}
