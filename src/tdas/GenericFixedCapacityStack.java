 package tdas;
//import cosas.Placa;
/**
 * OK Generica, Iterable,
 * Redimensionable, OK No loitering
 */
 //REALIZAR LA COLA, CON TODOS LOS MÉTODOS, GENERICA, CAPACIDAD VARIABLE, NO LOITERING Y QUE SEA ITERABLE
public class GenericFixedCapacityStack <Item>{
   private Item a[];
   private int count;
   
   /**
     * Constructor que inicializa una pila con una capacidad máxima especificada.
     * 
     * @param maxCap la capacidad máxima de la pila (debe ser no negativa)
     * @throws IllegalArgumentException si {@code maxCap} es negativo
     */
   
   public GenericFixedCapacityStack(int maxCap){
       a = (Item[])new Object[maxCap];
       count = 0;
   }
   /**
     * Añade un elemento a la parte superior de la pila.
     * 
     * @param item el elemento a añadir (no puede ser {@code null})
     * @throws ArrayIndexOutOfBoundsException si la pila está llena
     * @throws NullPointerException si {@code item} es {@code null}
     */
   
   public void push(Item item){
       a[count++] = item;
   }
   /**
     * Elimina y devuelve el elemento en la parte superior de la pila.
     * 
     * @return el elemento eliminado de la cima de la pila
     * @throws ArrayIndexOutOfBoundsException si la pila está vacía
     */
   
   public Item pop(){
       Item aux = a[--count];
       a[count] = null;
       return aux;
   }
   /**
     * Devuelve (sin eliminar) el elemento en la parte superior de la pila.
     * 
     * @return el elemento en la cima de la pila
     * @throws ArrayIndexOutOfBoundsException si la pila está vacía
     */
   
   public Item peak(){
       return a[count-1];
   }
   /**
     * Verifica si la pila está vacía.
     * 
     * @return {@code true} si la pila no contiene elementos, {@code false} en caso contrario
     */
   
   public boolean isEmpty(){
       return count == 0;
   }
   /**
     * Devuelve el número actual de elementos en la pila.
     * 
     * @return la cantidad de elementos almacenados
     */
   
   public int size(){
       return count;
   }
   /**
     * Devuelve una representación en cadena de los elementos de la pila.
     * Los elementos se listan en orden desde el fondo hasta la cima (uno por línea).
     * 
     * @return una cadena con los elementos de la pila separados por saltos de línea
     */
   
   public String toString(){
       String salida = "";
       for(int i=0;i<count; i++){
           salida += a[i] + " \n";
       }
       return salida;
   }
}
