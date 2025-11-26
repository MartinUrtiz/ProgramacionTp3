public class CambioNota {
    private String estudianteDocumento; 
    private String materiaNombre;
    private double notaAnterior;
    private double notaNueva;
    private String fecha; 

    public CambioNota(String estudianteDocumento, String materiaNombre, double notaAnterior, double notaNueva, String fecha) {
        this.estudianteDocumento = estudianteDocumento;
        this.materiaNombre = materiaNombre;
        this.notaAnterior = notaAnterior;
        this.notaNueva = notaNueva;
        this.fecha = fecha;
    }
    
    public String getEstudianteDocumento() { return estudianteDocumento; }
    public String getMateriaNombre() { return materiaNombre; }
    public double getNotaAnterior() { return notaAnterior; }
    public double getNotaNueva() { return notaNueva; }

    @Override
    public String toString() {
        return "CambioNota [Estudiante: " + estudianteDocumento + ", Materia: " + materiaNombre + 
               ", Antes: " + notaAnterior + ", Ahora: " + notaNueva + ", Fecha: " + fecha + "]";
    }
}