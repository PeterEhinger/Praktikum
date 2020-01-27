package edu.unibw.se.gdp.praktikum03;

import edu.unibw.se.gdp.graphics.SimpleGraphicPanel;
import edu.unibw.se.gdp.praktikum02.Geometrie;

import java.awt.*;

public class Baum {
    public static void main(String[] args) {
        double ax = 250.0;
        double ay = 75.0;
        double bx = ax + 50.0;
        double by = ay;
        double s = 0.5;
        int hoehe = 3;

        System.out.println(maleBaum(hoehe, ax, ay, bx, by, s));

        //System.out.println(maleBaum(ax, ay, bx, by, s));      //Freiwillig b)

        //System.out.println(maleBaum(ax, ay, bx, by));         //Freiwillig c) & d)
    }

    public static int maleBaum(int hoehe, double ax, double ay,
                               double bx, double by, double s) {
        double cx = Geometrie.berechneCx(ay, bx, by);
        double cy = Geometrie.berechneCy(ax, bx, by);
        double dx = Geometrie.berechneDx(ax, ay, by);
        double dy = Geometrie.berechneDy(ax, ay, bx);
        double ex = Geometrie.berechneEx(dx, dy, cx, cy, s);
        double ey = Geometrie.berechneEy(dx, dy, cx, cy, s);
        Color color = (hoehe == 0) ? (SimpleGraphicPanel.getRandomColor()) : (Color.black);

        SimpleGraphicPanel.drawQuadrilateral(color, true, ax, ay, bx, by, cx, cy, dx, dy);
        return (hoehe > 0) ? (maleBaum(hoehe - 1, ex, ey, cx, cy, s) + 1 + maleBaum(hoehe - 1, dx, dy, ex, ey, s)) : 1;
    }

    public static int maleBaum(double ax, double ay, double bx, double by, double s) {
        //Abbruchbedingung (ax,ay) <-Abschand-> (bx,by) | kleiner als 2.0

        double cx = Geometrie.berechneCx(ay, bx, by);
        double cy = Geometrie.berechneCy(ax, bx, by);
        double dx = Geometrie.berechneDx(ax, ay, by);
        double dy = Geometrie.berechneDy(ax, ay, bx);
        double ex = Geometrie.berechneEx(dx, dy, cx, cy, s);
        double ey = Geometrie.berechneEy(dx, dy, cx, cy, s);
        double abstand = Math.sqrt((Math.pow((bx-ax),2) + Math.pow((by-ay), 2)));
        Color color = (abstand <= 2.0) ? (SimpleGraphicPanel.getRandomColor()) : (Color.black);

        SimpleGraphicPanel.drawQuadrilateral(color, true, ax, ay, bx, by, cx, cy, dx, dy);

        return (abstand <= 2.0) ? 1 : (maleBaum(ex, ey, cx, cy, s) + 1 + maleBaum(dx, dy, ex, ey, s));
    }

    public static int maleBaum(double ax, double ay, double bx, double by) {
        //Zufälliges s

        double cx = Geometrie.berechneCx(ay, bx, by);
        double cy = Geometrie.berechneCy(ax, bx, by);
        double dx = Geometrie.berechneDx(ax, ay, by);
        double dy = Geometrie.berechneDy(ax, ay, bx);
        double s = 0.2 + (Math.random() * 0.6);
        double ex = Geometrie.berechneEx(dx, dy, cx, cy, s);
        double ey = Geometrie.berechneEy(dx, dy, cx, cy, s);
        double abstand = Math.sqrt(Math.pow((ax-bx),2) + Math.pow((by-ay), 2));
        Color color = (abstand <= 2.0) ? (SimpleGraphicPanel.getRandomColor()) : (Color.black);

        SimpleGraphicPanel.drawQuadrilateral(color, true, ax, ay, bx, by, cx, cy, dx, dy);

        return (abstand <= 2.0) ? 1 : (maleBaum(ex, ey, cx, cy) + 1 + maleBaum(dx, dy, ex, ey));
    }
}
