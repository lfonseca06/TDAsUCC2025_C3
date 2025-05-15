package tdas;

import cosas.*;
import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 Implementación de la estructura de datos lista con arreglos.
 La lista permite insertar eliminar buscar y recorrer elementos.
 */
public class List implements Iterable<Placa>{
    private Placa[] a;
    private int count;
    
     /**
     * Constructor que crea una lista vacía con la capacidad máxima inicial especificada.
     * 
     * @param maxCap la capacidad inicial máxima de la lista
     */

    public List(int maxCap) {
        a = new Placa[maxCap];
        count = 0;
    }
    
    
    /**
     * Inserta una placa en la posición especificada de la lista.
     * 
     * @param index la posición donde se insertará la placa
     * @param placa el objeto Placa a insertar
     * @throws IndexOutOfBoundsException si el índice está fuera del rango válido (0 ≤ index ≤ count)
     */
    
    // Adiciona la placa en la posición dada
    public void add(int index, Placa placa) {
        if (index < 0 || index > count) {
            throw new IndexOutOfBoundsException("Índice fuera de rango");
        }

        if (count == a.length) resize(a.length * 2); // redimensionar si está lleno

        shiftRight(index); // mover elementos para abrir espacio
        a[index] = placa;
        count++;
    }
    
    /**
     * Inserta una placa al inicio de la lista.
     * 
     * @param placa el objeto Placa a insertar
     */
    
    // Adiciona la placa al inicio de la lista
    public void addFirst(Placa placa) {
        add(0, placa);
    }
    
     /**
     * Inserta una placa al final de la lista.
     * 
     * @param placa el objeto Placa a insertar
     */
    
    // Adiciona la placa al final de la lista
    public void addLast(Placa placa) {
        add(count, placa);
    }

    /**
     * Elimina todos los elementos de la lista, dejándola vacía.
     */
    // Remueve todos los elementos de la lista
    public void clear() {
        for (int i = 0; i < count; i++) {
            a[i] = null;
        }
        count = 0;
    }
    
    /**
     * Verifica si la lista contiene una placa con el número especificado.
     * 
     * @param placa el número de placa a buscar (comparación insensible a mayúsculas)
     * @return true si la placa existe en la lista, false en caso contrario
     */
    // Retorna verdadero si la lista contiene una placa
    public boolean contains(String placa) {
        for (int i = 0; i < count; i++)
            if (a[i].getPlaca().equalsIgnoreCase(placa))
                return true;
        return false;
    }
    
    /**
     * Obtiene la placa en la posición especificada.
     * 
     * @param index la posición de la placa a obtener
     * @return la placa en la posición indicada, o null si el índice es inválido
     */
    // Retorna la placa en una posición dada
    public Placa get(int index) {
        return index >= 0 && index < count ? a[index] : null;
    }
    
    /**
     * Obtiene la primera placa de la lista.
     * 
     * @return la primera placa, o null si la lista está vacía
     */
    // Retorna la placa de la primera posición
    public Placa getFirst() {
        return get(0);
    }
    
    /**
     * Obtiene la última placa de la lista.
     * 
     * @return la última placa, o null si la lista está vacía
     */
    // Retorna la placa de la última posición
    public Placa getLast() {
        return get(count - 1);
    }
    
    /**
     * Busca la primera ocurrencia de una placa en la lista.
     * 
     * @param placa el número de placa a buscar (comparación insensible a mayúsculas)
     * @return el índice de la placa encontrada, o -1 si no se encuentra
     */
    // Retorna el índice de la primera ocurrencia
    public int indexOf(String placa) {
        for (int i = 0; i < count; i++)
            if (a[i].getPlaca().equalsIgnoreCase(placa))
                return i;
        return -1;
    }
    
     /**
     * Verifica si la lista está vacía.
     * 
     * @return true si la lista no contiene elementos, false en caso contrario
     */
    // Retorna verdadero si el arreglo está vacío
    public boolean isEmpty() {
        return count == 0;
    }
    
