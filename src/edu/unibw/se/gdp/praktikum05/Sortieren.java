package edu.unibw.se.gdp.praktikum05;

import java.util.Arrays;

public class Sortieren {
    private static int vergleiche = 0;
    private static int vertauschungen = 0;

    public static void main(String[] args) {
        double[][] arrays = {null, {}, {1.0}, {3.0, 2.5, 1.0, 2.5}};
        for (double[] array : arrays) {
            System.out.print(Arrays.toString(array) + " -> ");
            selectionSort(array);
            System.out.println(Arrays.toString(array));
        }

        selectionSort(new double[]{1.0, 2.0, 3.0, 4.0, 5.0});
        System.out.println(vergleiche + ", " + vertauschungen);

        vergleiche = 0; vertauschungen = 0;
        selectionSort(new double[]{5.0, 4.0, 3.0, 2.0, 1.0});
        System.out.println(vergleiche + ", " + vertauschungen);
    }

    public static void selectionSort(double[] a) {
        if (a != null)
        {
            for (int i = 0; i < a.length - 1; i++) {
                for (int j = i + 1; j < a.length; j++) {
                    vergleiche ++;
                    if (a[i] > a[j]) {
                        double temp = a[i];
                        a[i] = a[j];
                        a[j] = temp; vertauschungen++;
                    }
                }
            }
        }

    }
}
