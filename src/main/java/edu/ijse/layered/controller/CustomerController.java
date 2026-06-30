package edu.ijse.layered.controller;

import edu.ijse.layered.bo.BOFactory;
import edu.ijse.layered.bo.custom.CustomerBO;
import edu.ijse.layered.dto.CustomerDTO;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;

public class CustomerController {

    private final CustomerBO customerBO = (CustomerBO) BOFactory.getInstance().getBO(BOFactory.BOTypes.CUSTOMER);

    @FXML
    private Button btnDelete;

    @FXML
    private Button btnReset;

    @FXML
    private Button btnSave;

    @FXML
    private Button btnUpdate;

    @FXML
    private TableColumn<CustomerDTO, Integer> colCustomerId;

    @FXML
    private TableColumn<CustomerDTO, String> colFullName;

    @FXML
    private TableColumn<CustomerDTO, String> colEmail;

    @FXML
    private TableColumn<CustomerDTO, String> colContactNo;

    @FXML
    private TableView<CustomerDTO> tblCustomers;

    @FXML
    private TextField txtId;

    @FXML
    private TextField txtFullName;

    @FXML
    private TextField txtEmail;

    @FXML
    private TextField txtContactNo;

    @FXML
    public void initialize() {
        colCustomerId.setCellValueFactory(new PropertyValueFactory<>("customerId"));
        colFullName.setCellValueFactory(new PropertyValueFactory<>("fullName"));
        colEmail.setCellValueFactory(new PropertyValueFactory<>("email"));
        colContactNo.setCellValueFactory(new PropertyValueFactory<>("contactNo"));

        loadAllCustomers();

        tblCustomers.getSelectionModel().selectedItemProperty().addListener((observable, oldValue, customer) -> {
            if (customer != null) {
                txtId.setText(String.valueOf(customer.getCustomerId()));
                txtFullName.setText(customer.getFullName());
                txtEmail.setText(customer.getEmail());
                txtContactNo.setText(customer.getContactNo());
            }
        });
    }

    void loadAllCustomers(){
        try {
            tblCustomers.getItems().clear();
            tblCustomers.getItems().addAll(customerBO.getAll());
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @FXML
    void handleSave(ActionEvent event) {

        try {
            CustomerDTO customerDTO = new CustomerDTO(
                    0,
                    txtFullName.getText(),
                    txtEmail.getText(),
                    txtContactNo.getText()
            );

            boolean isSaved = customerBO.save(customerDTO);

            if (isSaved) {
                new Alert(Alert.AlertType.INFORMATION, "Customer Saved Successfully").show();
                loadAllCustomers();
                clearFields();
            } else {
                new Alert(Alert.AlertType.ERROR, "Failed to Save Customer").show();
            }

        } catch (Exception e) {
            new Alert(Alert.AlertType.ERROR, e.getMessage()).show();
        }
    }

    @FXML
    void handleUpdate(ActionEvent event) {

        try {

            CustomerDTO customerDTO = new CustomerDTO(
                    Integer.parseInt(txtId.getText()),
                    txtFullName.getText(),
                    txtEmail.getText(),
                    txtContactNo.getText()
            );

            boolean isUpdated = customerBO.update(customerDTO);

            if (isUpdated) {
                new Alert(Alert.AlertType.INFORMATION, "Customer Updated Successfully").show();
                loadAllCustomers();
                clearFields();
            } else {
                new Alert(Alert.AlertType.ERROR, "Failed to Update Customer").show();
            }

        } catch (Exception e) {
            new Alert(Alert.AlertType.ERROR, e.getMessage()).show();
        }
    }

    @FXML
    void handleDelete(ActionEvent event) {

        try {

            int customerId = Integer.parseInt(txtId.getText());

            boolean isDeleted = customerBO.delete(customerId);

            if (isDeleted) {
                new Alert(Alert.AlertType.INFORMATION, "Customer Deleted Successfully").show();
                loadAllCustomers();
                clearFields();
            } else {
                new Alert(Alert.AlertType.ERROR, "Failed to Delete Customer").show();
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
        txtEmail.clear();
        txtContactNo.clear();

        tblCustomers.getSelectionModel().clearSelection();
    }
}