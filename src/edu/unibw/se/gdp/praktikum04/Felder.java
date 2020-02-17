package edu.unibw.se.gdp.praktikum04;

import java.util.Arrays;
import java.util.Collections;

public class Felder {
    public static void main(String[] args) {
        // Aufgabe 3 b)
        double[] a = {-23, -1, -8, -2};
        System.out.println(getMaximum(a));

        // Aufgabe 3 c)
        char[] b = {'v', 'm', 'b', 'h', 'l'};
        System.out.println(revert(b));

        // Aufgabe 3 d)
        long[] c = {54, 21, 10, 7, 33};
        System.out.println(isSorted(c));
    }


    public static double getMaximum(double[] a) {
        double tmp = a[0];
        for (double i: a) {
            tmp = (i>tmp) ? i : tmp;
        }
        return tmp;
    }

    public static char[] revert(char[] a) {
        for (int i = 0; i < a.length / 2; i++) {
            char temp = a[i];
            a[i] = a[a.length - 1 - i];
            a[a.length - 1 - i] = temp;
        }
        return a;
    }

    public static boolean isSorted(long[] a) {
        for (int i = 0; i < (a.length-1); i++) {
            if ((a[i] < a[i+1])) {
                return false;
            }
        }
        return true;
    }

}
