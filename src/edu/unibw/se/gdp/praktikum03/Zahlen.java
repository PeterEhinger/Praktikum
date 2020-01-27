package edu.unibw.se.gdp.praktikum03;

import java.lang.reflect.Array;

public class Zahlen {
    public static void main(String[] args) {
        //System.out.println(isHarshadZahl(12));
        //printHarshadZahl(100);
        //System.out.println(teilersumme(12));
        printVollkommeneZahlen(1000);
    }

    public static long quersumme(long n) {
        long tmp = 0;
        while (n > 0) {
            tmp = tmp + n % 10;
            n = n / 10;
        }
        return tmp;
    }

    public static boolean isHarshadZahl(long n) {
        return (n % quersumme(n) == 0);
    }

    public static void printHarshadZahl(long n) {
        for (int i = 1; i <= n; i++)
            if (isHarshadZahl(i)) System.out.println(i);
    }

    public static long teilersumme(long n) {
        long tmp = 0;
        for (int i = 1; i < n; i++)
            if (n % i == 0) tmp = tmp + i;
        return tmp;
    }

    public static void printVollkommeneZahlen(long n) {
        for (int i = 1; i <= n; i++) {
            if (teilersumme(i) == i) System.out.println(i);
        }
    }
}
