public class HistorialCambios {
    private Pila historial;

    public HistorialCambios() {
        this.historial = new Pila();
    }
    
    public void registrarCambio(CambioNota cambio) {
        historial.insertar(cambio);
        System.out.println("Historial: Cambio registrado.");
    }

    public CambioNota deshacerUltimoCambio() {
        if (historial.esVacia()) {
            System.out.println("Historial: No hay cambios para deshacer.");
            return null;
        }
        CambioNota cambioDeshecho = (CambioNota) historial.quitar();
        System.out.println("Historial: Deshecho el cambio en " + cambioDeshecho.getMateriaNombre());
        return cambioDeshecho; 
    }
    

    public void mostrarHistorialRecursivo() {
        System.out.println("--- Historial de Cambios (Cima abajo) ---");
        Pila pilaTemporal = new Pila();
        mostrarContenido(historial, pilaTemporal);
    }
    
    private void mostrarContenido(Pila original, Pila temporal) {
        if (original.esVacia()) return;
        
        CambioNota cambio = (CambioNota) original.quitar();
        System.out.println(cambio);
        temporal.insertar(cambio);
        
        mostrarContenido(original, temporal);
        

        original.insertar(temporal.quitar());
    }
}