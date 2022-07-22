package com.example.poyectofinal.modelo;

import javafx.scene.control.Label;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Locale;
import java.util.Scanner;

public class ControladorPalabras {

    //atributos
    private String palabra;

    //Comparara las palabras y le dara colo a los label dependiendo que tan acertado este cada letra
    public static boolean comparacionPalabras(Label[] arregloLabel, int contador, String palabraDet, String palabra){

        if(palabraDet.equals(palabra)){//CASO 1: SE ADIVINA LA PALABRA

            for(int i= contador; i<contador+5; i++){
                arregloLabel[i].setStyle("-fx-background-color: '3cb334'; -fx-text-fill: black;");
            }

            return true;
        }

        else{//CASO 2: NO SE ADIVINA LA LA PABRA O SE ADIVINA PARCIALMENTE
            for(int i = 0; i < 5; i++ ){
                for(int j=0 ; j<5;j++){
                    if(palabra.charAt(i) == palabraDet.charAt(j) ){//if 1
                        if(i==j){
                            arregloLabel[contador].setStyle("-fx-background-color: '3cb334'; -fx-text-fill: black;");
                        }else{
                            arregloLabel[contador].setStyle("-fx-background-color: yellow; -fx-text-fill: black;");
                        }
                    }//end if1
                    else if(!palabraDet.contains(palabra.substring(i, i+1))){
                        arregloLabel[contador].setStyle("-fx-background-color: '606059'; -fx-text-fill: yellow;");
                    }
                }
                contador++;
            }

        }
        return false;

    }

    //envia la pabra ingresada, a los Label y devuelve el nuevo numero controlador de filas del arregloLabel
    public static boolean enviarPalabraLabel(Label[] arregloLabel, String palabra, int numControlador){



        if((palabra.length() == 5 && palabra.equals(palabra.toUpperCase(Locale.ROOT))) && palabra != null) {
            int numAux = numControlador;
            numControlador += 5;
            int i = 0;
            for (numAux = numAux; numAux < numControlador; numAux++) {
                arregloLabel[numAux].setText(String.valueOf(palabra.charAt(i)));
                i++;
            }

            return true;

        }
            return false;
    }



    public String getPalabra() {
        return palabra;
    }

    public void determinarPalabra(){ //determina una palabra de manera aleatoria sin posibilidad de tomar la anterior
        String ruta = "src/main/java/com/example/poyectofinal/modelo/palabras.txt";
        FileReader fileReader;
        String palabra = "";
        try {
            fileReader = new FileReader(ruta);
            Scanner scanner = new Scanner(fileReader);
            int i=1;
            int numeroAleatorio = this.obtenerNumeroAleatorio();

            while (!(i == numeroAleatorio)){
                scanner.nextLine();
                i+=1;
                }
                palabra = scanner.nextLine();





            scanner.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        this.palabra = palabra;

    }

    private int obtenerNumeroAleatorio(){
        int numAux = 0;


        FileReader fileReader;
        int numAleatorio = 0;
        try {
            fileReader = new FileReader("src/main/java/com/example/poyectofinal/modelo/almacenar_numeroAleatorio.txt");

            Scanner scanner = new Scanner(fileReader);
            numAleatorio = scanner.nextInt();

            scanner.close();
            fileReader.close();

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        numAux = numAleatorio;

        while(numAleatorio == numAux){
            numAux  = (int)(Math.random()*10 + 1);
        }

        this.escribirNuevoNumAleatorio(numAux);

        return numAux;
    }

    private void escribirNuevoNumAleatorio(int num){
        try {

            FileWriter fileWriter = new FileWriter("src/main/java/com/example/poyectofinal/modelo/almacenar_numeroAleatorio.txt");
            fileWriter.write(String.valueOf(num));
            fileWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }


}
