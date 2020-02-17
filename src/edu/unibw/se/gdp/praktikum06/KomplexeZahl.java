package edu.unibw.se.gdp.praktikum06;

public class KomplexeZahl {
    double realteil;
    double imaginaerteil;
    double betrag;
    double phi;
    boolean istBogenmass;

    public KomplexeZahl(double realteil, double imaginaerteil) {
        this.realteil = realteil;
        this.imaginaerteil = imaginaerteil;
    }

    public KomplexeZahl(double betrag, double phi, boolean istBogenmass) {
        this.betrag = betrag;
        this.phi = phi;
        this.istBogenmass = istBogenmass;
        if (istBogenmass == true) {
            this.realteil = betrag * Math.cos(phi);
            this.imaginaerteil = betrag * Math.sin(phi);
        } else if (istBogenmass == false) {
            this.realteil = betrag * Math.cos(Math.toRadians(phi));
            this.imaginaerteil = betrag * Math.sin(Math.toRadians(phi));
        }
    }
}
