package uiMain;/*
Archivo principal del programa

Donde se programa la UI de consola del programa

NO CAMBIAR SIN PREGUNTAR PRECAUCION

 */

//Falta logica para cada opcion. Simplemente es una idea de lo que puede ser la base. Hay "errores" en el switch


// Se crean instalaciones basicas

//Agregar descripciones de las instalaciones

import gestorAplicacion.entidades.Instalacion;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Instalacion canchaGrandeF11 = new Instalacion("Cancha F11 Grande","Futbol", 120, 0, "");

        Instalacion canchaF11 = new Instalacion("Cancha F11","Futbol", 100, 0, "");

        Instalacion canchaF9 = new Instalacion("Cancha F9","Futbol", 80, 0, "");

        Instalacion canchaF7 = new Instalacion("Cancha F7","Futbol", 60, 0, "");

        Instalacion coliseoBasket = new Instalacion("Coliseo Basket","Baloncesto", 120, 0, "");

        Instalacion canchaBasket1 = new Instalacion("Cancha Basket 1","Baloncesto", 80, 0, "");

        Instalacion canchaBasket2 = new Instalacion("Cancha Basket 2","Baloncesto", 80, 0, "");

        Instalacion piscinaOlimpica = new Instalacion("Piscina Olimpica","Natacion", 120, 3, "");

        Instalacion piscinaSemiOlimpica = new Instalacion("Piscina Semi Olimpica","Natacion", 10, 2, "");

        Instalacion piscinaInfantil = new Instalacion("Piscina Infantil","Natacion", 80, 1, "");

        Instalacion canchaVoleibolArena = new Instalacion("Cancha Voleibol Arena","Voleibol", 100, 0, "");

        Instalacion canchaVoleibolCemento1 = new Instalacion ("Cancha Voleibol Cemento 1","Voleibol", 80, 0, "");

        Instalacion canchaVoleibolcemento2 = new Instalacion("Cancha Voleibol Cemento 2","Voleibol", 80, 0, "");

        boolean salir = false;

        while (!salir) {
            System.out.println("\n===== Menú Principal =====");
            System.out.println("1. Realizar Reservas");
            System.out.println("2. Realizar Inscripciones a Deportes Formativos");
            System.out.println("3. Crear Torneos");
            System.out.println("4. Crear Eventos (Concierto)");
            System.out.println("5. Taquilla (Pagos)");
            System.out.println("6. Salir");
            System.out.print("Seleccione una opción: ");

            int opcion = scanner.nextInt();

            switch (opcion) {
                case 1:
                    System.out.println("\n--- Crear Torneo ---");
                    System.out.println("Seleccione una subopción:");
                    System.out.println("1. Crear Reserva");
                    System.out.println("2. Ver horarios disponibles");
                    System.out.println("3. Volver al menú principal");
                    System.out.print("Ingrese una subopción: ");

                    int subOpcionReserva = scanner.nextInt();
                    switch (subOpcionReserva) {
                        case 1:
                            System.out.println("Iniciando la creación de una nueva reserva...");
                            // Aquí iría la lógica para crear un torneo desde cero
                            break;
                        case 2:
                            System.out.println("Mostrando horarios existentes...");
                            // Aquí iría la lógica para listar horarios
                            break;
                        case 3:
                            System.out.println("Volviendo al menú principal...");
                            break;
                        default:
                            System.out.println("Subopción inválida.");
                    }
                    break;

                case 2:
                    System.out.println("\n--- Inscripcion a Deporte Formativo ---");
                    System.out.println("Seleccione una subopción:");
                    System.out.println("1. Registrar un joven");
                    System.out.println("2. Comprar implementos deportivos");
                    System.out.println("3. Volver al menú principal");
                    System.out.print("Ingrese una subopción: ");

                    int subOpcionGestion = scanner.nextInt();
                    switch (subOpcionGestion) {
                        case 1:
                            System.out.println("Registrando joven...");
                            // Aquí iría la lógica para registrar jovenes
                            break;
                        case 2:
                            System.out.println("Mostrando implementos disponibles...");
                            // Aquí iría la lógica para comprar en la tienda
                            break;
                        case 3:
                            System.out.println("Volviendo al menú principal...");
                            break;
                        default:
                            System.out.println("Subopción inválida.");
                    }
                    break;

                case 3:
                    System.out.println("\n--- Configurar Torneo ---");
                    System.out.println("Ingrese el deporte en el cual desea realizar el torneo");
                    System.out.println("1. Futbol");
                    System.out.println("2. Baloncesto");
                    System.out.println("3. Natación");
                    System.out.print("4. Voleibol");
                    System.out.print("5. Salir");
                    boolean salirTorneo = false;

                    while (!salirTorneo)
                        switch (scanner.nextInt()) {
                            case 1://futbol
                                System.out.println("Seleccione la cancha en la cual desea realizar el torneo");
                                System.out.println("Existe la opción de que al escoger una cancha de Futbol 11, se puedan seleccionar ambas");
                                System.out.println("Instalaciones deisponibles");
                                System.out.println(canchaGrandeF11.toString());
                                System.out.println(canchaF11.toString());
                                System.out.println(canchaF9.toString());
                                System.out.println(canchaF7.toString()); //Concatenar con los numeros para la seleccion

                                String seleccionCanchaFutbol = scanner.nextLine();

                                switch (seleccionCanchaFutbol) {
                                    case 1:
                                        System.out.println("Se puede seleccionar la otra cancha de Futbol 11");
                                        break;
                                    case 2:
                                        break;
                                    case 3:
                                        break;
                                    case 4:
                                        break;
                                    default:
                                        System.out.println("Ingrese");
                                }

                                break;
                            case 2://baloncesto
                                break;
                            case 3://Natacion
                                break;
                            case 4://Voleibol
                                break;
                            case 5:
                                System.out.println("Saliendo de la funcionalidad");
                                salirTorneo = true;
                                break;
                            default:
                                System.out.println("Ingrese una opicón válida");
                    }

                    break;

                case 4:
                    System.out.println("\n--- Crear evento ---");
                    // Lógica para crear eventos
                    break;

                case 5:
                    System.out.println("\n--- Generar Pagos ---");
                    // Lógica para generar pagos
                    break;

                case 6:
                    System.out.println("Saliendo del sistema. ¡Hasta pronto!");
                    salir = true;
                    break;

                default:
                    System.out.println("Opción inválida. Por favor, seleccione una opción del 1 al 6.");
            }
        }

        scanner.close();
    }
}
