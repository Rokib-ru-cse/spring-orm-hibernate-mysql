package org.example.dao;


import org.example.entities.User;
import org.springframework.orm.hibernate5.HibernateTemplate;

import javax.transaction.Transactional;
import java.util.List;

public class UserDao {
    private HibernateTemplate hibernateTemplate;

    public HibernateTemplate getHibernateTemplate() {
        return hibernateTemplate;
    }

    public void setHibernateTemplate(HibernateTemplate hibernateTemplate) {
        this.hibernateTemplate = hibernateTemplate;
    }

    @Transactional
    public int insert(User user) {
        return (int) this.hibernateTemplate.save(user);
    }

    public User getUser(int userId) {
        return this.hibernateTemplate.get(User.class, userId);
    }

    public List<User> getUsers() {
        return this.hibernateTemplate.loadAll(User.class);
    }

    @Transactional
    public int delete(int userId) {
        User user = this.hibernateTemplate.get(User.class, userId);
        assert user != null;
        this.hibernateTemplate.delete(user);
        return 1;
    }

    @Transactional
    public int update(User user) {
        this.hibernateTemplate.update(user);
        return 1;
    }
}
