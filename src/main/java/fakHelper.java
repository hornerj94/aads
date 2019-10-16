/*
 * Copyright 2019 (C) Julian.
 * All Rights Reserved.
 */

/**
 * Helper class for calculating fakulty.
 * 
 * @author Julian
 */
public final class fakHelper {
    // --------------------------------------------------------------------------------------------

    public static void main(String[] args) {
        System.out.println(calculateFak(5));
    }

    // --------------------------------------------------------------------------------------------

    /**
     * Calculates and returns the faculty for the given input. The method works
     * recursive.
     * 
     * @param base The base
     * @return The faculty
     */
    public static int calculateFak(int base) {
        if (base == 1) {
            return 1;
        }
        return base * calculateFak(base - 1);
    }

    // --------------------------------------------------------------------------------------------

    /**
     * Hide utility class constructor.
     */
    private fakHelper() {
    }

    // --------------------------------------------------------------------------------------------
}