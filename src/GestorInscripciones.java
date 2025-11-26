public class GestorInscripciones {
    private Cola solicitudesPendientes;

    public GestorInscripciones() {
        this.solicitudesPendientes = new Cola();
    }

    public void agregarSolicitud(SolicitudInscripcion solicitud) {
        solicitudesPendientes.insertar(solicitud);
        System.out.println("Gestor: Solicitud de " + solicitud.getEstudiante().getNombre() + " agregada a la cola.");
    }

    public SolicitudInscripcion procesarSiguienteSolicitud() {
        if (solicitudesPendientes.esVacia()) {
            System.out.println("Gestor: No hay solicitudes pendientes.");
            return null;
        }
        SolicitudInscripcion solicitud = (SolicitudInscripcion) solicitudesPendientes.quitar();
        solicitud.setEstado("Aprobada");
        System.out.println("Gestor: Procesada y Aprobada la solicitud de " + solicitud.getEstudiante().getNombre());
        return solicitud;
    }

    public SolicitudInscripcion verSiguienteSolicitud() {
        return (SolicitudInscripcion) solicitudesPendientes.verFrente();
    }

    public int cantidadSolicitudesPendientes() {
        return solicitudesPendientes.getTamaño();
    }
    

    public void procesarTodasSolicitudesRecursivo() {
        System.out.println("--- Procesando Cola Recursivamente ---");
        Cola temp = new Cola();
        procesarRecursivamente(solicitudesPendientes, temp);

    }
    
    private void procesarRecursivamente(Cola colaOriginal, Cola colaTemporal) {
        if (colaOriginal.esVacia()) {
            System.out.println("Cola de solicitudes vacía.");
            while (!colaTemporal.esVacia()) {
                colaOriginal.insertar(colaTemporal.quitar());
            }
            return;
        }
        SolicitudInscripcion solicitud = (SolicitudInscripcion) colaOriginal.quitar();
        solicitud.setEstado("Procesada Recursiva");
        System.out.println("Procesado: " + solicitud.getEstudiante().getNombre() + " para " + solicitud.getMateria().getNombre());
        colaTemporal.insertar(solicitud);
        
        procesarRecursivamente(colaOriginal, colaTemporal);
    }
}