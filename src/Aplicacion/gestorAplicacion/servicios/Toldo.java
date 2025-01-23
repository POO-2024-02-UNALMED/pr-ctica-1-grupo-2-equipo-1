package gestorAplicacion.servicios;

public class Toldo {
    public int idToldo;
    public int precioToldo;
    public String patrocinadorToldo;

    //Constructor sin nombre del patrocinador
    public Toldo(int idToldo, int precioToldo){
        this.idToldo = idToldo;
        this.precioToldo = precioToldo;
    }
    //Constructor con nombre del patrocinador
    public Toldo(int idToldo, int precioToldo, String patrocinadorToldo){
        this.idToldo = idToldo;
        this.precioToldo = precioToldo;
        this.patrocinadorToldo = patrocinadorToldo;
    }

    //Setters y getters
    public void setIdToldo(int idToldo){
        this.idToldo = idToldo;
    }
    public void setPrecioToldo(int precioToldo){
        this.precioToldo = precioToldo;
    }
    public void setPatrocinadorToldo(String patrocinadorToldo){
        this.patrocinadorToldo = patrocinadorToldo;
    }
    public String getPatrocinadorToldo(){
        return patrocinadorToldo;
    }
    public int getIdToldo(){
        return idToldo;
    }
    public int getPrecioToldo(){
        return precioToldo;
    }
}
