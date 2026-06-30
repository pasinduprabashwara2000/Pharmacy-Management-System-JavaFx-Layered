module edu.ijse.layered {

    requires javafx.controls;
    requires javafx.fxml;

    requires jakarta.persistence;
    requires org.hibernate.orm.core;

    requires java.naming;
    requires java.sql;

    requires static lombok;

    exports edu.ijse.layered;

    opens edu.ijse.layered.controller to javafx.fxml;
    opens edu.ijse.layered.entity to org.hibernate.orm.core;
    opens edu.ijse.layered.dto to javafx.base;
    opens edu.ijse.layered.dao.custom.impl to org.hibernate.orm.core;

}