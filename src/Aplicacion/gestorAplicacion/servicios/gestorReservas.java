package gestorAplicacion.servicios;

import gestorAplicacion.entidades.Cliente;
import gestorAplicacion.entidades.Horario;
import gestorAplicacion.entidades.Reserva;
import gestorAplicacion.entidades.Instalacion;
import gestorAplicacion.entidades.Enfermero;
import gestorAplicacion.entidades.Acompanante;


import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


public class GestorReservas {
    private List<Reserva> reservas; // Lista que almacena todas las reservas realizadas

    public GestorReservas() {
        this.reservas = new ArrayList<>();
    }

    // Método para agregar una nueva reserva
    public boolean agregarReserva(Reserva reserva) {
        Horario horario = reserva.getHorario();
        String hora = reserva.getHoraReservada();

        // Verificar si hay cupos disponibles
        if (hayCupoDisponible(horario, hora)) {
            // Realizar la reserva (reduce el cupo)
            reducirCupo(horario, hora);
            reservas.add(reserva); // Agregar la reserva a la lista
            return true;
        }
        return false; // La hora no se encuentra disponible
    }

    // Método para verificar si hay cupos disponibles para una hora específica
    private boolean hayCupoDisponible(Horario horario, String hora) {
        List<String> horasDisponibles = horario.getHorasDisponibles();
        List<Integer> cuposDisponibles = horario.getCuposDisponibles();

        for (int i = 0; i < horasDisponibles.size(); i++) {
            if (horasDisponibles.get(i).equals(hora) && cuposDisponibles.get(i) > 0) {
                return true;
            }
        }
        return false;
    }

    // Método para reducir el cupo cuando se realiza una reserva
    private void reducirCupo(Horario horario, String hora) {
        List<String> horasDisponibles = horario.getHorasDisponibles();
        List<Integer> cuposDisponibles = horario.getCuposDisponibles();

        for (int i = 0; i < horasDisponibles.size(); i++) {
            if (horasDisponibles.get(i).equals(hora)) {
                cuposDisponibles.set(i, cuposDisponibles.get(i) - 1); // Reducir el cupo
                break;
            }
        }
    }

    // Buscar reservas por cliente
    public List<Reserva> buscarReservasPorCliente(Cliente cliente) {
        List<Reserva> resultado = new ArrayList<>();
        for (Reserva reserva : reservas) {
            if (reserva.getCliente().equals(cliente)) {
                resultado.add(reserva);
            }
        }
        return resultado;
    }

    // Buscar reservas por estado
    public List<Reserva> buscarReservasPorEstado(String estado) {
        List<Reserva> resultado = new ArrayList<>();
        for (Reserva reserva : reservas) {
            if (reserva.getEstado().equalsIgnoreCase(estado)) {
                resultado.add(reserva);
            }
        }
        return resultado;
    }

    // Listar todas las reservas
    public List<Reserva> listarReservas() {
        return new ArrayList<>(reservas);
    }

    // Método para cancelar reserva
    public boolean cancelarReserva(Reserva reserva) {
        if (reservas.contains(reserva)) {
            Horario horario = reserva.getHorario();
            String hora = reserva.getHoraReservada();

            // Restaurar el cupo en el horario
            restaurarCupo(horario, hora);
            reservas.remove(reserva);
            return true;
        }
        return false; // La reserva no existe
    }

    // Método para restaurar el cupo al cancelar la reserva
    public void restaurarCupo(Horario horario, String hora) {
        List<String> horasDisponibles = horario.getHorasDisponibles();
        List<Integer> cuposDisponibles = horario.getCuposDisponibles();

        for (int i = 0; i < horasDisponibles.size(); i++) {
            if (horasDisponibles.get(i).equals(hora)) {
                cuposDisponibles.set(i, cuposDisponibles.get(i) + 1); // Restaurar el cupo
                break;
            }
        }
    }

    public static void mostrarMenuReservas() {
        System.out.println("\n--- Realizar Reservas ---");
        System.out.println("1. Crear Reserva");
        System.out.println("2. Ver horarios disponibles");
        System.out.println("3. Volver al menú principal");
        System.out.print("Seleccione una opción: ");
    }

    public static void crearReserva(Scanner scanner, ArrayList<Instalacion> instalaciones, ArrayList<Enfermero> enfermeros, ArrayList<Acompanante> acompanantes) {
        System.out.println("\n--- Crear Reserva ---");
        Cliente cliente = Cliente.solicitarDatosCliente(scanner);

        ArrayList<Instalacion> instalacionesDisponibles = filtrarInstalaciones(instalaciones, cliente);

        if (instalacionesDisponibles.isEmpty()) {
            System.out.println("No se encontraron instalaciones que cumplan con los criterios.");
            return;
        }

        Instalacion instalacionSeleccionada = Instalacion.seleccionarInstalacion(scanner, instalacionesDisponibles);

        if (Instalacion.esPiscinaConRestriccion(instalacionSeleccionada)) {
            manejarExamenesMedicos(scanner, cliente, enfermeros, acompanantes);
        }

        mostrarYReservarHorario(scanner, instalacionSeleccionada, cliente);
    }



    public static void mostrarYReservarHorario(Scanner scanner, Instalacion instalacionSeleccionada, Cliente cliente) {
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

    public static ArrayList<Instalacion> filtrarInstalaciones(ArrayList<Instalacion> instalaciones, Cliente cliente) {
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

    public static void manejarExamenesMedicos(Scanner scanner, Cliente cliente, ArrayList<Enfermero> enfermeros, ArrayList<Acompanante> acompanantes) {
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
    public static void asignarAcompanante(Scanner scanner, ArrayList<Acompanante> acompanantes) {
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
}