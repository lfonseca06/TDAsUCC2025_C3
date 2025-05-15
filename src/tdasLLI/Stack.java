/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tdasLLI;

import java.util.Iterator;
import java.util.ListIterator;

/**
 *
 * @author yessica Malaver
 */
public class Stack <Item> implements Iterable<Item>{
   private Node first;
   private int count;
   
   //El contador no es obligatorio es opcional
   
   public Stack (){
       first = null;
       count = 0;
   }
   
   //Creamos una clase interna o anidada llamada Node
   // Por ser interna debe ser private
   private class Node{
    Item item;
    Node next;
   } 
   
   //metodo para insertar - apilar
   public void push (Item item){
        Node oldfirst = first;
        first = new Node();
        first.item = item;
        first.next = oldfirst;
        count ++;
   }
   //Metodo para eliminar - desapilar
   public Item pop(){
       Item item = first.item;
       first.item= null;
       first = first.next;
       count--;
       return item;
   }
   
   //Método para mostrar el primer dado- solo lo muestra no lo elimina
   public Item peak(){
      return first.item;
   }
   
   //Metodo para validar si esta vacio
   public boolean isEmpty(){
       return first == null;//si no hay un primer elemento está vacio
   }
   
   //Metodo para saber el tamaño
   public int size (){
       return count;
   }
   
    @Override
    public Iterator<Item> iterator() {
        return new LinkedListIterator();
    }
    //Creo una clase privada Iterator
    private class LinkedListIterator implements Iterator <Item>{
        
        private Node current= first;//current es el actual

        @Override
        public boolean hasNext() {
            return current != null;
        }

        @Override
        public Item next() {
            Item item = current.item;
            current =current.next;
            return item;
        }
        
        
    }
   
}
