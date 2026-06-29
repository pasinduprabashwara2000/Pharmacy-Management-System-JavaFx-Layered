package edu.ijse.layered.dao.custom.impl;

import edu.ijse.layered.dao.custom.SupplierDAO;
import edu.ijse.layered.entity.Supplier;
import edu.ijse.layered.util.FactoryConfiguration;
import org.hibernate.Session;
import org.hibernate.Transaction;
import java.util.ArrayList;
import java.util.List;

public class SupplierDAOImpl implements SupplierDAO {

    FactoryConfiguration factoryConfiguration = FactoryConfiguration.getInstance();

    @Override
    public boolean save(Supplier supplier) throws Exception {

        Session session = factoryConfiguration.getSession();
        Transaction transaction = session.beginTransaction();

        try {
            session.persist(supplier);
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
    public boolean update(Supplier supplier) throws Exception {

        Session session = factoryConfiguration.getSession();
        Transaction transaction = session.beginTransaction();

        try {
            Supplier oldSupplier = session.find(Supplier.class,supplier.getSupplierId());
            oldSupplier.setSupplierName(supplier.getSupplierName());
            oldSupplier.setEmail(supplier.getEmail());
            oldSupplier.setContactNo(supplier.getContactNo());
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
            Supplier supplier = session.find(Supplier.class,id);
            session.remove(supplier);
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
    public Supplier findById(Integer id) throws Exception {

        Session session = factoryConfiguration.getSession();
        Transaction transaction = session.beginTransaction();

        try {
            Supplier supplier = session.find(Supplier.class, id);
            transaction.commit();
            return supplier;
        } catch (Exception e) {
            e.printStackTrace();
            transaction.rollback();
            return null;
        } finally {
            session.close();
        }
    }

    @Override
    public List<Supplier> getAll() throws Exception {

        Session session = factoryConfiguration.getSession();

        try {
            return new ArrayList<>(session.createQuery("FROM Supplier", Supplier.class).list());
        } finally {
            session.close();
        }

    }
}
