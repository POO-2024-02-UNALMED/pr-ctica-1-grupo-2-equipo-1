package gestorAplicacion.servicios;

import java.util.ArrayList;
import gestorAplicacion.entidades.Torneo;

import java.util.Objects;
import java.util.Scanner;

public class Reglas {
    private ArrayList<String> reglas;
    private String deporte;

    Scanner scanner = new Scanner(System.in);

    public void setDeporte(){
        this.deporte = Torneo.deporte; //Errror
    }

    public String setReglas(){
        System.out.println("Para el deporte seleccionado se pueden modificar las siguientes reglas:\n");
        switch(deporte){
            case "Futbol":
                System.out.println("Sustituciones máximas: mínimo 2, máximo 7.\n" +
                        "Duración del partido: 30 o 90 minutos (Se agregarán 30 minutos más a la reserva).\n" +
                        "Criterios de desempate: Diferencia de goles, goles a favor, goles en contra o sorteo.\n" +
                        "En este caso deberán ser ingresados en orden de prioridad. Además, despúes de sorteo no podrán ir más criterios de desempate.");

                System.out.println("Ingrese la cantidad de susticiones máximas.");
                int Sustituciones = scanner.nextInt();
                if ((Sustituciones < 2) || (Sustituciones > 7)){
                    break;
                } else {
                    reglas.add(Integer.toString(Sustituciones));
                }

                System.out.println("Ingrese la duración del partido.");
                int Duracion = scanner.nextInt();
                if ((Duracion < 30) || (Duracion > 90)){
                    break;
                } else {
                    reglas.add(Integer.toString(Duracion));
                }

                ArrayList<String> Criterios = new ArrayList<>();
                System.out.println("Ingrese los criterios de desempate en orden de prioridad.");

                while(!Criterios.contains("Sorteo")){
                    String Criterio = scanner.next();
                    Criterios.add(Criterio);
                }
                System.out.println("Las siguientes serán las reglas personalizadas para este torneo:"); //ARREGLAR - Puede genrar un error si se pone sorteo como una opcion distinta a la ultima
                System.out.println("Sustituciones máximas:" + Criterios.getFirst());
                System.out.println("Duración del partido:" + Criterios.get(1));
                System.out.println("Criterios de desempate:" + Criterios.get(2));



                return "";
            case "Baloncesto":
                return "";
            case "Natación":
                return "";
            case "Voleibol":
                return "";
        }
    }

}