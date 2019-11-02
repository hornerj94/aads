/*
 * Copyright 2019 (C) by Julian Horner.
 * All Rights Reserved.
 */

package lists;

/**
 * My own implementation of an ArrayList.
 * 
 * @param <T> The type of the elements of the list
 */
public class ArrayList<T> implements List<T> {
    //---------------------------------------------------------------------------------------------

    /** The array of the list to store the elements. */
    private T[] elements;

    //----------------------------------------------------------------------------------------------

    /**
     * Default constructor.
     */
    public ArrayList() {
//        elements = T[25];
    }

    //----------------------------------------------------------------------------------------------

    /**
     * {@inheritDoc}
     */
    @Override
    public boolean add(final Object element) {
        return false;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void add(final int index, final Object element) {
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
    public T get(final int index) {
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
    public boolean remove(final Object element) {
        return false;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public T remove(final int index) {
        return null;
    }

    //---------------------------------------------------------------------------------------------
}