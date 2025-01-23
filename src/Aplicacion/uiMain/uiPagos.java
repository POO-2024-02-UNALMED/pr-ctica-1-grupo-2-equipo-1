package uiMain;

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
                    System.out.println("pago via ID");
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

    private static void pagoViaID(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Ingrese el ID de la reserva: ");
        int idIngresado = scanner.nextInt();

    }
}
