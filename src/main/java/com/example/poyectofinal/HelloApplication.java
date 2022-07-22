package com.example.poyectofinal;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class HelloApplication extends Application {
    @Override
    public void start(Stage stage) throws IOException {


        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("inicio-vista.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 863, 620);
        stage.setTitle("INCIO");


        stage.setScene(scene);

        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}