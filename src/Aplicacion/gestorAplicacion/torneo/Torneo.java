package gestorAplicacion.torneo;

import gestorAplicacion.pagos.Cliente;
import gestorAplicacion.reservas.Instalacion;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import static uiMain.Main.crearInstalaciones;

public class Torneo {
    public static ArrayList<Torneo> torneos;
    private int idTorneo = 0;
    public String deporte;
    private List<Equipo> equiposParticipantes;
    private String seguroMedico;
    public float costoSeguroMedico;
    public double precioTotal;
    public boolean ventaBoletasTorneo = false;
    public ArrayList<String> partidos;
    public static ArrayList<String> reglas;

    public Torneo(String deporte,List<Equipo> equiposParticipantes, String seguroMedico, double precioTotal) {
        this.deporte = deporte;
        this.equiposParticipantes = equiposParticipantes;
        this.seguroMedico = seguroMedico;
        this.precioTotal = precioTotal;
    }

    public Torneo(int idTorneo) {
        this.idTorneo = idTorneo;
    }

    public void asignarEquipos(List<Equipo> equipos) {
        this.equiposParticipantes = equipos;
    }

    public void generarHorarios() {
        // Lógica para generar los horarios
    }

    public int calcularPrecio() {
        this.precioTotal = equiposParticipantes.size() * 100;  // Ejemplo básico
        if (seguroMedico != null) {
            this.precioTotal += costoSeguroMedico;
        }
        return 0;
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

    public void crearTorneos() {
        boolean salirTorneo = false;

        System.out.println("Antes de empezar con la creacion del torneo, se requieren unos datos del clietne");
        System.out.println("Ingrese su nombre");
        String nombreCliente = new Scanner(System.in).nextLine();
        System.out.println("Ingrese su apellido");
        String apellidoCliente = new Scanner(System.in).nextLine();
        System.out.println("Ingrese su edad");
        int edadCliente = new Scanner(System.in).nextInt();
        System.out.println("Ingrese su ID");
        int idCliente = new Scanner(System.in).nextInt();
        String idClienteString = String.valueOf(idCliente);

        Cliente cliente = new Cliente(nombreCliente, apellidoCliente, edadCliente, idClienteString);

        Scanner scanner = new Scanner(System.in);

        System.out.println("Seleccione el deporte en el cual desea realizar el torneo");
        System.out.println("1. Futbol");
        System.out.println("2. Baloncesto");
        System.out.println("3. Natacion");
        System.out.println("4. Voleibol");
        System.out.println("5. Salir");


        //Agregar codigo para detectar si el clietne esta suscrito

        int deporteTorneo = scanner.nextInt();

        ArrayList<Instalacion> inst = crearInstalaciones();

        while (!salirTorneo) {
            switch (deporteTorneo) {
                case 1://futbol
                    System.out.println("Seleccione la cancha en la que desea realizar el torneo");
                    System.out.println("Existe la opción de que al escoger una cancha de Futbol 11, se puedan seleccionar ambas");
                    System.out.println("Instalaciones deisponibles");
                    System.out.println(inst.getFirst().toString());
                    System.out.println(inst.get(1).toString()); //Arregalar un dia
                    System.out.println(inst.get(2).toString()); //Arregalar un dia
                    System.out.println(inst.get(3).toString()); //Arregalar un dia

                    int selccionanchaFutbol = scanner.nextInt(); //Informacion necesaria para la reserva

                    if (selccionanchaFutbol == 1) {
                        System.out.println("Desea usar ambas canchas de Futbol 11? (true/false)");
                        boolean ambasCanchas = scanner.nextBoolean();
                        if (ambasCanchas) {
                            System.out.println("Se han seleccionado ambas canchas de Futbol 11");
                            //Agregar logica para la doble reserva
                        }
                    }


                    System.out.println("Ahora se personalizaran las relgas del torneo");
                    System.out.println("Sustituciones máximas: mínimo 2, máximo 7.\n" +
                            "Duración del partido: 30 o 90 minutos (Se agregarán 30 minutos más a la reserva).\n" +
                            "Criterios de desempate: Goles a favor (GF), Goles en contra (GC) o Sorteo.\n" +
                            "En este caso deberán ser ingresados en orden de prioridad. Además, despúes de sorteo no podrán ir más criterios de desempate.");

                    System.out.println("Ingrese la cantidad de susticiones máximas.");

                    int Sustituciones = scanner.nextInt();

                    ArrayList<String> reglasFutbol = new ArrayList<>();

                    if ((Sustituciones < 2) || (Sustituciones > 7)) {
                        break;
                    } else {
                        reglasFutbol.add(Integer.toString(Sustituciones));
                    }

                    System.out.println("Ingrese la duración del partido.");
                    int duracionFutbol = scanner.nextInt();
                    if ((duracionFutbol < 30) || (duracionFutbol > 90)) {
                        break;
                    } else {
                        reglasFutbol.add(Integer.toString(duracionFutbol));
                    }

                    ArrayList<String> Criterios = new ArrayList<>();
                    System.out.println("Ingrese los criterios de desempate en orden de prioridad.");

                    while (!Criterios.contains("Sorteo")) {
                        String Criterio = scanner.next();
                        Criterios.add(Criterio);
                    }
                    System.out.println("Las siguientes serán las reglas personalizadas para este torneo:"); //ARREGLAR - Puede genrar un error si se pone sorteo como una opcion distinta a la ultima
                    System.out.println("Sustituciones máximas:" + reglasFutbol.getFirst()); //
                    System.out.println("Duración del partido:" + reglasFutbol.get(1));
                    System.out.println("Criterios de desempate:" + Criterios);

                    reglas = reglasFutbol;

                    System.out.println("Ahora, se ingresaran los nombres de los equipos participantes.");

                    List<Equipo> equiposParticipantes = new ArrayList<>();

                    for (int i = 0; i < 5; i++) {
                        System.out.println("Ingrese el nombre del equipo No. " + i + ":");
                        String nombreEquipo = scanner.next();
                        equiposParticipantes.add(new Equipo(nombreEquipo));

                    }

                    System.out.println("Los equipos inscritos en el torneo son:");
                    for (Equipo equipo : equiposParticipantes) {
                        System.out.println(equipo.getNombreEquipo());
                    }

                    int cantJugadores = switch (selccionanchaFutbol) {
                        case 1, 2 -> 18;
                        case 3 -> 16;
                        case 4 -> 14;
                        default -> 0; // Valor por defecto si no coincide con ningún caso
                    };


                    System.out.println("Ingrese los nombres de los jugadores por equipo");
                    for (int i = 0; i < equiposParticipantes.size(); i++) {
                        System.out.println("Los jugadores del equipo " + i + 1 + " son:");
                        for (int j = 0; j < cantJugadores; j++) {
                            System.out.println("Ingrese el nombre del jugador del equipo " + i + 1 + " No. " + j + 1 + ":");
                            String nombreJugador = scanner.next();
                            equiposParticipantes.get(i).setJugadores(nombreJugador);
                        }
                    }


                    salirTorneo = true;
                    break;


                case 2://basket
                    ArrayList<String> reglasBasket = new ArrayList<>();

                    System.out.println("Duración del partido: 4 períodos de 10 minutos (FIBA) o 12 minutos (NBA).\n" +
                            "Tiempos fuera por periodo: máximo 3");

                    System.out.println("Ingrese la duración del partido.");
                    int duracionBaloncesto = scanner.nextInt();
                    if ((duracionBaloncesto < 10) || (duracionBaloncesto > 12)) {
                        break;
                    } else {
                        reglasBasket.add(Integer.toString(duracionBaloncesto));
                    }

                    System.out.println("Ingrese la cantidad de cambios permitidos por periodo");
                    int cambios = scanner.nextInt();
                    if ((cambios < 0) || (cambios > 3)) {
                        break;
                    } else {
                        reglasBasket.add(Integer.toString(cambios));
                    }

                    System.out.println("");//Agregar prints de las reglas, etc

                    reglas = reglasBasket;

                    salirTorneo = true;
                    break;
                case 3://natacion
                    ArrayList<String> reglasNatacion = new ArrayList<>();
                    break;
                case 4://voleibol
                    break;
                case 5://salir
                    break;
                default:
                    System.out.println("Seleccione una opcion valide. Del 1 al 5");
            }
        }
    }
}