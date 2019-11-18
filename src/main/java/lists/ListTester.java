/*
 * Copyright 2019 (C) by Julian Horner.
 * All Rights Reserved.
 */

package lists;

import java.util.Iterator;

/**
 * Class for testing my list implementations.
 * 
 * @author julian
 */
public final class ListTester {
    //----------------------------------------------------------------------------------------------

    /**
     * Tests the lists.
     * 
     * @param args The arguments
     */
    public static void main(final String[] args) {
        List<Integer> list = new SinglyLinkedList<>();

        for (int i = 0; i < 10; i++) {
            list.add(i);
        }
                
        for (int i = 0; i < list.size(); i++) {
            System.out.println(list.get(i));
        }
        
        Iterator<Integer> it = list.iterator();
        while (it.hasNext()) {
            System.out.println(it.next());
        }
        
        for (Integer i : list) {
            System.out.println(i);
        }
    }

    //----------------------------------------------------------------------------------------------

    /**
     * Hide constructor of utility class.
     */
    private ListTester() { }
    
    //----------------------------------------------------------------------------------------------
}
