package baseDatos;

import java.io.File;
import java.io.FileInputStream;
import java.io.ObjectInputStream;

public class Deserializador {
    private static File rutaTemp = new File("out/production/src/baseDatos/temp");

    public static void deserializar(){
        File[] docs = rutaTemp.listFiles();
        FileInputStream fis;
        ObjectInputStream ois;

        /*
        for(File file: docs){
            if(file.getAbsolutePath().contains("reserva")){
                fis = new FileInputStream(file);
                ois = new ObjectInputStream(fis);

            }
        }
        */

    }
}
