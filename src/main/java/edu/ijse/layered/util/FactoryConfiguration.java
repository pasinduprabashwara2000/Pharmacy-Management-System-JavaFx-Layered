package edu.ijse.layered.util;

import edu.ijse.layered.entity.*;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class FactoryConfiguration {

    private static FactoryConfiguration factoryConfiguration;
    private final SessionFactory sessionFactory;

    private FactoryConfiguration() {

        Configuration configuration = new Configuration();
        configuration.configure("hibernate.cfg.xml");

        configuration.addAnnotatedClass(Customer.class);
        configuration.addAnnotatedClass(Supplier.class);
        configuration.addAnnotatedClass(Employee.class);
        configuration.addAnnotatedClass(Medicine.class);

        sessionFactory = configuration.buildSessionFactory();
    }

    public static FactoryConfiguration getInstance() {
        if (factoryConfiguration == null) {
            factoryConfiguration = new FactoryConfiguration();
        }
        return factoryConfiguration;
    }

    public Session getSession() {
        return sessionFactory.openSession();
    }

}