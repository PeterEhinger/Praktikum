package edu.unibw.se.gdp.praktikum02;

import edu.unibw.se.gdp.graphics.SimpleGraphicPanel;

import java.awt.Color;
import java.util.Random;

public class House {
    public static void main(String[] args) {
        //blueQuader();
        //greenTriangle();
        randomHouse();
    }


    public static void blueQuader() {
        double ax = 100.0;
        double ay = 100.0;
        double bx = 150.0;
        double by = 70.0;

        double cx = Geometrie.berechneCx(ay, bx, by);
        double cy = Geometrie.berechneCy(ax, bx, by);
        double dx = Geometrie.berechneDx(ax, ay, by);
        double dy = Geometrie.berechneDy(ax, ay, bx);

        Color color = Color.blue;

        SimpleGraphicPanel.drawQuadrilateral(color, true, ax, ay, bx, by, cx, cy, dx, dy);
    }

    public static void greenTriangle() {
        double ax = 200.0;
        double ay = 100.0;
        double bx = 270.0;
        double by = 110.0;
        double s = 0.3;
        double ex = Geometrie.berechneEx(ax, ay, bx, by, s);
        double ey = Geometrie.berechneEy(ax, ay, bx, by, s);

        Color color = Color.green;

        SimpleGraphicPanel.drawTriangle(color, true, bx, by, ax, ay, ex, ey);
    }

    public static void randomHouse() {

        for (int i = 1; i < 100; i++) {
            double ax = i * 15;
            double ay = 100.0 + 50.0 * Math.sin(Math.toRadians(ax));

            double bx = i * 15 + 10;
            double by = 100.0 + 50.0 * Math.sin(Math.toRadians(bx));


            double s = (new Random()).nextDouble();
            /*
            double min = 40;
            double max = 50;

            double ax = min + (max - min) * (new Random()).nextDouble();
            ax = (Math.sin(ax)+1*20) + i * 50;
            double ay = min + (max - min) * (new Random()).nextDouble();
            ay = (Math.sin(ay)+1*20) + ax;
            double bx = min + (max - min) * (new Random()).nextDouble();
            bx = (Math.sin(bx)+1*20) + i * 50;
            double by = min + (max - min) * (new Random()).nextDouble();
            by = (Math.sin(by)+1*20) + ay;
            double s = (new Random()).nextDouble();
            */

            maleHausBunt(ax, ay, bx, by, s);
        }
        //maleHausBunt(ax, ay, bx, by, s);

    }

    public static boolean maleHausBunt(double ax, double ay, double bx, double by, double s) {
        if ((ax < 0) || (ay < 0) || (bx < 0) ||
                (by < 0) || (s < 0) || (s > 1.0)) {
            return false;
        } else {
            double cx = Geometrie.berechneCx(ay, bx, by);
            double cy = Geometrie.berechneCy(ax, bx, by);
            double dx = Geometrie.berechneDx(ax, ay, by);
            double dy = Geometrie.berechneDy(ax, ay, bx);
            double ex = Geometrie.berechneEx(dx, dy, cx, cy, s);
            double ey = Geometrie.berechneEy(dx, dy, cx, cy, s);

            Color color1 = SimpleGraphicPanel.getRandomColor();
            Color color2 = SimpleGraphicPanel.getRandomColor();
            return (SimpleGraphicPanel.drawTriangle(color1, true, dx, dy, cx, cy, ex, ey) |
                    SimpleGraphicPanel.drawQuadrilateral(color2, true, ax, ay, bx, by, cx, cy, dx, dy));
        }
    }
}
