package tdas;

import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * Implementación de una Cola genérica basada en un arreglo circular redimensionable.
 * Sigue el orden FIFO (el primero en entrar es el primero en salir).
 * Es iterable y aplica no loitering.
 */
public class Queue<Item> implements Iterable<Item> {

    private Item[] a;    // Arreglo donde se almacenan los elementos
    private int first;   // Índice del primer elemento (para eliminar)
    private int last;    // Índice donde se insertará el próximo elemento
    private int count;   // Número de elementos en la cola

    // Constructor: crea la cola con una capacidad inicial de 10
    public Queue() {
        a = (Item[]) new Object[10];
        first = 0;
        last = 0;
        count = 0;
    }
    
    
    /**
     * Agrega un elemento al final de la cola.
     * Si la capacidad se llena, automáticamente redimensiona el arreglo al doble.
     * 
     * @param item el elemento a agregar a la cola
     */
    // Agrega un nuevo elemento al final de la cola
    public void enqueue(Item item) {
        // Si el arreglo está lleno, se redimensiona al doble
        if (count == a.length) resize(2 * a.length);

        // Se inserta el elemento en la posición 'last'
        a[last++] = item;

        // Si se llega al final del arreglo, se vuelve al inicio (arreglo circular)
        if (last == a.length) last = 0;

        count++;
    }
    
    /**
     * Elimina y retorna el elemento al frente de la cola (operación FIFO).
     * 
     * @return el elemento eliminado del frente de la cola
     * @throws NoSuchElementException si la cola está vacía
     */
    // Elimina y retorna el primer elemento de la cola (FIFO)
    public Item dequeue() {
        if (isEmpty()) throw new NoSuchElementException("La cola está vacía");

        Item item = a[first];
        a[first] = null; // Eliminamos la referencia (no loitering)

        first++;
        if (first == a.length) first = 0; // ciclo circular

        count--;

        // Si hay muy pocos elementos, se reduce el tamaño del arreglo a la mitad
        if (count > 0 && count == a.length / 4) resize(a.length / 2);

        return item;
    }
    
    /**
     * Retorna (sin eliminar) el elemento al frente de la cola.
     * 
     * @return el elemento al frente de la cola
     * @throws NoSuchElementException si la cola está vacía
     */
    // Devuelve el primer elemento sin eliminarlo
    public Item peek() {
        if (isEmpty()) throw new NoSuchElementException("La cola está vacía");
        return a[first];
    }
    
    /**
     * Verifica si la cola no contiene elementos.
     * 
     * @return true si la cola está vacía, false en caso contrario
     */
    // Retorna true si la cola está vacía
    public boolean isEmpty() {
        return count == 0;
    }
    
    
    /**
     * Retorna el número actual de elementos en la cola.
     * 
     * @return la cantidad de elementos en la cola
     */
    // Retorna la cantidad de elementos almacenados
    public int size() {
        return count;
    }
    
    /**
     * Método interno que ajusta el tamaño del arreglo subyacente.
     * 
     * @param newCap la nueva capacidad para el arreglo
     */
    // Cambia el tamaño del arreglo cuando se llena o queda muy vacío
    private void resize(int newCap) {
        Item[] temp = (Item[]) new Object[newCap];

        // Copiamos los elementos actuales en el nuevo arreglo, respetando el orden FIFO
        for (int i = 0; i < count; i++) {
            temp[i] = a[(first + i) % a.length];
        }

        a = temp;
        first = 0;
        last = count;
    }
    
    
    /**
     * Retorna un iterador que permite recorrer los elementos de la cola
     * en orden FIFO (del primero al último agregado).
     * 
     * @return un iterador sobre los elementos de la cola
     */
    // Permite recorrer la cola con un for-each
    @Override
    public Iterator<Item> iterator() {
        return new ArrayIterator();
    }
    
    /**
     * Implementación de un iterador para recorrer los elementos de la cola.
     */
    // Iterador que recorre los elementos en orden FIFO
    private class ArrayIterator implements Iterator<Item> {
        private int i = 0;
        
        /**
         * Verifica si hay más elementos por recorrer en la iteración.
         * 
         * @return true si hay más elementos, false en caso contrario
         */

        public boolean hasNext() {
            return i < count;
        }
        
        /**
         * Retorna el siguiente elemento en la iteración.
         * 
         * @return el siguiente elemento en orden FIFO
         * @throws NoSuchElementException si no hay más elementos por recorrer
         */

        public Item next() {
            if (!hasNext()) throw new NoSuchElementException();
            return a[(first + i++) % a.length];
        }
    }
    
    /**
     * Retorna una representación en cadena de todos los elementos de la cola
     * en orden FIFO (del primero al último agregado).
     * 
     * @return una cadena que muestra todos los elementos de la cola
     */
    // Muestra todos los elementos de la cola como un String
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("Cola:\n");
        for (Item item : this) sb.append(item).append("\n");
        return sb.toString();
    }
}