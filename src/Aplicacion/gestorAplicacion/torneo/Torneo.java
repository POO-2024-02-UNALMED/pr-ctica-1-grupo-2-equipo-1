package gestorAplicacion.torneo;

import gestorAplicacion.reservas.Instalacion;
import gestorAplicacion.reservas.Reserva;
import uiMain.Main;
import java.util.ArrayList;
import java.util.List;

import static uiMain.Main.crearInstalaciones;

public class Torneo {
    public static ArrayList<Torneo> torneos;
    private int idTorneo = 0;
    public String deporte;
    private ArrayList<Equipo> equiposParticipantes;
    private String seguroMedico;
    public float costoSeguroMedico;
    public double precioTotal;
    public Instalacion instalacion;
    public boolean ventaBoletasTorneo = false;
    public ArrayList<String> partidos;
    public ArrayList<String> reglas;
    private List<Reserva> reservas = new ArrayList<>();
    private ArrayList<String> arbitros = new ArrayList<>();

    public Torneo(String deporte, ArrayList<Equipo> equiposParticipantes, String seguroMedico, double precioTotal) {
        this.deporte = deporte;
        this.equiposParticipantes = equiposParticipantes;
        this.seguroMedico = seguroMedico;
        this.precioTotal = precioTotal;
    }

    public Torneo(int idTorneo) {
        this.idTorneo = idTorneo;
    }

    public Torneo() {
    }

    public void setDeporte(int num) {
        if (num == 1) {
            this.deporte = "Futbol";
        } else if (num == 2) {
            this.deporte = "Baloncesto";
        } else if (num == 3) {
            this.deporte = "Natacion";
        } else {
            this.deporte = "Voleibol";
        }
    }

    public String getDeporte(){
        return this.deporte;
    }

    ArrayList<Instalacion> inst = crearInstalaciones();//Se puede mover de esta calse si es necesario


    public ArrayList<Instalacion> getInstalaciones(int num) {
        ArrayList<Instalacion> instalaciones = new ArrayList<>();//Arreglar???

        if (num == 1) {
            instalaciones.add(inst.get(0));
            instalaciones.add(inst.get(1));
            instalaciones.add(inst.get(2));
            instalaciones.add(inst.get(3));
        } else if (num == 2) {
            instalaciones.add(inst.get(4));
            instalaciones.add(inst.get(5));
            instalaciones.add(inst.get(6));
        } else if (num == 3) {
            instalaciones.add(inst.get(10));
            instalaciones.add(inst.get(11));
        } else if (num == 4) {
            instalaciones.add(inst.get(7));
            instalaciones.add(inst.get(8));
            instalaciones.add(inst.get(9));
        }
        return instalaciones;
    }

    public void setInstalacion(int instalacion) {
        if (this.deporte.equals("Futbol")){
            if (instalacion == 1) {
                this.instalacion = inst.get(0);
            } else if (instalacion == 2) {
                this.instalacion = inst.get(1);
            } else if (instalacion == 3) {
                this.instalacion = inst.get(2);
            } else if (instalacion == 4) {
                this.instalacion = inst.get(3);
            }
        } else if (this.deporte.equals("Baloncesto")){
            if (instalacion == 1) {
                this.instalacion = inst.get(4);
            } else if (instalacion == 2) {
                this.instalacion = inst.get(5);
            } else if (instalacion == 3) {
                this.instalacion = inst.get(6);
            }
        } else if (this.deporte.equals("Natacion")){
            if (instalacion == 1) {
                this.instalacion = inst.get(10);
            } else if (instalacion == 2) {
                this.instalacion = inst.get(11);
            }
        } else if (this.deporte.equals("Voleibol")){
            if (instalacion == 1) {
                this.instalacion = inst.get(7);
            } else if (instalacion == 2) {
                this.instalacion = inst.get(8);
            } else if (instalacion == 3) {
                this.instalacion = inst.get(9);
            }
        }
    }

    public Instalacion getInstalacion(){
        return this.instalacion;
    }

    public void setReglas(ArrayList<String> reglas) {
        this.reglas = reglas;
    }

