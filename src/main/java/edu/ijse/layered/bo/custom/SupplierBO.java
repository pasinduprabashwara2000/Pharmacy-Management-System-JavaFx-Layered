package edu.ijse.layered.bo.custom;

import edu.ijse.layered.bo.SuperBO;
import edu.ijse.layered.dto.SupplierDTO;
import java.util.List;

public interface SupplierBO extends SuperBO {

    boolean save(SupplierDTO supplierDTO) throws Exception;
    boolean update(SupplierDTO supplierDTO) throws Exception;
    boolean delete(Integer id) throws Exception;
    SupplierDTO findById(Integer id) throws Exception;
    List<SupplierDTO> getAll() throws Exception;

}
