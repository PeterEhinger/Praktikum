package edu.unibw.se.gdp.praktikum06;

public class KomplexeZahlOperationen {
    public static void main(String[] args) {
        KomplexeZahl k1 = new KomplexeZahl(1.1, -2.5);
        KomplexeZahl k2 = new KomplexeZahl(2, 1);
        print(new KomplexeZahl(1.1, -2.5));
        print(add(k1,k2));
        print(sub(k1,k2));
        print(mult(k1,k2));
        print(div(k1,k2));
        System.out.println(abs(k2));
        System.out.println(phi(k2));

        //-------------------------------//

        print(new KomplexeZahl(0.5, 45.0, false), true);
        print(new KomplexeZahl(1.0, 45.0, false), false);
        print(new KomplexeZahl(0.5, -0.5), false);
    }

    public static void print(KomplexeZahl c) {
        System.out.println(c.realteil + ((c.imaginaerteil < 0) ? "-" : "+") + "j" + Math.abs(c.imaginaerteil));
    }

    public static void print(KomplexeZahl c, boolean imBogenmass) {
        if (c.betrag == 0 && c.phi == 0) {
            c.betrag = abs(c);
            c.phi = phi(c);

            if (imBogenmass == false)
                c.phi = Math.toDegrees(c.phi);
        }


        if (imBogenmass == true) {
            if (c.istBogenmass == false) {
                c.phi = phi(c);
                c.istBogenmass = true;
            }
            System.out.println(((c.betrag == 1.0) ? "" : c.betrag) + "e^j(" + c.phi + ") (Bogenmass)");
        } else if (imBogenmass == false) {
            System.out.println(((c.betrag == 1.0) ? "" : c.betrag) + "e^j(" + c.phi + ") (Gradmass)");
        }
    }

    public static KomplexeZahl add(KomplexeZahl c1, KomplexeZahl c2) {
        double re = c1.realteil + c2.realteil;
        double im = c1.imaginaerteil + c2.imaginaerteil;
        return new KomplexeZahl(re, im);
    }

    public static KomplexeZahl sub(KomplexeZahl c1, KomplexeZahl c2) {
        double re = c1.realteil - c2.realteil;
        double im = c1.imaginaerteil - c2.imaginaerteil;
        return new KomplexeZahl(re, im);
    }

    public static KomplexeZahl mult(KomplexeZahl c1, KomplexeZahl c2) {
        double re = (c1.realteil * c2.realteil) - (c2.imaginaerteil * c1.imaginaerteil);
        double im = (c1.realteil * c2.imaginaerteil) + (c1.imaginaerteil * c2.realteil);
        return new KomplexeZahl(re, im);
    }

    public static KomplexeZahl div(KomplexeZahl c1, KomplexeZahl c2) {
        double re = ((c1.realteil * c2.realteil) + (c2.imaginaerteil * c1.imaginaerteil)) / (Math.pow(c2.realteil, 2) + Math.pow(c2.imaginaerteil, 2));
        double im = ((c1.imaginaerteil * c2.realteil) - (c1.realteil * c2.imaginaerteil)) / (Math.pow(c2.realteil, 2) + Math.pow(c2.imaginaerteil, 2));
        return new KomplexeZahl(re, im);
    }

    public static double abs(KomplexeZahl c) {
        return Math.hypot(c.realteil, c.imaginaerteil);
    }

    public static double phi(KomplexeZahl c) {
        double a = c.realteil;
        double b = c.imaginaerteil;
        if (a>0)
            return Math.atan2(b, a);
        else if (a<0 && b>=0)
            return Math.atan2(b, a) + Math.PI;
        else if (a<0 && b<0)
            return Math.atan2(b, a) - Math.PI;
        else if (a==0 && b>0)
            return (Math.PI/2);
        else if (a==0 && b<0)
            return -(Math.PI/2);
        else
            return 0;
    }
}
