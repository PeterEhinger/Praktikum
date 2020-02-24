package edu.unibw.se.gdp.praktikum07;

public class SeqByDLLOperation {
    public static void main(String[] args) {
        int[] i = {5, 3, 7, 4, 3, 4, 7, 5};
        SeqByDLL seq = createSeq(i);

        System.out.println(getString(seq, true));
        System.out.println(getString(seq, false));

        System.out.println(getString(insert(2, seq), false));
        System.out.println(getString(revert(insert(2, seq)), false));
    }

    public static SeqByDLL revert (SeqByDLL seq) {
        while (seq != null) {
            int tmp = seq.head.value;
            seq.head.value = seq.tail.value;
            seq.head.value = tmp;


        }

        return seq;
    }

    public static SeqByDLL insert(int value, SeqByDLL seq) {
        DLLInt neuesElement = new DLLInt(null, value, null);
        if (seq.head == null) {
            seq.head = neuesElement;
            seq.tail = neuesElement;
        } else if (value >= seq.head.value) {
            seq.head.prev = neuesElement;
            neuesElement.next = seq.head;
            seq.head = neuesElement; // seq.head = seq.head.prev;
        } else if (value <= seq.tail.value) {
            seq.tail.next = neuesElement;
            neuesElement.prev = seq.tail;
            seq.tail = neuesElement;
        } else {
            DLLInt current = seq.head;
            while (value < current.value) {
                current = current.next;
            }
            neuesElement.next = current;
            neuesElement.prev = current.prev;
            current.prev.next = neuesElement;
            current.prev = neuesElement;
        }

        return seq;
    }

    public static String getString(SeqByDLL seq, boolean reverted) {
        if (reverted) {
            String result = "(";
            DLLInt current = seq.tail;
            while (current != null) {
                result = result + current.value;

                if (current.prev != null)
                    result += ":";

                current = current.prev;
            }
            result += ") <-";
            return result;
        } else {
            String result = "-> (";
            DLLInt current = seq.head;
            while (current != null) {
                result = result + current.value;

                if (current.next != null)
                    result += ":";

                current = current.next;
            }
            result += ")";
            return result;
        }
    }



    public static SeqByDLL createSeq(int[] tmp) {
        SeqByDLL seq = new SeqByDLL(null, null);
        for (int value : tmp) {
            seq = insert(value, seq);
        }
        return seq;
    }
}
