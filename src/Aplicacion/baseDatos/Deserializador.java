package baseDatos;

import gestorAplicacion.inscripcion.GrupoFormativo;
import gestorAplicacion.pagos.Cliente;
import gestorAplicacion.reservas.Reserva;
import gestorAplicacion.torneo.Torneo;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.ArrayList;

public class Deserializador {
    private static File rutaTemp = new File("out/production/src/baseDatos/temp");

    public static void deserializar() throws IOException, ClassNotFoundException {
        File[] docs = rutaTemp.listFiles();
        FileInputStream fis;
        ObjectInputStream ois;


        for(File file: docs){
            if(file.getAbsolutePath().contains("reserva")){
                fis = new FileInputStream(file);
                ois = new ObjectInputStream(fis);

                Reserva.setListaReservas((ArrayList<Reserva>) ois.readObject());
            } else if (file.getAbsolutePath().contains("cliente")) {
                fis = new FileInputStream(file);
                ois = new ObjectInputStream(fis);

                Cliente.setListaClientes((ArrayList<Cliente>) ois.readObject());
            } else if (file.getAbsolutePath().contains("torneo")) {
                fis = new FileInputStream(file);
                ois = new ObjectInputStream(fis);

                Torneo.setTorneos((ArrayList<Torneo>) ois.readObject());
            }else if(file.getAbsolutePath().contains("formativo")){
                fis = new FileInputStream(file);
                ois = new ObjectInputStream(fis);

                GrupoFormativo.setGrupoFormativos((ArrayList<GrupoFormativo>) ois.readObject());
            }
        }


    }
}
