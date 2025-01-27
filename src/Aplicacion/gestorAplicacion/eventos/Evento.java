package gestorAplicacion.eventos;

import gestorAplicacion.reservas.Instalacion;
import gestorAplicacion.eventos.Localidad;
import java.util.ArrayList;
import java.util.List;

public class Evento {
    private String nombreEvento;
    private String tipoEvento;
    private String personajePrincipal;
    private String generoMusical;
    private List<Localidad> localidades;
    private List<Instalacion> toldosPatrocinados;
    private Instalacion lugarPrincipal;

    public Evento() {
        this.localidades = new ArrayList<>();
        this.toldosPatrocinados = new ArrayList<>();
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

    public Instalacion getLugarPrincipal() {
        return lugarPrincipal;
    }

    public void setLugarPrincipal(Instalacion lugarPrincipal) {
        this.lugarPrincipal = lugarPrincipal;
    }
}
