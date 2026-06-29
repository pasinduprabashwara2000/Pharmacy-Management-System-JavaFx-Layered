package edu.ijse.layered.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;

public class CategoryController {

    @FXML
    private Button btnDelete;

    @FXML
    private Button btnReset;

    @FXML
    private Button btnSave;

    @FXML
    private Button btnUpdate;

    @FXML
    private TableColumn<?, ?> colCategoryId;

    @FXML
    private TableColumn<?, ?> colCategoryName;

    @FXML
    private TableView<?> tblCategories;

    @FXML
    private TextField txtCategoryName;

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
