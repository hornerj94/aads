/*
 * Copyright 2019 (C) Julian.
 * All Rights Reserved.
 */

package lists;

/**
 * List interface that describes operations of a list.
 * 
 * @param <T> The type of the list
 */
public interface List<T> {
    // ---------------------------------------------------------------------------------------------

    /**
     * Add an element to the end of the list. Returns whether the operation was
     * successfully.
     * 
     * @param element The element to add
     * @return Whether the insertion completed successfully.
     */
    boolean add(final T element);

    /**
     * Add an element to the given position of the list. Move all elements to the
     * right after the inserted element by one.
     * 
     * @param index   the index to insert the element
     * @param element The element to add
     */
    void add(final int index, final T element);

    /**
     * Gets the current size of the list.
     * 
     * @return The stated size
     */
    int size();

    /**
     * Get the element at the given index in the list. Returns null if no element
     * was found.
     * 
     * @param index The stated index
     * @return The stated element or null
     */
    T get(final int index);

    /**
     * Get whether the list is empty.
     * 
     * @return Whether the list is empty
     */
    boolean isEmpty();

    /**
     * Removes the given element from the list. Returns whether the operation was
     * successfully.
     * 
     * @param element The stated element
     * @return Whether the operation was successfully
     */
    boolean remove(final T element);

    /**
     * Removes the element at the given index from the list. Returns the removed
     * element or null if the element wasn't found in the list.
     * 
     * @param index The stated index
     * @return The removed element or null
     */
    T remove(final int index);

    // ---------------------------------------------------------------------------------------------
}