    public ArrayList<String> getReglas() {
        return this.reglas;
    }

    public void setEquiposParticipantes(ArrayList<Equipo> equiposParticipantes) {
        this.equiposParticipantes = equiposParticipantes;
    }

    public ArrayList<Equipo> getEquiposParticipantes(){
        return this.equiposParticipantes;
    }






    public void setEquiposParticipantes() {
        this.equiposParticipantes = equiposParticipantes;
    }

    public void asignarEquipos(ArrayList<Equipo> equipos) {
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





}



    //public void setDeporte(int number){}



/*
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
        int idCliente = new Scanner(System.in).nextInt();;
        System.out.println();// BOrrar

        Cliente cliente = new Cliente(nombreCliente, apellidoCliente, edadCliente, idCliente);

        Scanner scanner = new Scanner(System.in);

        System.out.println("Seleccione el deporte en el cual desea realizar el torneo");
        System.out.println("1. Futbol");
        System.out.println("2. Baloncesto");
        System.out.println("3. Natacion");
        System.out.println("4. Voleibol");
        System.out.println("5. Salir");
        System.out.println();


        //Agregar codigo para detectar si el clietne esta suscrito


        }
        int deporteTorneo = scanner.nextInt();

        ArrayList<Instalacion> inst = crearInstalaciones();

        while (!salirTorneo) {
            switch (deporteTorneo) {
                case 1://futbol

                    System.out.println("Seleccione la cancha en la que desea realizar el torneo");
                    System.out.println();
                    System.out.println("Instalaciones deisponibles");
                    System.out.println();
                    System.out.println("1. " + inst.getFirst().toString());
                    System.out.println("2. " + inst.get(1).toString());
                    System.out.println("3. " + inst.get(2).toString());
                    System.out.println("4. " + inst.get(3).toString());
                    System.out.println();
                    int seleccionCanchaFutbol = scanner.nextInt(); //Informacion necesaria para la reserva
                    /*
                    System.out.println("Ahora se personalizaran las relgas del torneo");
                    System.out.println();
                    System.out.println("Sustituciones máximas: mínimo 2, máximo 7.\n" +
                            "Duración del partido: 30 o 90 minutos (Se agregarán 30 minutos más a la reserva).\n" +
                            "Criterios de desempate: Goles a favor (GF), Goles en contra (GC) o Sorteo.\n" +
                            "En este caso deberán ser ingresados en orden de prioridad. Además, despúes de sorteo no podrán ir más criterios de desempate.");
                    System.out.println();
                    System.out.println("Ingrese la cantidad de susticiones máximas.");

                    int Sustituciones = scanner.nextInt();
                    System.out.println();

                    ArrayList<String> reglasFutbol = new ArrayList<>();

                    if ((Sustituciones < 2) || (Sustituciones > 7)) {
                        break;
                    } else {
                        reglasFutbol.add(Integer.toString(Sustituciones));
                    }

                    System.out.println("Ingrese la duración del partido.");
                    int duracionFutbol = scanner.nextInt();
                    System.out.println();
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
                    System.out.println();

                    System.out.println("Las siguientes serán las reglas personalizadas para este torneo:"); //ARREGLAR - Puede genrar un error si se pone sorteo como una opcion distinta a la ultima
                    System.out.println("Sustituciones máximas:" + reglasFutbol.getFirst()); //
                    System.out.println("Duración del partido:" + reglasFutbol.get(1));
                    System.out.println("Criterios de desempate:" + Criterios);
                    System.out.println();

                    reglas = reglasFutbol;

                    System.out.println("Ahora, se ingresaran los nombres de los equipos participantes.");
                    System.out.println();

                    List<Equipo> equiposParticipantesFutbol = new ArrayList<>();

                    for (int i = 0; i < 5; i++) {
                        System.out.println("Ingrese el nombre del equipo No. " + i + ":");
                        String nombreEquipo = scanner.next();
                        equiposParticipantesFutbol.add(new Equipo(nombreEquipo));
                        System.out.println();
                    }

                    System.out.println("Los equipos inscritos en el torneo son:");
                    for (Equipo equipo : equiposParticipantesFutbol) {
                        System.out.println(equipo.getNombreEquipo());
                    }

                    System.out.println();

                    System.out.println("Ahora, se ingresanran los arbitros - jueces para este torneo");

                    ArrayList<String >arbitrosFutbol = new ArrayList<>();

                    for (int i = 0; i < 2; i++) {
                        System.out.println("Ingrese el nombre del Arbitro - Juez No. " + i + 1 + ":");//Crear validacion en base de datos???
                        String arbitro = scanner.next();
                        arbitrosFutbol.add(arbitro);
                    }

                     arbitros = arbitrosFutbol;


                    ///Logica de reservas y agregar arbitros
                    List<Instalacion> instalaciones = crearInstalaciones();
                    if (instalaciones.isEmpty()) {
                        System.out.println("No hay instalaciones disponibles para reservas.");
                        return;
                    }

                    System.out.println("Creando reservas para el torneo de Futbol...");

                    for (int i = 0; i < equiposParticipantes.size() - 1; i++) {
                        for (int j = i + 1; j < equiposParticipantes.size(); j++) {
                            System.out.println("Seleccione un horario para el partido entre " +
                                    equiposParticipantes.get(i).getNombreEquipo() + " y " +
                                    equiposParticipantes.get(j).getNombreEquipo());

                            //int seleccionInstalacion = scanner.nextInt();
                            Instalacion instalacionSeleccionada = instalaciones.get(seleccionCanchaFutbol - 1);

                            System.out.println("Instalación seleccionada: " + instalacionSeleccionada.getNombre());

                            Horario horario = instalacionSeleccionada.getHorario(); // Obtener el horario de la instalación
                            System.out.println("Horario disponible: ");
                            System.out.println(horario);

                            System.out.println("Seleccione una hora de las disponibles:");
                            for (int k = 0; k < horario.getHorasDisponibles().size(); k++) {
                                System.out.println((k + 1) + ". " + horario.getHorasDisponibles().get(k) +
                                        " (" + horario.getCuposDisponibles().get(k) + " cupos disponibles)");
                            }
                            int seleccionHora = scanner.nextInt();
                            String horaReservada = horario.getHorasDisponibles().get(seleccionHora - 1);

                            // Reducir el cupo disponible para la hora seleccionada
                            List<Integer> cupos = horario.getCuposDisponibles();
                            cupos.set(seleccionHora - 1, cupos.get(seleccionHora - 1) - 1);

                            // Crear la reserva
                            Reserva reserva = new Reserva(instalacionSeleccionada, horario, horaReservada,
                                    equiposParticipantes.get(i), equiposParticipantes.get(j));
                            System.out.println("Reserva creada: " + reserva);
                        }
                    }

                    int cantJugadoresFutbol = switch (seleccionCanchaFutbol) {
                        case 1, 2 -> 18;
                        case 3 -> 16;
                        case 4 -> 14;
                        default -> 0; // Valor por defecto si no coincide con ningún caso
                    };


                    System.out.println("Ingrese los nombres de los jugadores por equipo");
                    System.out.println();
                    for (int i = 0; i < equiposParticipantes.size(); i++) {
                        System.out.println("Los jugadores del equipo " + i + 1 + " son:");
                        System.out.println();
                        for (int j = 0; j < cantJugadoresFutbol; j++) {
                            System.out.println("Ingrese el nombre del jugador del equipo " + i + 1 + " No. " + j + 1 + ":");
                            String nombreJugador = scanner.next();
                            equiposParticipantes.get(i).setJugadores(nombreJugador);
                        }
                        System.out.println();
                    }

                    for (int i = 0; i < equiposParticipantes.size(); i++) {
                        Equipo equipo = equiposParticipantes.get(i);
                        for (int j = 0; j < equipo.getJugadores().size(); j++) {
                            String jugador = equipo.getJugadores().get(j);
                            System.out.println("Al jugador: " + jugador + " ;del equipo: " + equipo.getNombreEquipo() + " se le ha asignado una valoracion medica.");
                        }
                        System.out.println();
                    }

                    System.out.println("Ofrecemos la opción de contratar un seguro médico para todos los equipos participantes del torneo.\n" +
                            "Este seguro cubre posibles lesiones o emergencias médicas que puedan surgir durante el evento.\n" +
                            "El costo adicional es de [monto del seguro] por equipo.");
                    System.out.println("El cliente desea adquirir el seguro? (si/no)");
                    scanner.nextLine();
                    String seguroFutbol = scanner.nextLine();

                    if (seguroFutbol.equals("si")) {
                        System.out.println("El seguro ha sido adquirido y se valor se va a ver reflejado en el costo final");
                    } else if (seguroFutbol.equals("no")) {
                        System.out.println("Al no optar por el seguro médico ofrecido, los equipos y sus representantes aceptan asumir toda la responsabilidad por posibles lesiones o emergencias médicas que puedan ocurrir durante el torneo.\n" +
                                "La organización no será responsable por ningún gasto médico ni relacionado con este tipo de eventualidades.");
                    }

                    salirTorneo = true;

                    break;

                case 2://basket
                    System.out.println("Seleccione la cancha en la que desea realizar el torneo");
                    System.out.println();
                    System.out.println("Instalaciones disponibles: ");
                    System.out.println();
                    System.out.println("5. " + inst.get(4).toString());
                    System.out.println("6. " + inst.get(5).toString());
                    System.out.println("7. " + inst.get(6).toString());

                    int seleccionCanchaBasket = scanner.nextInt();//Se usa para la reserva de las canchas

                    System.out.println("Ahora se personalizaran las relgas del torneo");
                    System.out.println();

                    ArrayList<String> reglasBasket = new ArrayList<>();

                    System.out.println("Duración del partido: 4 períodos de 10 minutos (FIBA) o 12 minutos (NBA).\n" +
                            "Tiempos fuera por periodo: máximo 3\n");

                    System.out.println("Ingrese la duración del partido.");
                    int duracionBaloncesto = scanner.nextInt();
                    System.out.println();
                    if ((duracionBaloncesto < 10) || (duracionBaloncesto > 12)) {
                        break;
                    } else {
                        reglasBasket.add(Integer.toString(duracionBaloncesto));
                    }

                    System.out.println("Ingrese la cantidad de tiempos fuera permitidos por periodo");
                    int tiemposFuera = scanner.nextInt();
                    System.out.println();
                    if ((tiemposFuera < 0) || (tiemposFuera > 3)) {
                        break;
                    } else {
                        reglasBasket.add(Integer.toString(tiemposFuera));
                    }

                    System.out.println("Las siguientes serán las reglas personalizadas para este torneo:");
                    System.out.println("Sustituciones máximas:" + reglasBasket.getFirst());
                    System.out.println("Tiempos fuera por periodo: " + tiemposFuera);
                    System.out.println();

                    reglas = reglasBasket;

                    System.out.println("Ahora, se ingresaran los nombres de los equipos participantes.");
                    System.out.println();

                    List<Equipo> equiposParticipantesBasket = new ArrayList<>();

                    for (int i = 0; i < 5; i++) {
                        System.out.println("Ingrese el nombre del equipo No. " + i + ":");
                        String nombreEquipo = scanner.next();
                        equiposParticipantesBasket.add(new Equipo(nombreEquipo));
                        System.out.println();
                    }

                    System.out.println("Los equipos inscritos en el torneo son:");
                    for (Equipo equipo : equiposParticipantesBasket) {
                        System.out.println(equipo.getNombreEquipo());
                    }

                    System.out.println();

                    System.out.println("Ahora, se ingresanran los arbitros - jueces para este torneo");

                    ArrayList<String >arbitrosBasket = new ArrayList<>();

                    for (int i = 0; i < 2; i++) {
                        System.out.println("Ingrese el nombre del Arbitro - Juez No. " + i + 1 + ":");//Crear validacion en base de datos???
                        String arbitro = scanner.next();
                        arbitrosBasket.add(arbitro);
                    }

                    arbitros = arbitrosBasket;

                    //Logica para reservas

                    int cantJugadoresBasket = 12;

                    System.out.println("Ingrese los nombres de los jugadores por equipo");
                    System.out.println();
                    for (int i = 0; i < equiposParticipantesBasket.size(); i++) {
                        System.out.println("Los jugadores del equipo " + i + 1 + " son:");
                        System.out.println();
                        for (int j = 0; j < cantJugadoresBasket; j++) {
                            System.out.println("Ingrese el nombre del jugador del equipo " + i + 1 + " No. " + j + 1 + ":");
                            String nombreJugador = scanner.next();
                            equiposParticipantesBasket.get(i).setJugadores(nombreJugador);
                        }
                        System.out.println();
                    }

                    for (int i = 0; i < equiposParticipantesBasket.size(); i++) {
                        Equipo equipo = equiposParticipantesBasket.get(i);
                        for (int j = 0; j < equipo.getJugadores().size(); j++) {
                            String jugador = equipo.getJugadores().get(j);
                            System.out.println("Al jugador: " + jugador + " ;del equipo: " + equipo.getNombreEquipo() + " se le ha asignado una valoracion medica.");
                        }
                        System.out.println();
                    }

                    System.out.println("Ofrecemos la opción de contratar un seguro médico para todos los equipos participantes del torneo.\n" +
                            "Este seguro cubre posibles lesiones o emergencias médicas que puedan surgir durante el evento.\n" +
                            "El costo adicional es de [monto del seguro] por equipo.");
                    System.out.println("El cliente desea adquirir el seguro? (si/no)");
                    scanner.nextLine();
                    String seguroBasket = scanner.nextLine();

                    if (seguroBasket.equals("si")) {
                        System.out.println("El seguro ha sido adquirido y se valor se va a ver reflejado en el costo final");
                    } else if (seguroBasket.equals("no")) {
                        System.out.println("Al no optar por el seguro médico ofrecido, los equipos y sus representantes aceptan asumir toda la responsabilidad por posibles lesiones o emergencias médicas que puedan ocurrir durante el torneo.\n" +
                                "La organización no será responsable por ningún gasto médico ni relacionado con este tipo de eventualidades.");
                    }

                    salirTorneo = true;
                    break;
                case 3://natacion
                    System.out.println("Seleccione la piscina en la que desea realizar el torneo");
                    System.out.println();
                    System.out.println("Instalaciones disponibles: ");
                    System.out.println();
                    System.out.println("11. " + inst.get(10).toString());
                    System.out.println("12. " + inst.get(11).toString());

                    int seleccionPiscina = scanner.nextInt();

                    ArrayList<String> reglasNatacion = new ArrayList<>();

                    System.out.println("Ahora se personalizaran las reglas del torneo");
                    System.out.println();
                    System.out.println("Formato de competencia:\n" +
                            "1. Relevos (2 Participantes por equipo)\n" +
                            "2. Mejor tiempo\n" +
                            "Para ambos formatos se realiza una reserva de dos horas, indiferente de la piscina seleccionada");

                    int formatoNatacion = scanner.nextInt();

                    if (formatoNatacion == 2) {
                        reglasNatacion.add("Mejor tiempo");
                        System.out.println("Ingrese la cantidad de intentos maximos por participante");
                        int intentosNatacion = scanner.nextInt();
                        reglasNatacion.add(String.valueOf(intentosNatacion));
                        System.out.println();
                    } else if (formatoNatacion == 1) {
                        reglasNatacion.add("Relevos");
                    }

                    System.out.println("Las siguientes serán las reglas personalizadas para este torneo:");
                    if (formatoNatacion == 1) {
                        System.out.println("Formato de competencia: " +reglasNatacion.get(0));
                    }   else if (formatoNatacion == 2) {
                        System.out.println("Formato de competencia: " +reglasNatacion.get(0));
                        System.out.println("Intentos maximos por competidor: " +reglasNatacion.get(1));
                    }

                    reglas = reglasNatacion;

                    
                    salirTorneo = true;
                    break;
                case 4://voleibol
                    break;
                case 5://salir
                    break;
                default:
                    System.out.println("Seleccione una opcion valida. Del 1 al 5");
            }

        }
    }
}*/
