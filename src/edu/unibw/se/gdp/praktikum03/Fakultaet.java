package edu.unibw.se.gdp.praktikum03;

import java.sql.SQLOutput;

public class Fakultaet {
    public static void main(String[] args) {
        System.out.println(fakulaet(0)); //bis !12 //479001600
        // System.out.println(fakulaetLong(21)); //bis !20 //2432902008176640000
    }

    public static int fakulaet(int n) {
        int tmp = 1;

        if (n >= 0) {
            for (int i = 1; i <= n; i++) {
                if (tmp <= (Integer.MAX_VALUE / i)) tmp = tmp * i;
                else return -1;
            }
            return tmp;
        } else return -1;
    }

    public static long fakulaetLong(int n) {
        long tmp = 1;

        if (n >= 0) {
            for (int i = 1; i <= n; i++) {
                if (tmp <= (Long.MAX_VALUE / i)) tmp = tmp * i;
                else return -1;
            }
            return tmp;
        } else return -1;
    }
}
