/*
 * Copyright 2019 (C) Julian.
 * All Rights Reserved.
 */

package lists;

/**
 * My own implementation of an ArrayList.
 */
public class ArrayList<T> implements List<T> {
    //---------------------------------------------------------------------------------------------

    /** The array of the list to store the elements. */
    private T[] elements;

    //---------------------------------------------------------------------------------------------

    /**
     * Default constructor.
     */
    public ArrayList() {
        elements = T[25];
    }

    //---------------------------------------------------------------------------------------------

    /**
     * {@inheritDoc}
     */
    @Override
    public boolean add(Object element) {
        return false;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void add(int index, Object element) {
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public int size() {
        return 0;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public T get(int index) {
        return null;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public boolean isEmpty() {
        return false;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public boolean remove(Object element) {
        return false;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public T remove(int index) {
        return null;
    }

    //---------------------------------------------------------------------------------------------
}