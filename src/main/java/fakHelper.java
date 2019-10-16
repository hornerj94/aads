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
    //---------------------------------------------------------------------------------------------

    public static void main(String[] args) {
        System.out.println(calculateFak(5));
    }

    public static int calculateFak(int fak1) {
        if (fak1 == 1) {
            return 1;
        }
        return fak1 * calculateFak(fak1 - 1);
    }

    //---------------------------------------------------------------------------------------------
}