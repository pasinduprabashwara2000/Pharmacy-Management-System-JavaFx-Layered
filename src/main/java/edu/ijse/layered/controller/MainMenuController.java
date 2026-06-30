package edu.ijse.layered.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class MainMenuController {

    @FXML
    private Button btnCategory;

    @FXML
    private Button btnCustomers;

    @FXML
    private Button btnDashboard;

    @FXML
    private Button btnEmployees;

    @FXML
    private Button btnLogout;

    @FXML
    private Button btnMedicines;

    @FXML
    private Button btnOrders;

    @FXML
    private Button btnPayments;

    @FXML
    private Button btnReports;

    @FXML
    private Button btnReturn;

    @FXML
    private Button btnSuppliers;

    @FXML
    private AnchorPane contentArea;

    @FXML
    private Label lblDateTime;

    @FXML
    private Label lblPageTitle;

    @FXML
    private Label lblUserName;

    @FXML
    private StackPane pageContent;

    @FXML
    private VBox sidebar;

    @FXML
    private ScrollPane sidebarScroll;

    @FXML
    public void initialize() {
        lblUserName.setText("Admin");
        updateDateTime();
        handleDashboard(null);
    }

    private void updateDateTime() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");
        lblDateTime.setText(LocalDateTime.now().format(formatter));
    }

    @FXML
    void handleDashboard(ActionEvent event) {
        lblPageTitle.setText("Dashboard");
        loadPage("Dashboard.fxml");
    }

    @FXML
    void handleCustomers(ActionEvent event) {
        lblPageTitle.setText("Manage Customers");
        loadPage("ManageCustomer.fxml");
    }

    @FXML
    void handleCategory(ActionEvent event) {
        lblPageTitle.setText("Manage Categories");
        loadPage("ManageCategory.fxml");
    }

    @FXML
    void handleSuppliers(ActionEvent event) {
        lblPageTitle.setText("Manage Suppliers");
        loadPage("ManageSupplier.fxml");
    }

    @FXML
    void handleMedicines(ActionEvent event) {
        lblPageTitle.setText("Manage Medicines");
        loadPage("ManageMedicine.fxml");
    }

    @FXML
    void handleEmployees(ActionEvent event) {
        lblPageTitle.setText("Manage Employees");
        loadPage("ManageEmployee.fxml");
    }

    @FXML
    void handleOrders(ActionEvent event) {
        lblPageTitle.setText("Orders");
        loadPage("Order.fxml");
    }

    @FXML
    void handlePayments(ActionEvent event) {
        lblPageTitle.setText("Manage Payments");
        loadPage("ManagePayment.fxml");
    }

    @FXML
    void handleReturn(ActionEvent event) {
        lblPageTitle.setText("Manage Returns");
        loadPage("ManageReturn.fxml");
    }

    @FXML
    void handleReports(ActionEvent event) {
        lblPageTitle.setText("Reports");
        loadPage("Report.fxml");
    }

    @FXML
    void handleLogout(ActionEvent event) {
        try {
            Parent root = FXMLLoader.load(getClass().getResource("Login.fxml"));

            Stage stage = (Stage) btnLogout.getScene().getWindow();
            stage.setScene(new Scene(root));
            stage.setTitle("Login");
            stage.centerOnScreen();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void loadPage(String fxmlFile) {
        try {
            Parent root = FXMLLoader.load(getClass().getResource("/edu/ijse/layered/"+fxmlFile));

            pageContent.getChildren().clear();
            pageContent.getChildren().add(root);

        } catch (IOException e) {
            System.err.println("Cannot load: " + fxmlFile);
            e.printStackTrace();
        }
    }
}