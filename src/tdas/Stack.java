package tdas;

import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 Implementación de una Pila (Stack) genérica.
 Sigue el orden LIFO (último en entrar, primero en salir).
 Es redimensionable, iterable y aplica no-loitering para liberar memoria.
 */
public class Stack<Item> implements Iterable<Item> {

    private Item[] a;     // Arreglo donde se almacenan los elementos de la pila
    private int count;    // Cantidad de elementos en la pila

    // Constructor: crea la pila con capacidad inicial de 4
    public Stack() {
        a = (Item[]) new Object[4];
        count = 0;
    }

    /**
     * Inserta un elemento en la parte superior (cima) de la pila.
     * Si la pila está llena, duplica automáticamente su capacidad.
     * 
     * @param item el elemento a insertar en la pila
     */
    // Inserta un elemento en la parte superior de la pila
    public void push(Item item) {
        if (count == a.length) resize(2 * a.length); // redimensiona si está llena
        a[count++] = item; // agrega el elemento y aumenta el contador
    }

    /**
     * Elimina y retorna el elemento que está en la cima de la pila.
     * 
     * @return el elemento eliminado de la cima de la pila
     * @throws NoSuchElementException si la pila está vacía
     */
    // Elimina y retorna el elemento que está en la cima de la pila
    public Item pop() {
        if (isEmpty()) throw new NoSuchElementException("La pila está vacía");

        Item item = a[--count]; // obtenemos el último elemento
        a[count] = null;        // eliminamos la referencia (no loitering)

        // Si hay muy pocos elementos, se reduce la capacidad a la mitad
        if (count > 0 && count == a.length / 4) resize(a.length / 2);

        return item;
    }

    /**
     * Retorna (sin eliminar) el elemento que está en la cima de la pila.
     * 
     * @return el elemento en la cima de la pila
     * @throws NoSuchElementException si la pila está vacía
     */
    // Retorna el elemento que está en la cima sin eliminarlo
    public Item peek() {
        if (isEmpty()) throw new NoSuchElementException("La pila está vacía");
        return a[count - 1];
    }

    /**
     * Verifica si la pila no contiene elementos.
     * 
     * @return true si la pila está vacía, false en caso contrario
     */
    // Verifica si la pila está vacía
    public boolean isEmpty() {
        return count == 0;
    }

    /**
     * Retorna el número actual de elementos en la pila.
     * 
     * @return la cantidad de elementos en la pila
     */
    // Devuelve la cantidad de elementos en la pila
    public int size() {
        return count;
    }

    /**
     * Método interno que ajusta el tamaño del arreglo subyacente.
     * 
     * @param newCap la nueva capacidad para el arreglo
     */
    // Redimensiona el arreglo a una nueva capacidad
    private void resize(int newCap) {
        Item[] temp = (Item[]) new Object[newCap];
        for (int i = 0; i < count; i++) {
            temp[i] = a[i]; // copiamos los elementos al nuevo arreglo
        }
        a = temp;
    }

     /**
     * Retorna un iterador que permite recorrer los elementos de la pila
     * en orden LIFO (del último al primero agregado).
     * 
     * @return un iterador sobre los elementos de la pila
     */
    // Permite recorrer la pila con un for-each (de arriba hacia abajo)
    @Override
    public Iterator<Item> iterator() {
        return new ReverseArrayIterator();
    }

    
    // Iterador que recorre los elementos de la pila en orden LIFO
    private class ReverseArrayIterator implements Iterator<Item> {
        private int i = count;
        
         /**
         * Verifica si hay más elementos por recorrer en la iteración.
         * 
         * @return true si hay más elementos, false en caso contrario
         */
        
        public boolean hasNext() {
            return i > 0;
        }
        
        /**
         * Retorna el siguiente elemento en la iteración (orden LIFO).
         * 
         * @return el siguiente elemento de la pila
         * @throws NoSuchElementException si no hay más elementos por recorrer
         */

        public Item next() {
            if (!hasNext()) throw new NoSuchElementException();
            return a[--i]; // se recorre desde el tope hacia el fondo
        }
    }
    
     /**
     * Retorna una representación en cadena de todos los elementos de la pila
     * en orden LIFO (del último al primero agregado).
     * 
     * @return una cadena que muestra todos los elementos de la pila
     */
    // Convierte la pila en un texto para mostrar sus elementos
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("Pila:\n");
        for (Item item : this) {
            sb.append(item).append("\n");
        }
        return sb.toString();
    }
}