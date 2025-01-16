package gestorAplicacion.servicios;

import java.util.Scanner;

public class DeporteFormativo {

    // Atributos
    private String nombre;
    private int edad;
    private String eps;
    private String acudiente;
    private String deporteDeseado;
    private int experienciaMeses; // Experiencia en meses
    private String categoriaEquipo; // Categoría del equipo asignado
    private String categoriaEntrenador; // Categoría del entrenador asignado
    private String horario; // Horario asignado

    // Constructor vacío
    public DeporteFormativo() {}

    // Métodos
    public void capturarDatos() {
        Scanner scanner = new Scanner(System.in);

        // Captura de los datos personales
        System.out.print("Nombre: ");
        this.nombre = scanner.nextLine();

        System.out.print("Edad: ");
        this.edad = scanner.nextInt();
        scanner.nextLine(); // Consumir el salto de línea

        System.out.print("EPS: ");
        this.eps = scanner.nextLine();

        System.out.print("Nombre del Acudiente: ");
        this.acudiente = scanner.nextLine();

        System.out.print("Deporte deseado: ");
        this.deporteDeseado = scanner.nextLine();

        // Captura de experiencia previa en meses
        System.out.print("Experiencia previa en meses: ");
        this.experienciaMeses = scanner.nextInt();

        // Cerrar scanner
        scanner.close();
    }

    public void clasificarYAsignar() {
        // Clasificación y asignación según meses de experiencia
        if (experienciaMeses < 6) {
            this.categoriaEquipo = "Categoría 1";
            this.categoriaEntrenador = "Entrenador Categoría 1";
        } else if (experienciaMeses <= 12) {
            this.categoriaEquipo = "Categoría 2";
            this.categoriaEntrenador = "Entrenador Categoría 2";
        } else {
            this.categoriaEquipo = "Categoría 3";
            this.categoriaEntrenador = "Entrenador Categoría 3";
        }

        // Asignación de horario disponible
        if (edad <= 12) { // Para los más jóvenes, asignar horario de mañana
            this.horario = "Mañana: 6 AM - 12 M";
        } else { // Para mayores de 12 años, asignar horario de tarde
            this.horario = "Tarde: 1 PM - 8 PM";
        }
    }

    public void mostrarResultados() {
        // Mostrar los datos ingresados y asignaciones realizadas
        System.out.println("\n--- Resultados de la Evaluación ---");
        System.out.println("Nombre: " + nombre);
        System.out.println("Edad: " + edad);
        System.out.println("EPS: " + eps);
        System.out.println("Acudiente: " + acudiente);
        System.out.println("Deporte Deseado: " + deporteDeseado);
        System.out.println("Experiencia Previa: " + experienciaMeses + " meses");
        System.out.println("Equipo Asignado: " + categoriaEquipo);
        System.out.println("Entrenador Asignado: " + categoriaEntrenador);
        System.out.println("Horario Asignado: " + horario);
    }

    // Método main para pruebas
    public static void main(String[] args) {
        // Crear instancia de DeporteFormativo
        DeporteFormativo deporteFormativo = new DeporteFormativo();

        // Capturar datos
        deporteFormativo.capturarDatos();

        // Clasificar y asignar equipo, entrenador y horario
        deporteFormativo.clasificarYAsignar();

        // Mostrar resultados
        deporteFormativo.mostrarResultados();
    }
}
/*
### **Explicación del código:**
1. **Atributos:**
    - **Datos personales:** `nombre`, `edad`, `eps`, `acudiente`.
    - **Datos deportivos:** `deporteDeseado`, `experienciaMeses`.
    - Se agregaron **atributos para asignación**: `categoriaEquipo`, `categoriaEntrenador`, y `horario`.

2. **Métodos:**
    - **`capturarDatos`**: Captura los datos del joven usando la clase `Scanner`.
    - **`clasificarYAsignar`**:
        - Evalúa la experiencia previa y asigna un equipo y entrenador según las reglas indicadas.
        - Asigna un horario basado en la edad del joven:
            - Menores de 12: Horario de mañana.
            - Mayores de 12: Horario de tarde.

    - **`mostrarResultados`**: Presenta los datos personales y las asignaciones efectuadas.

3. **Uso del método `main`:**
    - Permite ejecutar el flujo completo (`capturarDatos`, `clasificarYAsignar`, `mostrarResultados`) en una prueba.

### **Ejemplo de ejecución del programa:**
#### Entrada del usuario:
```
Nombre: Juan Pérez
Edad: 14
EPS: Salud Total
Nombre del Acudiente: María Pérez
Deporte deseado: Fútbol
Experiencia previa en meses: 10
```
#### Salida esperada:
```
--- Resultados de la Evaluación ---
Nombre: Juan Pérez
Edad: 14
EPS: Salud Total
Acudiente: María Pérez
Deporte Deseado: Fútbol
Experiencia Previa: 10 meses
Equipo Asignado: Categoría 2
Entrenador Asignado: Entrenador Categoría 2
Horario Asignado: Tarde: 1 PM - 8 PM
```
### **Posibles Mejoras:**
- Permitir múltiples capturas de datos para varios jóvenes (usando una lista).
- Agregar validaciones en la entrada (por ejemplo, que la `edad` sea mayor a 0).
- Opcionalmente manejar horarios personalizados o verificar disponibilidad según día.

Si necesitas agregar cualquiera de estas mejoras, avísame. 😊

 */