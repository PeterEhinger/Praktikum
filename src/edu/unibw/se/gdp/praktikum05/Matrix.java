package edu.unibw.se.gdp.praktikum05;

public class Matrix {
    public static void main(String[] args) {
        int l = 5;
        int m = 5;
        double[][] a = new double[l][m];
    }

    public static boolean isMatrix(double[][] a, int l, int m) {
        if(!(l <= 0) && !(m <= 0) && isMatrix(a)) {
            return true;
        }

        return false;
    }

    public static boolean isMatrix(double[][] a) {
        if (a == null)
            return false;


        return true;
    }
}
