/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */


package tdasLLI;
import java.util.NoSuchElementException;
import java.util.Iterator;

/**
 *
 * @author yessica malaver
 */
public class List <Item> implements Iterable<Item>{
    
    private Node first;
    private Node last;
    private int count;
    
    //Creamos la clase interna Node
    private class Node{
        Item item;
        Node next;
        Node prev;//del anterior
    }
    
    public void add(int index, Item item) {
    if (index < 0 || index > count) {
        throw new IndexOutOfBoundsException("Índice fuera de rango: " + index);
    }

    if (index == 0) {
        addFirst(item);
    } else if (index == count) {
        addLast(item);
    } else {
        Node current = first;
        for (int i = 0; i < index - 1; i++) {
            current = current.next;
        }

        Node newNode = new Node();
        newNode.item = item;
        newNode.prev = current;
        newNode.next = current.next;

        current.next.prev = newNode;
        current.next = newNode;

        count++;
        }
    }
    
      public void addFirst(Item item) {
        Node oldfirst = first;
        first = new Node();
        first.item = item;
        first.next = oldfirst;
        first.prev = null;
        if (oldfirst != null) {
            oldfirst.prev = first;
        } else {
            last = first; // La lista estaba vacía
        }
        count++;
    }
      
    public void addLast(Item item) {
        Node oldlast = last;
        last = new Node();
        last.item = item;
        last.prev = oldlast;
        last.next = null;
        if (oldlast != null) {
            oldlast.next = last;
        } else {
            first = last; // La lista estaba vacía
        }
        count++;
    }
    
     public void clear() {
        Node current = first;
        while (current != null) {
            Node next = current.next;
            current.item = null;
            current.next = null;
            current.prev = null;
            current = next;
        }
        first = null;
        last = null;
        count = 0;
    }
     
    public boolean contains(Item item) {
        for (Item i : this) {
            if (i.equals(item)) return true;
        }
        return false;
    }
    
    public Item getFirst() {
        if (isEmpty()) throw new NoSuchElementException("Lista vacía");
        return first.item;
    }
    
    public Item getLast() {
        if (isEmpty()) throw new NoSuchElementException("Lista vacía");
        return last.item;
    }
    
    public boolean isEmpty(){
        return first == null;
        //return count == 0;
    }
    
    public int size(){
        return count;
    }
    public Item removeFirst() {
        if (isEmpty()) throw new NoSuchElementException("Lista vacía");
        Item item = first.item;
        Node oldfirst = first;
        first = first.next;
        if (first != null) {
            first.prev = null;
        } else {
            last = null; // La lista queda vacía
        }
        oldfirst.item = null;
        count--;
        return item;
    }
    
    public Item removeLast() {
        if (isEmpty()) throw new NoSuchElementException("Lista vacía");
        Item item = last.item;
        Node oldlast = last;
        last = last.prev;
        if (last != null) {
            last.next = null;
        } else {
            first = null; // La lista queda vacía
        }
        oldlast.item = null;
        count--;
        return item;
    }

    public boolean remove(Item item) {
        Node current = first;
        while (current != null) {
            if (current.item.equals(item)) {
                if (current == first) {
                    removeFirst();
                    return true;
                } else if (current == last) {
                    removeLast();
                    return true;
                } else {
                    current.prev.next = current.next;
                    current.next.prev = current.prev;
                    current.item = null;
                    count--;
                    return true;
                }
            }
            current = current.next;
        }
        return false;
    }
    
    public Item get(int index) {
        if (index < 0 || index >= count) {
            throw new IndexOutOfBoundsException("Índice fuera de rango: " + index);
        }
        Node current = first;
        for (int i = 0; i < index; i++) {
            current = current.next;
        }
        return current.item;
    }

    public int indexOf(Item item) {
        Node current = first;
        int index = 0;
        while (current != null) {
            if (current.item.equals(item)) {
                return index;
            }
            current = current.next;
            index++;
        }
        return -1;
    }

    public Item remove(int index) {
        if (index < 0 || index >= count) {
            throw new IndexOutOfBoundsException("Índice fuera de rango: " + index);
        }
        if (index == 0) {
            return removeFirst();
        }
        if (index == count - 1) {
            return removeLast();
        }
        Node current = first;
        for (int i = 0; i < index; i++) {
            current = current.next;
        }
        Item removedItem = current.item;
        current.prev.next = current.next;
        current.next.prev = current.prev;
        current.item = null;
        count--;
        return removedItem;
    }

    public void set(int index, Item item) {
        if (index < 0 || index >= count) {
            throw new IndexOutOfBoundsException("Índice fuera de rango: " + index);
        }
        Node current = first;
        for (int i = 0; i < index; i++) {
            current = current.next;
        }
        current.item = item;
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

