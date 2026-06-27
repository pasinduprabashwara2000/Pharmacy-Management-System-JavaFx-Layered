package edu.ijse.layered.dao.custom.impl;

import edu.ijse.layered.dao.custom.CategoryDAO;
import edu.ijse.layered.entity.Category;
import edu.ijse.layered.util.FactoryConfiguration;
import org.hibernate.Session;
import org.hibernate.Transaction;
import java.util.ArrayList;
import java.util.List;

public class CategoryDAOImpl implements CategoryDAO {

    FactoryConfiguration factoryConfiguration = FactoryConfiguration.getInstance();

    @Override
    public boolean save(Category category) throws Exception {

        Session session = factoryConfiguration.getSession();
        Transaction transaction = session.beginTransaction();

        try {
            session.persist(category);
            transaction.commit();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            transaction.rollback();
            return false;
        } finally {
            session.close();
        }
    }

    @Override
    public boolean update(Category category) throws Exception {

        Session session = factoryConfiguration.getSession();
        Transaction transaction = session.beginTransaction();

        try {
           Category oldCategory = session.find(Category.class, category.getCategoryId());
           oldCategory.setCategoryName(category.getCategoryName());
           transaction.commit();
           return true;
        } catch (Exception e) {
            transaction.rollback();
            return false;
        } finally {
            session.close();
        }
    }

    @Override
    public boolean delete(Integer id) throws Exception {

        Session session = factoryConfiguration.getSession();
        Transaction transaction = session.beginTransaction();

        try {
            Category category = session.find(Category.class,id);
            session.remove(category);
            transaction.commit();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            transaction.rollback();
            return false;
        } finally {
            session.close();
        }
    }

    @Override
    public Category findById(Integer id) throws Exception {

        Session session = factoryConfiguration.getSession();
        Transaction transaction = session.beginTransaction();

        try {
            Category category = session.find(Category.class, id);
            transaction.commit();
            return category;
        } catch (Exception e) {
            e.printStackTrace();
            transaction.rollback();
            return null;
        } finally {
            session.close();
        }

    }

    @Override
    public List<Category> getAll() throws Exception {

        Session session = factoryConfiguration.getSession();

        try {
            return new ArrayList<>(session.createQuery("FROM Category", Category.class).list());
        } finally {
            session.close();
        }

    }
}
