package edu.unibw.se.gdp.praktikum08;

import edu.unibw.se.gdp.graphics.GraphicsPanel;
import edu.unibw.se.gdp.graphics.Position;

import java.awt.*;

public class Balloon extends Circle {
    private double moveX = 5.0;
    private double moveY = 5.0;

    public Balloon(double x, double y, Color color, double radius) {
        super(x, y, radius, color);
    }

    public void move() {
        this.radius = radius + 0.5;

        center.setX(center.getX() + moveX);
        center.setY(center.getY() + moveY);

        if (center.getX() - radius + moveX < 0) {
            moveX = Math.abs(moveX);
            radius = 1.0;
        }
        else if (center.getY() - radius + moveY < 0) {
            moveY = Math.abs(moveY);
            radius = 1.0;
        }
        else if (center.getY()+radius > Position.Y_MAX) {
            moveY = (-Math.abs(moveY));
            radius = 1.0;
        }
        else if (center.getX()+radius > Position.X_MAX) {
            moveX = (-Math.abs(moveX));
            radius = 1.0;
        }
    }
}
