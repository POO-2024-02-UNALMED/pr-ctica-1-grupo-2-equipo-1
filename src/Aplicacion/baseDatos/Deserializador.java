package baseDatos;

import gestorAplicacion.eventos.Evento;
import gestorAplicacion.inscripcion.GrupoFormativo;
import gestorAplicacion.pagos.Cliente;
import gestorAplicacion.reservas.Reserva;
import gestorAplicacion.torneo.Torneo;

import java.io.*;
import java.util.ArrayList;

public class Deserializador {
    private static File rutaTemp = new File("out/production/src/baseDatos/temp");

    public static void deserializar() {
        File[] docs = rutaTemp.listFiles();
        if (docs == null) {
            System.out.println("No se encontraron archivos en la ruta especificada.");
            return;
        }

        for (File file : docs) {
            if (file.getAbsolutePath().contains("reserva")) {
                deserializarReservas(file);
            } else if (file.getAbsolutePath().contains("cliente")) {
                deserializarClientes(file);
            } else if (file.getAbsolutePath().contains("torneo")) {
                deserializarTorneos(file);
            } else if (file.getAbsolutePath().contains("formativo")) {
                deserializarGrupoFormativo(file);
            } else if (file.getAbsolutePath().contains("evento")) {
                deserealizarEventos(file);
            }
        }
    }

    private static void deserealizarEventos(File file){
        try (FileInputStream fis = new FileInputStream(file);
             ObjectInputStream ois = new ObjectInputStream(fis)) {
            Evento.setEventos((ArrayList<Evento>) ois.readObject());
        } catch (EOFException e) {
            System.out.println("Se alcanzó el final del archivo para eventos: " + file.getName());
        } catch (FileNotFoundException e) {
            System.out.println("Archivo no encontrado: " + file.getName());
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    private static void deserializarReservas(File file) {
        try (FileInputStream fis = new FileInputStream(file);
             ObjectInputStream ois = new ObjectInputStream(fis)) {
            Reserva.setListaReservas((ArrayList<Reserva>) ois.readObject());
        } catch (EOFException e) {
            System.out.println("Se alcanzó el final del archivo para reservas: " + file.getName());
        } catch (FileNotFoundException e) {
            System.out.println("Archivo no encontrado: " + file.getName());
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    private static void deserializarClientes(File file) {
        try (FileInputStream fis = new FileInputStream(file);
             ObjectInputStream ois = new ObjectInputStream(fis)) {
            Cliente.setListaClientes((ArrayList<Cliente>) ois.readObject());
        } catch (EOFException e) {
            System.out.println("Se alcanzó el final del archivo para clientes: " + file.getName());
        } catch (FileNotFoundException e) {
            System.out.println("Archivo no encontrado: " + file.getName());
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    private static void deserializarTorneos(File file) {
        try (FileInputStream fis = new FileInputStream(file);
             ObjectInputStream ois = new ObjectInputStream(fis)) {
            Torneo.setTorneos((ArrayList<Torneo>) ois.readObject());
        } catch (EOFException e) {
            System.out.println("Se alcanzó el final del archivo para torneos: " + file.getName());
        } catch (FileNotFoundException e) {
            System.out.println("Archivo no encontrado: " + file.getName());
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    private static void deserializarGrupoFormativo(File file) {
        try (FileInputStream fis = new FileInputStream(file);
             ObjectInputStream ois = new ObjectInputStream(fis)) {
            GrupoFormativo.setGrupoFormativos((ArrayList<GrupoFormativo>) ois.readObject());
        } catch (EOFException | ClassNotFoundException e) {
            System.out.println("Se alcanzó el final del archivo para grupo formativo: " + file.getName());
        } catch (IOException e) {
            System.out.println("Archivo no encontrado: " + file.getName());
        }
    }
}