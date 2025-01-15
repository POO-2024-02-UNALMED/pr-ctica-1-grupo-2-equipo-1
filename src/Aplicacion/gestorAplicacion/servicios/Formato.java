package gestorAplicacion.servicios;

import gestorAplicacion.entidades.Equipo;

import java.util.List;

public class Formato {
    private String nombreFormato;
    private String detallesFormato;

    public Formato(String nombreFormato, String detallesFormato) {
        this.nombreFormato = nombreFormato;
        this.detallesFormato = detallesFormato;
    }

    public void generarPartidos(List<Equipo> equipos) {
        for (int i = 0; i < equipos.size(); i++) {
            for (int j = i + 1; j < equipos.size(); j++) {
                System.out.println("Partido: " + equipos.get(i).getNombreEquipo() + " vs " + equipos.get(j).getNombreEquipo());
            }
        }
    }

    public String getNombreFormato() {
        return nombreFormato;
    }

    public void setNombreFormato(String nombreFormato) {
        this.nombreFormato = nombreFormato;
    }

    public String getDetallesFormato() {
        return detallesFormato;
    }

    public void setDetallesFormato(String detallesFormato) {
        this.detallesFormato = detallesFormato;
    }
}
