/*
 * Copyright 2019 (C) Trang.
 * All Rights Reserved.
 */

/**
 * Class for calculating the ggT.
 * 
 * @author Trang
 */
public final class ggTHelper {
    //---------------------------------------------------------------------------------------------

    public static void main(String[] args) {
        System.out.println(calculateGgT(9,3));
    }

    //---------------------------------------------------------------------------------------------

    public static int calculateGgT(int zahl1, int zahl2) {
        System.out.println("zahl1: " + zahl1);
        System.out.println("zahl2: " + zahl2);

        if (zahl1 > zahl2) {
            zahl1 = zahl1 - zahl2;
            int returnValue = calculateGgT(zahl1, zahl2);
            System.out.println("Zahl1 größer, Die Rückgabe war: " + returnValue);
            return returnValue;            
        } else if (zahl2 > zahl1) {
            zahl2 = zahl2- zahl1;
            int returnValue = calculateGgT(zahl1, zahl2);
            System.out.println("Zahl2 größer, Die Rückgabe war: " + returnValue);
            return returnValue;            
        } else {
            System.out.println("Gleichheit, Die Rückgabe war: " + zahl1);
            return zahl1;
        }
    }

    //---------------------------------------------------------------------------------------------
}