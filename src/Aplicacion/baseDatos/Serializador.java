package baseDatos;

import gestorAplicacion.pagos.Cliente;
import gestorAplicacion.reservas.Reserva;
import gestorAplicacion.torneo.Torneo;

import java.io.*;

public class Serializador {
    private static File rutaTemp  = new File("out\\production\\src\\baseDatos\\temp");

    public static void serializar() throws IOException {
        FileOutputStream fos;
        ObjectOutputStream oos;
        File[] docs = rutaTemp.listFiles();
        PrintWriter pw;

        assert docs != null;
        for(File file : docs){
            try {
                pw = new PrintWriter(file);
            }catch(FileNotFoundException e){
                e.printStackTrace();
            }
        }

        for (File file : docs){
            if(file.getAbsolutePath().contains("reserva")){
                    fos = new FileOutputStream(file);
                    oos = new ObjectOutputStream(fos);
                    oos.writeObject(Reserva.getListaReservas());
            }else if(file.getAbsolutePath().contains("cliente")){
                    fos = new FileOutputStream(file);
                    oos = new ObjectOutputStream(fos);
                    oos.writeObject(Cliente.getListaClientes());
            } else if (file.getAbsolutePath().contains("torneo")) {
                    fos = new FileOutputStream(file);
                    oos = new ObjectOutputStream(fos);
                    oos.writeObject(Torneo.torneos);
            }

        }
    }
}
