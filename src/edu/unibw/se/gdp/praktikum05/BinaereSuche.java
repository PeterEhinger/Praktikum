package edu.unibw.se.gdp.praktikum05;

public class BinaereSuche {
    public static void main(String[] args) {
        int[] a1 = {1, 4, 6, 8, 11, 15, 61};
        int[] a2 = {1, 2, 7, 7, 11, 12, 15};

        for (int i : a1)
            System.out.println(i + " , Index: " + getIndexR(a1, i));


        System.out.println(7 + " , Index: " + getIndexR(a2, 7));

    }


    public static int getIndex(int[] a, int value) {
        if (a == null)
            return -1;

        int leftLimit = 0;
        int rightLimit = a.length - 1;

        while (leftLimit <= rightLimit) {
            int middle = (leftLimit + rightLimit) / 2;

            if (a[middle] == value) {
                return middle;
            } else if (a[middle] < value) {
                leftLimit = middle + 1;
            } else {
                rightLimit = middle - 1;
            }
        }

        return -1;
    }


    public static int getIndexR(int[] a, int value) {
        if (a == null)
            return -1;

        return getIndex(a, value, 0, a.length-1);
    }

    public static int getIndex(int[] a, int value, int leftLimit, int rightLimit) {
        while (leftLimit <= rightLimit) {
            int middle = (leftLimit + rightLimit) / 2;

            if (a[middle] == value) {
                return middle;
            } else if (a[middle] < value) {
                return getIndex(a, value, middle+1, rightLimit);
            } else {
                return getIndex(a, value, leftLimit, middle-1);
            }
        }

        return -1;
    }
}
