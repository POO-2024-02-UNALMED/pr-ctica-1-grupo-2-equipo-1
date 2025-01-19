package gestorAplicacion.servicios;

import gestorAplicacion.entidades.Cliente;
import gestorAplicacion.entidades.Horario;
import gestorAplicacion.entidades.Reserva;

import java.util.ArrayList;
import java.util.List;

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
    private void restaurarCupo(Horario horario, String hora) {
        List<String> horasDisponibles = horario.getHorasDisponibles();
        List<Integer> cuposDisponibles = horario.getCuposDisponibles();

        for (int i = 0; i < horasDisponibles.size(); i++) {
            if (horasDisponibles.get(i).equals(hora)) {
                cuposDisponibles.set(i, cuposDisponibles.get(i) + 1); // Restaurar el cupo
                break;
            }
        }
    }
}