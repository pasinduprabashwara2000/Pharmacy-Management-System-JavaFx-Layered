package edu.ijse.layered.controller;

import edu.ijse.layered.bo.BOFactory;
import edu.ijse.layered.bo.custom.CategoryBO;
import edu.ijse.layered.dto.CategoryDTO;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;

public class CategoryController {

    private final CategoryBO categoryBO = (CategoryBO) BOFactory.getInstance().getBO(BOFactory.BOTypes.CATEGORY);

    @FXML
    private Button btnDelete;

    @FXML
    private Button btnReset;

    @FXML
    private Button btnSave;

    @FXML
    private Button btnUpdate;

    @FXML
    private TableColumn<CategoryDTO, Integer> colCategoryId;

    @FXML
    private TableColumn<CategoryDTO, String> colCategoryName;

    @FXML
    private TableView<CategoryDTO> tblCategories;

    @FXML
    private TextField txtId;

    @FXML
    private TextField txtCategoryName;

    @FXML
    public void initialize() {

        colCategoryId.setCellValueFactory(new PropertyValueFactory<>("categoryId"));
        colCategoryName.setCellValueFactory(new PropertyValueFactory<>("categoryName"));

        loadAllCategories();

        tblCategories.getSelectionModel().selectedItemProperty().addListener((observable, oldValue, category) -> {
            if (category != null) {
                txtId.setText(String.valueOf(category.getCategoryId()));
                txtCategoryName.setText(category.getCategoryName());
            }
        });
    }

    private void loadAllCategories() {
        try {
            tblCategories.getItems().clear();
            tblCategories.getItems().addAll(categoryBO.getAll());
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @FXML
    void handleSave(ActionEvent event) {

        try {

            CategoryDTO categoryDTO = new CategoryDTO(
                    0,
                    txtCategoryName.getText()
            );

            boolean isSaved = categoryBO.save(categoryDTO);

            if (isSaved) {
                new Alert(Alert.AlertType.INFORMATION, "Category Saved Successfully").show();
                loadAllCategories();
                clearFields();
            } else {
                new Alert(Alert.AlertType.ERROR, "Failed to Save Category").show();
            }

        } catch (Exception e) {
            new Alert(Alert.AlertType.ERROR, e.getMessage()).show();
        }
    }

    @FXML
    void handleUpdate(ActionEvent event) {

        try {

            CategoryDTO categoryDTO = new CategoryDTO(
                    Integer.parseInt(txtId.getText()),
                    txtCategoryName.getText()
            );

            boolean isUpdated = categoryBO.update(categoryDTO);

            if (isUpdated) {
                new Alert(Alert.AlertType.INFORMATION, "Category Updated Successfully").show();
                loadAllCategories();
                clearFields();
            } else {
                new Alert(Alert.AlertType.ERROR, "Failed to Update Category").show();
            }

        } catch (Exception e) {
            new Alert(Alert.AlertType.ERROR, e.getMessage()).show();
        }
    }

    @FXML
    void handleDelete(ActionEvent event) {

        try {

            int categoryId = Integer.parseInt(txtId.getText());

            boolean isDeleted = categoryBO.delete(categoryId);

            if (isDeleted) {
                new Alert(Alert.AlertType.INFORMATION, "Category Deleted Successfully").show();
                loadAllCategories();
                clearFields();
            } else {
                new Alert(Alert.AlertType.ERROR, "Failed to Delete Category").show();
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
        txtCategoryName.clear();

        tblCategories.getSelectionModel().clearSelection();
    }
}