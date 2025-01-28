package baseDatos;

import gestorAplicacion.eventos.Evento;
import gestorAplicacion.inscripcion.GrupoFormativo;
import gestorAplicacion.pagos.Cliente;
import gestorAplicacion.reservas.Reserva;
import gestorAplicacion.torneo.Torneo;

import java.io.*;

public class Serializador {
    private static File rutaTemp = new File("out\\production\\src\\baseDatos\\temp");

    public static void serializar() {
        File[] docs = rutaTemp.listFiles();

        assert docs != null;
        for (File file : docs) {

            try (PrintWriter pw = new PrintWriter(file)) {
                pw.print("");
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }
        }

        for (File file : docs) {
            try (FileOutputStream fos = new FileOutputStream(file);
                 ObjectOutputStream oos = new ObjectOutputStream(fos)) {
                if (file.getAbsolutePath().contains("reserva")) {
                    oos.writeObject(Reserva.getListaReservas());
                } else if (file.getAbsolutePath().contains("cliente")) {
                    oos.writeObject(Cliente.getListaClientes());
                } else if (file.getAbsolutePath().contains("torneo")) {
                    oos.writeObject(Torneo.getTorneos());
                } else if (file.getAbsolutePath().contains("formativo")) {
                    oos.writeObject(GrupoFormativo.getGrupoFormativos());
                } else if(file.getAbsolutePath().contains("evento")){
                    oos.writeObject(Evento.getEventos());
                }
            } catch (NotSerializableException e) {
                System.out.println("Error: Un objeto no es serializable: " + e.getMessage());
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}