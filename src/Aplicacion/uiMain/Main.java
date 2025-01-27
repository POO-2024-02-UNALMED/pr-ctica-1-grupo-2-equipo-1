/*Archivo principal del programa
PRUEBA
PRUEBA
Donde se programa la UI de consola del programa

NO CAMBIAR SIN PREGUNTAR PRECAUCION

*/
//Falta logica para cada opcion. Simplemente es una idea de lo que puede ser la base. Hay "errores" en el switch


// Se crean instalaciones basicas

//Agregar descripciones de las instalaciones

package uiMain;

import gestorAplicacion.entidades.Trabajador;
import gestorAplicacion.pagos.Boleta;
import gestorAplicacion.pagos.Cliente;
import gestorAplicacion.pagos.Suscripcion;
import gestorAplicacion.pagos.TipoSuscripcion;
import gestorAplicacion.reservas.Instalacion;
import gestorAplicacion.reservas.Reserva;
import gestorAplicacion.torneo.Equipo;
import gestorAplicacion.torneo.Torneo;
import gestorAplicacion.inscripcion.Joven;
import java.util.Random;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Scanner;
import gestorAplicacion.eventos.Evento;
import gestorAplicacion.eventos.Localidad;
import gestorAplicacion.reservas.Instalacion;


public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Creación de todas las instalaciones
        ArrayList<Instalacion> instalaciones = crearInstalaciones();

        ArrayList<Trabajador> arbitrosTodos = crearArbitros();

        ArrayList<Trabajador> medicos = crearMedicos();

        Torneo torneoBase = new Torneo(9999);

        boolean salir = false;

        // Menú principal
        while (!salir) {
            System.out.println("\n===== Menú Principal =====");
            System.out.println("1. Realizar Reservas");
            System.out.println("2. Realizar Inscripciones a Deportes Formativos");
            System.out.println("3. Crear Torneos");
            System.out.println("4. Crear Eventos (Concierto)");
            System.out.println("5. Taquilla (Pagos)");
            System.out.println("6. Administar Clientes");
            System.out.println("7. Salir del sistema");
            System.out.print("Seleccione una opción: ");

            int opcion = scanner.nextInt();

            switch (opcion) {
                case 1:
                    //realizarReservas(scanner, instalaciones, enfermeros, acompanantes);
                    break;

                case 2:
                    //realizarInscripciones(scanner);
                    break;

                case 3:
                    crearTorneos(medicos, arbitrosTodos);
                    //Logica en la parte inferior de esta clase
                    break;

                case 4:
                    crearEvento();
                    break;

                case 5:
                    pagosUI();
                    break;

                case 6:
                    clientesUI();
                    break;

                case 7:
                    System.out.println("Saliendo del sistema. ¡Hasta pronto!");
                    salir = true;
                    break;

                default:
                    System.out.println("Opción inválida. Por favor, seleccione una opción del 1 al 6.");
            }
        }

        scanner.close();
    }
    ///////////////////////////////CLIENTES INTERFAZ///////////////////////////////
    public static void clientesUI(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("-----Administracion Clientes-----");
        System.out.println("1: Crear cliente\n2: Visualizar cliente ");
        int opcion = scanner.nextInt();

        if(opcion == 1){
            System.out.println("---Crear Cliente---");
            System.out.println("Nombre: ");
            String nombre = scanner.nextLine();
            scanner.nextLine();

            System.out.println("Apellido: ");
            String apellido = scanner.nextLine();

            System.out.println("Edad: ");
            int edad = scanner.nextInt();

            Cliente cliente = new Cliente(nombre,apellido,edad);

            System.out.println("Cliente creado recordar su ID,\n Informacion:");
            System.out.println(cliente);
            System.out.println("Si desea una suscripcion, realizarla en pagos");
        }
        else if(opcion == 2){
            System.out.println("---Visualizar Cliente---");
            System.out.println("Ingrese el id de su cliente: ");
            int idCliente = scanner.nextInt();

            Cliente clienteEncontrado = Cliente.obtenerCliente(idCliente);
            if(clienteEncontrado != null){
                System.out.println(clienteEncontrado);
            }else{
                System.out.println("Cliente no encontrado con ese ID");
            }
        }else{
            System.out.println("Su opcion es invalidad,ingresar una opcion correcta");
        }

    }


    ////////////////////////////////////PAGOS INTERFAZ///////////////////////////////
    public static void pagosUI(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("-----Pagos y/o Suscripciones-----");

        boolean corriendo = true;
        do{
            System.out.println("1: Pago via ID\n2: Pago boleta de evento\n3: Administrar Suscripcion\n4: Salir de pagos");
            int opcionPagoID = scanner.nextInt();
            switch (opcionPagoID){
                //Pago via ID
                case 1:
                    System.out.println("-----Pago Reserva------");
                    System.out.println("Ingrese el ID de la reserva: ");
                    int idIngresado = scanner.nextInt();
                    Reserva reserva = Reserva.buscarReserva(idIngresado);
                    int totalPago = 10000;
                    if(reserva != null){
                        Cliente cliente = reserva.getCliente();
                        System.out.println("Reserva encontrada");
                        System.out.println("En nombre de: " + cliente.getNombre() + " " + cliente.getApellido());
                        System.out.println("Total a pagar: " + totalPago);
                        System.out.println("Desea realizar el pago?\n1:Si\n2:No");
                        int opcion = scanner.nextInt();
                        if(opcion == 1){
                            System.out.println("Ingrese el monto a pagar: ");
                            int montoIngresado = scanner.nextInt();
                            System.out.println("Felicitaciones por su pago");
                            System.out.println("ID: "+reserva.getID());
                            System.out.println("Nombre: " + cliente.getNombre() + " " + cliente.getApellido());
                            System.out.println("Total: "+ totalPago);
                            System.out.println("Monto dado: "+ montoIngresado);
                            System.out.println("Vuelto" + (montoIngresado - totalPago));
                            System.out.println("Gracias por elegirnos");
                            corriendo = false;
                        }else if(opcion == 2){
                            System.out.println("Gracias vuelva pronto");
                            corriendo = false;
                        }else{
                            System.out.println("Opcion no disponible,eliga otra opcion");
                        }
                    }else{
                        System.out.println("Reserva no encontrada porfavor ingresar un ID correcto");
                    }
                    break;
                    //Pago boletas
                case 2:
                    System.out.println("-----Pago Boleta-----");
                    System.out.println("Ingrese el ID de la boleta");
                    int idBoleta = scanner.nextInt();
                    Boleta boleta = Boleta.buscarBoleta(idBoleta);

                    if(boleta != null){
                        if(boleta.isPagada()){
                            System.out.println("Boleta encontrada \n"+boleta);
                            System.out.println("Desea realizar el pago?\n1: Si\n2: No");
                            int opcionPago = scanner.nextInt();
                            if(opcionPago == 1){
                                System.out.println("Ingrese el monto a pagar:");
                                int montoIngresado = scanner.nextInt();
                                System.out.println("Felicidades, boleta pagada \n"+boleta+"Total: "+boleta.getPrecio()+"\nonto ingresado: "+montoIngresado+"\n Vuelto: "+(montoIngresado-boleta.getPrecio()));
                                boleta.setPagada(true);
                                corriendo = false;
                            }else if(opcionPago == 2){
                                System.out.println("Gracias vuelva pronto");
                                corriendo = false;
                            }else{
                                System.out.println("Opcion no disponible,escoga una opcion valida");
                            }
                        }else{
                            System.out.println("Su boleta ya se encuentra pagada");
                        }
                    }else{
                        System.out.println("Boleta no encontrada");
                    }
                    break;
                    //Realizar suscripciones
                case 3:
                    System.out.println("---Administracion Suscripcion---");
                    System.out.println("1: Renovar Suscripcion\n2: Suscribirse al programa\n3: Salir");
                    int opcionSuscripcion = scanner.nextInt();
                    if(opcionSuscripcion == 1){
                        System.out.println("--Renovacion Suscripcion--");
                        System.out.println("Ingrese el ID de su cliente: ");
                        int idCliente = scanner.nextInt();
                        Cliente cliente = Cliente.obtenerCliente(idCliente);
                        if(cliente != null){
                            Suscripcion suscripcion= cliente.getSuscripcion();
                            System.out.println(cliente);
                            if(suscripcion.getTipoSuscripcion() == TipoSuscripcion.NOTIENE){
                                System.out.println("Usted no posee suscripcion por favor crearla");
                            }else{
                                System.out.println("Su suscripcion vence el: " + suscripcion.getFinSuscripcion());
                                System.out.println("Monto a pagar: " + suscripcion.getTipoSuscripcion().getPrecio());
                                System.out.println("Proceder con el renovamiento? \n1: Si\n2: No");
                                int opcionRenovamiento = scanner.nextInt();
                                if(opcionRenovamiento == 1){
                                    System.out.println("Felicidades haz renovado tu suscripcion hasta el: "+ LocalDateTime.now().plusMonths(1));
                                    suscripcion.setFinSuscripcion(LocalDate.now().plusMonths(1));
                                    corriendo = false;
                                }else if(opcionRenovamiento == 2){
                                    System.out.println("Gracias, vuelva pronto");
                                    corriendo = false;
                                }else{
                                    System.out.println("Opcion no disponible,ingrese una opcion correcta");
                                }
                            }
                        }
                    }else if(opcionSuscripcion == 2){
                        System.out.println("Ingrese el ID de su cliente: ");
                        int idCliente = scanner.nextInt();
                        Cliente cliente = Cliente.obtenerCliente(idCliente);
                        if(cliente != null){
                            System.out.println("--Realizar Suscripcion--");
                            System.out.println(cliente);
                            Suscripcion suscripcion = cliente.getSuscripcion();
                            System.out.println("Eliga una entre estas suscripciones: \n1: Rookie\n2: Pro Player\n3: MVP\n4: Salirse");
                            int opcionTiposSuscripciones = scanner.nextInt();
                            if(opcionTiposSuscripciones == 1){
                                suscripcion.setTipoSuscripcion(TipoSuscripcion.ROOKIE);
                                System.out.println("Suscripcion creada tipo ROOKIE");
                                System.out.println(suscripcion);
                                corriendo = false;
                            } else if (opcionTiposSuscripciones == 2) {
                                suscripcion.setTipoSuscripcion(TipoSuscripcion.PROPLAYER);
                                System.out.println("Suscripcion creada tipo PROPLAYER");
                                System.out.println(suscripcion);
                                corriendo = false;
                            } else if (opcionTiposSuscripciones == 3) {
                                suscripcion.setTipoSuscripcion(TipoSuscripcion.MVP);
                                System.out.println("Suscripcion creada tipo MVP");
                                System.out.println(suscripcion);
                                corriendo = false;
                            } else if (opcionTiposSuscripciones == 4) {
                                System.out.println("Gracias vuelva pronto");
                                corriendo = false;
                            }else{
                                System.out.println("Eliga una opcion valida");
                            }
                        }else{
                            System.out.println("ID de cliente no encontrado");
                        }
                    }
                    break;
                case 4:
                    System.out.println("Saliendo de pagos");
                    corriendo = false;
                    break;
                default:
                    System.out.println("Opcion no encontrada, por favor seleccione alguna opcion correcta");
            }
        }while(corriendo);
    }


    //Metodo para crear Torneos
    private static void crearTorneos(ArrayList<Trabajador> medicos, ArrayList<Trabajador> arbitrosTodos) {
        System.out.println("Antes de empezar con la creacion del torneo, se requieren unos datos del cliente");
        System.out.println("Ingrese su nombre");
        String nombreCliente = new Scanner(System.in).nextLine();
        System.out.println("Ingrese su apellido");
        String apellidoCliente = new Scanner(System.in).nextLine();
        System.out.println("Ingrese su edad");
        int edadCliente = new Scanner(System.in).nextInt();
        System.out.println("Ingrese su ID");
        int idCliente = new Scanner(System.in).nextInt();
        System.out.println();

        Cliente cliente = new Cliente(nombreCliente, apellidoCliente, edadCliente, idCliente);

        System.out.println("Seleccione el deporte en el cual desea realizar el torneo");
        System.out.println("1. Futbol");
        System.out.println("2. Baloncesto");
        System.out.println("3. Natacion");
        System.out.println("4. Voleibol");
        System.out.println("5. Salir");

        Torneo torneo = new Torneo();

        int deporteTorneo = new Scanner(System.in).nextInt();
        System.out.println();
        if (deporteTorneo == 5) {
            System.out.println("Saliendo...");
            return;
        }

        // Asignar deporte (Futbol, Baloncesto, Natación, Voleibol)
        torneo.setDeporte(deporteTorneo);

        // ========================================================
        // 1) Mostrar instalaciones disponibles para el deporte
        // ========================================================
        ArrayList<Instalacion> instalacionesTorneo = torneo.getInstalaciones(deporteTorneo);

        System.out.println("Seleccione una de las instalaciones disponibles para el torneo:");
        int contador = 1;
        for (Instalacion instalacion : instalacionesTorneo) {
            System.out.println(contador + ". " + instalacion.getNombre());
            contador++;
        }

        int seleccionInstalacion = new Scanner(System.in).nextInt();
        System.out.println();

        // Guardamos la instalación elegida en el torneo
        torneo.setInstalacion(seleccionInstalacion);

        // ========================================================
        // 2) Reglas específicas de cada deporte
        // ========================================================
        System.out.println("Ahora se personalizarán las reglas del torneo");
        System.out.println();

        boolean salir = false;
        switch (deporteTorneo) {
            case 1: // ========== FUTBOL ==========
                while (!salir) {
                    System.out.println("Sustituciones máximas: mínimo 2, máximo 7.\n" +
                            "Duración del partido: 30 o 90 minutos (Se realiza una reserva de dos horas).\n" +
                            "Criterios de desempate: Goles a favor (GF), Goles en contra (GC) o Sorteo.\n" +
                            "(Se ingresan en orden de prioridad; después de Sorteo no pueden ir más criterios).");
                    System.out.println();

                    System.out.println("Ingrese la cantidad de sustituciones máximas:");
                    int Sustituciones = new Scanner(System.in).nextInt();
                    System.out.println();

                    if ((Sustituciones < 2) || (Sustituciones > 7)) {
                        System.out.println("Número de sustituciones fuera de rango. Terminando...");
                        break;
                    }

                    System.out.println("Ingrese la duración del partido (30 o 90):");
                    int duracionFutbol = new Scanner(System.in).nextInt();
                    System.out.println();
                    if (duracionFutbol != 30 && duracionFutbol != 90) {
                        System.out.println("Duración fuera de rango. Terminando...");
                        break;
                    }

                    // Criterios
                    ArrayList<String> criterios = new ArrayList<>();
                    System.out.println("Ingrese los criterios de desempate en orden de prioridad. (Escriba 'Sorteo' para terminar)");
                    while (!criterios.contains("Sorteo")) {
                        String criterio = new Scanner(System.in).nextLine();
                        criterios.add(criterio);
                    }

                    // Armar la lista de reglas
                    ArrayList<String> reglasFutbol = new ArrayList<>();
                    reglasFutbol.add(Integer.toString(Sustituciones));
                    reglasFutbol.add(Integer.toString(duracionFutbol));
                    // Podrías concatenar los criterios si así lo deseas, o guardarlos aparte
                    // Por simplicidad, lo dejamos como un "extra" en la lista
                    reglasFutbol.add("Criterios: " + criterios);

                    // Mostrar las reglas
                    System.out.println("Las siguientes serán las reglas personalizadas para este torneo:");
                    System.out.println("Sustituciones máximas: " + Sustituciones);
                    System.out.println("Duración del partido: " + duracionFutbol);
                    System.out.println("Criterios de desempate: " + criterios);
                    System.out.println();

                    torneo.setReglas(reglasFutbol);
                    salir = true;
                }
                break;

            case 2: // ========== BALONCESTO ==========
                while (!salir) {
                    ArrayList<String> reglasBasket = new ArrayList<>();

                    System.out.println("Duración del partido: 4 períodos de 10 minutos (FIBA) o 12 minutos (NBA).\n" +
                            "Tiempos fuera por periodo: máximo 3.\n" +
                            "(Se realiza una reserva de dos horas).");

                    System.out.println("Ingrese la duración del partido (10 o 12):");
                    int duracionBaloncesto = new Scanner(System.in).nextInt();
                    if (duracionBaloncesto != 10 && duracionBaloncesto != 12) {
                        System.out.println("Duración fuera de rango. Terminando...");
                        break;
                    }

                    System.out.println("Ingrese la cantidad de tiempos fuera permitidos por periodo (0 a 3):");
                    int tiemposFuera = new Scanner(System.in).nextInt();
                    if (tiemposFuera < 0 || tiemposFuera > 3) {
                        System.out.println("Número de tiempos fuera inválido. Terminando...");
                        break;
                    }

                    reglasBasket.add("Duración: " + duracionBaloncesto);
                    reglasBasket.add("Tiempos fuera: " + tiemposFuera);

                    System.out.println("Las siguientes serán las reglas personalizadas para este torneo:");
                    System.out.println("Duración del partido: " + duracionBaloncesto);
                    System.out.println("Tiempos fuera por periodo: " + tiemposFuera);
                    System.out.println();

                    torneo.setReglas(reglasBasket);
                    salir = true;
                }
                break;

            case 3: // ========== NATACION ==========
                while (!salir) {
                    ArrayList<String> reglasNatacion = new ArrayList<>();

                    System.out.println("Formato de competencia:\n" +
                            "1. Relevos (2 Participantes por equipo)\n" +
                            "2. Mejor tiempo (Competencia individual)\n" +
                            "(Se realiza una reserva de dos horas).");

                    System.out.println("Ingrese el formato de competencia: (1 o 2)");
                    int formatoNatacion = new Scanner(System.in).nextInt();

                    if (formatoNatacion == 1) {
                        // Relevos
                        reglasNatacion.add("Relevos");
                    } else if (formatoNatacion == 2) {
                        // Mejor tiempo
                        reglasNatacion.add("Mejor tiempo");
                        System.out.println("Ingrese la cantidad de intentos máximos por participante (1 a 5):");
                        int intentosNatacion = new Scanner(System.in).nextInt();
                        if (intentosNatacion < 1 || intentosNatacion > 5) {
                            System.out.println("Número de intentos inválido. Terminando...");
                            break;
                        }
                        reglasNatacion.add("Intentos: " + intentosNatacion);
                    } else {
                        System.out.println("Formato desconocido. Terminando...");
                        break;
                    }

                    // Mostrar las reglas
                    System.out.println("Las siguientes serán las reglas personalizadas para este torneo:");
                    for (String regla : reglasNatacion) {
                        System.out.println("- " + regla);
                    }
                    System.out.println();

                    torneo.setReglas(reglasNatacion);
                    salir = true;
                }
                break;

            case 4: // ========== VOLEIBOL ==========
                while (!salir) {
                    ArrayList<String> reglasVoleibol = new ArrayList<>();

                    System.out.println("Cantidad de sets: 2 o 5.\n" +
                            "Indiferente de la cantidad de sets, se realiza una reserva de dos horas.\n" +
                            "Altura de la malla: 2.24 mts o 2.43 mts.");

                    System.out.println("Ingrese la cantidad de sets (2 o 5):");
                    int setsVoleibol = new Scanner(System.in).nextInt();
                    if (setsVoleibol != 2 && setsVoleibol != 5) {
                        System.out.println("Cantidad de sets fuera de rango. Terminando...");
                        break;
                    }

                    System.out.println("Ingrese la altura de la malla (2.24 o 2.43):");
                    float alturaVoleibol = new Scanner(System.in).nextFloat();
                    if (alturaVoleibol != 2.24f && alturaVoleibol != 2.43f) {
                        System.out.println("Altura de la malla fuera de rango. Terminando...");
                        break;
                    }

                    reglasVoleibol.add("Sets: " + setsVoleibol);
                    reglasVoleibol.add("Altura malla: " + alturaVoleibol);

                    System.out.println("Las siguientes serán las reglas personalizadas para este torneo:");
                    System.out.println("Cantidad de sets: " + setsVoleibol);
                    System.out.println("Altura de la malla: " + alturaVoleibol);

                    torneo.setReglas(reglasVoleibol);
                    salir = true;
                }
                break;
        }
        // ==========================================================
        // 3) Inscripción de equipos y jugadores según la instalación
        // ==========================================================

        // Recuperamos la instalación seleccionada
        Instalacion instalacionElegida = torneo.getInstalacion();
        String nombreInstalacion = instalacionElegida.getNombre();
        String deporte = torneo.getDeporte();  // "Futbol", "Baloncesto", "Natacion", "Voleibol"

        // Lista para guardar equipos (o competidores en natación individual)
        ArrayList<Equipo> equiposTorneo = new ArrayList<>();

        if (deporte.equals("Futbol")) {
            // A partir de la instalación seleccionada, deducir la modalidad
            // "Cancha F11 Grande", "Cancha F11"  => 17 jugadores
            // "Cancha F9" => 15 jugadores
            // "Cancha F7" => 13 jugadores
            int numJugadoresFutbol = 0;
            if (nombreInstalacion.contains("F11")) {
                numJugadoresFutbol = 17;
            } else if (nombreInstalacion.contains("F9")) {
                numJugadoresFutbol = 15;
            } else if (nombreInstalacion.contains("F7")) {
                numJugadoresFutbol = 13;
            }

            System.out.println("Ahora, se ingresarán los nombres de los equipos participantes de Fútbol.");
            System.out.println("Usted ha seleccionado " + nombreInstalacion + ". Cada equipo tendrá " + numJugadoresFutbol + " jugadores.");
            System.out.println();

            // Supongamos 5 equipos
            for (int i = 1; i <= 5; i++) {
                System.out.println("Ingrese el nombre del equipo N° " + i + ":");
                String nombreEquipo = new Scanner(System.in).nextLine();
                Equipo equipo = new Equipo(nombreEquipo);

                // Registrar jugadores
                for (int j = 1; j <= numJugadoresFutbol; j++) {
                    System.out.println("Ingrese el nombre del jugador N° " + j + " del equipo " + nombreEquipo + ":");
                    String nombreJugador = new Scanner(System.in).nextLine();
                    equipo.setJugadores(nombreJugador);
                }

                equiposTorneo.add(equipo);
                System.out.println();
            }

        } else if (deporte.equals("Baloncesto")) {
            // Baloncesto siempre 12 jugadores
            System.out.println("Ahora, se ingresarán los nombres de los equipos de Baloncesto.");
            System.out.println("Usted ha seleccionado " + nombreInstalacion + ". Cada equipo tendrá 12 jugadores.");
            System.out.println();

            for (int i = 1; i <= 5; i++) {
                System.out.println("Ingrese el nombre del equipo N° " + i + ":");
                String nombreEquipo = new Scanner(System.in).nextLine();
                Equipo equipo = new Equipo(nombreEquipo);

                for (int j = 1; j <= 12; j++) {
                    System.out.println("Ingrese el nombre del jugador N° " + j + " del equipo " + nombreEquipo + ":");
                    String nombreJugador = new Scanner(System.in).nextLine();
                    equipo.setJugadores(nombreJugador);
                }

                equiposTorneo.add(equipo);
                System.out.println();
            }

        } else if (deporte.equals("Voleibol")) {
            // Voleibol también 12 jugadores
            System.out.println("Ahora, se ingresarán los nombres de los equipos de Voleibol.");
            System.out.println("Usted ha seleccionado " + nombreInstalacion + ". Cada equipo tendrá 12 jugadores.");
            System.out.println();

            for (int i = 1; i <= 5; i++) {
                System.out.println("Ingrese el nombre del equipo N° " + i + ":");
                String nombreEquipo = new Scanner(System.in).nextLine();
                Equipo equipo = new Equipo(nombreEquipo);

                for (int j = 1; j <= 12; j++) {
                    System.out.println("Ingrese el nombre del jugador N° " + j + " del equipo " + nombreEquipo + ":");
                    String nombreJugador = new Scanner(System.in).nextLine();
                    equipo.setJugadores(nombreJugador);
                }

                equiposTorneo.add(equipo);
                System.out.println();
            }

        } else if (deporte.equals("Natacion")) {
            // Revisar si es Relevos o Mejor tiempo según las reglas
            ArrayList<String> reglasNatacion = torneo.getReglas();
            if (reglasNatacion == null || reglasNatacion.isEmpty()) {
                System.out.println("No se definieron reglas para Natación. Saliendo...");
                return;
            }

            String formato = reglasNatacion.get(0); // "Relevos" o "Mejor tiempo"
            if (formato.equals("Relevos")) {
                // 2 participantes por equipo
                System.out.println("Formato Relevos: Cada equipo tendrá 2 participantes.");
                System.out.println("Ahora, se ingresarán los nombres de los equipos participantes.");
                System.out.println();

                for (int i = 1; i <= 5; i++) {
                    System.out.println("Ingrese el nombre del equipo N° " + i + ":");
                    String nombreEquipo = new Scanner(System.in).nextLine();
                    Equipo equipo = new Equipo(nombreEquipo);

                    for (int j = 1; j <= 2; j++) {
                        System.out.println("Ingrese el nombre del nadador N° " + j + " del equipo " + nombreEquipo + ":");
                        String nombreNadador = new Scanner(System.in).nextLine();
                        equipo.setJugadores(nombreNadador);
                    }

                    equiposTorneo.add(equipo);
                    System.out.println();
                }

            } else if (formato.equals("Mejor tiempo")) {
                // Competencia individual => cada “equipo” es un solo participante
                System.out.println("Formato Mejor tiempo: Competencia individual.");
                System.out.println("Ahora, se ingresarán los nombres de los competidores (cada uno es un equipo).");
                System.out.println();

                for (int i = 1; i <= 5; i++) {
                    System.out.println("Ingrese el nombre del competidor N° " + i + ":");
                    String nombreCompetidor = new Scanner(System.in).nextLine();
                    // Creamos un 'Equipo' con ese nombre
                    Equipo competidor = new Equipo(nombreCompetidor);
                    // Agregamos al propio competidor como único jugador
                    competidor.setJugadores(nombreCompetidor);

                    equiposTorneo.add(competidor);
                    System.out.println();
                }
            }
        }

        // Registrar los equipos en el torneo
        torneo.setEquiposParticipantes(equiposTorneo);

        Random rand = new Random();

// 1. AGENDA CITA MÉDICA PARA CADA EQUIPO
        System.out.println("\n=== AGENDANDO VALORACIÓN MÉDICA PREVIA PARA CADA EQUIPO ===");
        for (Equipo equipo : equiposTorneo) {
            // Elige un médico aleatorio
            int indiceMedico = rand.nextInt(medicos.size());
            Trabajador medicoAsignado = medicos.get(indiceMedico);

            // Marcar como ocupado si deseas
            medicoAsignado.setOcupado(true);

            System.out.println("Al equipo '" + equipo.getNombreEquipo()
                    + "' se le ha asignado el médico: "
                    + medicoAsignado.getNombre() + " " + medicoAsignado.getApellido());
        }

// 2. ALEATORIAMENTE, UN JUGADOR NO PASA LA VALORACIÓN Y SE REEMPLAZA
        System.out.println("\n=== VERIFICANDO RESULTADOS DE VALORACIONES MÉDICAS ===");
        ArrayList<String> listaGlobalJugadores = new ArrayList<>();
        ArrayList<Equipo> referenciaEquipo = new ArrayList<>();

        for (Equipo eq : equiposTorneo) {
            for (String jugador : eq.getJugadores()) {
                listaGlobalJugadores.add(jugador);
                referenciaEquipo.add(eq);
            }
        }

        if (!listaGlobalJugadores.isEmpty()) {
            int indiceJugadorFallido = rand.nextInt(listaGlobalJugadores.size());
            String jugadorFallido = listaGlobalJugadores.get(indiceJugadorFallido);
            Equipo equipoAfectado = referenciaEquipo.get(indiceJugadorFallido);

            System.out.println("El jugador '" + jugadorFallido
                    + "' del equipo '" + equipoAfectado.getNombreEquipo()
                    + "' NO pasó la valoración médica.");

            // Lo eliminamos del equipo
            equipoAfectado.getJugadores().remove(jugadorFallido);

            // Pedimos un nuevo jugador
            System.out.println("Ingrese el nombre de un nuevo jugador para reemplazarlo:");
            String nuevoJugador = new Scanner(System.in).nextLine();
            equipoAfectado.setJugadores(nuevoJugador);

            System.out.println("El jugador '" + nuevoJugador
                    + "' ha sido registrado exitosamente en el equipo '"
                    + equipoAfectado.getNombreEquipo() + "'.");
        } else {
            System.out.println("No hay jugadores inscritos.");
        }

// 3. OFRECER SEGURO
        System.out.println("\n=== OFRECIMIENTO DE SEGURO POR LESIONES Y ACCIDENTES ===");
        System.out.println("Se ofrece un seguro médico con costo de $50 para cubrir lesiones/accidentes.");
        System.out.println("¿Desea adquirir el seguro? (1. Si / 2. No)");
        int opcionSeguro = new Scanner(System.in).nextInt();
        if (opcionSeguro == 1) {
            // Supongamos que el costo del seguro es 50
            torneo.agregarSeguro("Seguro de lesiones/accidentes", 50.0);
            System.out.println("Ha adquirido el seguro. ¡Gracias por su compra!");
        } else {
            System.out.println("Ha decidido no adquirir el seguro. El comité no se hace responsable de lesiones.");
        }

// 4. ASIGNAR 2 ÁRBITROS ALEATORIOS
        System.out.println("\n=== ASIGNANDO 2 ÁRBITROS AL TORNEO ===");

        if (arbitrosTodos.size() >= 2) {
            // Elegimos 2 distintos
            int primerIndice = rand.nextInt(arbitrosTodos.size());
            Trabajador arbitro1 = arbitrosTodos.get(primerIndice);
            // Marcar como ocupado si deseas
            arbitro1.setOcupado(true);

            int segundoIndice;
            do {
                segundoIndice = rand.nextInt(arbitrosTodos.size());
            } while (segundoIndice == primerIndice);

            Trabajador arbitro2 = arbitrosTodos.get(segundoIndice);
            arbitro2.setOcupado(true);

            // Agregar al torneo
            torneo.agregarArbitro(arbitro1);
            torneo.agregarArbitro(arbitro2);

            System.out.println("Árbitros asignados al torneo:");
            System.out.println("- " + arbitro1.getNombre() + " " + arbitro1.getApellido());
            System.out.println("- " + arbitro2.getNombre() + " " + arbitro2.getApellido());
        } else {
            System.out.println("No hay suficientes árbitros para asignar.");
        }

        System.out.println("\n=== Registro finalizado. Precio total del torneo: $"
                + torneo.getPrecioTotal() + " ===");
    }


    /// ///////Metodo para crear eventos/////////
    public static void crearEvento() {
        // Se crea un escáner para leer datos desde consola
        Scanner sc = new Scanner(System.in);

        // Se obtienen todas las instalaciones disponibles, incluyendo la cancha F11 Grande y los posibles toldos
        ArrayList<Instalacion> todasLasInstalaciones = crearInstalaciones();

        // Se instancia un nuevo objeto Evento para almacenar toda la información que el usuario proporcione
        Evento evento = new Evento();

        System.out.println("Creación de un evento no deportivo (Festival o Concierto)");
        System.out.println("Ingrese el nombre del evento:");
        String nombre = sc.nextLine();  // Nombre del evento

        System.out.println("Seleccione el tipo de evento:");
        System.out.println("1. Festival");
        System.out.println("2. Concierto");
        int tipo = sc.nextInt();  // Se lee el tipo (1 o 2)
        sc.nextLine(); // Se consume la línea pendiente del buffer

        // Se asigna el tipo de evento en función de la elección
        if (tipo == 1) {
            evento.setTipoEvento("Festival");
        } else {
            evento.setTipoEvento("Concierto");
        }

        // Se asigna el nombre del evento
        evento.setNombreEvento(nombre);

        System.out.println("Ingrese el nombre del artista o personaje principal:");
        String artista = sc.nextLine();  // Personaje o artista principal
        evento.setPersonajePrincipal(artista);

        // Si el evento es un concierto, se pide el género musical
        if (evento.getTipoEvento().equals("Concierto")) {
            System.out.println("Ingrese el género musical:");
            String genero = sc.nextLine();
            evento.setGeneroMusical(genero);
        }

        // Se busca la instalación "Cancha F11 Grande" y se asigna como lugar principal del evento
        for (Instalacion ins : todasLasInstalaciones) {
            if (ins.getNombre().equals("Cancha F11 Grande")) {
                evento.setLugarPrincipal(ins);
                break;
            }
        }

        System.out.println("Configuración de localidades (tribunas y gramilla).");

        // Se crean y configuran cinco localidades distintas (Norte, Sur, Oriental, Occidental, Gramilla)
        ArrayList<Localidad> localidades = new ArrayList<>();
        localidades.add(configurarLocalidad(todasLasInstalaciones, "Norte"));
        localidades.add(configurarLocalidad(todasLasInstalaciones, "Sur"));
        localidades.add(configurarLocalidad(todasLasInstalaciones, "Oriental"));
        localidades.add(configurarLocalidad(todasLasInstalaciones, "Occidental"));
        localidades.add(configurarLocalidad(todasLasInstalaciones, "Gramilla"));

        // Se asignan todas las localidades configuradas al evento
        evento.setLocalidades(localidades);

        // Opción de agregar toldos patrocinados, de 1 a 3
        System.out.println("¿Desea agregar toldos patrocinados? Puede agregar de 1 a 3. Ingrese la cantidad (0 si no desea):");
        int cantidadToldos = sc.nextInt();
        sc.nextLine();

        // Lista donde se guardarán los toldos seleccionados
        ArrayList<Instalacion> toldosPatrocinados = new ArrayList<>();

        // Si el usuario ingresa más de 3, se limita a 3
        if (cantidadToldos > 3) {
            cantidadToldos = 3;
        }

        // Se seleccionan los toldos uno a uno, según la cantidad elegida
        for (int i = 0; i < cantidadToldos; i++) {
            mostrarToldosDisponibles(todasLasInstalaciones);
            System.out.println("Seleccione un toldo patrocinado por número:");
            int opcionToldo = sc.nextInt();
            sc.nextLine();
            // El valor de opcionToldo debe ser 1, 2 o 3 para seleccionarlo correctamente
            if (opcionToldo >= 1 && opcionToldo <= 3) {
                toldosPatrocinados.add(todasLasInstalaciones.get(opcionToldo + 3));
            }
        }

        // Se asignan los toldos patrocinados al evento
        evento.setToldosPatrocinados(toldosPatrocinados);

        // Se muestra un resumen final del evento creado
        System.out.println("Resumen del evento creado:");
        System.out.println("Nombre: " + evento.getNombreEvento());
        System.out.println("Tipo: " + evento.getTipoEvento());
        System.out.println("Artista/Personaje Principal: " + evento.getPersonajePrincipal());
        if (evento.getTipoEvento().equals("Concierto")) {
            System.out.println("Género musical: " + evento.getGeneroMusical());
        }
        System.out.println("Lugar principal: " + evento.getLugarPrincipal().getNombre());
        System.out.println("Localidades configuradas:");
        for (Localidad loc : evento.getLocalidades()) {
            System.out.println("- " + loc.getUbicacion()
                    + " | Capacidad: " + loc.getCapacidad()
                    + " | Precio sugerido: " + loc.getPrecioSugerido()
                    + " | División: " + loc.getDivision()
                    + " | Menores: " + loc.getMenores());
        }

        // Se informa si se agregaron o no toldos patrocinados
        if (!evento.getToldosPatrocinados().isEmpty()) {
            System.out.println("Toldos patrocinados seleccionados:");
            for (Instalacion t : evento.getToldosPatrocinados()) {
                System.out.println("- " + t.getNombre());
            }
        } else {
            System.out.println("No se agregaron toldos patrocinados.");
        }
    }

    public static Localidad configurarLocalidad(ArrayList<Instalacion> instalaciones, String ubicacion) {
        // Este método pide al usuario la capacidad y define si la localidad se divide para menores
        Scanner sc = new Scanner(System.in);
        Instalacion canchaF11Grande = null;

        // Se busca la instalación "Cancha F11 Grande" para vincularla a la localidad
        for (Instalacion ins : instalaciones) {
            if (ins.getNombre().equals("Cancha F11 Grande")) {
                canchaF11Grande = ins;
                break;
            }
        }

        // Se definen capacidad mínima y máxima para la localidad
        int capacidadMin = 50;
        int capacidadMax = 500;

        System.out.println("Configurando localidad: " + ubicacion);
        System.out.println("Ingrese la capacidad (entre " + capacidadMin + " y " + capacidadMax + "):");
        int capacidad = sc.nextInt();

        // Si la capacidad ingresada está por debajo o por encima de los límites, se ajusta
        if (capacidad < capacidadMin) capacidad = capacidadMin;
        if (capacidad > capacidadMax) capacidad = capacidadMax;

        // Se crea la localidad con la instalación Cancha F11 Grande y la ubicación especificada
        Localidad loc = new Localidad(canchaF11Grande, ubicacion, capacidad);

        // Se pregunta si se desea dividir la localidad para menores
        System.out.println("¿Desea dividir la localidad para menores? (1. Sí / 2. No)");
        int opcion = sc.nextInt();
        if (opcion == 1) {
            loc.setDivision(true);
            loc.setMenores(true);
        }
        return loc;
    }

    public static void mostrarToldosDisponibles(ArrayList<Instalacion> instalaciones) {
        // Se muestran los tres toldos patrocinados disponibles
        System.out.println("Toldos patrocinados disponibles (1 a 3):");
        System.out.println("1. " + instalaciones.get(4).getNombre());
        System.out.println("2. " + instalaciones.get(5).getNombre());
        System.out.println("3. " + instalaciones.get(6).getNombre());
    }


    //Metodo para crear los arbitros
    public static ArrayList<Trabajador> crearArbitros(){
        ArrayList<Trabajador> arbitros = new ArrayList<>();
        arbitros.add(new Trabajador("Pedro", "Gaspar", "Arbitro", 55));
        arbitros.add(new Trabajador("Martin", "Corredor", "Arbitro", 50));
        arbitros.add(new Trabajador("Santiago", "Zapata", "Arbitro", 40));
        arbitros.add(new Trabajador("Deivy", "Jhoan", "Arbitro", 43));
        arbitros.add(new Trabajador("Wilmar", "Rolando", "Arbitro", 51));
        arbitros.add(new Trabajador("Anthony", "Silva", "Arbitro", 39));
        arbitros.add(new Trabajador("Joel", "Graterol", "Arbitro", 52));
        arbitros.add(new Trabajador("Paulo", "Torres", "Arbitro", 44));
        arbitros.add(new Trabajador("Diego", "Sinisterra", "Arbitro", 42));
        arbitros.add(new Trabajador("Armando", "Carrascal", "Arbitro", 54));
        return arbitros;
    }


    //Metodo para crear medicos
    public static ArrayList<Trabajador> crearMedicos(){
        ArrayList<Trabajador> medicos = new ArrayList<>();
        medicos.add(new Trabajador("Juan", "Ramírez", "Medico", 55));
        medicos.add(new Trabajador("Luis", "Fernández", "Medico", 50));
        medicos.add(new Trabajador("Carlos", "López", "Medico", 40));
        medicos.add(new Trabajador("José", "Martínez", "Medico", 43));
        medicos.add(new Trabajador("Miguel", "González", "Medico", 51));
        medicos.add(new Trabajador("Antonio", "Rodríguez", "Medico", 39));
        medicos.add(new Trabajador("Francisco", "Pérez", "Medico", 52));
        medicos.add(new Trabajador("David", "García", "Medico", 44));
        medicos.add(new Trabajador("Raúl", "Hernández", "Medico", 42));
        medicos.add(new Trabajador("Álvaro", "Díaz", "Medico", 54));
        return medicos;
    }

    // Método para crear todas las instalaciones predeterminadas
    public static ArrayList<Instalacion> crearInstalaciones() {
        ArrayList<Instalacion> instalaciones = new ArrayList<>();

        // Instalaciones que no son Piscinas todas con capacidad 1(1 cupo)
        instalaciones.add(new Instalacion("Cancha F11 Grande", "Futbol", 120, 0, "", 1));
        instalaciones.add(new Instalacion("Cancha F11", "Futbol", 100, 0, "", 1));
        instalaciones.add(new Instalacion("Cancha F9", "Futbol", 80, 0, "", 1));
        instalaciones.add(new Instalacion("Cancha F7", "Futbol", 60, 0, "", 1));
        instalaciones.add(new Instalacion("Coliseo Basket", "Baloncesto", 120, 0, "", 1));
        instalaciones.add(new Instalacion("Cancha Basket 1", "Baloncesto", 80, 0, "", 1));
        instalaciones.add(new Instalacion("Cancha Basket 2", "Baloncesto", 80, 0, "", 1));
        instalaciones.add(new Instalacion("Cancha Voleibol Arena", "Voleibol", 100, 0, "", 1));
        instalaciones.add(new Instalacion("Cancha Voleibol Cemento 1", "Voleibol", 80, 0, "", 1));
        instalaciones.add(new Instalacion("Cancha Voleibol Cemento 2", "Voleibol", 80, 0, "", 1));

        // Instalaciones de piscina 
        instalaciones.add(new Instalacion("Piscina Olimpica", "Natacion", 120, 3, "", 3));  //capacidad 3
        instalaciones.add(new Instalacion("Piscina Semi Olimpica", "Natacion", 100, 2, "", 30));  //capacidad 30
        instalaciones.add(new Instalacion("Piscina Infantil", "Natacion", 80, 1, "", 20));  //capacidad 20

        return instalaciones;
    }
