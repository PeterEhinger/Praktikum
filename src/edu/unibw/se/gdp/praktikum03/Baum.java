package edu.unibw.se.gdp.praktikum03;

import edu.unibw.se.gdp.graphics.SimpleGraphicPanel;
import edu.unibw.se.gdp.praktikum02.Geometrie;

import java.awt.*;

public class Baum {
    public static void main(String[] args) {
        double ax = 125.0, ay = 75.0, bx = ax + 50.0, by = ay;
        double s = 0.5;
        int hoehe = 5;

        System.out.println(maleBaum(hoehe, ax, ay, bx, by, s));
        System.out.println(maleBaum(ax+300, ay, bx+300, by, s));      //Freiwillig b)
        System.out.println(maleBaum(ax+650, ay, bx+650, by));         //Freiwillig c) & d)
    }

    public static int maleBaum(int hoehe, double ax, double ay,
                               double bx, double by, double s) {
        Quader quader = new Quader(hoehe, ax, ay, bx, by, s, 1);
        return (hoehe > 0) ? (maleBaum(hoehe - 1, quader.ex, quader.ey, quader.cx, quader.cy, s) + 1
                + maleBaum(hoehe - 1, quader.dx, quader.dy, quader.ex, quader.ey, s)) : 1;
    }

    public static int maleBaum(double ax, double ay, double bx, double by, double s) {
        Quader quader = new Quader(-1, ax, ay, bx, by, s, 2);
        return (quader.abstand <= 2.0) ? 1 : (maleBaum(quader.ex, quader.ey, quader.cx, quader.cy, s) + 1
                + maleBaum(quader.dx, quader.dy, quader.ex, quader.ey, s));
    }

    public static int maleBaum(double ax, double ay, double bx, double by) {
        double s = 0.2 + (Math.random() * 0.6);
        Quader quader = new Quader(-1, ax, ay, bx, by, s, 2);
        return (quader.abstand <= 2.0) ? 1 : (maleBaum(quader.ex, quader.ey, quader.cx, quader.cy) + 1
                + maleBaum(quader.dx, quader.dy, quader.ex, quader.ey));
    }
}
