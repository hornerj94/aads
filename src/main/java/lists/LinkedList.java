/*
 * Copyright 2019 (C) by Julian Horner.
 * All Rights Reserved.
 */

package lists;

import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * My implementation of a singly linked list.
 * 
 * @author julian
 *
 * @param <T> The type of the data of the list
 */
public class LinkedList<T> implements List<T> {
    //----------------------------------------------------------------------------------------------

    /** The head node of the list. */
    private ListNode head;
    
    /**
     * A node of the list containing the data it holds and a reference to the next node in the list.
     */
    private class ListNode {
        
        /** The successor of this node. */
        private ListNode next;
        
        /** The data the node holds. */
        private T data;
    }
    
    //----------------------------------------------------------------------------------------------
    
    /**
     * {@inheritDoc}
     */
    @Override
    public boolean add(final T element) {
        ListNode node = head;
        while (node.next != null) {
            node = node.next;
        }
        
        ListNode newNode = new ListNode();
        newNode.data = element;
        node.next = newNode;
        
        return true;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void add(final int index, final T element) {   
        //TODO to be implemented
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public T get(final int index) {
        if (index > size() || index < 0) { throw new IndexOutOfBoundsException(); }
        
        ListNode node = head;
        for (int i = 0; i < index; i++) {
            node = node.next;
        }

        return node.data;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public boolean remove(final T element) {
        //TODO to be implemented
        return false;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public T remove(final int index) {
        //TODO to be implemented
        return null;
    }

    //----------------------------------------------------------------------------------------------

    /**
     * {@inheritDoc}
     */
    @Override
    public int size() {
        ListNode node = head;
        
        int size = 0;
        while (node.next != null) {
            size++;
            node = node.next;
        }
        
        return size;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public boolean isEmpty() { return head == null; }
    
    //----------------------------------------------------------------------------------------------

    /**
     * {@inheritDoc}
     */
    @Override
    public String toString() {
        ListNode node = head;
        StringBuilder sb = new StringBuilder("[");
        while (node != null) {
            sb.append(node.data);
            sb.append(", ");
            
            node = node.next;
        }
        sb.setLength(sb.length() - 2);
        sb.append("]");
        
        return sb.toString();
    }
    
    //----------------------------------------------------------------------------------------------

    /**
     * {@inheritDoc}
     */
    @Override
    public Iterator<T> iterator() {
        return new Iterator<T>() {
            
            private ListNode node;
            
            @Override
            public boolean hasNext() { return node.next != null; }

            @Override
            public T next() {
                if (node.next == null) { throw new NoSuchElementException(); }
                
                T data = node.data;
                node = node.next;
                
                return data;
            }
            
        };
    }
    
    //----------------------------------------------------------------------------------------------
}
