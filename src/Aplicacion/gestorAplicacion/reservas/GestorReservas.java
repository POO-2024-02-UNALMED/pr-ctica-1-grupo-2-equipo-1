package gestorAplicacion.reservas;

import gestorAplicacion.pagos.Factura;
import gestorAplicacion.entidades.Enfermero;
import gestorAplicacion.pagos.Cliente;
import gestorAplicacion.entidades.Acompanante;


import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;



public class GestorReservas {
    public static ArrayList<Reserva> reservas; // Lista que almacena todas las reservas realizadas
    private static int idReservaCounter = 0;
    public static ArrayList<Factura> listaFacturas = new ArrayList<>();

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

    //Mostrar Horarios Disponibles
    public static void mostrarHorariosDisponibles(ArrayList<Instalacion> instalaciones) {
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

    public static void asignarHorarios(ArrayList<Instalacion> instalaciones) {
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
            for (int j = 0; j < horario.getHorasDisponibles().size(); j++) {
                String hora = horario.getHorasDisponibles().get(j);
                int cupos = horario.getCuposDisponibles().get(j);
                System.out.println("   - " + hora + " (" + cupos + " cupos disponibles)");
            }
        }
    
        // Seleccionar día
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
    
        // Mostrar horas ocupadas para información adicional
        System.out.println("\nHoras ocupadas para el día " + horarioSeleccionado.getDia() + ": " 
            + horarioSeleccionado.getHorasOcupadas());
    
        // Mostrar horas disponibles
        System.out.println("Horas disponibles para el día " + horarioSeleccionado.getDia() + ":");
        for (int i = 0; i < horarioSeleccionado.getHorasDisponibles().size(); i++) {
            String hora = horarioSeleccionado.getHorasDisponibles().get(i);
            int cupos = horarioSeleccionado.getCuposDisponibles().get(i);
            System.out.println("   - " + hora + " (" + cupos + " cupos disponibles)");
        }
    
        // Seleccionar la hora para la reserva
        System.out.print("\nSeleccione la hora para la reserva: ");
        String horaSeleccionada = scanner.nextLine();
    
        // Validar si hay cupo en la hora seleccionada
        int indiceHora = horarioSeleccionado.getHorasDisponibles().indexOf(horaSeleccionada);
        if (indiceHora == -1 || horarioSeleccionado.getCuposDisponibles().get(indiceHora) <= 0) {
            System.out.println("La hora ingresada no tiene cupos disponibles. Intente con otra.");
            return;
        }
    
        // Reducir los cupos y crear la reserva
        int cupos = horarioSeleccionado.getCuposDisponibles().get(indiceHora);
        horarioSeleccionado.getCuposDisponibles().set(indiceHora, cupos - 1);
    
        Reserva reserva = new Reserva(cliente, instalacionSeleccionada, horaSeleccionada, horarioSeleccionado);
        System.out.println("\nReserva realizada exitosamente:");
        System.out.println(reserva);
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

    public static Reserva validarYConfirmarReserva(Cliente cliente, Instalacion instalacion, String hora, int duracion, boolean tieneSuscripcion, int cantidadAcompanantes, boolean evaluacionMedicaCompleta) {
        // Verificar disponibilidad
        if (!instalacion.hayCupoDisponible(hora)) {
            System.out.println("Lo sentimos, no hay disponibilidad para la hora seleccionada.");
            return null;
        }

        // Verificar requisitos de piscinas
        if (instalacion.getDeporte().equalsIgnoreCase("Natacion") && !evaluacionMedicaCompleta) {
            System.out.println("Debe completar la evaluación médica para acceder a la piscina.");
            return null;
        }

        // Calcular monto total
        int montoTotal = calcularMonto(instalacion, duracion, tieneSuscripcion, cantidadAcompanantes);

        // Generar ID de reserva
        int idReserva = ++idReservaCounter;
        Reserva reserva = new Reserva(cliente, instalacion, hora, null, "Reservado");

        // Crear factura
        String descripcion = "Reserva de " + instalacion.getNombre() + " a las " + hora;
        Factura factura = new Factura(idReserva, montoTotal, false, descripcion);
        listaFacturas.add(factura);

        // Actualizar estado de instalación
        instalacion.setDescripcion("Reservado");
        System.out.println("Reserva confirmada. Su ID es: " + idReserva);
        System.out.println("Factura generada: " + factura.getDescripcionFactura());

        return reserva;
    }

    private static int calcularMonto(Instalacion instalacion, int duracion, boolean tieneSuscripcion, int cantidadAcompanantes) {
        int precioBase = instalacion.getPrecioHora() * duracion;
        int descuento = tieneSuscripcion ? (int) (precioBase * 0.10) : 0;
        int cargoAcompanantes = cantidadAcompanantes * 5000;
        int cargoHorarioNocturno = (esHorarioNocturno(instalacion) ? 10000 : 0);

        return precioBase - descuento + cargoAcompanantes + cargoHorarioNocturno;
    }

    private static boolean esHorarioNocturno(Instalacion instalacion) {
        return instalacion.getDescripcion().contains("20:00") || instalacion.getDescripcion().contains("22:00") || instalacion.getDescripcion().contains("23:00");
    }

    public static ArrayList<Factura> obtenerFacturas() {
        return listaFacturas;
    }

 
}