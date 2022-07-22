package com.example.poyectofinal;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Modality;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class InicioController implements Initializable {


    @FXML
    private Button btnAbrir;
    @FXML
    private ImageView imageView;
    private Image image;


    @FXML
    public void abrirJuego(ActionEvent event) throws IOException {
        //llamando a la ventana ventena secundaria

        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("hello-view.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 720, 550);
        Stage stage  = new Stage();
        stage.setTitle("WORDLE APP!");
        stage.setResizable(false);
        stage.initModality(Modality.APPLICATION_MODAL);


        stage.setScene(scene);

        stage.show();
        btnAbrir.setText("nada");


        //cerrando la ventana actual
        Stage stage2 = (Stage) btnAbrir.getScene().getWindow();
        stage2.close();
    }


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        image = new Image("file:src/main/java/com/example/poyectofinal/imagenes/disenioPrincipal.jpg");
        imageView.setImage(image);

    }
}
