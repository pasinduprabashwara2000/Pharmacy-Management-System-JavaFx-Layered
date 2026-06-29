package edu.ijse.layered.bo.custom.impl;

import edu.ijse.layered.bo.custom.EmployeeBO;
import edu.ijse.layered.dao.DAOFactory;
import edu.ijse.layered.dao.custom.EmployeeDAO;
import edu.ijse.layered.dto.EmployeeDTO;
import edu.ijse.layered.entity.Employee;
import java.util.ArrayList;
import java.util.List;

public class EmployeeBOImpl implements EmployeeBO {

    EmployeeDAO employeeDAO = (EmployeeDAO) DAOFactory.getInstance().getDAO(DAOFactory.DAOTypes.EMPLOYEE);

    @Override
    public boolean save(EmployeeDTO employeeDTO) throws Exception {

        Employee employee = new Employee(
                employeeDTO.getEmployeeId(),
                employeeDTO.getFullName(),
                employeeDTO.getRole(),
                employeeDTO.getSalary(),
                employeeDTO.getContactNo()
        );

        return employeeDAO.save(employee);

    }

    @Override
    public boolean update(EmployeeDTO employeeDTO) throws Exception {

        Employee employee = new Employee(
                employeeDTO.getEmployeeId(),
                employeeDTO.getFullName(),
                employeeDTO.getRole(),
                employeeDTO.getSalary(),
                employeeDTO.getContactNo()
        );

        return employeeDAO.update(employee);

    }

    @Override
    public boolean delete(Integer id) throws Exception {
        return employeeDAO.delete(id);
    }

    @Override
    public EmployeeDTO findById(Integer id) throws Exception {

        Employee employee = employeeDAO.findById(id);

        if(employee != null){
            return new EmployeeDTO(
                    employee.getEmployeeId(),
                    employee.getFullName(),
                    employee.getRole(),
                    employee.getSalary(),
                    employee.getContactNo()
            );
        }

        return null;

    }

    @Override
    public List<EmployeeDTO> getAll() throws Exception {

        List<Employee> employees = employeeDAO.getAll();
        List<EmployeeDTO> employeeDTOS = new ArrayList<>();

        for (Employee employee : employees){
            employeeDTOS.add(new EmployeeDTO(
               employee.getEmployeeId(),
               employee.getFullName(),
               employee.getRole(),
               employee.getSalary(),
               employee.getContactNo()
            ));
        }

        return employeeDTOS;

    }
}
