package edu.unibw.se.gdp.praktikum02;

public class MathTest {
    public static void main(String[] args) {
        double a;
        double b;
        double c;

        a = 100.0;
        b = 75.0;
        c = hypotenuse(a, b);
        System.out.println(c);
    }

    public static double hypotenuse(double a, double b) {
        //Satz des Pythagoras
        double c;
        double tmp = Math.pow(a, 2) + Math.pow(b,2);
        c = Math.pow(tmp, (0.5));

        return c;
    }
}
