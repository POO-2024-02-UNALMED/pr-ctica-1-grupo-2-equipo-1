/* 
package gestorAplicacion.servicios;

import gestorAplicacion.entidades.Cliente;
import gestorAplicacion.entidades.Horario;
import gestorAplicacion.entidades.Instalacion;
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

        // Verificar si la hora está disponible antes de agregar la reserva
        if (horario.reservarHora(hora)) {
            reservas.add(reserva); // Agregar la reserva a la lista
            return true;
        }
        return false; // La hora no se encuentra disponible para reservar
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

    public boolean cancelarReserva(Reserva reserva) {
        if (reservas.contains(reserva)) {
            // Liberar la hora reservada
            Horario horario = reserva.getHorario();
            String hora = reserva.getHoraReservada();
            if (!horario.getHorasDisponibles().contains(hora)) {
                horario.getHorasDisponibles().add(hora);// Se añade la hora nuevamente
            }
            reservas.remove(reserva);// Se elimina la reserva 
            return true;
        }
        return false;// La reserva no existe
    }

}
*/