package edu.unibw.se.gdp.praktikum06;

public class SLLIntOperation {
    public static void main(String[] args) {
        SLLInt liste1 = new SLLInt(1);
        SLLInt liste2 = new SLLInt(5, liste1);
        SLLInt liste3 = new SLLInt(83, liste2);

        System.out.println(toString(liste3));
        System.out.println(getLength(liste3));
        System.out.println(isSorted(liste3));
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
            if (seq.value <= seq.next.value)
                seq = seq.next;
            else
                return false;
        }
        return true;
    }
}
