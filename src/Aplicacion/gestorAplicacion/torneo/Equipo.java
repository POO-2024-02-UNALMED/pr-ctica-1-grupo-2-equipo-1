package gestorAplicacion.torneo;

import java.util.ArrayList;

public class Equipo {
    private int idEquipo = 0;
    private String nombreEquipo;
    private ArrayList<String> jugadores;


    public Equipo( String nombreEquipo) {
        this.idEquipo++;
        this.nombreEquipo = nombreEquipo;
        this.jugadores = new ArrayList<>();
    }

    public String getNombreEquipo() {
        return nombreEquipo;
    }

    public void setNombreEquipo(String nombreEquipo) {
        this.nombreEquipo = nombreEquipo;
    }



    public ArrayList<String> getJugadores() {
        return jugadores;
    }

    public void setJugadores( String nombreJugador) {
        jugadores.add(nombreJugador);
    }

    public int getIdEquipo() {
        return idEquipo;
    }

    public void setIdEquipo(int idEquipo) {
        this.idEquipo = idEquipo;
    }
}
