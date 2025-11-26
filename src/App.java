public class App {
   public static void main(String[] args) {
        Profesor prof1 = new Profesor("Fernando", "Cavenaghi", 45, "10223312", "Matemática", 20);
        Profesor prof2 = new Profesor("Hernan", "Crespo", 55, "11243333", "Programación", 25);

        Materia[] materias1Array = {
            new Materia("Matemática I", 7.5, prof1),
            new Materia("Programación I", 7.0, prof2)
        };
        Materia[] materias2Array = {
            new Materia("Diseño Web", 9.5, prof1),
            new Materia("Base de Datos", 8.5, prof2)
        };
        // Se necesitan objetos Materia individuales para las solicitudes
        Materia m1 = materias1Array[0]; 
        Materia m2 = materias2Array[0];

        Estudiante e1 = new Estudiante("Maximiliano", "Rodriguez", 20, "45111222", "Ingeniería", materias1Array);
        Estudiante e2 = new Estudiante("Lionel", "Messi", 24, "42786668", "Sistemas", materias2Array);
        Estudiante e3 = new Estudiante("Angel", "DiMaria", 22, "44111333", "Ingeniería", new Materia[]{}); // Para la cuenta recursiva

        Personal p1 = new Personal("Pablo", "Aimar", 33, "33111444", "Administración", "Secretario", "2010-03-12");

        Universidad u = new Universidad();
        u.agregarMiembro(e1);
        u.agregarMiembro(e2);
        u.agregarMiembro(e3);
        u.agregarMiembro(prof1);
        u.agregarMiembro(prof2);
        u.agregarMiembro(p1);

        System.out.println("=== Listado de Miembros ===");
        u.listarMiembros();
        
        System.out.println("\n=== Promedio Recursivo (e1) ===");
        double promRec = Estudiante.calcularPromedioRecursivo(e1.getMateriasPrimero(), 0, 0);
        System.out.println("Promedio recursivo de " + e1.getNombre() + ": " + promRec);

        System.out.println("\n=== Contar Estudiantes Recursivo (Carrera: Ingeniería) ===");
        int count = u.contarEstudiantes("Ingeniería");
        System.out.println("Estudiantes en Ingeniería: " + count);

        System.out.println("\n=== Ordenamiento por Apellido ===");
        Estudiante[] lista = {e1, e2, e3};
        Universidad.ordenarEstudiantesPorApellido(lista);
        for (Estudiante e : lista) System.out.println(e);

        System.out.println("\n=== Búsqueda Binaria (Apellido = 'Messi') ===");
        int pos = Universidad.busquedaBinariaEstudiantes(lista, "Messi");
        System.out.println(pos >= 0 ? "Encontrado: " + lista[pos] : "No encontrado");
        
        System.out.println("\n" + "=".repeat(30));
        System.out.println("=== NUEVAS FUNCIONALIDADES (Pila y Cola) ===");
        System.out.println("=".repeat(30));

        HistorialCambios hc = new HistorialCambios();
        System.out.println("\n--- Historial de Notas (PILA) ---");
        hc.registrarCambio(new CambioNota(e1.getDocumento(), m1.getNombre(), 7.5, 8.0, "2025-11-25"));
        hc.registrarCambio(new CambioNota(e2.getDocumento(), m2.getNombre(), 8.5, 9.0, "2025-11-26")); // Último

        hc.mostrarHistorialRecursivo();
        
        hc.deshacerUltimoCambio();
        hc.deshacerUltimoCambio();

        GestorInscripciones gi = new GestorInscripciones();
        System.out.println("\n--- Solicitudes de Inscripción (COLA) ---");
        gi.agregarSolicitud(new SolicitudInscripcion(e1, m2, "2025-11-25 10:00")); 
        gi.agregarSolicitud(new SolicitudInscripcion(e2, m1, "2025-11-25 10:05"));
        gi.agregarSolicitud(new SolicitudInscripcion(e3, m1, "2025-11-25 10:10"));

        System.out.println("Siguiente a procesar: " + gi.verSiguienteSolicitud());

        gi.procesarSiguienteSolicitud();
        
        System.out.println("\n--- Procesando Cola Recursivamente ---");
        gi.procesarTodasSolicitudesRecursivo(); 
    }
}