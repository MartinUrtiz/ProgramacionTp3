public class SolicitudInscripcion {
    private Estudiante estudiante;
    private Materia materia;
    private String fechaSolicitud;
    private String estado; // "Pendiente", "Aprobada", "Rechazada"

    public SolicitudInscripcion(Estudiante estudiante, Materia materia, String fechaSolicitud) {
        this.estudiante = estudiante;
        this.materia = materia;
        this.fechaSolicitud = fechaSolicitud;
        this.estado = "Pendiente";
    }

    public Estudiante getEstudiante() { return estudiante; }
    public Materia getMateria() { return materia; }
    public void setEstado(String estado) { this.estado = estado; }

    public String getFechaSolicitud() { return fechaSolicitud; }
    
    @Override
    public String toString() {
        return "Solicitud [" + estudiante.getNombre() + " " + estudiante.getApellido() + 
               " | Materia: " + materia.getNombre() + 
               " | Fecha: " + fechaSolicitud +
               " | Estado: " + estado + "]";
    }
}