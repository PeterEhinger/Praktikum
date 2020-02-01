package edu.unibw.se.gdp.praktikum03;

public class Nat {
    public static void main(String[] args) {

        int zahl = 123233;
        int ziffer = 3;
        //System.out.println(occurs(ziffer, zahl));

        // ---------------------------------------------------------------- //
        int x = 18;
        int y = 24;
        System.out.println(ggT(x, y));
    }

    public static int occurs(int n, int z) {
        if (z == 0) return 0;
        else if (z % 10 == n) return 1 + (occurs(n, z / 10));
        else return (occurs(n, z / 10));
    }

    public static int ggT(int x, int y) {
        if (x == y) return x;
        else return (((x > y)) ? (ggT(x - y, y)) : (ggT(y - x, x)));
    }
}
