module com.dht.englishapp {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql;

    opens com.dht.englishapp to javafx.fxml;
    exports com.dht.englishapp;
    exports com.dht.services;
    exports com.dht.pojo;
}
