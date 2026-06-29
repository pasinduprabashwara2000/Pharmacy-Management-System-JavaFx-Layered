package edu.ijse.layered.bo.custom;

import edu.ijse.layered.bo.SuperBO;
import edu.ijse.layered.dto.CategoryDTO;
import java.util.List;

public interface CategoryBO extends SuperBO {

    boolean save(CategoryDTO categoryDTO) throws Exception;
    boolean update(CategoryDTO categoryDTO) throws Exception;
    boolean delete(Integer id) throws Exception;
    CategoryDTO findById(Integer id) throws Exception;
    List<CategoryDTO> getAll() throws Exception;

}
