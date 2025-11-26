public class Estudiante extends Persona implements MiembroUniversidad{
    private String carrera;
    private double promedio;
    private ListaEnlazada materias;

    public Estudiante(String nombre, String apellido, int edad, String documento, String carrera, Materia[] materiasArray) {
        super(nombre, apellido, edad, documento);
        this.carrera = carrera;
        this.materias = ListaEnlazada.convertirArrayALista(materiasArray); 
        this.promedio = calcularPromedioIterativo();
    }

    public static double calcularPromedioRecursivo(Nodo actual, int contador, double suma) {
        if (actual == null) {
            return contador == 0 ? 0 : suma / contador;
        }
        Materia materia = (Materia) actual.dato;
        return calcularPromedioRecursivo(actual.siguiente, contador + 1, suma + materia.getNota());
    }

    public double calcularPromedioIterativo() {
        if (materias == null || materias.getPrimero() == null) return 0;
        double suma = 0;
        int contador = 0;
        Nodo actual = materias.getPrimero();
        while (actual != null) {
            Materia m = (Materia) actual.dato;
            suma += m.getNota();
            contador++;
            actual = actual.siguiente;
        }
        return contador == 0 ? 0 : suma / contador;
    }

    @Override
    public String obtenerRol() {
        return "Estudiante";
    }

    @Override
    public String obtenerInformacionCompleta() {
        return toString();
    }

    @Override
    public String toString() {
        return "Estudiante: " + super.toString() + ", Carrera: " + carrera + ", Promedio: " + promedio;
    }
    
    public Nodo getMateriasPrimero() {
        return materias.getPrimero();
    }
}