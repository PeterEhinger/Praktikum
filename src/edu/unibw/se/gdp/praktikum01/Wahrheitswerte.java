package edu.unibw.se.gdp.praktikum01;

public class Wahrheitswerte {
    public static void main(String[] args) {
        //normal boolean values
        boolean a = true;
        boolean b = false;

        //Operations:
        boolean c = (a == b);   //equality
        boolean d = (a != c);   //inequality
        boolean e = !a;         //negation
        boolean f = (a && b);   //conjunction
        boolean g = (a & b);
        f = (f && (b && a));

        boolean h = (a || b);      //disjunction
        boolean i = (a | b);
        h = ((a || b) || (b || a));


        //more
        boolean j = (c != a);
        boolean k = (d == c);
        boolean l = (b && c);
        boolean m = (!k != f);
        boolean n = (f == !a);
    }
}
