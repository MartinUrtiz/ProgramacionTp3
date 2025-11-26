public class Pila {
    private ListaEnlazada lista;

    public Pila() {
        this.lista = new ListaEnlazada(); 
    }

    public void insertar(Object dato) {
        Nodo nuevo = new Nodo(dato);
        nuevo.siguiente = lista.getPrimero();
        lista.setPrimero(nuevo); 
    }

    public Object quitar() {
        if (esVacia()) return null;
        Object dato = lista.getPrimero().dato;
        lista.setPrimero(lista.getPrimero().siguiente); 
        return dato;
    }

    public Object verCima() {
        if (esVacia()) return null;
        return lista.getPrimero().dato;
    }

    public boolean esVacia() {
        return lista.getPrimero() == null;
    }
}