package gestorAplicacion.entidades;

//clase abstracta
public abstract class Persona{

    //Atributos----------------------------------------------------------
    protected String nombre;
    protected String apellido;
    protected int id;
    protected int edad;
    //-------------------------------------------------------------------

    //Constructores------------------------------------------------------

    //Constructor sin parámetros
    public Persona(){}

    //Constructor sin id
    public Persona(String nombre, String apellido, int edad) {
            this.nombre = nombre;
            this.apellido = apellido;
            this.edad = edad;
    }

    //Constructor con id
    public Persona(String nombre, String apellido, int edad, int id) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.edad = edad;
        this.id = id;
    }
    //-------------------------------------------------------------------

    //Métodos------------------------------------------------------------

    //Setters y Getters.
    public String getNombre() {
        return nombre;
    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }
    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public int getId(){
        return id;
    }
    public void setId(int id){
        this.id = id;
    }

    public int getEdad() {
        return edad;
    }
    public void setEdad(int edad) {
        this.edad = edad;
    }

    public String getNombreCompleto() {
        return nombre + " " + apellido;
    }

    @Override
    public String toString() {
        return getNombreCompleto();
    }


    //Método abstracto---------------------------------------------------

    public abstract String getRol();

    //-------------------------------------------------------------------
}
