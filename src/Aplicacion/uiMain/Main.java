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
import gestorAplicacion.servicios.GestorReservas;
import gestorAplicacion.entidades.Acompanante;
import gestorAplicacion.entidades.Cliente;
import gestorAplicacion.entidades.Enfermero;
import gestorAplicacion.entidades.Horario;
import gestorAplicacion.entidades.Torneo;

import java.util.ArrayList;
import java.util.List;
import java.util.Arrays;
import java.util.Scanner;

import static gestorAplicacion.entidades.Torneo.crearTorneos;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Creación de todas las instalaciones
        ArrayList<Instalacion> instalaciones = crearInstalaciones();

        // Llamar a asignarHorarios para asignar horarios a las instalaciones
        asignarHorarios(instalaciones);

        // Crear enfermeros y acompañantes por defecto
        ArrayList<Enfermero> enfermeros = crearEnfermeros();
        ArrayList<Acompanante> acompanantes = crearAcompanantes();

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
                    realizarReservas(scanner, instalaciones, enfermeros, acompanantes);
                    break;

                case 2:
                    realizarInscripciones(scanner);
                    break;

                case 3:
                    crearTorneos();
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
    public static ArrayList<Instalacion> crearInstalaciones() {
        ArrayList<Instalacion> instalaciones = new ArrayList<>();

        // Instalaciones que no son Piscinas todas con capacidad 1(1 cupo)
        instalaciones.add(new Instalacion("Cancha F11 Grande", "Futbol", 120, 0, "", 1));
        instalaciones.add(new Instalacion("Cancha F11", "Futbol", 100, 0, "", 1));
        instalaciones.add(new Instalacion("Cancha F9", "Futbol", 80, 0, "", 1));
        instalaciones.add(new Instalacion("Cancha F7", "Futbol", 60, 0, "", 1));
        instalaciones.add(new Instalacion("Coliseo Basket", "Baloncesto", 120, 0, "", 1));
        instalaciones.add(new Instalacion("Cancha Basket 1", "Baloncesto", 80, 0, "", 1));
        instalaciones.add(new Instalacion("Cancha Basket 2", "Baloncesto", 80, 0, "", 1));
        instalaciones.add(new Instalacion("Cancha Voleibol Arena", "Voleibol", 100, 0, "", 1));
        instalaciones.add(new Instalacion("Cancha Voleibol Cemento 1", "Voleibol", 80, 0, "", 1));
        instalaciones.add(new Instalacion("Cancha Voleibol Cemento 2", "Voleibol", 80, 0, "", 1));

        // Instalaciones de piscina 
        instalaciones.add(new Instalacion("Piscina Olimpica", "Natacion", 120, 3, "", 3));  //capacidad 3
        instalaciones.add(new Instalacion("Piscina Semi Olimpica", "Natacion", 100, 2, "", 30));  //capacidad 30
        instalaciones.add(new Instalacion("Piscina Infantil", "Natacion", 80, 1, "", 20));  //capacidad 20

        return instalaciones;
    }

    private static void asignarHorarios(ArrayList<Instalacion> instalaciones) {
        // Días y horarios configurables
        String[] dias = {"Lunes", "Martes", "Miércoles", "Jueves", "Viernes", "Sábado", "Domingo"};
        String[] horas = {"08:00", "10:00", "12:00", "14:00", "16:00", "18:00"};
        
        // Iterar sobre cada instalación
        for (Instalacion instalacion : instalaciones) {
            ArrayList<Horario> horarios = new ArrayList<>();
            
            // Iterar sobre los días
            for (String dia : dias) {
                // Crear listas de horas y cupos disponibles
                ArrayList<String> horasDisponibles = new ArrayList<>();
                ArrayList<Integer> cuposDisponibles = new ArrayList<>();
                
                // Añadir las horas y los cupos correspondientes
                for (String hora : horas) {
                    horasDisponibles.add(hora);
                    cuposDisponibles.add(instalacion.getCapacidad()); // Usamos la capacidad de la instalación como el cupo
                }
                
                // Añadir el horario para el día correspondiente
                Horario horario = new Horario(dia, horasDisponibles, cuposDisponibles);
                horarios.add(horario);
            }
            
            // Asignar los horarios a la instalación
            instalacion.setHorariosDisponibles(horarios);
        }
    }
    private static ArrayList<Enfermero> crearEnfermeros() {
            ArrayList<Enfermero> enfermeros = new ArrayList<>();
            enfermeros.add(new Enfermero("Carlos", "Gomez", 35, "Emergencias"));
            enfermeros.add(new Enfermero("Ana", "Rodriguez", 40, "Urgencias"));
            enfermeros.add(new Enfermero("Lucia", "Perez", 28, "Pediatría"));
            return enfermeros;
        }
    
        private static ArrayList<Acompanante> crearAcompanantes() {
            ArrayList<Acompanante> acompanantes = new ArrayList<>();
            acompanantes.add(new Acompanante("Pedro", "Lopez", 30, true));
            acompanantes.add(new Acompanante("María", "Diaz", 25, true));
            acompanantes.add(new Acompanante("Luis", "Martinez", 32, true));
            return acompanantes;
        }
    //Mostrar Horarios Disponibles
    private static void mostrarHorariosDisponibles(ArrayList<Instalacion> instalaciones) {
        System.out.println("\n--- Horarios Disponibles ---");

        if (instalaciones.isEmpty()) {
            System.out.println("No hay instalaciones disponibles.");
            return;
        }

        for (Instalacion instalacion : instalaciones) {
            System.out.println("\nInstalación: " + instalacion.getNombre());
            for (Horario horario : instalacion.getHorariosDisponibles()) {
                System.out.println("\n  Día: " + horario.getDia());
                System.out.println("  ---------------------------------");
                // Mostrar las horas y los cupos
                for (int i = 0; i < horario.getHorasDisponibles().size(); i++) {
                    String hora = horario.getHorasDisponibles().get(i);
                    int cupos = horario.getCuposDisponibles().get(i);
                    System.out.println("    " + hora + " (" + cupos + " cupos disponibles)");
                }
                System.out.println("  ---------------------------------");
            }
        }
    }
//Logica Realizar Reservas-------------
    private static void realizarReservas(Scanner scanner, ArrayList<Instalacion> instalaciones, ArrayList<Enfermero> enfermeros, ArrayList<Acompanante> acompanantes) {
        boolean salirReserva = false;

        while (!salirReserva) {
            GestorReservas.mostrarMenuReservas();
            int opcionReserva = scanner.nextInt();
            scanner.nextLine(); 

            switch (opcionReserva) {
                case 1:
                    GestorReservas.crearReserva(scanner, instalaciones, enfermeros, acompanantes);
                    break;

                case 2:
                    mostrarHorariosDisponibles(instalaciones);
                    break;

                case 3:
                    System.out.println("Volviendo al menú principal...");
                    salirReserva = true;
                    break;

                default:
                    System.out.println("Opción inválida. Intente nuevamente.");
            }
        }
    }


    
//------------------------
    private static void realizarInscripciones(Scanner scanner) {
        // Implementación del método para realizar inscripciones a deportes formativos
    }

    private static void crearEventos(Scanner scanner) {
        // Implementación del método para crear eventos (conciertos)
    }

    private static void gestionarTaquilla(Scanner scanner) {
        // Implementación del método para gestionar la taquilla
    }
}