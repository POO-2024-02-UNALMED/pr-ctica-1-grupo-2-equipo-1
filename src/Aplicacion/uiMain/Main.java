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
import gestorAplicacion.entidades.Acompanante;
import gestorAplicacion.entidades.Cliente;
import gestorAplicacion.entidades.Enfermero;
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
            mostrarMenuReservas();
            int opcionReserva = scanner.nextInt();
            scanner.nextLine(); 

            switch (opcionReserva) {
                case 1:
                    crearReserva(scanner, instalaciones, enfermeros, acompanantes);
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

    private static void mostrarMenuReservas() {
        System.out.println("\n--- Realizar Reservas ---");
        System.out.println("1. Crear Reserva");
        System.out.println("2. Ver horarios disponibles");
        System.out.println("3. Volver al menú principal");
        System.out.print("Seleccione una opción: ");
    }

    private static void crearReserva(Scanner scanner, ArrayList<Instalacion> instalaciones, ArrayList<Enfermero> enfermeros, ArrayList<Acompanante> acompanantes) {
        System.out.println("\n--- Crear Reserva ---");
        Cliente cliente = solicitarDatosCliente(scanner);

        ArrayList<Instalacion> instalacionesDisponibles = filtrarInstalaciones(instalaciones, cliente);

        if (instalacionesDisponibles.isEmpty()) {
            System.out.println("No se encontraron instalaciones que cumplan con los criterios.");
            return;
        }

        Instalacion instalacionSeleccionada = seleccionarInstalacion(scanner, instalacionesDisponibles);

        if (esPiscinaConRestriccion(instalacionSeleccionada)) {
            manejarExamenesMedicos(scanner, cliente, enfermeros, acompanantes);
        }

        mostrarYReservarHorario(scanner, instalacionSeleccionada, cliente);
    }

    private static Cliente solicitarDatosCliente(Scanner scanner) {
        System.out.print("Ingrese el ID del cliente: ");
        String idCliente = scanner.nextLine();
        System.out.print("Ingrese el nombre del cliente: ");
        String nombreCliente = scanner.nextLine();
        System.out.print("Ingrese el apellido del cliente: ");
        String apellidoCliente = scanner.nextLine();
        System.out.print("Ingrese la edad del cliente: ");
        int edadCliente = scanner.nextInt();
        scanner.nextLine();

        System.out.print("¿Desea ingresar sus preferencias? (si/no): ");
        String deseaPreferencias = scanner.nextLine().toLowerCase();
        String instalacionPreferida = "";
        String deporte = "";
        double precioMinimo = 0.0;
        double precioMaximo = 0.0;

        if (deseaPreferencias.equals("si")) {
            System.out.print("Ingrese la instalación preferida: ");
            instalacionPreferida = scanner.nextLine();
            System.out.print("Ingrese el deporte preferido: ");
            deporte = scanner.nextLine();
            System.out.print("Ingrese el precio mínimo: ");
            precioMinimo = scanner.nextDouble();
            System.out.print("Ingrese el precio máximo: ");
            precioMaximo = scanner.nextDouble();
            scanner.nextLine();
        }

        System.out.print("¿El cliente está suscrito? (true/false): ");
        boolean suscrito = scanner.nextBoolean();
        scanner.nextLine();

        return new Cliente(idCliente, nombreCliente, apellidoCliente, edadCliente, instalacionPreferida, deporte, precioMinimo, precioMaximo, suscrito);
    }

    private static ArrayList<Instalacion> filtrarInstalaciones(ArrayList<Instalacion> instalaciones, Cliente cliente) {
        ArrayList<Instalacion> disponibles = new ArrayList<>();
        for (Instalacion instalacion : instalaciones) {
            boolean cumpleCriterios = true;

            if (!cliente.getInstalacionPreferida().isEmpty() && !instalacion.getNombre().toLowerCase().contains(cliente.getInstalacionPreferida().toLowerCase())) {
                cumpleCriterios = false;
            }
            if (!cliente.getDeporte().isEmpty() && !instalacion.getDeporte().equalsIgnoreCase(cliente.getDeporte())) {
                cumpleCriterios = false;
            }
            if (cliente.getPrecioMinimo() > 0 && instalacion.getPrecioHora() < cliente.getPrecioMinimo()) {
                cumpleCriterios = false;
            }
            if (cliente.getPrecioMaximo() > 0 && instalacion.getPrecioHora() > cliente.getPrecioMaximo()) {
                cumpleCriterios = false;
            }

            if (cumpleCriterios) {
                disponibles.add(instalacion);
            }
        }
        return disponibles;
    }

    private static Instalacion seleccionarInstalacion(Scanner scanner, ArrayList<Instalacion> instalacionesDisponibles) {
        System.out.println("Instalaciones disponibles que cumplen con los criterios:");
        for (int i = 0; i < instalacionesDisponibles.size(); i++) {
            System.out.println((i + 1) + ". " + instalacionesDisponibles.get(i).getNombre());
        }

        int seleccion;
        do {
            System.out.print("Seleccione una instalación por su número: ");
            seleccion = scanner.nextInt();
            scanner.nextLine();
            if (seleccion < 1 || seleccion > instalacionesDisponibles.size()) {
                System.out.println("Selección inválida. Intente nuevamente.");
            }
        } while (seleccion < 1 || seleccion > instalacionesDisponibles.size());

        return instalacionesDisponibles.get(seleccion - 1);
    }

    private static boolean esPiscinaConRestriccion(Instalacion instalacion) {
        return instalacion.getNombre().toLowerCase().contains("piscina") &&
            (instalacion.getNombre().toLowerCase().contains("olimpica") ||
                instalacion.getNombre().toLowerCase().contains("semi olimpica"));
    }

    private static void manejarExamenesMedicos(Scanner scanner, Cliente cliente, ArrayList<Enfermero> enfermeros, ArrayList<Acompanante> acompanantes) {
        System.out.print("¿El cliente tiene exámenes médicos válidos para natación? (si/no): ");
        String tieneExamen = scanner.nextLine().toLowerCase();

        if (tieneExamen.equals("no")) {
            if (enfermeros.isEmpty()) {
                System.out.println("No hay enfermeros disponibles para realizar los exámenes.");
                return;
            }

            System.out.println("Enfermeros disponibles para realizar los exámenes:");
            for (int i = 0; i < enfermeros.size(); i++) {
                System.out.println((i + 1) + ". " + enfermeros.get(i).getNombre() + " " + enfermeros.get(i).getApellido());
            }

            System.out.print("Seleccione un enfermero por su número: ");
            int seleccionEnfermero = scanner.nextInt();
            scanner.nextLine();

            Enfermero enfermeroSeleccionado = enfermeros.get(seleccionEnfermero - 1);
            System.out.println("Enfermero seleccionado: " + enfermeroSeleccionado.getNombre() + " " + enfermeroSeleccionado.getApellido());

            boolean examenAprobado = Math.random() < 0.5;
            if (examenAprobado) {
                System.out.println("¡El cliente ha aprobado los exámenes médicos!");
            } else {
                System.out.println("El cliente no ha aprobado los exámenes médicos.");
                asignarAcompanante(scanner, acompanantes);
            }

            if (Math.random() < 0.2) {
                enfermeros.remove(enfermeroSeleccionado);
                System.out.println("El enfermero ya no está disponible para otras reservas.");
            }
        }
    }

    private static void asignarAcompanante(Scanner scanner, ArrayList<Acompanante> acompanantes) {
        if (acompanantes.isEmpty()) {
            System.out.println("No hay acompañantes disponibles.");
            return;
        }

        System.out.println("Acompañantes disponibles:");
        for (int i = 0; i < acompanantes.size(); i++) {
            System.out.println((i + 1) + ". " + acompanantes.get(i).getNombre() + " " + acompanantes.get(i).getApellido());
        }

        System.out.print("Seleccione un acompañante por su número: ");
        int seleccionAcompanante = scanner.nextInt();
        scanner.nextLine();

        Acompanante acompananteSeleccionado = acompanantes.get(seleccionAcompanante - 1);
        System.out.println("Acompañante seleccionado: " + acompananteSeleccionado.getNombre() + " " + acompananteSeleccionado.getApellido());
    }

    private static void mostrarYReservarHorario(Scanner scanner, Instalacion instalacionSeleccionada, Cliente cliente) {
        System.out.println("\nHorarios disponibles para la instalación: " + instalacionSeleccionada.getNombre());

        ArrayList<Horario> horariosDisponibles = instalacionSeleccionada.getHorariosDisponibles();

        // Mostrar los horarios disponibles
        for (int i = 0; i < horariosDisponibles.size(); i++) {
            Horario horario = horariosDisponibles.get(i);
            System.out.println((i + 1) + ". " + horario.getDia() + ":");
            // Mostrar la hora y los cupos disponibles
            for (int j = 0; j < horario.getHorasDisponibles().size(); j++) {
                String hora = horario.getHorasDisponibles().get(j);
                int cupos = horario.getCuposDisponibles().get(j);
                System.out.println("   - " + hora + " (" + cupos + " cupos disponibles)");
            }
        }

        int seleccionDia;
        do {
            System.out.print("Seleccione un día por su número: ");
            seleccionDia = scanner.nextInt();
            scanner.nextLine();
            if (seleccionDia < 1 || seleccionDia > horariosDisponibles.size()) {
                System.out.println("Selección inválida. Intente nuevamente.");
            }
        } while (seleccionDia < 1 || seleccionDia > horariosDisponibles.size());

        Horario horarioSeleccionado = horariosDisponibles.get(seleccionDia - 1);

        // Mostrar las horas disponibles para el día seleccionado
        System.out.println("Horas disponibles para el día " + horarioSeleccionado.getDia() + ":");
        for (int i = 0; i < horarioSeleccionado.getHorasDisponibles().size(); i++) {
            String hora = horarioSeleccionado.getHorasDisponibles().get(i);
            int cupos = horarioSeleccionado.getCuposDisponibles().get(i);
            System.out.println(" - " + hora + " (" + cupos + " cupos disponibles)");
        }

        // Seleccionar la hora para la reserva
        System.out.print("Seleccione la hora para la reserva: ");
        String horaSeleccionada = scanner.nextLine();

        // Verificar si hay cupo disponible
        if (!instalacionSeleccionada.hayCupoDisponible(horaSeleccionada)) {
            System.out.println("La hora ingresada no tiene cupos disponibles. Intente con otra.");
            return;
        }

        // Procedemos a reservar la hora
        for (Horario horario : instalacionSeleccionada.getHorariosDisponibles()) {
            for (int i = 0; i < horario.getHorasDisponibles().size(); i++) {
                String hora = horario.getHorasDisponibles().get(i);
                if (hora.equals(horaSeleccionada)) {
                    // Reducir los cupos disponibles
                    int cupos = horario.getCuposDisponibles().get(i);
                    if (cupos > 0) {
                        horario.getCuposDisponibles().set(i, cupos - 1);

                        // Crear la reserva
                        Reserva reserva = new Reserva(cliente, instalacionSeleccionada, horaSeleccionada, horario);
                        System.out.println("Reserva realizada exitosamente:");
                        System.out.println(reserva);
                        return;
                    }
                }
            }
        }

        System.out.println("Hubo un error al realizar la reserva.");
    }
//------------------------
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