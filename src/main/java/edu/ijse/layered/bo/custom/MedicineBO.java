package edu.ijse.layered.bo.custom;

import edu.ijse.layered.bo.SuperBO;
import edu.ijse.layered.dto.MedicineDTO;
import java.util.List;

public interface MedicineBO extends SuperBO {

    boolean save(MedicineDTO medicineDTO) throws Exception;
    boolean update(MedicineDTO medicineDTO) throws Exception;
    boolean delete(Integer id) throws Exception;
    MedicineDTO findById(Integer id) throws Exception;
    List<MedicineDTO> getAll() throws Exception;

}
