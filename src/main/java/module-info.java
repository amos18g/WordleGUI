module com.example.poyectofinal {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.poyectofinal to javafx.fxml;
    exports com.example.poyectofinal;
}