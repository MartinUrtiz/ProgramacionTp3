public class Universidad {
    private ListaEnlazada miembros; 

    public Universidad() {
        this.miembros = new ListaEnlazada(); 
    }

    public void agregarMiembro(MiembroUniversidad miembro) {
        miembros.agregar(miembro);
    }

    public void listarMiembros() {
        Nodo actual = miembros.getPrimero();
        while (actual != null) {
            MiembroUniversidad m = (MiembroUniversidad) actual.dato;
            System.out.println(m.obtenerInformacionCompleta());
            actual = actual.siguiente;
        }
    }

    public static int contarEstudiantesRecursivo(Nodo actual, String carrera) {
        if (actual == null) return 0;
        
        MiembroUniversidad miembro = (MiembroUniversidad) actual.dato;
        int contador = 0;
        
        if (miembro instanceof Estudiante) {
            Estudiante e = (Estudiante) miembro;
            if (e.obtenerRol().equals("Estudiante") && e.toString().contains("Carrera: " + carrera)) {
                contador = 1;
            }
        }
        
        return contador + contarEstudiantesRecursivo(actual.siguiente, carrera);
    }

    public int contarEstudiantes(String carrera) {
        return contarEstudiantesRecursivo(miembros.getPrimero(), carrera);
    }

    public static Estudiante[] ordenarEstudiantesPorApellido(Estudiante[] estudiantes) {
        int n = estudiantes.length;
        for (int i = 0; i < n - 1; i++) {
            int indiceMinimo = i;
            for (int j = i + 1; j < n; j++) {
                if (estudiantes[j].getApellido().compareTo(estudiantes[indiceMinimo].getApellido()) < 0) {
                    indiceMinimo = j;
                }
            }
            if (indiceMinimo != i) {
                Estudiante temp = estudiantes[i];
                estudiantes[i] = estudiantes[indiceMinimo];
                estudiantes[indiceMinimo] = temp;
            }
        }
        return estudiantes;
    }

    public static int busquedaBinariaEstudiantes(Estudiante[] estudiantes, String apellido) {
        int izquierda = 0;
        int derecha = estudiantes.length - 1;
        while (izquierda <= derecha) {
            int medio = (izquierda + derecha) / 2;
            int comparacion = estudiantes[medio].getApellido().compareToIgnoreCase(apellido);
            if (comparacion == 0) return medio;
            else if (comparacion < 0) izquierda = medio + 1;
            else derecha = medio - 1;
        }
        return -1;
    }
}