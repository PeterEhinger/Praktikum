package edu.unibw.se.gdp.praktikum08;

import edu.unibw.se.gdp.graphics.Position;

import java.awt.*;

public abstract class Circle{
    final protected Position center;
    private Color color;
    protected double radius;

    public Circle(double x, double y, double sideHalf, Color color) {
        this.center = new Position(x, y);
        this.radius = sideHalf;
        this.color = color;
    }

    public void drawOn(Graphics graphics) {
        graphics.setColor(color);
        graphics.fillOval((int)(center.getX() - radius), (int)(center.getY() - radius),
                (int)(2.0 * radius), (int)(2.0 * radius));
    }

    public abstract void move();
}
