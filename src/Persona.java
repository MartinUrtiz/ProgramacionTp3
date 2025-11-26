public class Persona {
 private String nombre;
    private String apellido;
    private int edad;
    private String documento;

    public Persona(String nombre, String apellido, int edad, String documento) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.edad = edad;
        this.documento = documento;
    }

    public String getNombre() { return nombre; }
    public String getApellido() { return apellido; }
    public int getEdad() { return edad; }
    public String getDocumento() { return documento; }

    public void setNombre(String nombre) { this.nombre = nombre; }
    public void setApellido(String apellido) { this.apellido = apellido; }
    public void setEdad(int edad) { this.edad = edad; }
    public void setDocumento(String documento) { this.documento = documento; }

    @Override
    public String toString() {
        return nombre + " " + apellido + " (DNI: " + documento + ")";
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (!(obj instanceof Persona)) return false;
        Persona p = (Persona) obj;
        return this.documento.equals(p.documento);
    }

    @Override
    public int hashCode() {
        return documento.hashCode();
    }
}
