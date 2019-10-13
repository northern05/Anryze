package dao;

import models.Project;
import models.User;
import org.hibernate.Session;
import org.hibernate.Transaction;
import utils.HibernateSessionFactoryUtil;

import java.util.List;

public class UsersDao {

    public User findById(int id) {
        return HibernateSessionFactoryUtil.getSessionFactory().openSession().get(User.class, id);
    }

    public void save(User user) {
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        Transaction tx1 = session.beginTransaction();
        session.save(user);
        tx1.commit();
        session.close();
    }

    public void update(User user){
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        Transaction transaction1 = session.beginTransaction();
        session.update(user);
        transaction1.commit();
        session.close();
    }

    public void delete (User user) {
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        Transaction transaction1 = session.beginTransaction();
        session.delete(user);
        transaction1.commit();
        session.close();
    }

    public Project findProjectById(int id){
        return HibernateSessionFactoryUtil.getSessionFactory().openSession().get(Project.class, id);
    }

    public List<User> findAll() {
        List<User> users = (List<User>) HibernateSessionFactoryUtil.getSessionFactory().openSession().createQuery("select*from users").list();
        return users;
    }
}
