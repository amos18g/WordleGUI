package com.example.poyectofinal;

import com.example.poyectofinal.modelo.ControladorPalabras;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

import java.net.URL;
import java.util.ResourceBundle;

public class HelloController implements Initializable {

    private int numControladorFilas = 0;
    private boolean palabraEnviada = false;
    private String palabra;
    private String palabraLabel;


    private Label[] arregloLabel;
    private boolean comprobarPalabraResultado = false;

    //Propiedades visuales
    @FXML
    private Label lbGano;

    @FXML
    private Label lbPerdio;

    @FXML
    private Label lbPerdio1;

    @FXML
    private Label lbPerdio2;

    @FXML
    private Label label21;

    @FXML
    private Label label20;

    @FXML
    private Label label25;

    @FXML
    private Label label24;

    @FXML
    private Label label23;

    @FXML
    private Label label22;

    @FXML
    private Label label4;

    @FXML
    private Label label5;

    @FXML
    private Label label6;

    @FXML
    private Label label7;

    @FXML
    private Label label8;

    @FXML
    private Label label9;

    @FXML
    private Label label18;

    @FXML
    private TextField txtPalabra;

    @FXML
    private Label label17;

    @FXML
    private Label label16;

    @FXML
    private Button btnEnviar;

    @FXML
    private Button btnComprobarPalabra;

    @FXML
    private Label label30;

    @FXML
    private Label label29;

    @FXML
    private Label label28;

    @FXML
    private Label label27;

    @FXML
    private Label label26;

    @FXML
    private Label label15;

    @FXML
    private Label label19;

    @FXML
    private Label label10;

    @FXML
    private Label label14;

    @FXML
    private Label label1;

    @FXML
    private Label label13;

    @FXML
    private Label label2;

    @FXML
    private Label label12;

    @FXML
    private Label label3;

    @FXML
    private Label label11;

    //Propiedades visuales


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        arregloLabel = new Label[]{label1, label2, label3,label4,label5, label6, label7, label8,label9,label10,
                label11, label12, label13,label14,label15, label16, label17, label18,label19,label20,
                label21, label22, label23,label24,label25, label26, label27, label28,label29,label30
        };
        ControladorPalabras controladorPalabras = new ControladorPalabras();
        controladorPalabras.determinarPalabra();
        palabra = controladorPalabras.getPalabra();


    }

    @FXML
    void enviarPalabra(ActionEvent event) {


        try {


            String palabra = this.txtPalabra.getText();


            palabraEnviada = ControladorPalabras.enviarPalabraLabel(arregloLabel, palabra, numControladorFilas);

            if(palabraEnviada){
                this.palabraLabel = palabra;
            }




        } catch (Exception e) {
            System.out.println(e.getMessage());

        }

    }



    @FXML
    void comprobarPalabra(ActionEvent event) {





        if(this.palabraEnviada){

            this.palabraEnviada = false;


            //TODO: aca ira la logica para comparar las palabras
            this.comprobarPalabraResultado = ControladorPalabras.comparacionPalabras(this.arregloLabel,this.numControladorFilas,this.palabra,this.palabraLabel);


            //TODO: logica para cambiar de fila en arregloLabel

            this.numControladorFilas += 5;



            if(!(arregloLabel[29].getText() == "") || this.comprobarPalabraResultado){//Desactiva los botones Enviar Palabra y comprobar palabra ya que
                //los intentos han terminado
                txtPalabra.setEditable(false);
                this.btnEnviar.setDisable(true);
                this.btnComprobarPalabra.setDisable(true);

                //mostrando el texto de juego finalizado
                if(this.comprobarPalabraResultado){

                    this.lbGano.setVisible(true);
                }else{

                    this.lbPerdio.setVisible(true);
                    this.lbPerdio1.setVisible(true);
                    this.lbPerdio2.setText(this.palabra);
                    this.lbPerdio2.setVisible(true);
                }

            }
        }

    }


}