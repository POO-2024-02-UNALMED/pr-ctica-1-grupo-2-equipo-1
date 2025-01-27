package gestorAplicacion.inscripcion;

import gestorAplicacion.reservas.Instalacion;
import java.util.ArrayList;

public class GrupoFormativo {
    private Instalacion instalacion;
    private ArrayList<Joven> Jovenes;
    private String deporte;
    //public static ArrayList<GrupoFormativo> gruposFormativo; Para implementación con el serializador.

    public Instalacion getInstalacion() {
        return instalacion;
    }
    public void setInstalacion(Instalacion Instalacion) {
        this.instalacion = Instalacion;
    }
    public ArrayList<Joven> getJovenes() {
        return Jovenes;
    }
    public void addJoven(Joven Joven) {
        Jovenes.add(Joven);
    }
    public void deleteJoven(Joven Joven) {
        Jovenes.remove(Joven);
    }
    public String getDeporte() {
        return deporte;
    }
    public void setDeporte(String deporte) {
        this.deporte = deporte;
    }
    public void resetJovenes() {
        Jovenes = new ArrayList<>();
    }
}