package edu.local.learningwicket.myprojects.sabrina;

public class Aufgabe3 {
    public static void main(String[] args) {
        int i = 10;
        // ---------- Aufgabe 3 a) ---------- //
        int zahlen[] = new int[i];
        for (i = 0; i < zahlen.length; i++) {
            zahlen[i] = i+1;
        }
        // ---------------------------------- //

        // ---------- Aufgabe 3 b) ---------- //
        int summe = 0;
        i = 0;
        do {
            summe = summe + zahlen[i];
            i++;
        } while(i < zahlen.length);
        // ---------------------------------- //

        // ---------- Aufgabe 3 c) ---------- //
        i = 0;
        int quadratZahlen[] = new int[10];
        while(i < zahlen.length) {
            quadratZahlen[i] = (int)(Math.pow(zahlen[i], 2));
            i++;
        }
        // ---------------------------------- //

        // ---------- Aufgabe 3 d) ---------- //
        i = 0;
        boolean gerade[] = new boolean[10];
        for( int k
                : quadratZahlen )
        {
            gerade[i] = ((k%2) == 0);
            i++;
        }
    }
}
