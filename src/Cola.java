public class Cola {
    private ListaEnlazada lista; // Base
    private Nodo ultimo; // Necesitamos referencia al último para inserción O(1)

    public Cola() {
        this.lista = new ListaEnlazada();
        this.ultimo = null;
    }

    // Insertar (ENQUEUE): Agrega al final (cola)
    public void insertar(Object dato) {
        Nodo nuevo = new Nodo(dato);
        if (esVacia()) {
            lista.setPrimero(nuevo); // ASUMO setPrimero
            ultimo = nuevo;
        } else {
            ultimo.siguiente = nuevo;
            ultimo = nuevo;
        }
    }

    // Quitar (DEQUEUE): Quita del principio (frente)
    public Object quitar() {
        if (esVacia()) return null;
        Object dato = lista.getPrimero().dato;
        lista.setPrimero(lista.getPrimero().siguiente); // Mueve el 'primero' al siguiente
        if (lista.getPrimero() == null) { // Si queda vacía
            ultimo = null;
        }
        return dato;
    }

    // Ver Frente (PEEK)
    public Object verFrente() {
        if (esVacia()) return null;
        return lista.getPrimero().dato;
    }

    public boolean esVacia() {
        return lista.getPrimero() == null;
    }
    
    // Método necesario para el ejemplo de uso
    public int getTamaño() {
        return lista.getTamaño();
    }
}