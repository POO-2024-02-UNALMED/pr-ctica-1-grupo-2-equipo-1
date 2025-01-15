package gestorAplicacion.servicios;

import java.util.ArrayList;

import gestorAplicacion.entidades.Torneo;

import javax.swing.*;
import java.util.Scanner;

public class Reglas {
    private ArrayList<String> reglas;
    private String deporte;

    public void setDeporte(){
        this.deporte = Torneo.deporte; //Errror
    }

    public String setReglas(){
        switch(deporte){
            case "Futbol":
                return "";
                break;
            case "Baloncesto":
                return "";
                break;
            case "Natación":
                return "";
                break;
            case "Voleibol":
                return "";
                break;
        }
    }

}
