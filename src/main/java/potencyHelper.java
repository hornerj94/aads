/*
 * Copyright 2019 (C) Julian.
 * All Rights Reserved.
 */

/**
 * Helper class for calculating potency.
 * 
 * @author Julian
 */
public final class potencyHelper {
    //---------------------------------------------------------------------------------------------

    public static void main(final String[] args) {
        System.out.println(calculatePotency(-5, 3));
    }

    //---------------------------------------------------------------------------------------------

    public static int calculatePotency(final int base, final int exponent) {
        int result = 0;
        for (int i = 0; i < exponent; i++) {
            result = base * base;
        }

        return result;
    }

    //---------------------------------------------------------------------------------------------
}