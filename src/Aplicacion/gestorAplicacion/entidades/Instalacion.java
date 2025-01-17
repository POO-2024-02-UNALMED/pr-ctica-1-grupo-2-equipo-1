package gestorAplicacion.entidades;

import gestorAplicacion.entidades.Toldo;

//Agregar capacidad de la instalacion (cantidad de tribunas)

public class Instalacion {
    public int idInstalacion = 0;
    public String deporte;
    public int precioHora;
    public int profundidad;
    public Toldo toldo;
    public String nombre;
    public String descripcion;

    //Constructor con todos los atributos
    public Instalacion(String nombre, String deporte, int precioHora, int profundidad, String descripcion) { //Hacer otro constructor con toldo, además, la clase toldo se podria eliminar
        this.idInstalacion++;
        this.nombre = nombre;
        this.deporte = deporte;
        this.descripcion = descripcion;
        this.precioHora = precioHora;
        this.profundidad = profundidad;
    }

    // Métodos setters y getters
    public void setIdInstalacion(int idInstalacion) {
        this.idInstalacion = idInstalacion;
    }
    public void setDeporte(String deporte) {
        this.deporte = deporte;
    }
    public void setPrecioHora(int precioHora) {
        this.precioHora = precioHora;
    }
    public void setProfundidad(int profundidad) {
        this.profundidad = profundidad;
    }
    public void setToldo(Toldo toldo) {
        this.toldo = toldo;
    }
    public int getIdInstalacion() {
        return idInstalacion;
    }
    public String getDeporte() {
        return deporte;
    }
    public int getPrecioHora() {
        return precioHora;
    }
    public int getProfundidad() {
        return profundidad;
    }
    public Toldo getToldo() {
        return toldo;
    }

    @Override
    public String toString() {
        return "Instalación: " + nombre + "\nDescripción: " + descripcion;
    }

}

