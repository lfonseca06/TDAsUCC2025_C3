package tdas;
import cosas.Placa;
/**
 *
 * @author sala5
 */
public class FixedCapacityStack {
   private Placa a[];
   private int count;
   /**
     * Constructor que crea una pila con una capacidad máxima especificada.
     * 
     * @param maxCap la capacidad máxima de la pila
     * @throws IllegalArgumentException si maxCap es negativo
     */
   
   public FixedCapacityStack(int maxCap){
       a = new Placa[maxCap];
       count = 0;
   }
   
   /**
     * Añade una placa a la parte superior de la pila.
     * 
     * @param placa la placa a añadir a la pila
     * @throws ArrayIndexOutOfBoundsException si la pila está llena
     */
   
   public void push(Placa placa){
       a[count++] = placa;
   }
   /**
     * Elimina y devuelve la placa en la parte superior de la pila.
     * 
     * @return la placa en la parte superior de la pila
     * @throws ArrayIndexOutOfBoundsException si la pila está vacía
     */
   
   
   public Placa pop(){
       return a[--count];
   }
   /**
     * Comprueba si la pila está vacía.
     * 
     * @return true si la pila está vacía, false en caso contrario
     */
   
   public boolean isEmpty(){
       return count == 0;
   }
   /**
     * Devuelve el número actual de elementos en la pila.
     * 
     * @return el número de elementos en la pila
     */
   
   public int size(){
       return count;
   }
    /**
     * Devuelve una representación en cadena de los elementos de la pila.
     * Los elementos se muestran en orden desde el fondo hasta la cima de la pila,
     * cada uno en una línea separada.
     * 
     * @return una cadena que representa los elementos de la pila
     */
   
   public String toString(){
       String salida = "";
       for(int i=0;i<count; i++){
           salida += a[i] + " \n";
       }
       return salida;
   }
}
