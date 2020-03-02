package edu.unibw.se.gdp.graphics;

/**
 * @author Andrea Baumann
 */
public final class Position {

    public static final int X_MAX = 600;
    public static final int Y_MAX = 400;
    private double x = 0;
    private double y = 0;

    public Position(double x, double y) {
        setXIntern(x);
        setYIntern(y);
    }
    public double getX() {
        return x;
    }
    public double getY() {
        return y;
    }
    public void setX(double x) {
        setXIntern(x);
    }
    public void setY(double y) {
        setYIntern(y);
    }
    private void setXIntern(double x) {
        this.x = x % X_MAX;
        if (this.x < 0) {
            this.x += X_MAX;
        }
    }
    private void setYIntern(double y) {
        this.y = y % Y_MAX;
        if (this.y < 0) {
            this.y += Y_MAX;
        }
    }
}
