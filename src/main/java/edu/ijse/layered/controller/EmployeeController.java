package edu.ijse.layered.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;

public class EmployeeController {

    @FXML
    private Button btnDelete;

    @FXML
    private Button btnReset;

    @FXML
    private Button btnSave;

    @FXML
    private Button btnUpdate;

    @FXML
    private ComboBox<?> cmbRole;

    @FXML
    private TableColumn<?, ?> colContactNo;

    @FXML
    private TableColumn<?, ?> colEmployeeId;

    @FXML
    private TableColumn<?, ?> colFullName;

    @FXML
    private TableColumn<?, ?> colRole;

    @FXML
    private TableColumn<?, ?> colSalary;

    @FXML
    private TableView<?> tblEmployees;

    @FXML
    private TextField txtContactNo;

    @FXML
    private TextField txtFullName;

    @FXML
    private TextField txtSalary;

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
