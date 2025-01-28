package gestorAplicacion.reservas;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Horario implements Serializable {
    private String dia; // Día específico de la semana
    private List<String> horasDisponibles; // Lista de horas disponibles
    private List<Integer> cuposDisponibles; // Lista de cupos disponibles para cada hora

    public Horario() {}
    public Horario(String dia, List<String> horasDisponibles, List<Integer> cuposDisponibles) {
        this.dia = dia;
        this.horasDisponibles = new ArrayList<>(horasDisponibles);
        this.cuposDisponibles = new ArrayList<>(cuposDisponibles); 
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
    public List<String> getHorasOcupadas() {
        List<String> horasOcupadas = new ArrayList<>();
        for (int i = 0; i < horasDisponibles.size(); i++) {
            if (cuposDisponibles.get(i) == 0) {
                horasOcupadas.add(horasDisponibles.get(i));
            }
        }
        return horasOcupadas;
    }
}