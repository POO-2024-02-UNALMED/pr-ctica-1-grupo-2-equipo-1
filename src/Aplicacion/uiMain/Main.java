/*
Archivo principal del programa
Donde se programa la UI de consola del programa
*/

package uiMain;

import gestorAplicacion.entidades.Trabajador;
import gestorAplicacion.inscripcion.*;
import gestorAplicacion.pagos.Boleta;
import gestorAplicacion.pagos.Cliente;
import gestorAplicacion.pagos.Suscripcion;
import gestorAplicacion.pagos.TipoSuscripcion;
import gestorAplicacion.reservas.FechaReserva;
import gestorAplicacion.reservas.Instalacion;
import gestorAplicacion.reservas.Reserva;
import gestorAplicacion.torneo.Equipo;
import gestorAplicacion.torneo.Torneo;

import java.util.Objects;
import java.util.Random;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Scanner;
import gestorAplicacion.eventos.Evento;
import gestorAplicacion.eventos.Localidad;
import gestorAplicacion.reservas.Instalacion;

import static gestorAplicacion.reservas.Instalacion.*;


public class Main {
    public static void main(String[] args) {

        crearInstalaciones();

        ArrayList<Instalacion> inst  = Instalacion.getListaInstalaciones();

        Scanner scanner = new Scanner(System.in);

        ArrayList<Trabajador> arbitrosTodos = crearArbitros();

        ArrayList<Trabajador> medicos = crearMedicos();

        ArrayList<Trabajador> seguridadDisponible = crearSeguridad();

        ArrayList<Trabajador> paramedicosDisponibles = crearParamedicos();

        Torneo torneoBase = new Torneo(9999);

        boolean salir = false;

        // Menú principal
        while (!salir) {
            System.out.println("\n===== Menú Principal =====");
            System.out.println("1. Realizar y/o Visualizar Reservas ");
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
                    reservasUI();
                    break;

                case 2:
                    gestionarInscripcion();
                    break;

                case 3:
                    crearTorneos(medicos, arbitrosTodos, inst);
                    break;

                case 4:
                    crearEvento(seguridadDisponible, paramedicosDisponibles);
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
                    System.out.println("Opción inválida. Por favor, seleccione una opción del 1 al 7.");
            }
        }
    }

    //////////////////////////MENU RESERVAS//////////////////////////////////////////
    public static void reservasUI(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("-----Menu Reservas-----");
        System.out.println("Ingresar id del cliente: ");
        int idCliente = scanner.nextInt();

        Cliente clienteEncontrado = Cliente.obtenerCliente(idCliente);

        if(clienteEncontrado != null){
            System.out.println(clienteEncontrado);
            System.out.println("Deporte de la instalacion: \n1: Futbol \n2: Baloncesto \n3: Natacion \n4: Voleibol");
            int opcionDeporte = scanner.nextInt();
            String deporte = deporteViaNumero(opcionDeporte);

            System.out.println("Mostrando instalaciones tipo " + deporte);
            for(Instalacion instalacion: Instalacion.getListaInstalaciones()){
                if(Objects.equals(instalacion.getDeporte(), deporte)){
                    System.out.println(instalacion);
                }
            }

            System.out.println("Ingrese el id de la instalacion: ");
            int instalacionId = scanner.nextInt();
            Instalacion instalacionEscogida = obtenerInstalacion(instalacionId);
            if(instalacionEscogida != null){
                System.out.println("--Seleccion fecha");
                System.out.println("Introduzca la fecha de la reserva: \nMes (1-12): ");
                int mes = scanner.nextInt();
                System.out.println("Dia (1-31): ");
                int dia = scanner.nextInt();
                System.out.println("Desde la hora (1-24): ");
                LocalDateTime inicioHora = LocalDateTime.of(2025,mes,dia,scanner.nextInt(),0);
                System.out.println("Hasta la hora (1-24): ");
                LocalDateTime finHora = LocalDateTime.of(2025,mes,dia,scanner.nextInt(),0);

                Reserva reservaRealizada = new Reserva(clienteEncontrado,instalacionEscogida,new FechaReserva(inicioHora,finHora));
                instalacionEscogida.getReservas().add(reservaRealizada);

                System.out.println("Reserva Realizada \n" + reservaRealizada);

            }else{
                System.out.println("No existe instalacion con ese id");
            }

        }else{
            System.out.println("Cliente no encontrado con ese ID");
        }
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
    private static void crearTorneos(ArrayList<Trabajador> medicos, ArrayList<Trabajador> arbitrosTodos, ArrayList<Instalacion> inst) {
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
        ArrayList<Instalacion> instalacionesTorneo = torneo.getInstalaciones(deporteTorneo, inst);

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
    public static void crearEvento( ArrayList<Trabajador> seguridadDisponible, ArrayList<Trabajador>  paramedicosDisponibles ) {
        Scanner sc = new Scanner(System.in);
        ArrayList<Instalacion> todasLasInstalaciones = new ArrayList<>();

        Evento evento = new Evento();

        System.out.println("Creación de un evento no deportivo (Festival o Concierto)");
        System.out.println("Ingrese el nombre del evento:");
        String nombre = sc.nextLine();

        System.out.println("Seleccione el tipo de evento:");
        System.out.println("1. Festival");
        System.out.println("2. Concierto");
        int tipo = sc.nextInt();
        sc.nextLine();
        if (tipo == 1) {
            evento.setTipoEvento("Festival");
        } else {
            evento.setTipoEvento("Concierto");
        }

        evento.setNombreEvento(nombre);

        System.out.println("Ingrese el nombre del artista o personaje principal:");
        String artista = sc.nextLine();
        evento.setPersonajePrincipal(artista);

        if (evento.getTipoEvento().equals("Concierto")) {
            System.out.println("Ingrese el género musical:");
            String genero = sc.nextLine();
            evento.setGeneroMusical(genero);
        }

        System.out.println("¿Cuántos artistas invitados desea agregar? (0 si no hay invitados):");
        int cantInvitados = sc.nextInt();
        sc.nextLine();
        ArrayList<String> artistasInvitados = new ArrayList<>();
        for (int i = 0; i < cantInvitados; i++) {
            System.out.println("Nombre del artista invitado " + (i + 1) + ":");
            String artistaInv = sc.nextLine();
            artistasInvitados.add(artistaInv);
        }
        evento.setArtistasInvitados(artistasInvitados);

        for (Instalacion ins : todasLasInstalaciones) {
            if (ins.getNombre().equals("Cancha F11 Grande")) {
                evento.setLugarPrincipal(ins);
                break;
            }
        }

        System.out.println("Configuración de localidades (tribunas y gramilla).");
        ArrayList<Localidad> localidades = new ArrayList<>();
        localidades.add(configurarLocalidad(todasLasInstalaciones, "Norte"));
        localidades.add(configurarLocalidad(todasLasInstalaciones, "Sur"));
        localidades.add(configurarLocalidad(todasLasInstalaciones, "Oriental"));
        localidades.add(configurarLocalidad(todasLasInstalaciones, "Occidental"));
        localidades.add(configurarLocalidad(todasLasInstalaciones, "Gramilla"));
        evento.setLocalidades(localidades);

        System.out.println("¿Desea agregar toldos patrocinados? Puede agregar de 1 a 3. Ingrese la cantidad (0 si no desea):");
        int cantidadToldos = sc.nextInt();
        sc.nextLine();
        ArrayList<Instalacion> toldosPatrocinados = new ArrayList<>();
        if (cantidadToldos > 3) {
            cantidadToldos = 3;
        }
        for (int i = 0; i < cantidadToldos; i++) {
            mostrarToldosDisponibles(todasLasInstalaciones);
            System.out.println("Seleccione un toldo patrocinado por número:");
            int opcionToldo = sc.nextInt();
            sc.nextLine();
            if (opcionToldo >= 1 && opcionToldo <= 3) {
                toldosPatrocinados.add(todasLasInstalaciones.get(opcionToldo));
            }
        }
        evento.setToldosPatrocinados(toldosPatrocinados);

        System.out.println("¿Desea agregar FoodTrucks? (0 a 5). Ingrese la cantidad:");
        int cantidadFoodTrucks = sc.nextInt();
        sc.nextLine();
        ArrayList<Instalacion> foodTrucksSeleccionados = new ArrayList<>();
        if (cantidadFoodTrucks > 5) {
            cantidadFoodTrucks = 5;
        }
        for (int i = 0; i < cantidadFoodTrucks; i++) {
            mostrarFoodTrucks(todasLasInstalaciones);
            System.out.println("Seleccione un FoodTruck por número (1-5):");
            int opcionFT = sc.nextInt();
            sc.nextLine();
            if (opcionFT >= 1 && opcionFT <= 5) {
                foodTrucksSeleccionados.add(todasLasInstalaciones.get(opcionFT + 3));
            }
        }
        evento.setFoodTrucks(foodTrucksSeleccionados);

        asignarPersonalSeguridad(evento, seguridadDisponible);
        asignarPersonalMedico(evento, paramedicosDisponibles);

        System.out.println("Resumen del evento creado:");
        System.out.println("Nombre: " + evento.getNombreEvento());
        System.out.println("Tipo: " + evento.getTipoEvento());
        System.out.println("Artista/Personaje Principal: " + evento.getPersonajePrincipal());
        if (evento.getTipoEvento().equals("Concierto")) {
            System.out.println("Género musical: " + evento.getGeneroMusical());
        }
        if (!evento.getArtistasInvitados().isEmpty()) {
            System.out.println("Artistas invitados:");
            for (String invitado : evento.getArtistasInvitados()) {
                System.out.println("- " + invitado);
            }
        }
        System.out.println("Lugar principal: " + evento.getLugarPrincipal().getNombre());
        System.out.println("Localidades configuradas:");
        for (Localidad loc : evento.getLocalidades()) {
            System.out.println("- " + loc.getUbicacion()
                    + " | Capacidad: " + loc.getCapacidad()
                    + " | Precio sugerido: " + loc.getPrecioSugerido()
                    + " | División menores: " + loc.getMenores()
                    + " | Zona VIP: " + loc.getVip());
        }
        if (!evento.getToldosPatrocinados().isEmpty()) {
            System.out.println("Toldos patrocinados seleccionados:");
            for (Instalacion t : evento.getToldosPatrocinados()) {
                System.out.println("- " + t.getNombre());
            }
        } else {
            System.out.println("No se agregaron toldos patrocinados.");
        }
        if (!evento.getFoodTrucks().isEmpty()) {
            System.out.println("FoodTrucks seleccionados:");
            for (Instalacion ft : evento.getFoodTrucks()) {
                System.out.println("- " + ft.getNombre());
            }
        } else {
            System.out.println("No se agregaron FoodTrucks.");
        }
        if (!evento.getPersonalSeguridad().isEmpty()) {
            System.out.println("Personal de Seguridad asignado:");
            for (Trabajador seg : evento.getPersonalSeguridad()) {
                System.out.println("- " + seg.getNombre() + " " + seg.getApellido());
            }
        }
        if (!evento.getPersonalMedico().isEmpty()) {
            System.out.println("Personal Médico asignado:");
            for (Trabajador med : evento.getPersonalMedico()) {
                System.out.println("- " + med.getNombre() + " " + med.getApellido());
            }
        }
    }

    public static Localidad configurarLocalidad(ArrayList<Instalacion> instalaciones, String ubicacion) {
        Scanner sc = new Scanner(System.in);
        Instalacion canchaF11Grande = null;
        for (Instalacion ins : instalaciones) {
            if (ins.getNombre().equals("Cancha F11 Grande")) {
                canchaF11Grande = ins;
                break;
            }
        }
        int capacidadMin = 50;
        int capacidadMax = 500;
        System.out.println("Configurando localidad: " + ubicacion);
        System.out.println("Ingrese la capacidad (entre " + capacidadMin + " y " + capacidadMax + "):");
        int capacidad = sc.nextInt();
        if (capacidad < capacidadMin) capacidad = capacidadMin;
        if (capacidad > capacidadMax) capacidad = capacidadMax;
        Localidad loc = new Localidad(canchaF11Grande, ubicacion, capacidad);

        System.out.println("¿Desea dividir la localidad para menores? (1. Sí / 2. No)");
        int opcionMenores = sc.nextInt();
        if (opcionMenores == 1) {
            loc.setDivision(true);
            loc.setMenores(true);
        }

        System.out.println("¿Desea habilitar zona VIP en esta localidad? (1. Sí / 2. No)");
        int opcionVip = sc.nextInt();
        if (opcionVip == 1) {
            loc.setVip(true);
        }
        return loc;
    }

    public static void mostrarToldosDisponibles(ArrayList<Instalacion> instalaciones) {
        System.out.println("Toldos patrocinados disponibles (1 a 3):");
        // Ajusta índices según la lista. En este ejemplo, se asume el primer toldo es índice 1,
        // segundo toldo es índice 2, y tercero es índice 3:
        System.out.println("1. " + instalaciones.get(1).getNombre());
        System.out.println("2. " + instalaciones.get(2).getNombre());
        System.out.println("3. " + instalaciones.get(3).getNombre());
    }

    public static void mostrarFoodTrucks(ArrayList<Instalacion> instalaciones) {
        System.out.println("FoodTrucks disponibles (1 a 5):");
        // Se asume que van de la posición 4 a la 8
        System.out.println("1. " + instalaciones.get(4).getNombre());
        System.out.println("2. " + instalaciones.get(5).getNombre());
        System.out.println("3. " + instalaciones.get(6).getNombre());
        System.out.println("4. " + instalaciones.get(7).getNombre());
        System.out.println("5. " + instalaciones.get(8).getNombre());
    }

    public static void asignarPersonalSeguridad(Evento evento, ArrayList<Trabajador> seguridadDisponible) {
        // Se asignan 10 personas de seguridad al evento
        ArrayList<Trabajador> asignados = new ArrayList<>();
        Random rand = new Random();
        if (seguridadDisponible.size() < 10) {
            // Si no hay suficientes, asigna los que haya
            asignados.addAll(seguridadDisponible);
        } else {
            while (asignados.size() < 10) {
                int indice = rand.nextInt(seguridadDisponible.size());
                Trabajador s = seguridadDisponible.get(indice);
                if (!s.isOcupado()) {
                    s.setOcupado(true);
                    asignados.add(s);
                }
            }
        }
        evento.setPersonalSeguridad(asignados);
    }

    public static void asignarPersonalMedico(Evento evento, ArrayList<Trabajador> paramedicosDisponibles) {
        // Se asignan 3 paramédicos al evento (puedes ajustar el número según necesidad)
        ArrayList<Trabajador> asignados = new ArrayList<>();
        Random rand = new Random();
        int cupoParamedicos = 3;
        if (paramedicosDisponibles.size() < cupoParamedicos) {
            asignados.addAll(paramedicosDisponibles);
        } else {
            while (asignados.size() < cupoParamedicos) {
                int indice = rand.nextInt(paramedicosDisponibles.size());
                Trabajador pm = paramedicosDisponibles.get(indice);
                if (!pm.isOcupado()) {
                    pm.setOcupado(true);
                    asignados.add(pm);
                }
            }
        }
        evento.setPersonalMedico(asignados);
    }


    //Metodo para crear los arbitros
    public static ArrayList<Trabajador> crearArbitros(){
        ArrayList<Trabajador> arbitros = new ArrayList<>();
        arbitros.add(new Trabajador("Marcela", "Gil", "Arbitro", 30));
        arbitros.add(new Trabajador("Ana", "Campos", "Arbitro", 42));
        arbitros.add(new Trabajador("Pedro", "Castillo", "Arbitro", 55));
        arbitros.add(new Trabajador("Sergio", "Correa", "Arbitro", 47));
        arbitros.add(new Trabajador("Carolina", "Ortega", "Arbitro", 38));
        arbitros.add(new Trabajador("Valentina", "Ríos", "Arbitro", 29));
        arbitros.add(new Trabajador("Ricardo", "Rojas", "Arbitro", 50));
        arbitros.add(new Trabajador("Laura", "Ponce", "Arbitro", 44));
        arbitros.add(new Trabajador("Javier", "Montoya", "Arbitro", 41));
        arbitros.add(new Trabajador("Gabriela", "López", "Arbitro", 36));
        return arbitros;
    }


    //Metodo para crear seguridada para eventos
    public static ArrayList<Trabajador> crearSeguridad() {
        ArrayList<Trabajador> personalSeguridad = new ArrayList<>();
        personalSeguridad.add(new Trabajador("Lucía", "Reyes", "Seguridad", 30));
        personalSeguridad.add(new Trabajador("Valentina", "Rojas", "Seguridad", 35));
        personalSeguridad.add(new Trabajador("Sofía", "Pérez", "Seguridad", 28));
        personalSeguridad.add(new Trabajador("Manuel", "Contreras", "Seguridad", 42));
        personalSeguridad.add(new Trabajador("Gabriela", "Ramírez", "Seguridad", 29));
        personalSeguridad.add(new Trabajador("Santiago", "Herrera", "Seguridad", 45));
        personalSeguridad.add(new Trabajador("Julia", "Fernández", "Seguridad", 33));
        personalSeguridad.add(new Trabajador("Diego", "Maldonado", "Seguridad", 40));
        personalSeguridad.add(new Trabajador("Ana", "Torres", "Seguridad", 38));
        personalSeguridad.add(new Trabajador("Leonardo", "Díaz", "Seguridad", 36));
        personalSeguridad.add(new Trabajador("Miguel", "Castañeda", "Seguridad", 31));
        personalSeguridad.add(new Trabajador("Carolina", "Osorio", "Seguridad", 27));
        personalSeguridad.add(new Trabajador("Esteban", "Flórez", "Seguridad", 44));
        personalSeguridad.add(new Trabajador("Marcela", "Marín", "Seguridad", 32));
        personalSeguridad.add(new Trabajador("Ricardo", "Vargas", "Seguridad", 39));
        personalSeguridad.add(new Trabajador("Paula", "Franco", "Seguridad", 29));
        personalSeguridad.add(new Trabajador("Mateo", "Cárdenas", "Seguridad", 41));
        personalSeguridad.add(new Trabajador("Felipe", "Guzmán", "Seguridad", 37));
        personalSeguridad.add(new Trabajador("Daniela", "Montoya", "Seguridad", 26));
        personalSeguridad.add(new Trabajador("Andrés", "López", "Seguridad", 43));
        return personalSeguridad;
    }


    //Metodo para crear paramedicos
    public static ArrayList<Trabajador> crearParamedicos() {
        ArrayList<Trabajador> paraMedicos = new ArrayList<>();
        paraMedicos.add(new Trabajador("Lucía", "Reyes", "Paramedico", 30));
        paraMedicos.add(new Trabajador("Valentina", "Rojas", "Paramedico", 35));
        paraMedicos.add(new Trabajador("Sofía", "Pérez", "Paramedico", 28));
        paraMedicos.add(new Trabajador("Manuel", "Contreras", "Paramedico", 42));
        paraMedicos.add(new Trabajador("Gabriela", "Ramírez", "Paramedico", 29));
        paraMedicos.add(new Trabajador("Santiago", "Herrera", "Paramedico", 45));
        paraMedicos.add(new Trabajador("Julia", "Fernández", "Paramedico", 33));
        paraMedicos.add(new Trabajador("Diego", "Maldonado", "Paramedico", 40));
        paraMedicos.add(new Trabajador("Ana", "Torres", "Paramedico", 38));
        paraMedicos.add(new Trabajador("Leonardo", "Díaz", "Paramedico", 36));
        return paraMedicos;
    }


    //Metodo para crear medicos
    public static ArrayList<Trabajador> crearMedicos() {
        ArrayList<Trabajador> medicos = new ArrayList<>();
        medicos.add(new Trabajador("Sofía", "Reyes", "Medico", 32));
        medicos.add(new Trabajador("Valentina", "Rojas", "Medico", 45));
        medicos.add(new Trabajador("Carlos", "López", "Medico", 40));
        medicos.add(new Trabajador("José", "Martínez", "Medico", 43));
        medicos.add(new Trabajador("Miguel", "González", "Medico", 51));
        medicos.add(new Trabajador("Fernanda", "Rodríguez", "Medico", 36));
        medicos.add(new Trabajador("Francisca", "Pérez", "Medico", 47));
        medicos.add(new Trabajador("Daniela", "García", "Medico", 39));
        medicos.add(new Trabajador("Raúl", "Hernández", "Medico", 42));
        medicos.add(new Trabajador("Ángela", "Díaz", "Medico", 54));
        return medicos;
    }


    // Método para crear todas las instalaciones predeterminadas
    /*public static ArrayList<Instalacion> crearInstalaciones() {
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
*/

//------------------------
public static void gestionarInscripcion() {
    Scanner sc = new Scanner(System.in);

    DeporteFormativo df = new DeporteFormativo();

    System.out.println("=== Ingreso de datos para Deporte Formativo ===");
    System.out.print("Nombre del joven: ");
    df.setNombre(sc.nextLine());

    System.out.print("Apellido del joven: ");
    String apellidoJoven = sc.nextLine();


    System.out.print("Documento del joven: ");
    int idJoven = sc.nextInt();

    sc.nextLine();

    System.out.print("Edad del joven: ");
    df.setEdad(sc.nextInt());
    sc.nextLine(); // limpiar buffer

    System.out.print("EPS del joven: ");
    df.setEps(sc.nextLine());

    System.out.print("Nombre del acudiente: ");
    df.setAcudiente(sc.nextLine());

    System.out.print("Teléfono del acudiente: ");
    String telAcudiente = sc.nextLine();

    System.out.print("Cédula del acudiente: ");
    String cedAcudiente = sc.nextLine();

    String depolte = "";
    boolean valido = false; // Variable para controlar si la opción es válida

    while (!valido) {
        System.out.println("Selecciona un deporte:");
        System.out.println("1. Futbol");
        System.out.println("2. Baloncesto");
        System.out.println("3. Voleibol");
        System.out.println("4. Natacion");

        int opcion = sc.nextInt();

        switch (opcion) {
            case 1:
                depolte = "Futbol";
                valido = true;
                break;
            case 2:
                depolte = "Baloncesto";
                valido = true;
                break;
            case 3:
                depolte = "Voleibol";
                valido = true;
                break;
            case 4:
                depolte = "Natacion";
                valido = true;
                break;
            default:
                System.out.println("Deporte no valido, ingrese un deporte dentro de los ofrecidos.");
                break; // Vuelve a pedir la opción si es inválida
        }
    }
    df.setDeporteDeseado(sc.nextLine());

    System.out.print("Experiencia previa (meses): ");
    df.setExperienciaMeses(sc.nextInt());
    sc.nextLine();

    // Asignamos categoría y horario
    df.clasificarYAsignar();

    System.out.println("\nDatos capturados:");
    System.out.println("Nombre: " + df.getNombre());
    System.out.println("Edad: " + df.getEdad());
    System.out.println("EPS: " + df.getEps());
    System.out.println("Acudiente: " + df.getAcudiente());
    System.out.println("Deporte: " + df.getDeporteDeseado());
    System.out.println("Experiencia: " + df.getExperienciaMeses() + " meses");
    System.out.println("Categoría Equipo: " + df.getCategoriaEquipo());
    System.out.println("Entrenador (categoría): " + df.getCategoriaEntrenador());
    System.out.println("Horario Asignado: " + df.getHorario());
    System.out.println("Apellido: "+apellidoJoven);

    System.out.println("\n=== Creando objeto Joven e inscribiendo en GrupoFormativo ===");



    Joven joven = new Joven(
            df.getNombre(),
            apellidoJoven,
            idJoven,
            df.getEdad(),
            df.getExperienciaMeses(),
            df.getEps(),
            df.getAcudiente(),
            telAcudiente,
            cedAcudiente
    );

    // Creamos un entrenador "simulado" con la categoría del DF
    Entrenador ent = new Entrenador("Entrenador", df.getCategoriaEntrenador(), 40, df.getDeporteDeseado());

    // Instalación simulada
    Instalacion inst = new Instalacion(
            "Cancha " + df.getDeporteDeseado(),
            df.getDeporteDeseado(),
            60
    );

    // Creamos el grupo formativo
    GrupoFormativo gf = new GrupoFormativo(df.getDeporteDeseado(), inst, ent);
    gf.addJoven(joven);

    // Inicializamos la tienda y ofrecemos la compra
    TiendaEscuela tienda = inicializarTienda();
    System.out.println("\n¿Desea comprar equipamiento para " + df.getDeporteDeseado() + "? (1. Sí / 2. No)");
    int opcionCompra = sc.nextInt();
    sc.nextLine();
    if (opcionCompra == 1) {
        mostrarArticulosPorDeporte(tienda, df.getDeporteDeseado());
        System.out.print("Ingrese el ID del artículo que desea comprar (0 para salir): ");
        int idArticulo = sc.nextInt();
        sc.nextLine();
        if (idArticulo != 0) {
            ArticuloTiendaEscuela articulo = tienda.buscarArticuloPorId(idArticulo);
            if (articulo != null && articulo.getTipoArticulo().equalsIgnoreCase(df.getDeporteDeseado())) {
                if (articulo.getStockArticulo() > 0) {
                    articulo.setStockArticulo(articulo.getStockArticulo() - 1);
                    System.out.println("Compra realizada: " + articulo.getNombreArticulo());
                } else {
                    System.out.println("No hay stock disponible del artículo seleccionado.");
                }
            } else {
                System.out.println("Artículo no encontrado o no corresponde al deporte.");
            }
        }
    }

    // Resumen final
    System.out.println("\n=== Resumen de Inscripción ===");
    System.out.println("Joven inscrito: " + joven);
    System.out.println("Grupo Formativo - Deporte: " + gf.getDeporte());
    System.out.println("Instalación: " + gf.getInstalacion().getNombre());
    System.out.println("Entrenador: " + gf.getEntrenador().getNombre() + " " + gf.getEntrenador().getApellido());
    System.out.println("Jóvenes en el grupo:");
    for (Joven jj : gf.getJovenes()) {
        System.out.println("- " + jj.getNombre() + " " + jj.getApellido());
    }

    sc.close();
}

    // Lógica para inicializar la tienda con algunos artículos
    public static TiendaEscuela inicializarTienda() {
        TiendaEscuela tienda = new TiendaEscuela();
        tienda.agregarArticulo(new ArticuloTiendaEscuela(1, "Uniforme Futbol", 10, 50000, "Futbol"));
        tienda.agregarArticulo(new ArticuloTiendaEscuela(2, "Balón Futbol", 15, 70000, "Futbol"));
        tienda.agregarArticulo(new ArticuloTiendaEscuela(3, "Uniforme Basket", 8, 55000, "Baloncesto"));
        tienda.agregarArticulo(new ArticuloTiendaEscuela(4, "Balón Basket", 12, 65000, "Baloncesto"));
        tienda.agregarArticulo(new ArticuloTiendaEscuela(5, "Gorro Natación", 20, 15000, "Natacion"));
        tienda.agregarArticulo(new ArticuloTiendaEscuela(6, "Gafas Natación", 25, 30000, "Natacion"));
        tienda.agregarArticulo(new ArticuloTiendaEscuela(7, "Uniforme Voleibol", 10, 45000, "Voleibol"));
        tienda.agregarArticulo(new ArticuloTiendaEscuela(8, "Balón Voleibol", 10, 50000, "Voleibol"));
        return tienda;
    }

    // Muestra solo los artículos que coincidan con el deporte
    public static void mostrarArticulosPorDeporte(TiendaEscuela tienda, String deporte) {
        System.out.println("Artículos disponibles para " + deporte + ":");
        for (ArticuloTiendaEscuela art : tienda.listarArticulos()) {
            if (art.getTipoArticulo().equalsIgnoreCase(deporte)) {
                System.out.println(art.getIdArticulo() + ". " + art.getNombreArticulo()
                        + " | Stock: " + art.getStockArticulo()
                        + " | Precio: " + art.getPrecio());
            }
        }
    }

}