/*
 * Copyright 2019 (C) Julian.
 * All Rights Reserved.
 */

/**
 * Dummy.
 * 
 * @author Julian
 */
public class fakHelper {
    //---------------------------------------------------------------------------------------------

    public static void main(String[] args) {
        System.out.println(fak(5));
    }

    public static int fak(int fak1) {
        if (fak1 == 1) {
            return 1;
        }
        return fak1 * fak(fak1 - 1);
    }

    //---------------------------------------------------------------------------------------------
}