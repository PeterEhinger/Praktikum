package edu.unibw.se.gdp.praktikum08;

import edu.unibw.se.gdp.graphics.Position;

import java.awt.*;

public class BilliardBall extends Circle {
    private double moveX;
    private double moveY;

    public BilliardBall(double x, double y, double sideHalf, Color color, double moveX, double moveY) {
        super(x, y, sideHalf, color);

        this.moveX = moveX;
        this.moveY = moveY;
    }

    public BilliardBall(double x, double y, double radius, Color color) {
        super(x, y, radius, color);

        new BilliardBall(x, y, radius, color, moveX, moveY);
    }

    public void move() {
        center.setX(center.getX() + moveX);
        center.setY(center.getY() + moveY);

        if (center.getX() - radius + moveX < 0)
            moveX = Math.abs(moveX);
        else if (center.getY() - radius + moveY < 0)
            moveY = Math.abs(moveY);
        else if (center.getY()+radius > Position.Y_MAX)
            moveY = (-Math.abs(moveY));
        else if (center.getX()+radius > Position.X_MAX)
            moveX = (-Math.abs(moveX));

    }
}
