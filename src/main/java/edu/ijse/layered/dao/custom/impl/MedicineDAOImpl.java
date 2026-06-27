package edu.ijse.layered.dao.custom.impl;

import edu.ijse.layered.dao.custom.MedicineDAO;
import edu.ijse.layered.entity.Medicine;
import edu.ijse.layered.util.FactoryConfiguration;
import org.hibernate.Session;
import org.hibernate.Transaction;
import java.util.ArrayList;
import java.util.List;

public class MedicineDAOImpl implements MedicineDAO {

    FactoryConfiguration factoryConfiguration = FactoryConfiguration.getInstance();

    @Override
    public boolean save(Medicine medicine) throws Exception {

        Session session = factoryConfiguration.getSession();
        Transaction transaction = session.beginTransaction();

        try {
            session.persist(medicine);
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
    public boolean update(Medicine medicine) throws Exception {

        Session session = factoryConfiguration.getSession();
        Transaction transaction = session.beginTransaction();

        try {
            Medicine oldMedicine = session.find(Medicine.class, medicine.getMedicineId());
            oldMedicine.setName(medicine.getName());
            oldMedicine.setCategory(medicine.getCategory());
            oldMedicine.setUnitPrice(medicine.getUnitPrice());
            oldMedicine.setQtyOnHand(medicine.getQtyOnHand());
            oldMedicine.setExpireDate(medicine.getExpireDate());

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
            Medicine medicine = session.find(Medicine.class,id);
            session.remove(medicine);
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
    public Medicine findById(Integer id) throws Exception {

        Session session = factoryConfiguration.getSession();
        Transaction transaction = session.beginTransaction();

        try {
            Medicine medicine = session.find(Medicine.class, id);
            transaction.commit();
            return medicine;
        } catch (Exception e) {
            e.printStackTrace();
            transaction.rollback();
            return null;
        } finally {
            session.close();
        }
    }

    @Override
    public List<Medicine> getAll() throws Exception {

        Session session = factoryConfiguration.getSession();
        try {
            return new ArrayList<>(session.createQuery("FROM Medicine", Medicine.class).list());
        } finally {
            session.close();
        }

    }
}
