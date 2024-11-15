module com.example.ormcw {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.ormcw to javafx.fxml;
    exports com.example.ormcw;
}