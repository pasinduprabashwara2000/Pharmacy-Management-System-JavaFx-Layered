package edu.ijse.layered.controller;

import edu.ijse.layered.bo.BOFactory;
import edu.ijse.layered.bo.custom.SupplierBO;
import edu.ijse.layered.dto.SupplierDTO;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;

public class SupplierController {

    private final SupplierBO supplierBO = (SupplierBO) BOFactory.getInstance().getBO(BOFactory.BOTypes.SUPPLIER);

    @FXML
    private Button btnDelete;

    @FXML
    private Button btnReset;

    @FXML
    private Button btnSave;

    @FXML
    private Button btnUpdate;

    @FXML
    private TableColumn<SupplierDTO, Integer> colSupplierId;

    @FXML
    private TableColumn<SupplierDTO, String> colSupplierName;

    @FXML
    private TableColumn<SupplierDTO, String> colEmail;

    @FXML
    private TableColumn<SupplierDTO, String> colContactNo;

    @FXML
    private TableView<SupplierDTO> tblSuppliers;

    @FXML
    private TextField txtId;

    @FXML
    private TextField txtSupplierName;

    @FXML
    private TextField txtEmail;

    @FXML
    private TextField txtContactNo;

    @FXML
    public void initialize() {

        colSupplierId.setCellValueFactory(new PropertyValueFactory<>("supplierId"));
        colSupplierName.setCellValueFactory(new PropertyValueFactory<>("supplierName"));
        colEmail.setCellValueFactory(new PropertyValueFactory<>("email"));
        colContactNo.setCellValueFactory(new PropertyValueFactory<>("contactNo"));

        loadAllSuppliers();

        tblSuppliers.getSelectionModel().selectedItemProperty().addListener((observable, oldValue, supplier) -> {
            if (supplier != null) {
                txtId.setText(String.valueOf(supplier.getSupplierId()));
                txtSupplierName.setText(supplier.getSupplierName());
                txtEmail.setText(supplier.getEmail());
                txtContactNo.setText(supplier.getContactNo());
            }
        });
    }

    private void loadAllSuppliers() {
        try {
            tblSuppliers.getItems().clear();
            tblSuppliers.getItems().addAll(supplierBO.getAll());
        } catch (Exception e) {
            new Alert(Alert.AlertType.ERROR, e.getMessage()).show();
        }
    }

    @FXML
    void handleSave(ActionEvent event) {

        if (txtSupplierName.getText().isBlank()
                || txtEmail.getText().isBlank()
                || txtContactNo.getText().isBlank()) {

            new Alert(Alert.AlertType.WARNING, "Please fill all fields.").show();
            return;
        }

        try {

            SupplierDTO supplierDTO = new SupplierDTO(
                    0,
                    txtSupplierName.getText(),
                    txtEmail.getText(),
                    txtContactNo.getText()
            );

            boolean isSaved = supplierBO.save(supplierDTO);

            if (isSaved) {
                new Alert(Alert.AlertType.INFORMATION, "Supplier Saved Successfully").show();
                loadAllSuppliers();
                clearFields();
            } else {
                new Alert(Alert.AlertType.ERROR, "Failed to Save Supplier").show();
            }

        } catch (Exception e) {
            new Alert(Alert.AlertType.ERROR, e.getMessage()).show();
        }
    }

    @FXML
    void handleUpdate(ActionEvent event) {

        if (txtId.getText().isBlank()) {
            new Alert(Alert.AlertType.WARNING, "Please select a supplier.").show();
            return;
        }

        try {

            SupplierDTO supplierDTO = new SupplierDTO(
                    Integer.parseInt(txtId.getText()),
                    txtSupplierName.getText(),
                    txtEmail.getText(),
                    txtContactNo.getText()
            );

            boolean isUpdated = supplierBO.update(supplierDTO);

            if (isUpdated) {
                new Alert(Alert.AlertType.INFORMATION, "Supplier Updated Successfully").show();
                loadAllSuppliers();
                clearFields();
            } else {
                new Alert(Alert.AlertType.ERROR, "Failed to Update Supplier").show();
            }

        } catch (Exception e) {
            new Alert(Alert.AlertType.ERROR, e.getMessage()).show();
        }
    }

    @FXML
    void handleDelete(ActionEvent event) {

        if (txtId.getText().isBlank()) {
            new Alert(Alert.AlertType.WARNING, "Please select a supplier.").show();
            return;
        }

        Alert alert = new Alert(
                Alert.AlertType.CONFIRMATION,
                "Delete this supplier?",
                ButtonType.YES,
                ButtonType.NO
        );

        if (alert.showAndWait().orElse(ButtonType.NO) == ButtonType.YES) {

            try {

                boolean isDeleted = supplierBO.delete(Integer.parseInt(txtId.getText()));

                if (isDeleted) {
                    new Alert(Alert.AlertType.INFORMATION, "Supplier Deleted Successfully").show();
                    loadAllSuppliers();
                    clearFields();
                } else {
                    new Alert(Alert.AlertType.ERROR, "Failed to Delete Supplier").show();
                }

            } catch (Exception e) {
                new Alert(Alert.AlertType.ERROR, e.getMessage()).show();
            }
        }
    }

    @FXML
    void handleReset(ActionEvent event) {
        clearFields();
    }

    private void clearFields() {
        txtId.clear();
        txtSupplierName.clear();
        txtEmail.clear();
        txtContactNo.clear();
        tblSuppliers.getSelectionModel().clearSelection();
    }

}