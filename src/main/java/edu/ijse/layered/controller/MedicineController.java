package edu.ijse.layered.controller;

import edu.ijse.layered.bo.BOFactory;
import edu.ijse.layered.bo.custom.MedicineBO;
import edu.ijse.layered.dto.MedicineDTO;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;

public class MedicineController {

    private final MedicineBO medicineBO = (MedicineBO) BOFactory.getInstance().getBO(BOFactory.BOTypes.MEDICINE);

    @FXML
    private Button btnDelete;

    @FXML
    private Button btnReset;

    @FXML
    private Button btnSave;

    @FXML
    private Button btnUpdate;

    @FXML
    private ComboBox<Integer> cmbCategory;

    @FXML
    private ComboBox<Integer> cmbSupplier;

    @FXML
    private TableColumn<MedicineDTO, Integer> colMedicineId;

    @FXML
    private TableColumn<MedicineDTO, String> colName;

    @FXML
    private TableColumn<MedicineDTO, Integer> colCategory;

    @FXML
    private TableColumn<MedicineDTO, Integer> colSupplier;

    @FXML
    private TableColumn<MedicineDTO, Double> colUnitPrice;

    @FXML
    private TableColumn<MedicineDTO, Integer> colQtyOnHand;

    @FXML
    private TableColumn<MedicineDTO, Object> colExpireDate;

    @FXML
    private DatePicker datePicker;

    @FXML
    private TableView<MedicineDTO> tblMedicines;

    @FXML
    private TextField txtId;

    @FXML
    private TextField txtName;

    @FXML
    private TextField txtQtyOnHand;

    @FXML
    private TextField txtUnitPrice;

    @FXML
    public void initialize() {

        colMedicineId.setCellValueFactory(new PropertyValueFactory<>("medicineId"));
        colName.setCellValueFactory(new PropertyValueFactory<>("medicineName"));
        colCategory.setCellValueFactory(new PropertyValueFactory<>("categoryId"));
        colSupplier.setCellValueFactory(new PropertyValueFactory<>("supplierId"));
        colUnitPrice.setCellValueFactory(new PropertyValueFactory<>("unitPrice"));
        colQtyOnHand.setCellValueFactory(new PropertyValueFactory<>("qtyOnHand"));
        colExpireDate.setCellValueFactory(new PropertyValueFactory<>("expireDate"));

        loadAllMedicines();

        tblMedicines.getSelectionModel().selectedItemProperty().addListener((observable, oldValue, medicine) -> {
            if (medicine != null) {
                txtId.setText(String.valueOf(medicine.getMedicineId()));
                txtName.setText(medicine.getName());
                cmbCategory.setValue(medicine.getCategoryId());
                cmbSupplier.setValue(medicine.getSupplierId());
                txtUnitPrice.setText(String.valueOf(medicine.getUnitPrice()));
                txtQtyOnHand.setText(String.valueOf(medicine.getQtyOnHand()));
                datePicker.setValue(medicine.getExpireDate());
            }
        });
    }

    private void loadAllMedicines() {
        try {
            tblMedicines.getItems().clear();
            tblMedicines.getItems().addAll(medicineBO.getAll());
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @FXML
    void handleSave(ActionEvent event) {

        try {

            MedicineDTO medicineDTO = new MedicineDTO(
                    0,
                    txtName.getText(),
                    cmbCategory.getValue(),
                    cmbSupplier.getValue(),
                    Double.parseDouble(txtUnitPrice.getText()),
                    Integer.parseInt(txtQtyOnHand.getText()),
                    datePicker.getValue()
            );

            boolean isSaved = medicineBO.save(medicineDTO);

            if (isSaved) {
                new Alert(Alert.AlertType.INFORMATION, "Medicine Saved Successfully").show();
                loadAllMedicines();
                clearFields();
            } else {
                new Alert(Alert.AlertType.ERROR, "Failed to Save Medicine").show();
            }

        } catch (Exception e) {
            new Alert(Alert.AlertType.ERROR, e.getMessage()).show();
        }
    }

    @FXML
    void handleUpdate(ActionEvent event) {

        try {

            MedicineDTO medicineDTO = new MedicineDTO(
                    Integer.parseInt(txtId.getText()),
                    txtName.getText(),
                    cmbCategory.getValue(),
                    cmbSupplier.getValue(),
                    Double.parseDouble(txtUnitPrice.getText()),
                    Integer.parseInt(txtQtyOnHand.getText()),
                    datePicker.getValue()
            );

            boolean isUpdated = medicineBO.update(medicineDTO);

            if (isUpdated) {
                new Alert(Alert.AlertType.INFORMATION, "Medicine Updated Successfully").show();
                loadAllMedicines();
                clearFields();
            } else {
                new Alert(Alert.AlertType.ERROR, "Failed to Update Medicine").show();
            }

        } catch (Exception e) {
            new Alert(Alert.AlertType.ERROR, e.getMessage()).show();
        }
    }

    @FXML
    void handleDelete(ActionEvent event) {

        try {

            int medicineId = Integer.parseInt(txtId.getText());

            boolean isDeleted = medicineBO.delete(medicineId);

            if (isDeleted) {
                new Alert(Alert.AlertType.INFORMATION, "Medicine Deleted Successfully").show();
                loadAllMedicines();
                clearFields();
            } else {
                new Alert(Alert.AlertType.ERROR, "Failed to Delete Medicine").show();
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
        txtName.clear();
        txtUnitPrice.clear();
        txtQtyOnHand.clear();

        cmbCategory.getSelectionModel().clearSelection();
        cmbSupplier.getSelectionModel().clearSelection();
        datePicker.setValue(null);

        tblMedicines.getSelectionModel().clearSelection();
    }
}