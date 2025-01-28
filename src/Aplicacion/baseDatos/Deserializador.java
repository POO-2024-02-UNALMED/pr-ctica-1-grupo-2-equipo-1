package baseDatos;

import gestorAplicacion.inscripcion.GrupoFormativo;
import gestorAplicacion.pagos.Cliente;
import gestorAplicacion.reservas.Reserva;
import gestorAplicacion.torneo.Torneo;

import java.io.*;
import java.util.ArrayList;

public class Deserializador {
    private static File rutaTemp = new File("out/production/src/baseDatos/temp");

    public static void deserializar() throws IOException, ClassNotFoundException {
        File[] docs = rutaTemp.listFiles();
        FileInputStream fis;
        ObjectInputStream ois;


        for(File file: docs){
            if(file.getAbsolutePath().contains("reserva")){
                try{
                    fis = new FileInputStream(file);
                    ois = new ObjectInputStream(fis);

                    Reserva.setListaReservas((ArrayList<Reserva>) ois.readObject());
                }catch (FileNotFoundException e){
                    System.out.println(e);
                }
            } else if (file.getAbsolutePath().contains("cliente")) {
                try{
                    fis = new FileInputStream(file);
                    ois = new ObjectInputStream(fis);

                    Cliente.setListaClientes((ArrayList<Cliente>) ois.readObject());
                }catch (FileNotFoundException e){
                    System.out.println(e);
                }
            } else if (file.getAbsolutePath().contains("torneo")) {
                try{
                    fis = new FileInputStream(file);
                    ois = new ObjectInputStream(fis);

                    Torneo.setTorneos((ArrayList<Torneo>) ois.readObject());
                }catch (FileNotFoundException e){
                    System.out.println(e);
                }
            }else if(file.getAbsolutePath().contains("formativo")){
                try{
                    fis = new FileInputStream(file);
                    ois = new ObjectInputStream(fis);

                    GrupoFormativo.setGrupoFormativos((ArrayList<GrupoFormativo>) ois.readObject());
                }catch (FileNotFoundException e){
                    System.out.println(e);
                }
            }
        }


    }
}
