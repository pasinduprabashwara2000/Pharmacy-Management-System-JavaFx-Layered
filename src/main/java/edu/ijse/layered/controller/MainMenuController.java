package edu.ijse.layered.controller;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.StackPane;
import java.io.IOException;
import java.net.URL;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ResourceBundle;

public class MainMenuController implements Initializable {

    // ── Sidebar buttons ──────────────────────────────────────
    @FXML
    private Button btnDashboard;

    @FXML
    private Button btnCategory;

    @FXML
    private Button btnMedicines;

    @FXML
    private Button btnCustomers;

    @FXML
    private Button btnSuppliers;

    @FXML
    private Button btnEmployees;

    @FXML
    private Button btnOrders;

    @FXML
    private Button btnPrescriptions;

    @FXML
    private Button btnReports;

    @FXML
    private Button btnLogout;

    // ── Top bar ──────────────────────────────────────────────
    @FXML
    private Label lblPageTitle;

    @FXML
    private Label lblDateTime;

    @FXML
    private Label lblUserName;

    // ── Content area ─────────────────────────────────────────
    @FXML private StackPane pageContent;

    private Button activeButton;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // Set date/time
        String now = LocalDateTime.now()
                .format(DateTimeFormatter.ofPattern("dd MMM yyyy  |  hh:mm a"));
        lblDateTime.setText(now);

        // Default active button
        setActive(btnDashboard, "Dashboard");
    }

    // ── Navigation handlers ──────────────────────────────────

    @FXML
    private void handleDashboard() {
        setActive(btnDashboard, "Dashboard");
        loadPage("Dashboard.fxml");
    }

    @FXML
    private void handleCategory() {
        setActive(btnCategory, "Manage Category");
        loadPage("ManageCategory.fxml");
    }

    @FXML
    private void handleMedicines() {
        setActive(btnMedicines, "Manage Medicines");
        loadPage("ManageMedicine.fxml");
    }

    @FXML
    private void handleCustomers() {
        setActive(btnCustomers, "Manage Customers");
        loadPage("ManageCustomer.fxml");
    }

    @FXML
    private void handleSuppliers() {
        setActive(btnSuppliers, "Manage Suppliers");
        loadPage("ManageSupplier.fxml");
    }

    @FXML
    private void handleEmployees() {
        setActive(btnEmployees, "Manage Employees");
        loadPage("ManageEmployee.fxml");
    }

    @FXML
    private void handleOrders() {
        setActive(btnOrders, "Orders");
        loadPage("Orders.fxml");
    }

    @FXML
    private void handlePrescriptions() {
        setActive(btnPrescriptions, "Prescriptions");
        loadPage("Prescriptions.fxml");
    }

    @FXML
    private void handleReports() {
        setActive(btnReports, "Reports");
        loadPage("Reports.fxml");
    }

    @FXML
    private void handleLogout() {
        try {
            AnchorPane loginPane = FXMLLoader.load(
                    getClass().getResource("/view/Login.fxml"));
            pageContent.getScene().setRoot(loginPane);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // ── Helpers ──────────────────────────────────────────────

    /**
     * Switches the active style class to the chosen nav button
     * and updates the top-bar page title.
     */
    private void setActive(Button target, String title) {
        if (activeButton != null) {
            activeButton.getStyleClass().remove("nav-btn-active");
        }
        target.getStyleClass().add("nav-btn-active");
        activeButton = target;
        lblPageTitle.setText(title);
    }

    /**
     * Loads an FXML file into the central content StackPane.
     */
    private void loadPage(String fxmlFile) {
        try {
            AnchorPane page = FXMLLoader.load(
                    getClass().getResource("/edu/ijse/layered/" + fxmlFile));
            pageContent.getChildren().setAll(page);
        } catch (IOException e) {
            e.printStackTrace();
            System.err.println("Could not load: " + fxmlFile);
        }
    }
}