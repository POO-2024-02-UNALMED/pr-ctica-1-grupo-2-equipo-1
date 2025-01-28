package gestorAplicacion.eventos;

import gestorAplicacion.pagos.Boleta;
import gestorAplicacion.reservas.Instalacion;
import gestorAplicacion.entidades.Trabajador;
import gestorAplicacion.reservas.Reserva;

import java.util.ArrayList;
import java.util.List;

public class Evento {
    private String nombreEvento;
    private String tipoEvento;
    private String personajePrincipal;
    private String generoMusical;
    private List<String> artistasInvitados;
    private Instalacion lugarPrincipal;
    private List<Localidad> localidades;
    private List<Instalacion> toldosPatrocinados;
    private List<Instalacion> foodTrucks;
    private List<Trabajador> personalSeguridad;
    private List<Trabajador> personalMedico;
    public ArrayList<Reserva> reservas = new ArrayList<>();
    public ArrayList<Boleta> boletas = new ArrayList<>();

    public Evento() {
        this.localidades = new ArrayList<>();
        this.toldosPatrocinados = new ArrayList<>();
        this.foodTrucks = new ArrayList<>();
        this.artistasInvitados = new ArrayList<>();
        this.personalSeguridad = new ArrayList<>();
        this.personalMedico = new ArrayList<>();
    }

    public String getNombreEvento() {
        return nombreEvento;
    }
    public void setNombreEvento(String nombreEvento) {
        this.nombreEvento = nombreEvento;
    }

    public String getTipoEvento() {
        return tipoEvento;
    }
    public void setTipoEvento(String tipoEvento) {
        this.tipoEvento = tipoEvento;
    }

    public String getPersonajePrincipal() {
        return personajePrincipal;
    }
    public void setPersonajePrincipal(String personajePrincipal) {
        this.personajePrincipal = personajePrincipal;
    }

    public String getGeneroMusical() {
        return generoMusical;
    }
    public void setGeneroMusical(String generoMusical) {
        this.generoMusical = generoMusical;
    }

    public List<String> getArtistasInvitados() {
        return artistasInvitados;
    }
    public void setArtistasInvitados(ArrayList<String> artistasInvitados) {
        this.artistasInvitados = artistasInvitados;
    }

    public Instalacion getLugarPrincipal() {
        return lugarPrincipal;
    }
    public void setLugarPrincipal(Instalacion lugarPrincipal) {
        this.lugarPrincipal = lugarPrincipal;
    }

    public List<Localidad> getLocalidades() {
        return localidades;
    }
    public void setLocalidades(List<Localidad> localidades) {
        this.localidades = localidades;
    }

    public List<Instalacion> getToldosPatrocinados() {
        return toldosPatrocinados;
    }
    public void setToldosPatrocinados(List<Instalacion> toldosPatrocinados) {
        this.toldosPatrocinados = toldosPatrocinados;
    }

    public List<Instalacion> getFoodTrucks() {
        return foodTrucks;
    }
    public void setFoodTrucks(List<Instalacion> foodTrucks) {
        this.foodTrucks = foodTrucks;
    }

    public List<Trabajador> getPersonalSeguridad() {
        return personalSeguridad;
    }
    public void setPersonalSeguridad(List<Trabajador> personalSeguridad) {
        this.personalSeguridad = personalSeguridad;
    }

    public List<Trabajador> getPersonalMedico() {
        return personalMedico;
    }
    public void setPersonalMedico(List<Trabajador> personalMedico) {
        this.personalMedico = personalMedico;
    }
}
