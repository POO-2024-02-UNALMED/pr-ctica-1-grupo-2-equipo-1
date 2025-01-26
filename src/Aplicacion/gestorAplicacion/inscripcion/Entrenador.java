package gestorAplicacion.inscripcion;
import gestorAplicacion.entidades.Persona;

public class Entrenador extends Persona {

    private String deporte;

    public Entrenador(String Nombre, String Apellido, /*int Id,*/ int Edad, String Deporte) {
        super(Nombre, Apellido, /*Id ,*/Edad);
        this.deporte = Deporte;
    }
    @Override
    public String getRol() {
        return "Entrenador";
    }
    public String getDeporte() {
        return deporte;
    }
    public void setDeporte(String deporte) {
        this.deporte = deporte;
    }
}
