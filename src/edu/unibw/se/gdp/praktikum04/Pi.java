package edu.unibw.se.gdp.praktikum04;

public class Pi {
    public static void main(String[] args) {
        System.out.println(wallissischesProdukt(0.01));
    }

    public static double wallissischesProdukt(double abbruch) {
        double tmp = 100;
        double tmp2 = 1;
        for (int i = 1; (abbruch+1) <= tmp; i++) {
            tmp = ((4 * Math.pow(i, 2)) / ((4 * Math.pow(i, 2)) - 1));
            tmp2 = tmp2 * tmp;
        }

        return tmp2*2;
    }
}
