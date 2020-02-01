package edu.unibw.se.gdp.praktikum04;

import java.util.*;

import static java.util.Collections.sort;

public class Felder {
    public static void main(String[] args) {
        // Aufgabe 3 b)
        double[] a = {23, 1, 8, 2};
        System.out.println(getMaximum(a));

        // Aufgabe 3 c)
        char[] b = {'v', 'm', 'b', 'k', 'h', 'l'};
        System.out.println(revert(b));

        // Aufgabe 3 d)
        long[] c = {23, 20, 12, 6, 1};
        System.out.println(isSorted(c));
    }


    public static double getMaximum(double[] a) {
        double tmp = 0;
        for (double i: a
             ) {
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
        Long[] b = new Long[a.length];
        for (int i = 0; i<a.length; i++)
            b[i] = a[i];
        Arrays.sort(b);
        Arrays.sort(b, Collections.reverseOrder());

        for (int i = 0; i<a.length; i++) {
            if (a[i] != b[i])
                return false;
        }
        return true;
    }

}
