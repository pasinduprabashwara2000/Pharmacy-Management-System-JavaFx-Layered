module edu.ijse.layered {
    requires javafx.controls;
    requires javafx.fxml;
    requires static lombok;
    requires jakarta.persistence;
    requires org.hibernate.orm.core;
    requires java.naming;

    opens edu.ijse.layered.controller to javafx.fxml;
    exports edu.ijse.layered;
}