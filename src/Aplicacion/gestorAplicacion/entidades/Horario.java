package gestorAplicacion.entidades;
import java.util.ArrayList;
import java.util.List;

public class Horario {
    private String dia; // Día específico
    private List<String> horasDisponibles; // Horas disponibles para reserva

    public Horario(String dia) {
        this.dia = dia;
        this.horasDisponibles = generarHorasDisponibles(); // Inicializa las horas disponibles
    }

    private List<String> generarHorasDisponibles() {
        // Generacion de horas disponibles (8:00 a 12:00)
        List<String> horas = new ArrayList<>();
        for (int hora = 8; hora < 12; hora++) {
            horas.add(hora + ":00 - " + (hora + 1) + ":00");
        }
        return horas;
    }

    public boolean reservarHora(String hora) {
        //Intento de reservar 
        if (horasDisponibles.contains(hora)) {
            horasDisponibles.remove(hora); // La hora deja de estar disponible luego de que se reserva
            return true;
        }
        return false; // La hora ya estaba reservada en caso tal de que se haya reservado
    }

    public List<String> getHorasDisponibles() {
        // Retorna la lista de horas disponibles
        return horasDisponibles;
    }

    public String getDia() {
        return dia;
    }
    public void setDia(String dia) {
        this.dia = dia;
    }


}