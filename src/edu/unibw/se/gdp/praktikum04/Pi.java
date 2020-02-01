package edu.unibw.se.gdp.praktikum04;

public class Pi {
    public static void main(String[] args) {
        System.out.println(wallissischesProdukt(1));
    }

    public static double wallissischesProdukt(double abbruch) {
        for (int i = 1; abbruch != (abbruch*((4*Math.pow(i,2))/((4*Math.pow(i,2))-1))); i++)
            abbruch = abbruch*((4*Math.pow(i,2))/((4*Math.pow(i,2))-1));

        return abbruch*2;
    }
}
