package edu.unibw.se.gdp.praktikum03;

import edu.unibw.se.gdp.graphics.SimpleGraphicPanel;
import edu.unibw.se.gdp.praktikum02.Geometrie;

import java.awt.*;

class Quader {
    double cx, cy, dx, dy, ex, ey, abstand;
    Color color;

    public Quader(int hoehe, double ax, double ay, double bx, double by, double s, int i) {
        cx = Geometrie.berechneCx(ay, bx, by);
        cy = Geometrie.berechneCy(ax, bx, by);
        dx = Geometrie.berechneDx(ax, ay, by);
        dy = Geometrie.berechneDy(ax, ay, bx);
        ex = Geometrie.berechneEx(dx, dy, cx, cy, s);
        ey = Geometrie.berechneEy(dx, dy, cx, cy, s);
        abstand = Math.hypot((bx - ax), (by - ay));

        color = ((abstand <= 2.0 && i >= 2) | (hoehe == 0 && i == 1)) ? (SimpleGraphicPanel.getRandomColor()) : (Color.black);

        SimpleGraphicPanel.drawQuadrilateral(color, true, ax, ay, bx, by, cx, cy, dx, dy);
    }
}
