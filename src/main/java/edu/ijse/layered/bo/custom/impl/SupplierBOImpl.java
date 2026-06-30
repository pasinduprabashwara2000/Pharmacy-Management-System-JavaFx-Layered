package edu.ijse.layered.bo.custom.impl;

import edu.ijse.layered.bo.custom.SupplierBO;
import edu.ijse.layered.dao.DAOFactory;
import edu.ijse.layered.dao.custom.SupplierDAO;
import edu.ijse.layered.dto.SupplierDTO;
import edu.ijse.layered.entity.Supplier;
import java.util.ArrayList;
import java.util.List;

public class SupplierBOImpl implements SupplierBO {

    SupplierDAO supplierDAO = (SupplierDAO) DAOFactory.getInstance().getDAO(DAOFactory.DAOTypes.SUPPLIER);

    @Override
    public boolean save(SupplierDTO supplierDTO) throws Exception {

        Supplier supplier = new Supplier(
                supplierDTO.getSupplierId(),
                supplierDTO.getSupplierName(),
                supplierDTO.getEmail(),
                supplierDTO.getContactNo(),
                null
        );

        return supplierDAO.save(supplier);

    }

    @Override
    public boolean update(SupplierDTO supplierDTO) throws Exception {

        Supplier supplier = new Supplier(
                supplierDTO.getSupplierId(),
                supplierDTO.getSupplierName(),
                supplierDTO.getEmail(),
                supplierDTO.getContactNo(),
                null
        );

        return supplierDAO.update(supplier);

    }

    @Override
    public boolean delete(Integer id) throws Exception {
        return supplierDAO.delete(id);
    }

    @Override
    public SupplierDTO findById(Integer id) throws Exception {

        Supplier supplier = supplierDAO.findById(id);

        if(supplier != null){
            return new SupplierDTO(
                   supplier.getSupplierId(),
                   supplier.getSupplierName(),
                   supplier.getEmail(),
                   supplier.getContactNo()
            );
        }

        return null;

    }

    @Override
    public List<SupplierDTO> getAll() throws Exception {

        List<Supplier> suppliers = supplierDAO.getAll();
        List<SupplierDTO> supplierDTOS = new ArrayList<>();

        for (Supplier supplier : suppliers){
            supplierDTOS.add(new SupplierDTO(
                    supplier.getSupplierId(),
                    supplier.getSupplierName(),
                    supplier.getEmail(),
                    supplier.getContactNo()
            ));
        }

        return supplierDTOS;

    }
}
