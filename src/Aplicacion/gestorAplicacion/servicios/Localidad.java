package gestorAplicacion.servicios;

import gestorAplicacion.Instalacion;

public class Localidad {
    public Instalacion instalacionLocalidad;
    public String ubicacion;
    public int capacidad;
    public int precioSugerido;
    public boolean division;
    public boolean menores;

    //constructor sin precio sugerido
    public Localidad(Instalacion instalacion, String ubicacion, int capacidad) {
        this.instalacionLocalidad = instalacion;
        this.ubicacion = ubicacion;
        this.capacidad = capacidad;
        this.division = false;
        this.menores = false;
        int ps = (int) Math.round(50000 + capacidad * 0.01);
        this.precioSugerido = ps;
    }

    //constructor con precio sugerido
    public Localidad(Instalacion instalacion, String ubicacion, int capacidad, int precioSugerido) {
        this.instalacionLocalidad = instalacion;
        this.ubicacion = ubicacion;
        this.capacidad = capacidad;
        this.division = false;
        this.menores = false;
        this.precioSugerido = precioSugerido;
    }

    //setters y getters
    public void setInstalacionLocalidad(Instalacion instalacion) {
        this.instalacionLocalidad = instalacion;
    }
    public void setUbicacion(String ubicacion) {
        this.ubicacion = ubicacion;
    }
    public void setCapacidad(int capacidad) {
        this.capacidad = capacidad;
    }
    public void setPrecioSugerido(int precioSugerido) {
        this.precioSugerido = precioSugerido;
    }
    public void setDivision(boolean division) {
        this.division = division;
    }
    public void setMenores(boolean menores) {
        this.menores = menores;
    }
    public Instalacion getInstalacionLocalidad() {
        return instalacionLocalidad;
    }
    public String getUbicacion() {
        return ubicacion;
    }
    public int getCapacidad() {
        return capacidad;
    }
    public int getPrecioSugerido() {
        return precioSugerido;
    }
    public boolean getDivision() {
        return division;
    }
    public boolean getMenores() {
        return menores;
    }
}