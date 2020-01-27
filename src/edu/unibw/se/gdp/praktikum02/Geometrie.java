package edu.unibw.se.gdp.praktikum02;

public class Geometrie {
    public static void main(String[] args) {

    }

    public static double berechneCx(double ay, double bx, double by) {
        double tmp = (bx + ay) - by;
        return tmp;
    }

    public static double berechneCy(double ax, double bx, double by) {
        double tmp = (by + bx) - ax;
        return tmp;
    }

    public static double berechneDx(double ax, double ay, double by) {
        double tmp = (ax + ay) - by;
        return tmp;
    }

    public static double berechneDy(double ax, double ay, double bx) {
        double tmp = (ay + bx) - ax;
        return tmp;
    }

    public static double berechneEx(double dx, double dy, double cx, double cy, double s) {
        double tmp = Math.pow((s * (1 - s)), (0.5));
        double tmp1 = (1 - s) * dx;
        double tmp2 = s * cx;
        double tmp3 = tmp * (dy - cy);
        return tmp1 + tmp2 + tmp3;
    }

    public static double berechneEy(double dx, double dy, double cx, double cy, double s) {
        double tmp = (1 - s) * dy;
        double tmp1 = s * cy;
        double tmp2 = Math.pow((s * (1 - s)), (0.5));
        double tmp3 = tmp2 * (cx - dx);
        return tmp + tmp1 + tmp3;
    }
}
