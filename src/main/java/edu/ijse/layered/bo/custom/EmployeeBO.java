package edu.ijse.layered.bo.custom;

import edu.ijse.layered.bo.SuperBO;
import edu.ijse.layered.dto.EmployeeDTO;
import java.util.List;

public interface EmployeeBO extends SuperBO {

    boolean save(EmployeeDTO employeeDTO) throws Exception;
    boolean update(EmployeeDTO employeeDTO) throws Exception;
    boolean delete(Integer id) throws Exception;
    EmployeeDTO findById(Integer id) throws Exception;
    List <EmployeeDTO> getAll() throws Exception;

}
