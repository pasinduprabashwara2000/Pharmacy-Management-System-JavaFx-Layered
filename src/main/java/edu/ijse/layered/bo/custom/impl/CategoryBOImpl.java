package edu.ijse.layered.bo.custom.impl;

import edu.ijse.layered.bo.custom.CategoryBO;
import edu.ijse.layered.dao.DAOFactory;
import edu.ijse.layered.dao.custom.CategoryDAO;
import edu.ijse.layered.dto.CategoryDTO;
import edu.ijse.layered.entity.Category;
import java.util.ArrayList;
import java.util.List;

public class CategoryBOImpl implements CategoryBO {

    CategoryDAO categoryDAO = (CategoryDAO) DAOFactory.getInstance().getDAO(DAOFactory.DAOTypes.CATEGORY);

    @Override
    public boolean save(CategoryDTO categoryDTO) throws Exception {

        Category category = new Category(
                categoryDTO.getCategoryId(),
                categoryDTO.getCategoryName(),
                null
        );

        return categoryDAO.save(category);

    }

    @Override
    public boolean update(CategoryDTO categoryDTO) throws Exception {

        Category category = new Category(
                categoryDTO.getCategoryId(),
                categoryDTO.getCategoryName(),
                null
        );

        return categoryDAO.update(category);

    }

    @Override
    public boolean delete(Integer id) throws Exception {
        return categoryDAO.delete(id);
    }

    @Override
    public CategoryDTO findById(Integer id) throws Exception {

        Category category = categoryDAO.findById(id);

        if(category != null){
            return new CategoryDTO(
                category.getCategoryId(),
                category.getCategoryName()
            );
        }

        return null;

    }

    @Override
    public List<CategoryDTO> getAll() throws Exception {

        List<Category> categories = categoryDAO.getAll();
        List<CategoryDTO> categoryDTOS = new ArrayList<>();

        for (Category category : categories){
            categoryDTOS.add(new CategoryDTO(
               category.getCategoryId(),
               category.getCategoryName()
            ));
        }

        return categoryDTOS;

    }
}