    /**
     * Elimina y retorna la placa en la posición especificada.
     * 
     * @param index la posición de la placa a eliminar
     * @return la placa eliminada, o null si el índice es inválido o la lista está vacía
     */
    // Remueve el elemento de una posición de la lista y lo retorna
    public Placa remove(int index) {
        Placa aux;
        if (!isEmpty()) {
            if (index >= 0 && index < count) {
                aux = a[index];
                shiftLeft(index);
                a[--count] = null; // no loitering
                return aux;
            }
        }
        return null;
    }
    
    
    /**
     * Elimina la primera ocurrencia de la placa especificada.
     * 
     * @param placa el número de placa a eliminar
     * @return true si se encontró y eliminó la placa, false en caso contrario
     */
    // Remueve la primera ocurrencia de una placa dada
    public boolean remove(String placa) {
        int index = indexOf(placa);
        if (index != -1) {
            remove(index);
            return true;
        }
        return false;
    }
    
     /**
     * Elimina y retorna la primera placa de la lista.
     * 
     * @return la primera placa, o null si la lista está vacía
     */
    // Remueve la primera placa
    public Placa removeFirst() {
        return remove(0);
    }
    
    /**
     * Elimina y retorna la última placa de la lista.
     * 
     * @return la última placa, o null si la lista está vacía
     */
    // Remueve la última placa
    public Placa removeLast() {
        if (!isEmpty()) {
            Placa aux = a[--count];
            a[count] = null; // no loitering
            return aux;
        }
        return null;
    }
    
    
    /**
     * Reemplaza la placa en la posición especificada.
     * 
     * @param index la posición de la placa a reemplazar
     * @param placa la nueva placa
     * @return la placa que fue reemplazada, o null si el índice es inválido o la lista está vacía
     */
    // Reemplaza la placa de una posición dada
    public Placa set(int index, Placa placa) {
        if (!isEmpty()) {
            if (index >= 0 && index < count) {
                Placa aux = a[index];
                a[index] = placa;
                return aux;
            }
        }
        return null;
    }
    
    /**
     * Obtiene el número de elementos en la lista.
     * 
     * @return la cantidad de placas almacenadas en la lista
     */
    // Retorna el número de elementos en la lista
    public int size() {
        return count;
    }
    
    /**
     * Retorna una representación en cadena de la lista y su contenido.
     * 
     * @return un string que muestra todas las placas en la lista numeradas
     */
    // Retorna un string con todos los elementos de la lista
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("Lista:\n");
        for (int i = 0; i < count; i++) {
            sb.append((i + 1)).append(". ").append(a[i]).append("\n");
        }
        return sb.toString();
    }
    
    /**
     * Método interno que mueve los elementos hacia la izquierda desde la posición dada.
     * 
     * @param index la posición desde donde comenzar el desplazamiento
     */
    // Mueve los elementos hacia la izquierda desde la posición dada
    private void shiftLeft(int index) {
        for (int i = index; i < count - 1; i++) {
            a[i] = a[i + 1];
        }
    }
    
    /**
     * Método interno que mueve los elementos hacia la derecha desde la posición dada.
     * 
     * @param index la posición desde donde comenzar el desplazamiento
     */
    // Mueve los elementos hacia la derecha desde la posición dada
    private void shiftRight(int index) {
        for (int i = count; i > index; i--) {
            a[i] = a[i - 1];
        }
    }
    
    /**
     * Método interno que redimensiona el arreglo interno cuando es necesario.
     * 
     * @param newCap la nueva capacidad del arreglo
     */
    // Aumenta la capacidad del arreglo cuando se llena
    private void resize(int newCap) {
        Placa[] temp = new Placa[newCap];
        for (int i = 0; i < count; i++) {
            temp[i] = a[i];
        }
        a = temp;
    }
    public Iterator<Placa> iterator() {
        return new Iterator<Placa>() {
            private int index = 0;

            @Override
            public boolean hasNext() {
                return index < count;
            }

            @Override
            public Placa next() {
                if (!hasNext()) throw new NoSuchElementException();
                return a[index++];
            }
        };
    }
}