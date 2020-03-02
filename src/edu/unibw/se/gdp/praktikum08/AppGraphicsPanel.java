package edu.unibw.se.gdp.praktikum08;

import edu.unibw.se.gdp.graphics.GraphicsPanel;
import edu.unibw.se.gdp.graphics.Position;

import java.awt.*;

public class AppGraphicsPanel {
    public static void main(String[] args) {
        GraphicsPanel panel = new GraphicsPanel("Circles", Position.X_MAX, Position.Y_MAX);
        Graphics g = panel.createGraphics();
        g.setColor(Color.RED);
        g.drawOval(250, 150, 100, 100);
        g.fillRect(50, 50, 100, 20);
        panel.showGraphics();
    }
}
