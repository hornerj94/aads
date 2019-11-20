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
    private final class ListNode {
        
        /** The successor of this node. */
        private ListNode next;
        
        /** The data the node holds. */
        private T data;
        
        /**
         * Creates an list node with the given data.
         * 
         * @param value The stated data
         */
        private ListNode(final T value) {
            data = value;
        }
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
        
        chainNode(index, new ListNode(element));
        size++;
    }
    
    //----------------------------------------------------------------------------------------------


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

    //----------------------------------------------------------------------------------------------

    /**
     * {@inheritDoc}
     */
    @Override
    public T remove(final int index) {
        checkIndex(index);
        
        ListNode element = unchainNode(index);
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
     * Chains the given list node into the list.
     * 
     * @param index The index at which the node should be inserted
     * @param node The node to insert
     */
    private void chainNode(final int index, final ListNode node) {
        boolean insertAsFirst = (index == 0);        
        if (insertAsFirst) {
            chainFirst(node);
        } else {
            boolean insertAsLast = (index == size());
            if (insertAsLast) {
                chainLast(node);
            } else {
                chainAt(index, node);
            }
        }
    }

    //----------------------------------------------------------------------------------------------

    /**
     * Chains the given list node as head and if the list is empty as last as well.
     * 
     * @param node The stated node
     */
    private void chainFirst(final ListNode node) {
        if (isEmpty()) { last = node; }

        node.next = head;
        head = node;
    }

    /**
     * Chains the given list node as last.
     * 
     * @param node The stated node
     */
    private void chainLast(final ListNode node) {      
        last.next = node;
        last = node;        
    }

    /**
     * Chains the given node to the list at the given index.
     * 
     * @param index The index at which the node should be inserted
     * @param node The node to insert
     */
    private void chainAt(final int index, final ListNode node) {
        ListNode prevNode = getNode(index - 1);
        ListNode subseqNode = prevNode.next;
        
        prevNode.next = node;
        node.next = subseqNode;
    }

    //----------------------------------------------------------------------------------------------

    /**
     * Unchains the given list node from the list.
     * 
     * @param index The index at which the node to be removed is located
     * @return The removed node
     */
    private ListNode unchainNode(final int index) {
        ListNode node = null;
        
        boolean removeFirst = (index == 0);
        if (removeFirst) {
            node = unchainFirst();
        } else {
            boolean removeLast = (index == (size() - 1));
            if (removeLast) {
                node = unchainLast();
            } else {
                node = unchainAt(index);
            }
        }
        
        return node;
    }

    //----------------------------------------------------------------------------------------------

    /**
     * Removes the head and sets the successor as new head.
     * 
     * @return The removed node
     */
    private ListNode unchainFirst() {       
        ListNode node = head;
        if (size() == 1) {
            head = null;
            last = null;
        } else {
            head = head.next;
        }

        return node;
    }

    /**
     * Removes the last and sets the predecessor as new last.
     * 
     * @return The removed node
     */
    private ListNode unchainLast() {       
        ListNode node = last;
        
        int indexBeforeLast = (size() - 2);
        ListNode prevNode = getNode(indexBeforeLast);

        last = prevNode;
        prevNode.next = null;

        return node;
    }

    /**
     * Removes the node at the given index.
     * 
     * @param index The index at which the node to be removed is located
     * @return The removed node
     */
    private ListNode unchainAt(final int index) {
        ListNode node = null;
        
        ListNode prevNode = getNode(index - 1);
        ListNode successorNode = prevNode.next.next;

        node = prevNode.next;
        prevNode.next = successorNode;

        return node;
    }
    
    //----------------------------------------------------------------------------------------------

    /**
     * Get the node at the given index.
     * 
     * @param index The stated index
     * @return The stated list node
     */
    private ListNode getNode(final int index) {
        ListNode node = head;
        for (int i = 0; i < index; i++) {
            node = node.next;
        }
        
        return node;
    }

    //----------------------------------------------------------------------------------------------

    /**
     * Checks the given index whether it is greater than or equal to the size or whether the index
     * is less than 0. If yes an <code>IndexOutOfBoundsException</code> is thrown.
     * 
     * @param index The index to check
     */
    private void checkIndex(final int index) {
        if (index >= size() || index < 0) { throw new IndexOutOfBoundsException(); }
    }

    //----------------------------------------------------------------------------------------------
}
