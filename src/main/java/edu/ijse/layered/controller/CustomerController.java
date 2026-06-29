package edu.ijse.layered.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;

public class CustomerController {

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
    private TableColumn<?, ?> colCustomerId;

    @FXML
    private TableColumn<?, ?> colEmail;

    @FXML
    private TableColumn<?, ?> colFullName;

    @FXML
    private TableView<?> tblCustomers;

    @FXML
    private TextField txtContactNo;

    @FXML
    private TextField txtEmail;

    @FXML
    private TextField txtFullName;

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
