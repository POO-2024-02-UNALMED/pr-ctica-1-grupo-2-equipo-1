package gestorAplicacion.eventos;

import gestorAplicacion.reservas.Instalacion;

public class Localidad {
    private Instalacion instalacionLocalidad;
    private String ubicacion;
    private int capacidad;
    private int precioSugerido;
    private boolean division;
    private boolean menores;
    private boolean vip;

    public Localidad(){}
    public Localidad(Instalacion instalacion, String ubicacion, int capacidad) {
        this.instalacionLocalidad = instalacion;
        this.ubicacion = ubicacion;
        this.capacidad = capacidad;
        this.division = false;
        this.menores = false;
        this.vip = false;
        int ps = (int) Math.round(50000 + capacidad * 0.01);
        this.precioSugerido = ps;
    }

    public Localidad(Instalacion instalacion, String ubicacion, int capacidad, int precioSugerido) {
        this.instalacionLocalidad = instalacion;
        this.ubicacion = ubicacion;
        this.capacidad = capacidad;
        this.division = false;
        this.menores = false;
        this.vip = false;
        this.precioSugerido = precioSugerido;
    }

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
    public void setVip(boolean vip) {
        this.vip = vip;
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
    public boolean getVip() {
        return vip;
    }
}
