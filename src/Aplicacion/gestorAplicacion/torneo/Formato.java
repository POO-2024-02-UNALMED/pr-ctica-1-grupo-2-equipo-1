package gestorAplicacion.torneo;

import java.util.ArrayList;

import java.util.List;

import java.util.Scanner; //Quitar, pasar el switch al Main

public class Formato {
    private String nombreFormato;
    private String detallesFormato;
    private Torneo torneo;

    public ArrayList<String> reglasFutbol;
    public String[] formatosFutbol = {"Todos contra todos","Eliminación directa"};
    public int[] duracionFutbol = {30, 90};
    public  int[] sustitucionesFutbol = {2,3,4,5,6,7};
    public String[] criteriosDesempateFutbol = {"Goles a favor", "Goles en contra", "Sorteo"};

    public ArrayList<String> reglasBaloncesto;
    public String[] formatosBaloncesto = {"Todos contra todos","Eliminación directa"};
    public int[] duracionBaloncesto = {10,12};
    public int[] tiemposFueraBaloncesto = {0,1,2,3};

    public ArrayList<String> reglasNatacion;
    public String[] formatosNatacion = {"Carreras clasificatorias y finales","Competencias por relevos"};
    public int[] intentosNatacion = {1,2,3,4,5};

    public ArrayList<String> reglasVoleibol;
    public String[] formatosVoleibol = {"Fase de grupos y finales", "Eliminación directa"};
    public int[] setsVoleibol = {3,4,5};
    public int[] tiemposFueraVoleibol = {0,1,2};
    public int[] alturaMallaVoleybol = {224,243};

    Scanner scanner = new Scanner(System.in); // Quitar

    public Formato(String nombreFormato) {
        this.nombreFormato = nombreFormato;
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