//------------------------
private static void realizarInscripciones(Scanner scanner) {
    System.out.println("Ingrese el nombre del joven:");
    String nombreJoven = scanner.nextLine();

    System.out.println("Ingrese el apellido del joven:");
    String apellidoJoven = scanner.nextLine();

    System.out.println("Ingrese el ID del joven:");
    int idJoven = scanner.nextInt();
    scanner.nextLine();

    System.out.println("Ingrese la edad del joven:");
    int edadJoven = scanner.nextInt();
    scanner.nextLine();

    System.out.println("Ingrese la experiencia del joven (en meses):");
    int experienciaJoven = scanner.nextInt();
    scanner.nextLine();

    System.out.println("Ingrese la EPS del joven:");
    String eps = scanner.nextLine();

    System.out.println("Ingrese el nombre del acudiente:");
    String nombreAcudiente = scanner.nextLine();

    System.out.println("Ingrese el teléfono del acudiente:");
    String telefonoAcudiente = scanner.nextLine();

    System.out.println("Ingrese la cédula del acudiente:");
    String cedulaAcudiente = scanner.nextLine();

    Joven jovenRegistrado = new Joven(
            nombreJoven,
            apellidoJoven,
            idJoven,
            edadJoven,
            experienciaJoven,
            eps,
            nombreAcudiente,
            telefonoAcudiente,
            cedulaAcudiente
    );

    System.out.println("Joven registrado con éxito");

    //System.out.println("Según los datos del joven, el mismo califica para la categoría: " + jovenRegistrado.darCategoria());
}
}