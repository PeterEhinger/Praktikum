package edu.unibw.se.gdp.Praktikum07;

public class SLLIntOperation {
    public static void main(String[] args) {
        SLLInt a = new SLLInt(11);
        SLLInt b = new SLLInt(0, a);
        SLLInt c = new SLLInt(2, b);
        SLLInt d = new SLLInt(-22, c);
        SLLInt e = new SLLInt(2, d);
        SLLInt f = new SLLInt(15, e);
        SLLInt g = new SLLInt(-7, f);
        SLLInt h = new SLLInt(9, g);
        SLLInt i = new SLLInt(-9, h);


        //System.out.println(toString(removeNegative(i)));
        //System.out.println(toString(removePositiv(i)));
        System.out.println(toString(copyWithoutNegative(i)));
        System.out.println(toString(copyWithoutPositive(i)));

        /*SLLInt[] listen = {a, b, c, d, e, f, g, h , i};

        for (SLLInt liste: listen
             ) {
            System.out.println(toString(liste));
            System.out.println("->" + getLength(liste));
            System.out.println("->" + isSorted(liste));
        }*/


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

    public static SLLInt removeNegative(SLLInt seq) {
        if (seq == null)
            return null;
        else if (seq.value < 0) {
            return removeNegative(seq.next);
        } else {
            seq.next = removeNegative(seq.next);
            return seq;
        }
    }

    public static SLLInt removePositiv(SLLInt seq) {
        if (seq == null)
            return null;
        else if (seq.value > 0) {
            return removePositiv(seq.next);
        } else {
            seq.next = removePositiv(seq.next);
            return seq;
        }
    }

    public static SLLInt copyWithoutNegative(SLLInt seq) {
        if (seq == null)
            return null;
        else if (seq.value < 0) {
            return copyWithoutNegative(seq.next);
        } else {
            return new SLLInt(seq.value, copyWithoutNegative(seq.next));
        }
    }

    public static SLLInt copyWithoutPositive(SLLInt seq) {
        if (seq == null)
            return null;
        else if (seq.value > 0) {
            return copyWithoutPositive(seq.next);
        } else {
            return new SLLInt(seq.value, copyWithoutPositive(seq.next));
        }
    }
}
