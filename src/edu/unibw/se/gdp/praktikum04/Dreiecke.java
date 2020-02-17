package edu.unibw.se.gdp.praktikum04;

import edu.unibw.se.gdp.container.DoubleContainer;
import edu.unibw.se.gdp.graphics.SimpleGraphicPanel;

import java.awt.*;

public class Dreiecke {
    public static void main(String[] args) {

        maleDreieckeIterativ(10.0, 10.0, 150.0, 150.0);
        //maleDreieckeIterativ(170.0, 10.0, 150.0, 75.0);
        //maleDreieckRekursiv(330.0, 10.0, 150.0, 37.5);
        //maleDreieckRekursiv(490.0, 10.0, 150.0, 18.75);
        //maleDreieckRekursiv(650.0, 10.0, 150.0, 9.375);


        // maleDreieckeIterativ2(10000, 170.0, 10.0, 150);
    }

    public static void maleDreieckRekursiv(double ax, double ay, double s, double t) {
        double bx, by, cx, cy, rx, ry, qx, qy, px, py;
        bx = ax + s;
        by = ay;
        cx = (ax + bx) / 2.0;
        cy = ay + Math.sqrt(3.0) * (bx - ax) / 2.0;
        px = (ax + cx) / 2.0;
        py = (ay + cy) / 2.0;
        qx = (bx + cx) / 2.0;
        qy = (by + cy) / 2.0;
        rx = (ax + bx) / 2.0;
        ry = (ay + by) / 2.0;

        if (s <= t) {
            SimpleGraphicPanel.drawTriangle(Color.black, true, ax, ay, bx, by, cx, cy);
        } else {
            s = (s/2);
            maleDreieckRekursiv(ax, ay, s, t);
            maleDreieckRekursiv(rx, ry, s, t);
            maleDreieckRekursiv(px, py, s, t);
        }
    }

    public static void maleDreieckeIterativ(double ax, double ay, double s, double t) {
        double bx, by, cx, cy, rx, ry, qx, qy, px, py;

        while(s >= t) {


            while(s >= t) {

                while(s >= t) {

                }
            }
            s = (s/2);
        }

        while (s <= t) {
            ax = DoubleContainer.removeFirst("ax");
            ay = DoubleContainer.removeFirst("ay");
            bx = DoubleContainer.removeFirst("bx");
            by = DoubleContainer.removeFirst("by");
            cx = DoubleContainer.removeFirst("cx");
            cy = DoubleContainer.removeFirst("cy");
            px = DoubleContainer.removeFirst("py");
            py = DoubleContainer.removeFirst("py");
            qx = DoubleContainer.removeFirst("qy");
            qy = DoubleContainer.removeFirst("qy");
            rx = DoubleContainer.removeFirst("ry");
            ry = DoubleContainer.removeFirst("ry");

            SimpleGraphicPanel.drawTriangle(Color.black, true, ax, ay, bx, by, cx, cy);
            SimpleGraphicPanel.drawTriangle(Color.black, true, rx, ry, bx, by, cx, cy);
            SimpleGraphicPanel.drawTriangle(Color.black, true, px, py, bx, by, cx, cy);

            s = s*2;
        }



    }

    public static void maleDreieckeIterativ2(int wiederholungen, double ax, double ay, double s) {
        double bx = ax + s;
        double by = ay;
        double cx = (ax + bx) / 2.0;
        double cy = ay + Math.sqrt(3.0) * (bx - ax) / 2.0;

        double zx = ax;
        double zy = ay;

        for (int i = 0; i < wiederholungen; i++) {
            switch ((int) (Math.random() * 3)) {
                case 1:
                    zx = (ax + zx) / 2.0;
                    zy = (ay + zy) / 2.0;     // A
                    break;
                case 2:
                    zx = (bx + zx) / 2.0;
                    zy = (by + zy) / 2.0;    // B
                    break;
                default:
                    zx = (cx + zx) / 2.0;
                    zy = (cy + zy) / 2.0;    // C
            }
            SimpleGraphicPanel.drawCircle(Color.black, true, zx, zy, 1.0);
        }
    }
}
