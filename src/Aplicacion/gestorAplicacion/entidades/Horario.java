package gestorAplicacion.entidades;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Horario implements Serializable {
    private String dia; // Día específico de la semana
    private List<String> horasDisponibles; // Lista de horas disponibles
    private List<Integer> cuposDisponibles; // Lista de cupos disponibles para cada hora

    public Horario(String dia, List<String> horasDisponibles, List<Integer> cuposDisponibles) {
        this.dia = dia;
        this.horasDisponibles = new ArrayList<>(horasDisponibles);
        this.cuposDisponibles = new ArrayList<>(cuposDisponibles); 
    }

    // Método para reservar una hora
    public boolean reservarHora(String horaReservada) {
        for (int i = 0; i < horasDisponibles.size(); i++) {
            if (horasDisponibles.get(i).equals(horaReservada) && cuposDisponibles.get(i) > 0) {
                cuposDisponibles.set(i, cuposDisponibles.get(i) - 1); // Reducir el cupo si hay disponibilidad
                return true; // Reserva exitosa
            }
        }
        return false; // Hora no disponible o sin cupos
    }

    // Verificar si una hora específica tiene cupos disponibles
    public boolean esHoraDisponible(String hora) {
        for (int i = 0; i < horasDisponibles.size(); i++) {
            if (horasDisponibles.get(i).equals(hora) && cuposDisponibles.get(i) > 0) {
                return true;
            }
        }
        return false;
    }

    public String getDia() {
        return dia;
    }

    public List<String> getHorasDisponibles() {
        return horasDisponibles;
    }

    public List<Integer> getCuposDisponibles() {
        return cuposDisponibles;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Día: ").append(dia).append(", Horas disponibles: ");
        for (int i = 0; i < horasDisponibles.size(); i++) {
            sb.append(horasDisponibles.get(i)).append(" (").append(cuposDisponibles.get(i)).append(" cupos disponibles), ");
        }
        return sb.toString();
    }
}