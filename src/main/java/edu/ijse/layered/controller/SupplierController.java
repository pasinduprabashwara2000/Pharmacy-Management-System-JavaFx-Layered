package edu.ijse.layered.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;

public class SupplierController {

    @FXML
    private Button btnDelete;

    @FXML
    private Button btnReset;

    @FXML
    private Button btnSave;

    @FXML
    private Button btnUpdate;

    @FXML
    private TableColumn<?, ?> colContactNo;

    @FXML
    private TableColumn<?, ?> colEmail;

    @FXML
    private TableColumn<?, ?> colSupplierId;

    @FXML
    private TableColumn<?, ?> colSupplierName;

    @FXML
    private TableView<?> tblSuppliers;

    @FXML
    private TextField txtContactNo;

    @FXML
    private TextField txtEmail;

    @FXML
    private TextField txtSupplierName;

    @FXML
    void handleDelete(ActionEvent event) {

    }

    @FXML
    void handleReset(ActionEvent event) {

    }

    @FXML
    void handleSave(ActionEvent event) {

    }

    @FXML
    void handleUpdate(ActionEvent event) {

    }

}
