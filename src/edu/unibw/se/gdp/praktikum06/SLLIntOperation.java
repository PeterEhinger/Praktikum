package edu.unibw.se.gdp.praktikum06;

public class SLLIntOperation {
    public static void main(String[] args) {
        SLLInt a = new SLLInt(8);
        SLLInt b = new SLLInt(5, a);
        SLLInt c = new SLLInt(10, b);

        SLLInt[] listen = {a, b, c};

        for (SLLInt liste: listen
             ) {
            System.out.println(toString(liste));
            System.out.println("->" + getLength(liste));
            System.out.println("->" + isSorted(liste));
        }
    }

    public static String toString(SLLInt s) {
        if (s == null)
            return "";
        else if (s.next == null)
            return "" + s.value;
        else
            return s.value + ":" + toString(s.next);
    }

    public static int getLength(SLLInt seq) {
        int i = 0;
        while (seq != null) {
            seq = seq.next;
            i++;
        }
        return i;
    }

    public static boolean isSorted (SLLInt seq) {
        while (seq != null) {
            if (seq.next == null)
                return true;
            else if (seq.value <= seq.next.value)
                seq = seq.next;
            else
                return false;
        }
        return true;
    }
}
