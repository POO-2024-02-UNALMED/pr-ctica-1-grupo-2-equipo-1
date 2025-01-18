/*Archivo principal del programa

        Donde se programa la UI de consola del programa

        NO CAMBIAR SIN PREGUNTAR PRECAUCION

        */

//Falta logica para cada opcion. Simplemente es una idea de lo que puede ser la base. Hay "errores" en el switch


// Se crean instalaciones basicas

//Agregar descripciones de las instalaciones

package uiMain;

import gestorAplicacion.entidades.Instalacion;
import gestorAplicacion.entidades.Reserva;
import gestorAplicacion.entidades.Cliente;
import gestorAplicacion.entidades.Horario;

import java.util.ArrayList;
import java.util.List;
import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Creación de todas las instalaciones
        ArrayList<Instalacion> instalaciones = crearInstalaciones();

        // Llamar a asignarHorarios para asignar horarios a las instalaciones
        asignarHorarios(instalaciones);

        boolean salir = false;

        // Menú principal
        while (!salir) {
            System.out.println("\n===== Menú Principal =====");
            System.out.println("1. Realizar Reservas");
            System.out.println("2. Realizar Inscripciones a Deportes Formativos");
            System.out.println("3. Crear Torneos");
            System.out.println("4. Crear Eventos (Concierto)");
            System.out.println("5. Taquilla (Pagos)");
            System.out.println("6. Salir");
            System.out.print("Seleccione una opción: ");

            int opcion = scanner.nextInt();

            switch (opcion) {
                case 1:
                    realizarReservas(scanner, instalaciones);
                    break;

                case 2:
                    realizarInscripciones(scanner);
                    break;

                case 3:
                    crearTorneos(scanner);
                    break;

                case 4:
                    crearEventos(scanner);
                    break;

                case 5:
                    gestionarTaquilla(scanner);
                    break;

                case 6:
                    System.out.println("Saliendo del sistema. ¡Hasta pronto!");
                    salir = true;
                    break;

                default:
                    System.out.println("Opción inválida. Por favor, seleccione una opción del 1 al 6.");
            }
        }

        scanner.close();
    }

    // Método para crear todas las instalaciones predeterminadas
    private static ArrayList<Instalacion> crearInstalaciones() {
        ArrayList<Instalacion> instalaciones = new ArrayList<>();
        instalaciones.add(new Instalacion("Cancha F11 Grande", "Futbol", 120, 0, ""));
        instalaciones.add(new Instalacion("Cancha F11", "Futbol", 100, 0, ""));
        instalaciones.add(new Instalacion("Cancha F9", "Futbol", 80, 0, ""));
        instalaciones.add(new Instalacion("Cancha F7", "Futbol", 60, 0, ""));
        instalaciones.add(new Instalacion("Coliseo Basket", "Baloncesto", 120, 0, ""));
        instalaciones.add(new Instalacion("Cancha Basket 1", "Baloncesto", 80, 0, ""));
        instalaciones.add(new Instalacion("Cancha Basket 2", "Baloncesto", 80, 0, ""));
        instalaciones.add(new Instalacion("Piscina Olímpica", "Natación", 120, 3, ""));
        instalaciones.add(new Instalacion("Piscina Semi Olímpica", "Natación", 100, 2, ""));
        instalaciones.add(new Instalacion("Piscina Infantil", "Natación", 80, 1, ""));
        instalaciones.add(new Instalacion("Cancha Voleibol Arena", "Voleibol", 100, 0, ""));
        instalaciones.add(new Instalacion("Cancha Voleibol Cemento 1", "Voleibol", 80, 0, ""));
        instalaciones.add(new Instalacion("Cancha Voleibol Cemento 2", "Voleibol", 80, 0, ""));
        return instalaciones;
    }

    private static void asignarHorarios(ArrayList<Instalacion> instalaciones) {
        // Implementación de asignación de horarios
    }

    private static void realizarReservas(Scanner scanner, ArrayList<Instalacion> instalaciones) {
        // Implementación del método para realizar reservas
    }

    private static void realizarInscripciones(Scanner scanner) {
        // Implementación del método para realizar inscripciones a deportes formativos
    }

    private static void crearTorneos(Scanner scanner) {
        // Implementación del método para crear torneos
    }

    private static void crearEventos(Scanner scanner) {
        // Implementación del método para crear eventos (conciertos)
    }

    private static void gestionarTaquilla(Scanner scanner) {
        // Implementación del método para gestionar la taquilla
    }
}