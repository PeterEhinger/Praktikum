package edu.unibw.se.gdp.praktikum08;

import edu.unibw.se.gdp.graphics.GraphicsPanel;
import edu.unibw.se.gdp.graphics.Position;

import java.awt.*;

public class AppRandomCircles {
    public static void main(String[] args) {
        int variants = 2;
        int count = 5 * variants;
        GraphicsPanel panel = new GraphicsPanel("Circles",
                Position.X_MAX, Position.Y_MAX);
        Graphics graphics = panel.createGraphics();
        Circle[] circles = new Circle[count];
        for (int i = 0; i < circles.length; i++) {
            double x = Math.random() * Position.X_MAX;
            double y = Math.random() * Position.Y_MAX;
            switch (i % variants) {
                case 0:
                    circles[i] = new BilliardBall(x, y, 25.0, Color.RED, 1.0, 1.0);
                    break;
                case 1:
                    circles[i] = new Balloon(x, y, Color.BLUE, 1.0);
                    break;
                while (true) {
                    graphics.clearRect(0, 0, Position.X_MAX, Position.Y_MAX);
                    for (Circle circle : circles) {
                        circle.drawOn(graphics);
                    }
                    panel.showGraphics();
                    for (Circle circle : circles) {
                        circle.move();
                    }
                    GraphicsPanel.sleep(5); // pause the animation 5 milliseconds
                }
            }
        }
    }
}
