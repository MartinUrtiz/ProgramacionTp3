public class ListaEnlazada {
    protected Nodo primero;

    public ListaEnlazada() {
        this.primero = null;
    }

    public void agregar(Object dato) {
        Nodo nuevo = new Nodo(dato);
        if (primero == null) {
            primero = nuevo;
        } else {
            Nodo actual = primero;
            while (actual.siguiente != null) {
                actual = actual.siguiente;
            }
            actual.siguiente = nuevo;
        }
    }

    // Métodos necesarios para Pila y Cola
    public Nodo getPrimero() {
        return primero;
    }

    public void setPrimero(Nodo primero) {
        this.primero = primero;
    }

    public int getTamaño() {
        int tamaño = 0;
        Nodo actual = primero;
        while (actual != null) {
            tamaño++;
            actual = actual.siguiente;
        }
        return tamaño;
    }

    public Object[] convertirAArray() {
        int tamaño = getTamaño();
        Object[] array = new Object[tamaño];
        
        Nodo actual = primero;
        int indice = 0;
        while (actual != null) {
            array[indice] = actual.dato;
            actual = actual.siguiente;
            indice++;
        }
        return array;
    }

    public static ListaEnlazada convertirArrayALista(Object[] array) {
        ListaEnlazada nuevaLista = new ListaEnlazada();
        for (int i = 0; i < array.length; i++) {
            nuevaLista.agregar(array[i]);
        }
        return nuevaLista;
    }
}