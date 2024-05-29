module com.example.evaluation_dardari_gwendoline {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql;


    opens com.example.evaluation_dardari_gwendoline to javafx.fxml;
    exports com.example.evaluation_dardari_gwendoline;
}