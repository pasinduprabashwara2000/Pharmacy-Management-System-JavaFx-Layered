package edu.ijse.layered.dao;

import edu.ijse.layered.dao.custom.impl.*;

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
        CUSTOMER, CATEGORY, MEDICINE, EMPLOYEE, SUPPLIER
    }

    public SuperDAO getDAO(DAOTypes daoTypes){
        switch (daoTypes){
            case CUSTOMER :
                return new CustomerDAOImpl();
            case MEDICINE :
                return new MedicineDAOImpl();
            case CATEGORY :
                return new CategoryDAOImpl();
            case EMPLOYEE :
                return new EmployeeDAOImpl();
            case SUPPLIER :
                return new SupplierDAOImpl();
        }

        return null;

    }


}
