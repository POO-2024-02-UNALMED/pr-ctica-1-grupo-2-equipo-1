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
    public void setInstalacion() {
        String deporte = this.deporte;
    }
}