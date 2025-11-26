# Explicación: Arrays vs Listas Enlazadas

## Diferencias entre trabajar con **arrays** y **listas enlazadas**

### 1. Estructura interna
- **Arrays:** Estructura contigua en memoria.
- **Listas enlazadas:** Cada nodo está en memoria separada y apunta al siguiente.

### 2. Acceso a los elementos
- **Arrays:** Acceso directo 
- **Listas enlazadas:** Acceso secuencial 

### 3. Tamaño
- **Arrays:** Tamaño fijo.
- **Listas enlazadas:** Tamaño dinámico.

### 4. Inserción y eliminación
- **Arrays:** Insertar o borrar implica mover elementos 
- **Listas enlazadas:** Solo se cambian punteros 

### 5. Uso de memoria
- **Arrays:** Guardan únicamente los datos.
- **Listas enlazadas:** Cada nodo almacena datos + puntero.

---

## Ventajas y desventajas de usar **listas enlazadas**

### Ventajas
1. **Tamaño dinámico.**
2. **Inserciones y eliminaciones eficientes.**
3. **Estructura flexible** para representar relaciones dinámicas.

### Desventajas
1. **Acceso lento por posición.**
2. **Mayor uso de memoria.**
3. **Menor localidad espacial**, menos eficiente en cache.
4. **Recorridos más costosos** si se necesita acceder constantemente.

---

## Conclusión
- Si el programa modifica mucho la estructura → **lista enlazada** es recomendable.
- Si se requiere acceso rápido por índice o recorridos frecuentes → **array** es mejor opción.
