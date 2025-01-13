package uiMain;/*
Archivo principal del programa

Donde se programa la UI de consola del programa

NO CAMBIAR SIN PREGUNTAR PRECAUCION

 */

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        System.out.println("Bienvenidos al programa de reservas");
        Scanner scanner = new Scanner(System.in);
        boolean corriendo = true;
        while (corriendo){
            System.out.println("Porfavor oprima el numero de la opcion que le interese y oprima enter");
            System.out.println("1: Hacer una reserva \n2: Observar una reserva\n3: Cancelar una reserva");

            int opcion = scanner.nextInt();

            switch(opcion){
                case 1:
                    System.out.println("seleccionaste hacer reserva");
                    corriendo = false;
                    break;

                case 2:
                    System.out.println("seleccionaste observar una reserva");
                    corriendo = false;
                    break;

                case 3:
                    System.out.println("seleccionaste cancelar una reserva");
                    corriendo = false;
                    break;

                default:
                    System.out.println("No seleccionaste una opcion dentro del rango por favor selecciona de nuevo");
            }
        }

    }
}