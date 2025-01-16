package gestorAplicacion.servicios;

import gestorAplicacion.entidades.Equipo;

import gestorAplicacion.entidades.Torneo;

import java.util.List;

import java.util.Scanner;

public class Formato {
    private String nombreFormato;
    private String detallesFormato;
    private Reglas reglas;
    private Torneo torneo;

    Scanner scanner = new Scanner(System.in);

    public Formato(String nombreFormato, String detallesFormato) {
        this.nombreFormato = nombreFormato;
        this.detallesFormato = detallesFormato;
        this.torneo = null;
    }

    public void generarPartidos(List<Equipo> equipos) {
        for (int i = 0; i < equipos.size(); i++) {
            for (int j = i + 1; j < equipos.size(); j++) {
                System.out.println("Partido: " + equipos.get(i).getNombreEquipo() + " vs " + equipos.get(j).getNombreEquipo());
            }
        }
    }

    public String setFormato(){
        switch(this.torneo.deporte){ //Error - Arreglar - Agregar default case, agregar logica para que si no se selecciona una opcion valida, se vuelva al switch
            case "Futbol":
                System.out.println("Para el deporte selccionado están disponibles los siguientes formatos de competencia. Seleccione uno:\n" +
                        "1. Todos contra todos:\n" +
                        "Cada equipo juega contra todos los demás una vez. El equipo con mayor puntaje ganará\n\n" +
                        "2. Eliminación directa:\n" +
                        "Los equipos se enfrentan en rondas eliminatorias. El perdedor queda fuera y el ganador avanza hasta la final.");
                switch(scanner.nextInt()){
                    case 1:
                        setNombreFormato("Todos contra todos.");
                        setDetallesFormato("Cada equipo juega contra todos los demás una vez. El equipo con mayor puntaje ganará.");
                    case 2:
                        setNombreFormato("Eliminación directa.");
                        setDetallesFormato("Los equipos se enfrentan en rondas eliminatorias. El perdedor queda fuera y el ganador avanza hasta la final.");
                }
                return "El formato de tu torneo será el siguiente:\n" + getNombreFormato();
            case "Baloncesto":
                System.out.println("Para el deporte selccionado están disponibles los siguientes formatos de competencia. Seleccione uno:\n" +
                        "1. Todos contra todos:\n" +
                        "Cada equipo juega contra todos los demás una vez. El equipo con mayor puntaje ganará\n\n" +
                        "2. Eliminación directa:\n" +
                        "Los equipos se enfrentan en rondas eliminatorias. El perdedor queda fuera y el ganador avanza hasta la final.");
                switch(scanner.nextInt()){
                    case 1:
                        setNombreFormato("Todos contra todos.");
                        setDetallesFormato("Cada equipo juega contra todos los demás una vez. El equipo con mayor puntaje ganará.");
                    case 2:
                        setNombreFormato("Eliminación directa.");
                        setDetallesFormato("Los equipos se enfrentan en rondas eliminatorias. El perdedor queda fuera y el ganador avanza hasta la final.");
                }
                return "El formato de tu torneo será el siguiente:\n" + getNombreFormato();
            case "Natacion":
                System.out.println("Para el deporte selccionado están disponibles los siguientes formatos de competencia. Seleccione uno:\n" +
                        "1. Carreras clasificatorias y finales:\n" +
                        " Los mejores tiempos de las series preliminares avanzan a la final.\n\n" +
                        "2. Competencias por relevos:\n" +
                        "Equipos nadan distancias específicas por turnos.");
                switch(scanner.nextInt()){
                    case 1:
                        setNombreFormato("Carreras clasificatorias y finales.");
                        setDetallesFormato(" Los mejores tiempos de las series preliminares avanzan a la final.");
                    case 2:
                        setNombreFormato("Competencias por relevos.");
                        setDetallesFormato("Equipos nadan distancias específicas por turnos.");
                }
                return "El formato de tu torneo será el siguiente:\n" + getNombreFormato();
            case "Voleibol":
                System.out.println("Para el deporte selccionado están disponibles los siguientes formatos de competencia. Seleccione uno:\n" +
                        "1. Fase de grupos y finales:\n" +
                        "Los equipos compiten en grupos; los mejores avanzan a fases eliminatorias\n\n" +
                        "2. Eliminación directa:\n" +
                        "Los equipos se enfrentan en rondas eliminatorias. El perdedor queda fuera y el ganador avanza hasta la final.");
                switch(scanner.nextInt()){
                    case 1:
                        setNombreFormato("Fase de grupos y finales.");
                        setDetallesFormato("Los equipos compiten en grupos; los mejores avanzan a fases eliminatorias.");
                    case 2:
                        setNombreFormato("Eliminación directa.");
                        setDetallesFormato("Los equipos se enfrentan en rondas eliminatorias. El perdedor queda fuera y el ganador avanza hasta la final.");
                }
                return "El formato de tu torneo será el siguiente:\n" + getNombreFormato();
            default:
                return "Selecciona uno de los deportes disponibles";
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

    public void setTorneo(Torneo torneo){
        this.torneo = torneo;
    }
}
