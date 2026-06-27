package edu.ijse.layered.dao.custom.impl;

import edu.ijse.layered.dao.custom.CustomerDAO;
import edu.ijse.layered.entity.Customer;
import edu.ijse.layered.util.FactoryConfiguration;
import org.hibernate.Session;
import org.hibernate.Transaction;
import java.util.ArrayList;
import java.util.List;

public class CustomerDAOImpl implements CustomerDAO {

    FactoryConfiguration factoryConfiguration = FactoryConfiguration.getInstance();

    @Override
    public boolean save(Customer customer) throws Exception {

        Session session = factoryConfiguration.getSession();
        Transaction transaction = session.beginTransaction();
        try {
            session.persist(customer);
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
    public boolean update(Customer customer) throws Exception {

        Session session = factoryConfiguration.getSession();
        Transaction transaction = session.beginTransaction();

        try {
            Customer oldCustomer = session.find(Customer.class, customer.getCustomerId());
            oldCustomer.setFullName(customer.getFullName());
            oldCustomer.setEmail(customer.getEmail());
            oldCustomer.setContactNo(customer.getContactNo());
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
    public boolean delete(Integer id) throws Exception {

        Session session = factoryConfiguration.getSession();
        Transaction transaction = session.beginTransaction();

        try {
            Customer customer = session.find(Customer.class, id);
            session.remove(customer);
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
    public Customer findById(Integer id) throws Exception {

        Session session = factoryConfiguration.getSession();
        Transaction transaction = session.beginTransaction();

        try {
            Customer customer = session.find(Customer.class, id);
            transaction.commit();
            return customer;
        } catch (Exception e) {
            e.printStackTrace();
            transaction.rollback();
            return null;
        } finally {
            session.close();
        }
    }

    @Override
    public List<Customer> getAll() throws Exception {

        Session session = factoryConfiguration.getSession();

        try {
            return new ArrayList<>(session.createQuery("from Customer ", Customer.class).list());
        } finally {
            session.close();
        }

    }
}
