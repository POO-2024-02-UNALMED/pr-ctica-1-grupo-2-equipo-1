package uiMain;

import gestorAplicacion.pagos.Cliente;
import gestorAplicacion.reservas.Reserva;

import java.util.Scanner;

public class uiPagos {
    public static void principalPagos(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Bienvenido al programa de pagos \nPor favor elegir alguna de estas opciones");

        boolean corriendo = true;
        do{
            System.out.println("1: Pago via ID\n2: Pago boleta de evento\n3: Administrar Suscripcion\n4:Salir de pagos");
            int opcion = scanner.nextInt();
            switch (opcion){
                case 1:
                    System.out.println("Pago via ID");
                    corriendo = pagoViaID();
                    break;
                case 2:
                    System.out.println("pago evento");
                    break;
                case 3:
                    System.out.println("administrar suscripcion");
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

    private static boolean pagoViaID(){
        Scanner scanner = new Scanner(System.in);
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
                System.out.println("Perfecto, con que medio lo desea\n1:Efecto\n2:Tarjeta");
                int opcionPago = scanner.nextInt();
                if(opcionPago == 1){
                    System.out.println("Ingrese el monto en efectivo: ");
                    int montoIngresado = scanner.nextInt();
                    System.out.println("Felicitaciones por su pago");
                    System.out.println("ID: "+reserva.getID());
                    System.out.println("Nombre: " + cliente.getNombre() + " " + cliente.getApellido());
                    System.out.println("Total: "+ totalPago);
                    System.out.println("Monto dado: "+ montoIngresado);
                    System.out.println("Vuelto" + (montoIngresado + totalPago));
                    System.out.println("Gracias por elegirnos");
                    return false;
                }else if(opcionPago == 2){
                    System.out.println("Ingrese el monto en tarjeta: ");
                    int montoIngresado = scanner.nextInt();
                    System.out.println("Felicitaciones por su pago");
                    System.out.println("ID: "+reserva.getID());
                    System.out.println("Nombre: " + cliente.getNombre() + " " + cliente.getApellido());
                    System.out.println("Total: "+ totalPago);
                    System.out.println("Gracias por elegirnos");
                    return false;
                }else{
                    System.out.println("Opcion no encontrada,Ingrese una opcion valida");
                    return true;
                }
            }else if(opcion == 2){
                System.out.println("Gracias vuelva pronto");
                return false;
            }else{
                System.out.println("Opcion no disponible,eliga otra opcion");
                return true;
            }
        }else{
            System.out.println("Reserva no encontrada porfavor ingresar un ID correcto");
            return true;
        }
    }
}
