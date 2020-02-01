package edu.unibw.se.gdp.praktikum04;

public class Reihe {
    public static void main(String[] args) {
        System.out.println("Dei Meometrischen Reihen für:");
        System.out.println("2/3: " + geometrischeReihe(2.0/3.0));
        System.out.println("1/3: " + geometrischeReihe(1.0/3.0));
        System.out.println("99/100: " + geometrischeReihe(99/100.0));
        System.out.println("2: " + geometrischeReihe(100));
        System.out.println("100: " + geometrischeReihe(2));


        System.out.println("Die Grenzwerte für:");
        System.out.println("2/3: " + grenzwert(2.0/3.0));
        System.out.println("1/3: " + grenzwert(1.0/3.0));
        System.out.println("99/100: " + grenzwert(99/100.0));
    }

    public static double geometrischeReihe(double q) {
        int i = 0;
        double g = 0;
        do {
            g = g + Math.pow(q, i++);
        } while (g != (g + Math.pow(q, i)));
        return g;
    }

    public static double grenzwert(double q) {
        return ((1.0)/(1-q));
    }
}
