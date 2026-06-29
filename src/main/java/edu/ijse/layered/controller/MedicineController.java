package edu.ijse.layered.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;

public class MedicineController {

    @FXML
    private Button btnDelete;

    @FXML
    private Button btnReset;

    @FXML
    private Button btnSave;

    @FXML
    private Button btnUpdate;

    @FXML
    private ComboBox<?> cmbCategory;

    @FXML
    private ComboBox<?> cmbSupplier;

    @FXML
    private TableColumn<?, ?> colCategory;

    @FXML
    private TableColumn<?, ?> colExpireDate;

    @FXML
    private TableColumn<?, ?> colMedicineId;

    @FXML
    private TableColumn<?, ?> colName;

    @FXML
    private TableColumn<?, ?> colQtyOnHand;

    @FXML
    private TableColumn<?, ?> colSupplier;

    @FXML
    private TableColumn<?, ?> colUnitPrice;

    @FXML
    private DatePicker datePicker;

    @FXML
    private TableView<?> tblMedicines;

    @FXML
    private TextField txtName;

    @FXML
    private TextField txtQtyOnHand;

    @FXML
    private TextField txtUnitPrice;

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
