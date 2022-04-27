package org.example;

import org.example.dao.UserDao;
import org.example.entities.User;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.List;

public class App {
    public static void main(String[] args) {
        User user = new User(23,"xxx", "sadin@gmail.com", "gender", "1111");
        ApplicationContext context = new AnnotationConfigApplicationContext(JDBCConfig.class);
        UserDao userDao = (UserDao) context.getBean("getUserDao");
        List<User> user1 =  userDao.getUsers();
        for (User u:user1) {
            System.out.println(u);
        }
    }
}
