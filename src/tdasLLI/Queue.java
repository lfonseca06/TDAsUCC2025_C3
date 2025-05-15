/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tdasLLI;

import java.util.Iterator;

/**
 *
 * @author yessv
 */
public class Queue <Item> implements Iterable<Item>{
    
    private Node first;
    private Node last;
    private int count;

    
    
    //Creamos la clase interna Node
    private class Node{
        Item item;
        Node next;
    }
    
    public void enqueue(Item item){
        Node oldlast = last;
        last = new Node();
        last.item = item;
        oldlast.next = last;
        if(isEmpty())
            first = last;
        count++;
                
    }
    
    public Item dequeue(){
        Item item = first.item;
        first.item = null;
        first = first.next;
        count--;
        if(isEmpty())
            last = null;
        return item;
    }
    
    public boolean isEmpty(){
        return first == null;
        //return count == 0;
    }
    
    public int size(){
        return count;
    }
    
    @Override
    public Iterator<Item> iterator() {
        return new LinkedListIterator();
    }
    
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
