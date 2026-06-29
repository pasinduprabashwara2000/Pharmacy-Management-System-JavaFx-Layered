package edu.ijse.layered.bo.custom;

import edu.ijse.layered.bo.SuperBO;
import edu.ijse.layered.dto.CustomerDTO;
import java.util.List;

public interface CustomerBO extends SuperBO {

    boolean save(CustomerDTO customerDTO) throws Exception;
    boolean update(CustomerDTO customerDTO) throws Exception;
    boolean delete(Integer id) throws Exception;
    CustomerDTO findById(Integer id) throws Exception;
    List<CustomerDTO> getAll() throws Exception;

}
