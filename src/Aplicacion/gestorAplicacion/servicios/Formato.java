package gestorAplicacion.servicios;

import java.util.List;

public class Formato {
    private String deporte;
    private String nombreFormato; // Todos contra todos, eliminación directa
    private String detallesFormato;

    public Formato(String deporte, String nombreFormato, String detallesFormato) {
        this.deporte = deporte;
        this.nombreFormato = nombreFormato;
        this.detallesFormato = detallesFormato;
    }

    public void generarPartidos(List<Equipo> equipos) {
        // Lógica para generar los partidos según el formato
    }

    public void definirReglas(String reglasPorDeporte) {
        // Lógica para definir reglas específicas según el deporte
    }
}
