package edu.ijse.layered.controller;

import edu.ijse.layered.bo.BOFactory;
import edu.ijse.layered.bo.custom.EmployeeBO;
import edu.ijse.layered.dto.EmployeeDTO;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;

public class EmployeeController {

    private final EmployeeBO employeeBO = (EmployeeBO) BOFactory.getInstance().getBO(BOFactory.BOTypes.EMPLOYEE);

    @FXML
    private Button btnDelete;

    @FXML
    private Button btnReset;

    @FXML
    private Button btnSave;

    @FXML
    private Button btnUpdate;

    @FXML
    private ComboBox<String> cmbRole;

    @FXML
    private TableColumn<EmployeeDTO, Integer> colEmployeeId;

    @FXML
    private TableColumn<EmployeeDTO, String> colFullName;

    @FXML
    private TableColumn<EmployeeDTO, String> colRole;

    @FXML
    private TableColumn<EmployeeDTO, Double> colSalary;

    @FXML
    private TableColumn<EmployeeDTO, String> colContactNo;

    @FXML
    private TableView<EmployeeDTO> tblEmployees;

    @FXML
    private TextField txtId;

    @FXML
    private TextField txtContactNo;

    @FXML
    private TextField txtFullName;

    @FXML
    private TextField txtSalary;

    @FXML
    public void initialize() {

        colEmployeeId.setCellValueFactory(new PropertyValueFactory<>("employeeId"));
        colFullName.setCellValueFactory(new PropertyValueFactory<>("fullName"));
        colRole.setCellValueFactory(new PropertyValueFactory<>("role"));
        colSalary.setCellValueFactory(new PropertyValueFactory<>("salary"));
        colContactNo.setCellValueFactory(new PropertyValueFactory<>("contactNo"));

        cmbRole.getItems().addAll(
                "Manager",
                "Cashier",
                "Pharmacist",
                "Sales Assistant"
        );

        loadAllEmployees();

        tblEmployees.getSelectionModel().selectedItemProperty().addListener((observable, oldValue, employee) -> {
            if (employee != null) {
                txtId.setText(String.valueOf(employee.getEmployeeId()));
                txtFullName.setText(employee.getFullName());
                cmbRole.setValue(employee.getRole());
                txtSalary.setText(String.valueOf(employee.getSalary()));
                txtContactNo.setText(employee.getContactNo());
            }
        });
    }

    private void loadAllEmployees() {
        try {
            tblEmployees.getItems().clear();
            tblEmployees.getItems().addAll(employeeBO.getAll());
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @FXML
    void handleSave(ActionEvent event) {

        try {

            EmployeeDTO employeeDTO = new EmployeeDTO(
                    0,
                    txtFullName.getText(),
                    cmbRole.getValue(),
                    Double.parseDouble(txtSalary.getText()),
                    txtContactNo.getText()
            );

            boolean isSaved = employeeBO.save(employeeDTO);

            if (isSaved) {
                new Alert(Alert.AlertType.INFORMATION, "Employee Saved Successfully").show();
                loadAllEmployees();
                clearFields();
            } else {
                new Alert(Alert.AlertType.ERROR, "Failed to Save Employee").show();
            }

        } catch (Exception e) {
            new Alert(Alert.AlertType.ERROR, e.getMessage()).show();
        }
    }

    @FXML
    void handleUpdate(ActionEvent event) {

        try {

            EmployeeDTO employeeDTO = new EmployeeDTO(
                    Integer.parseInt(txtId.getText()),
                    txtFullName.getText(),
                    cmbRole.getValue(),
                    Double.parseDouble(txtSalary.getText()),
                    txtContactNo.getText()
            );

            boolean isUpdated = employeeBO.update(employeeDTO);

            if (isUpdated) {
                new Alert(Alert.AlertType.INFORMATION, "Employee Updated Successfully").show();
                loadAllEmployees();
                clearFields();
            } else {
                new Alert(Alert.AlertType.ERROR, "Failed to Update Employee").show();
            }

        } catch (Exception e) {
            new Alert(Alert.AlertType.ERROR, e.getMessage()).show();
        }
    }

    @FXML
    void handleDelete(ActionEvent event) {

        try {

            int employeeId = Integer.parseInt(txtId.getText());

            boolean isDeleted = employeeBO.delete(employeeId);

            if (isDeleted) {
                new Alert(Alert.AlertType.INFORMATION, "Employee Deleted Successfully").show();
                loadAllEmployees();
                clearFields();
            } else {
                new Alert(Alert.AlertType.ERROR, "Failed to Delete Employee").show();
            }

        } catch (Exception e) {
            new Alert(Alert.AlertType.ERROR, e.getMessage()).show();
        }
    }

    @FXML
    void handleReset(ActionEvent event) {
        clearFields();
    }

    private void clearFields() {
        txtId.clear();
        txtFullName.clear();
        txtSalary.clear();
        txtContactNo.clear();
        cmbRole.getSelectionModel().clearSelection();

        tblEmployees.getSelectionModel().clearSelection();
    }
}