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
public final class SinglyLinkedList<T> implements List<T> {
    //----------------------------------------------------------------------------------------------

    /** The head node of the list. */
    private ListNode head;
    
    /** The last node of the list. */
    private ListNode last;
    
    /** The current size of the list. */
    private int size;
    
    //----------------------------------------------------------------------------------------------

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
        add(size(), element);
        return true;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void add(final int index, final T element) {
        if (index > size() || index < 0) { throw new IndexOutOfBoundsException(); }

        ListNode newNode = new ListNode();
        newNode.data = element;

        boolean insertAsFirst = (index == 0);
        boolean insertAsLast = (index == size());
        if (insertAsFirst) {
            newNode.next = head;
            head = newNode;
            last = head;
        } else if (insertAsLast) {
            last.next = newNode;
            last = newNode;
        } else {
            ListNode node = head;
            int subseqIndex = index - 1;
            for (int i = 0; i < subseqIndex; i++) {
                node = node.next;
            }
            ListNode subseqNode = node.next;
            node.next = newNode;
            newNode.next = subseqNode;
        }

        size++;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public T get(final int index) {
        checkIndex(index);
        
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
        //size--;
        
        return false;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public T remove(final int index) {
        checkIndex(index);
        
        ListNode element = null;
        boolean removeFirst = (index == 0);
        if (removeFirst) {
            element = head;
            head = head.next;
        } else {
            ListNode node = head;
            int subseqIndex = index - 1;
            for (int i = 0; i < subseqIndex; i++) {
                node = node.next;
            }
            
            boolean removeLast = (index == (size() - 1));
            if (removeLast) {
                element = node.next;
                
                node.next = null;
                node = last;
            } else {
                ListNode subseqNode = node.next;
                element = subseqNode;
                node.next = subseqNode.next;
            }
        }
        
        size--;

        return element.data;
    }

    //----------------------------------------------------------------------------------------------

    /**
     * {@inheritDoc}
     */
    @Override
    public int size() { return size; }

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
            
            private ListNode node = head;
            
            @Override
            public boolean hasNext() { return node != null; }

            @Override
            public T next() {
                if (node == null) { throw new NoSuchElementException(); }
                
                T data = node.data;
                node = node.next;
                                
                return data;
            }
            
        };
    }
    
    //----------------------------------------------------------------------------------------------
    
    /**
     * Checks the given index whether it is greater than or equal to the size or less than 0. If yes
     * an <code>IndexOutOfBoundsException</code> is thrown.
     * 
     * @param index The index to check
     */
    private void checkIndex(final int index) {
        if (index >= size() || index < 0) { throw new IndexOutOfBoundsException(); }
    }

    //----------------------------------------------------------------------------------------------
}
