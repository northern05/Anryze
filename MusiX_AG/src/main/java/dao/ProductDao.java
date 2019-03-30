package dao;

import models.Product;
import org.hibernate.Session;
import org.hibernate.Transaction;
import utils.HibernateSessionFactoryUtil;

import java.util.List;

public class ProductDao {
    public Product findById(int id){
        return HibernateSessionFactoryUtil.getSessionFactory().openSession().get(Product.class, id);
    }

    public void save (Product product){
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        session.save(product);
        transaction.commit();
        session.close();
    }

    public void update(Product product){
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        session.update(product);
        transaction.commit();
        session.close();
    }

    public void delete (Product product){
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        session.delete(product);
        transaction.commit();
        session.close();
    }

    public List<Product> findAll(){
        List<Product> products = (List<Product>) HibernateSessionFactoryUtil.getSessionFactory().openSession().createQuery("from product").list();
        return products;
    }
}
