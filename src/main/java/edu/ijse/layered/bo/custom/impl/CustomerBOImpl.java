package edu.ijse.layered.bo.custom.impl;

import edu.ijse.layered.bo.custom.CustomerBO;
import edu.ijse.layered.dao.DAOFactory;
import edu.ijse.layered.dao.custom.CustomerDAO;
import edu.ijse.layered.dto.CustomerDTO;
import edu.ijse.layered.entity.Customer;
import java.util.ArrayList;
import java.util.List;

public class CustomerBOImpl implements CustomerBO {

    CustomerDAO customerDAO = (CustomerDAO) DAOFactory.getInstance().getDAO(DAOFactory.DAOTypes.CUSTOMER);

    @Override
    public boolean save(CustomerDTO customerDTO) throws Exception {

        Customer customer = new Customer(
                customerDTO.getCustomerId(),
                customerDTO.getFullName(),
                customerDTO.getEmail(),
                customerDTO.getContactNo()
        );

        return customerDAO.save(customer);

    }

    @Override
    public boolean update(CustomerDTO customerDTO) throws Exception {

        Customer customer = new Customer(
                customerDTO.getCustomerId(),
                customerDTO.getFullName(),
                customerDTO.getEmail(),
                customerDTO.getContactNo()
        );

        return customerDAO.update(customer);

    }

    @Override
    public boolean delete(Integer id) throws Exception {
        return customerDAO.delete(id);
    }

    @Override
    public CustomerDTO findById(Integer id) throws Exception {

        Customer customer = customerDAO.findById(id);

        if (customer != null) {
            return new CustomerDTO(
                    customer.getCustomerId(),
                    customer.getFullName(),
                    customer.getEmail(),
                    customer.getContactNo()
            );
        }

        return null;

    }

    @Override
    public List<CustomerDTO> getAll() throws Exception {

        List<Customer> customers = customerDAO.getAll();
        List<CustomerDTO> customerDTOS = new ArrayList<>();

        for (Customer customer : customers){
            customerDTOS.add(new CustomerDTO(
               customer.getCustomerId(),
               customer.getFullName(),
               customer.getEmail(),
               customer.getContactNo()
            ));
        }

        return customerDTOS;
    }
}
