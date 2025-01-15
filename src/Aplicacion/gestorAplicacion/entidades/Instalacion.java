package gestorAplicacion.entidades;

import gestorAplicacion.entidades.Toldo;

public class Instalacion {
    public int idInstalacion;
    public String deporte;
    public int precioHora;
    public int profundidad;
    public Toldo toldo;

    //Constructor con todos los atributos
    public Instalacion(int idInstalacion, String deporte, int precioHora, int profundidad, Toldo toldo) {
        this.idInstalacion = idInstalacion;
        this.deporte = deporte;
        this.precioHora = precioHora;
        this.profundidad = profundidad;
        this.toldo = toldo;
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
}