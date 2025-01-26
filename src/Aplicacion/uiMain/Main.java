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

import gestorAplicacion.pagos.Boleta;
import gestorAplicacion.pagos.Cliente;
import gestorAplicacion.pagos.Suscripcion;
import gestorAplicacion.pagos.TipoSuscripcion;
import gestorAplicacion.reservas.Instalacion;
import gestorAplicacion.reservas.Reserva;
import gestorAplicacion.torneo.Equipo;
import gestorAplicacion.torneo.Torneo;
import gestorAplicacion.inscripcion.Joven;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Scanner;



public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Creación de todas las instalaciones
        ArrayList<Instalacion> instalaciones = crearInstalaciones();

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
                    crearTorneos();
                    //Logica en la parte inferior de esta clase
                    break;

                case 4:
                    //crearEventos(scanner);
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
    private static void crearTorneos() {
        System.out.println("Antes de empezar con la creacion del torneo, se requieren unos datos del clietne");
        System.out.println("Ingrese su nombre");
        String nombreCliente = new Scanner(System.in).nextLine();
        System.out.println("Ingrese su apellido");
        String apellidoCliente = new Scanner(System.in).nextLine();
        System.out.println("Ingrese su edad");
        int edadCliente = new Scanner(System.in).nextInt();
        System.out.println("Ingrese su ID");
        int idCliente = new Scanner(System.in).nextInt();;
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

        torneo.setDeporte(deporteTorneo);

        ArrayList<Instalacion> instalacionesTorneo = torneo.getInstalaciones(deporteTorneo);

        System.out.println("Seleccione una de las instalaciones disponibles para el torneo:");

        int contador = 1;
        for (Instalacion instalacion : instalacionesTorneo) {
            System.out.println(contador + ". " + instalacion);
            contador++;
        }

        int seleccionInstalacion = new Scanner(System.in).nextInt();

        torneo.setInstalacion(seleccionInstalacion);

        System.out.println("Ahora se personalizaran las relgas del torneo");
        System.out.println();

        boolean salir = false;
        switch (deporteTorneo) {
            case 1://Futbol
                while(!salir) {
                    System.out.println("Sustituciones máximas: mínimo 2, máximo 7.\n" +
                            "Duración del partido: 30 o 90 minutos (Se realiza una reserva de dos horas indiferente de la duracion del partido).\n" +
                            "Criterios de desempate: Goles a favor (GF), Goles en contra (GC) o Sorteo.\n" +
                            "En este caso deberán ser ingresados en orden de prioridad. Además, despúes de sorteo no podrán ir más criterios de desempate.");
                    System.out.println();
                    System.out.println("Ingrese la cantidad de susticiones máximas.");

                    int Sustituciones = new Scanner(System.in).nextInt();
                    System.out.println();

                    ArrayList<String> reglasFutbol = new ArrayList<>();

                    if ((Sustituciones < 2) || (Sustituciones > 7)) {
                        break;
                    } else {
                        reglasFutbol.add(Integer.toString(Sustituciones));
                    }

                    System.out.println("Ingrese la duración del partido.");
                    int duracionFutbol = new Scanner(System.in).nextInt();
                    System.out.println();
                    if ((duracionFutbol < 30) || (duracionFutbol > 90)) {
                        break;
                    } else {
                        reglasFutbol.add(Integer.toString(duracionFutbol));
                    }

                    ArrayList<String> Criterios = new ArrayList<>();
                    System.out.println("Ingrese los criterios de desempate en orden de prioridad.");

                    while (!Criterios.contains("Sorteo")) {
                        String Criterio = new Scanner(System.in).nextLine();
                        Criterios.add(Criterio);
                    }
                    System.out.println();

                    System.out.println("Las siguientes serán las reglas personalizadas para este torneo:"); //ARREGLAR - Puede genrar un error si se pone sorteo como una opcion distinta a la ultima
                    System.out.println("Sustituciones máximas:" + reglasFutbol.getFirst()); //
                    System.out.println("Duración del partido:" + reglasFutbol.get(1));
                    System.out.println("Criterios de desempate:" + Criterios);
                    System.out.println();

                    torneo.setReglas(reglasFutbol);

                    salir = true;
                }
                break;
            case 2://Basket
                while(!salir) {
                    ArrayList<String> reglasBasket = new ArrayList<>();

                    System.out.println("Duración del partido: 4 períodos de 10 minutos (FIBA) o 12 minutos (NBA). (Se realiza una reserva de dos horas indiferente de la duracion del partido)\n" +
                            "Tiempos fuera por periodo: máximo 3");

                    System.out.println("Ingrese la duración del partido.");
                    int duracionBaloncesto = new Scanner(System.in).nextInt();
                    System.out.println();
                    if ((duracionBaloncesto < 10) || (duracionBaloncesto > 12)) {
                        break;
                    } else {
                        reglasBasket.add(Integer.toString(duracionBaloncesto));
                    }

                    System.out.println("Ingrese la cantidad de tiempos fuera permitidos por periodo");
                    int tiemposFuera = new Scanner(System.in).nextInt();
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

                    torneo.setReglas(reglasBasket);

                    salir = true;
                }
                break;
            case 3://Natacion
                while(!salir) {
                    ArrayList<String> reglasNatacion = new ArrayList<>();

                    System.out.println();
                    System.out.println("Formato de competencia:\n" +
                            "1. Relevos (2 Participantes por equipo)\n" +
                            "2. Mejor tiempo\n" +
                            "Para ambos formatos se realiza una reserva de dos horas, indiferente de la piscina seleccionada\n");


                    System.out.println("Ingrese el formato de competencia: ");
                    int formatoNatacion = new Scanner(System.in).nextInt();

                    if (formatoNatacion == 2) {
                        reglasNatacion.add("Mejor tiempo");
                        System.out.println("Ingrese la cantidad de intentos maximos por participante.\n" +
                                "Maximos: 5 - Minimos: 1.");
                        int intentosNatacion = new Scanner(System.in).nextInt();
                        if (intentosNatacion >= 1 && intentosNatacion <= 5) {
                            reglasNatacion.add(Integer.toString(intentosNatacion));
                        } else {
                            break;
                        }
                        System.out.println();
                    } else if (formatoNatacion == 1) {
                        reglasNatacion.add("Relevos");
                    }

                    System.out.println("Las siguientes serán las reglas personalizadas para este torneo:");
                    if (formatoNatacion == 1) {
                        System.out.println("Formato de competencia: " + reglasNatacion.get(0));
                    } else if (formatoNatacion == 2) {
                        System.out.println("Formato de competencia: " + reglasNatacion.get(0));
                        System.out.println("Intentos maximos por competidor: " + reglasNatacion.get(1));
                    }
                    torneo.setReglas(reglasNatacion);
                    salir = true;
                }
                break;
            case 4://Voleibol
                while(!salir) {
                    ArrayList<String> reglasVoleibol = new ArrayList<>();

                    System.out.println();
                    System.out.println("Cantidad de sets: 2 o 5");
                    System.out.println("Indiferente a la cantidad de sets, se realiza una reserva de dos horas");
                    System.out.println("Altura de la malla: 2.24 mts o 2.43 mts");

                    System.out.println("Ingrese la cantidad de sets: ");
                    int setsVoleibol = new Scanner(System.in).nextInt();
                    if ((setsVoleibol != 2) && (setsVoleibol != 5)) {
                        break;
                    } else {
                        reglasVoleibol.add(Integer.toString(setsVoleibol));
                    }

                    System.out.println("Ingrese la altura de la malla: ");
                    float alturaVoleibol = new Scanner(System.in).nextFloat();

                    if ((alturaVoleibol != 2.24) && (alturaVoleibol != 2.43)) {
                        break;
                    } else {
                        reglasVoleibol.add(Float.toString(alturaVoleibol));
                    }

                    System.out.println("Las siguientes serán las reglas personalizadas para este torneo:");
                    System.out.println("Cantidad de sets: " + reglasVoleibol.get(0));
                    System.out.println("Altura de la malla: " + reglasVoleibol.get(1));

                    torneo.setReglas(reglasVoleibol);
                    salir = true;
                }
                break;
        }

        if (deporteTorneo == 1){//Futbol
            System.out.println("Ahora, se ingresaran los nombres de los equipos participantes.");
            System.out.println();

            ArrayList<Equipo> equiposParticipantesFutbol = new ArrayList<>();

            for (int i = 0; i < 5; i++) {
                System.out.println("Ingrese el nombre del equipo No. " + i + ":");
                String nombreEquipo = new Scanner(System.in).nextLine();
                equiposParticipantesFutbol.add(new Equipo(nombreEquipo));
                System.out.println();
            }

            System.out.println("Los equipos inscritos en el torneo son:");
            for (Equipo equipo : equiposParticipantesFutbol) {
                System.out.println(equipo.getNombreEquipo());
            }

            torneo.setEquiposParticipantes(equiposParticipantesFutbol);

        } else if (deporteTorneo == 2){//Basket
            System.out.println("Ahora, se ingresaran los nombres de los equipos participantes.");
            System.out.println();

            ArrayList<Equipo> equiposParticipantesBasket = new ArrayList<>();

            for (int i = 0; i < 5; i++) {
                System.out.println("Ingrese el nombre del equipo No. " + i + ":");
                String nombreEquipo = new Scanner(System.in).nextLine();
                equiposParticipantesBasket.add(new Equipo(nombreEquipo));
                System.out.println();
            }

            System.out.println("Los equipos inscritos en el torneo son:");
            for (Equipo equipo : equiposParticipantesBasket) {
                System.out.println(equipo.getNombreEquipo());
            }

            torneo.setEquiposParticipantes(equiposParticipantesBasket);

        } else if (deporteTorneo == 3){//Natacion, equipos o personas
            if (torneo.reglas.get(0).equals("Relevos")) {
                System.out.println("Ahora, se ingresaran los nombres de los equipos participantes.");
                System.out.println();

                ArrayList<Equipo> equiposParticipantesNatacion = new ArrayList<>();

                for (int i = 0; i < 5; i++) {
                    System.out.println("Ingrese el nombre del equipo No. " + i + ":");
                    String nombreEquipo = new Scanner(System.in).nextLine();
                    equiposParticipantesNatacion.add(new Equipo(nombreEquipo));
                    System.out.println();
                }

                System.out.println("Los equipos inscritos en el torneo son:");
                for (Equipo equipo : equiposParticipantesNatacion) {
                    System.out.println(equipo.getNombreEquipo());
                }
            } else if (torneo.reglas.get(0).equals("Mejor tiempo")) {
                //Terminar, competencia individual
            }
        }

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

    System.out.println("Según los datos del joven, el mismo califica para la categoría: " + jovenRegistrado.darCategoria());
}



    private static void crearEventos(Scanner scanner) {
        // Implementación del método para crear eventos (conciertos)
    }
}