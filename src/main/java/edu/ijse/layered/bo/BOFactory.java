package edu.ijse.layered.bo;

import edu.ijse.layered.bo.custom.impl.CategoryBOImpl;
import edu.ijse.layered.bo.custom.impl.CustomerBOImpl;
import edu.ijse.layered.bo.custom.impl.EmployeeBOImpl;

public class BOFactory {

    private static BOFactory boFactory;

    public BOFactory(){

    }

    public static BOFactory getInstance(){
        if (boFactory == null){
            boFactory = new BOFactory();
        }
        return boFactory;
    }

    public enum BOTypes {
        CUSTOMER,CATEGORY,SUPPLIER,MEDICINE,EMPLOYEE
    }

    public SuperBO getBO(BOTypes boTypes){
        switch (boTypes){
            case CUSTOMER :
                return new CustomerBOImpl();
            case CATEGORY :
                return new CategoryBOImpl();
            case EMPLOYEE :
                return new EmployeeBOImpl();
        }
        return null;
    }

}
