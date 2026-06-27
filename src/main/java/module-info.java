module edu.ijse.layered {
    requires javafx.controls;
    requires javafx.fxml;
    requires static lombok;
    requires jakarta.persistence;
    requires org.hibernate.orm.core;


    opens edu.ijse.layered to javafx.fxml;
    exports edu.ijse.layered;
}