package tdas;

import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * Implementación de una Maleta (Bag) genérica.
 * Esta estructura solo permite agregar elementos.
 * No tiene orden específico y no se pueden eliminar elementos.
 * Es redimensionable, iterable y eficiente.
 * 
 */
public class Bag<Item> implements Iterable<Item> {

    private Item[] a;    // Arreglo donde se almacenan los elementos
    private int count;   // Número de elementos agregados

    // Constructor: crea una maleta con capacidad inicial de 10
    
    /**
     * Constructor que crea una bolsa con capacidad inicial de 10 elementos.
     */
    public Bag() {
        a = (Item[]) new Object[10];
        count = 0;
    }

    // Agrega un nuevo elemento a la maleta
    
    /**
     * Agrega un nuevo elemento a la bolsa.
     * Si la bolsa está llena, automáticamente aumenta su capacidad.
     * 
     * @param item el elemento a agregar a la bolsa
     */
    public void add(Item item) {
        // Si el arreglo está lleno, lo duplicamos
        if (count == a.length) resize(a.length * 2);
        a[count++] = item; // se agrega al final y se incrementa el contador
    }
    
    
    /**
     * Retorna la cantidad de elementos actualmente en la bolsa.
     * 
     * @return el número de elementos en la bolsa
     */
    // Retorna la cantidad de elementos en la maleta
    public int size() {
        return count;
    }
    
    
    /**
     * Verifica si la bolsa no contiene elementos.
     * 
     * @return true si la bolsa está vacía, false en caso contrario
     */
    // Verifica si la maleta está vacía
    public boolean isEmpty() {
        return count == 0;
    }
    
    
    /**
     * Método interno que aumenta la capacidad del arreglo subyacente.
     * 
     * @param newCap la nueva capacidad del arreglo
     */
    // Aumenta la capacidad del arreglo cuando se llena
    private void resize(int newCap) {
        Item[] temp = (Item[]) new Object[newCap];
        for (int i = 0; i < count; i++) {
            temp[i] = a[i]; // copiamos todos los elementos al nuevo arreglo
        }
        a = temp; // el nuevo arreglo se convierte en el principal
    }

    // Permite recorrer la maleta con un for-each
    
    /**
     * Retorna un iterador que permite recorrer los elementos de la bolsa.
     * 
     * @return un iterador sobre los elementos de la bolsa
     */
    @Override
    public Iterator<Item> iterator() {
        return new ArrayIterator();
    }
    
    /**
     * Implementación de un iterador para recorrer los elementos de la bolsa.
     */
    
    // Clase interna que implementa el iterador de la maleta
    private class ArrayIterator implements Iterator<Item> {
        private int i = 0;
        
        /**
         * Verifica si hay más elementos por recorrer.
         * 
         * @return true si hay más elementos, false en caso contrario
         */

        public boolean hasNext() {
            return i < count;
        }
        
        /**
         * Retorna el siguiente elemento en la iteración.
         * 
         * @return el siguiente elemento
         * @throws NoSuchElementException si no hay más elementos por recorrer
         */
        
        public Item next() {
            if (!hasNext()) throw new NoSuchElementException();
            return a[i++]; // retorna el siguiente elemento
        }
    }
    
     /**
     * Retorna una representación en cadena de la bolsa y su contenido.
     * 
     * @return una cadena que muestra todos los elementos de la bolsa
     */
    // Retorna una representación en texto de la maleta y su contenido
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("Maleta:\n");
        for (Item item : this) {
            sb.append(item).append("\n");
        }
        return sb.toString();
    }
}