package edu.ijse.layered.dao;

import edu.ijse.layered.dao.custom.impl.CategoryDAOImpl;
import edu.ijse.layered.dao.custom.impl.CustomerDAOImpl;
import edu.ijse.layered.dao.custom.impl.EmployeeDAOImpl;

public class DAOFactory {

    private static DAOFactory daoFactory;

    private DAOFactory(){

    }

    public static DAOFactory getInstance() {
        if(daoFactory == null){
            daoFactory = new DAOFactory();
        }
        return daoFactory;
    }

    public enum DAOTypes {
        CUSTOMER, CATEGORY, EMPLOYEE
    }

    public SuperDAO getDAO(DAOTypes daoTypes){
        switch (daoTypes){
            case CUSTOMER :
                return new CustomerDAOImpl();
            case CATEGORY :
                return new CategoryDAOImpl();
            case EMPLOYEE :
                return new EmployeeDAOImpl();
        }
        return null;
    }


}
