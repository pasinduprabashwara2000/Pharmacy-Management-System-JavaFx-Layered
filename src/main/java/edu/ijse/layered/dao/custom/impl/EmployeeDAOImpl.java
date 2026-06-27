package edu.ijse.layered.dao.custom.impl;

import edu.ijse.layered.dao.custom.EmployeeDAO;
import edu.ijse.layered.entity.Employee;
import edu.ijse.layered.util.FactoryConfiguration;
import org.hibernate.Session;
import org.hibernate.Transaction;
import java.util.ArrayList;
import java.util.List;

public class EmployeeDAOImpl implements EmployeeDAO {

    FactoryConfiguration factoryConfiguration = FactoryConfiguration.getInstance();

    @Override
    public boolean save(Employee employee) throws Exception {

        Session session = factoryConfiguration.getSession();
        Transaction transaction = session.beginTransaction();
        try {
            session.persist(employee);
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
    public boolean update(Employee employee) throws Exception {

        Session session = factoryConfiguration.getSession();
        Transaction transaction = session.beginTransaction();

        try {
            Employee oldEmployee = session.find(Employee.class, employee.getEmployeeId());
            oldEmployee.setFullName(employee.getFullName());
            oldEmployee.setRole(employee.getRole());
            oldEmployee.setSalary(employee.getSalary());
            oldEmployee.setContactNo(employee.getContactNo());
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
            Employee employee = session.find(Employee.class, id);
            session.remove(employee);
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
    public Employee findById(Integer id) throws Exception {

        Session session = factoryConfiguration.getSession();
        Transaction transaction = session.beginTransaction();

        try {
            Employee employee = session.find(Employee.class, id);
            transaction.commit();
            return employee;
        } catch (Exception e) {
            e.printStackTrace();
            transaction.rollback();
            return null;
        } finally {
            session.close();
        }
    }

    @Override
    public List<Employee> getAll() throws Exception {

        Session session = factoryConfiguration.getSession();

        try {
            return new ArrayList<>(session.createQuery("FROM Employee", Employee.class).list());
        } finally {
            session.close();
        }
    }

}
