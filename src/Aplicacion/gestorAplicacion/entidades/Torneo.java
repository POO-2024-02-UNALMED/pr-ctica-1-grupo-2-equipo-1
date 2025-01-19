package gestorAplicacion.entidades;

import gestorAplicacion.servicios.Formato;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import static uiMain.Main.crearInstalaciones;

public class Torneo {
    private int idTorneo = 0;
    public String deporte;
    private Formato formato;
    private List<Equipo> equiposParticipantes;
    private String seguroMedico;
    public float costoSeguroMedico;
    private double precioTotal;
    public boolean ventaBoletasTorneo = false;
    public ArrayList<String> partidos;
    public static ArrayList<String> reglas;

    public Torneo(String deporte,Formato formato,List<Equipo> equiposParticipantes, String seguroMedico, double precioTotal){
        this.deporte = deporte;
        this.formato = formato;
        this.equiposParticipantes = equiposParticipantes;
        this.seguroMedico = seguroMedico;
        this.precioTotal = precioTotal;
    }

    public void asignarEquipos(List<Equipo> equipos) {
        this.equiposParticipantes = equipos;
    }

    public void generarHorarios() {
        // Lógica para generar los horarios
    }

    public void calcularPrecio() {
        this.precioTotal = equiposParticipantes.size() * 100;  // Ejemplo básico
        if (seguroMedico != null) {
            this.precioTotal += costoSeguroMedico;
        }
    }

    public void agregarSeguro(String seguro) {
        this.seguroMedico = seguro;
    }

    public double getPrecioTotal() {
        return precioTotal;
    }

    public int getIdTorneo() {
        return idTorneo;
    }

    public void setIdTorneo(int idTorneo) {
        this.idTorneo = idTorneo;
    }

    public String getDeporte() {
        return deporte;
    }

    public void setDeporte(String deporte) {
        this.deporte = deporte;
    }

    public List<Equipo> getEquiposParticipantes() {
        return equiposParticipantes;
    }

    public void setEquiposParticipantes(List<Equipo> equiposParticipantes) {
        this.equiposParticipantes = equiposParticipantes;
    }

    public String getSeguroMedico() {
        return seguroMedico;
    }

    public void setSeguroMedico(String seguroMedico) {
        this.seguroMedico = seguroMedico;
    }

    public static void crearTorneos(){
        boolean salirTorneo = false;

        Scanner scanner = new Scanner(System.in);

        System.out.println("Seleccione el deporte en el cual desea realizar el torneo");
        System.out.println("1. Futbol");
        System.out.println("2. Baloncesto");
        System.out.println("3. Natacion");
        System.out.println("4. Voleibol");
        System.out.println("5. Salir");

        int deporteTorneo = scanner.nextInt();

        ArrayList<Instalacion> inst = crearInstalaciones();

        while (!salirTorneo){
            switch (deporteTorneo){
                case 1://futbol
                    System.out.println("Seleccione la cancha en la que desea realizar el torneo");
                    System.out.println("Existe la opción de que al escoger una cancha de Futbol 11, se puedan seleccionar ambas");
                    System.out.println("Instalaciones deisponibles");
                    System.out.println(inst.getFirst().toString());
                    System.out.println(inst.get(1).toString()); //Arregalar algun dia
                    System.out.println(inst.get(2).toString()); //Arregalar algun dia
                    System.out.println(inst.get(3).toString()); //Arregalar algun dia

                    int selccionanchaFutbol = scanner.nextInt();

                    if (selccionanchaFutbol == 1){
                        System.out.println("Desea usar ambas canchas de Futbol 11? (true/false)");
                        boolean ambasCanchas = scanner.nextBoolean();
                        if (ambasCanchas){
                            System.out.println("Se han seleccionado ambas canchas de Futbol 11");
                        }//Logica par reservar las canchas. De momento no la pondre



                    System.out.println("Ahora se personalizaran las relgas del torneo");
                        System.out.println("Sustituciones máximas: mínimo 2, máximo 7.\n" +
                                "Duración del partido: 30 o 90 minutos (Se agregarán 30 minutos más a la reserva).\n" +
                                "Criterios de desempate: Diferencia de goles, goles a favor, goles en contra o sorteo.\n" +
                                "En este caso deberán ser ingresados en orden de prioridad. Además, despúes de sorteo no podrán ir más criterios de desempate.");

                        System.out.println("Ingrese la cantidad de susticiones máximas.");
                        int Sustituciones = scanner.nextInt();
                        if ((Sustituciones < 2) || (Sustituciones > 7)){
                            break;
                        } else {
                            reglas.add(Integer.toString(Sustituciones));
                        }

                        System.out.println("Ingrese la duración del partido.");
                        int duracionFutbol = scanner.nextInt();
                        if ((duracionFutbol < 30) || (duracionFutbol > 90)){
                            break;
                        } else {
                            reglas.add(Integer.toString(duracionFutbol));
                        }

                        ArrayList<String> Criterios = new ArrayList<>();
                        System.out.println("Ingrese los criterios de desempate en orden de prioridad.");

                        while(!Criterios.contains("Sorteo")){
                            String Criterio = scanner.next();
                            Criterios.add(Criterio);
                        }
                        System.out.println("Las siguientes serán las reglas personalizadas para este torneo:"); //ARREGLAR - Puede genrar un error si se pone sorteo como una opcion distinta a la ultima
                        System.out.println("Sustituciones máximas:" + Criterios.getFirst());
                        System.out.println("Duración del partido:" + Criterios.get(1));
                        System.out.println("Criterios de desempate:" + Criterios.get(2));
                        }


                case 2://basket
                case 3://natacion
                case 4://voleibol
                case 5://salir
                default:
                    System.out.println("Seleccione una opcion valide. Del 1 al 5");
            }
        }
    }
}