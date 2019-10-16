/*
 * Copyright 2019 (C) Trang.
 * All Rights Reserved.
 */

/**
 * Class for calculating the gcd.
 * 
 * @author Trang
 */
public final class gcdHelper {
    // --------------------------------------------------------------------------------------------

    public static void main(String[] args) {
        System.out.println(calculateGCD(9, 3));
    }

    // --------------------------------------------------------------------------------------------

    /**
     * Calculates and returns the greatest common divisor for the given inputs. The
     * method works recursive.
     * 
     * @param number1 The first number
     * @param number2 The second number
     * @return The gcd
     */
    public static int calculateGCD(int number1, int number2) {
        if (number1 > number2) {
            return calculateGCD((number1 - number2), number2);
        } else if (number2 > number1) {
            return calculateGCD(number1, number2 - number1);
        } else {
            return number1;
        }
    }

    // --------------------------------------------------------------------------------------------

    /**
     * Hide utility class constructor.
     */
    private gcdHelper() {
    }

    // --------------------------------------------------------------------------------------------
}