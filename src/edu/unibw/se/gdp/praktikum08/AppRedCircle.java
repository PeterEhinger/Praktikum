package edu.unibw.se.gdp.praktikum08;

import edu.unibw.se.gdp.graphics.GraphicsPanel;
import edu.unibw.se.gdp.graphics.Position;

import java.awt.*;

public class AppRedCircle {
    public static void main(String[] args) {
        GraphicsPanel panel = new GraphicsPanel("Circles",
                Position.X_MAX, Position.Y_MAX);
        Graphics graphics = panel.createGraphics();
        Circle circle = new Circle(175.5, 210.5, 75.5, Color.RED);
        circle.drawOn(graphics);
        panel.showGraphics();
    }
}
