package edu.unibw.se.gdp.praktikum08;

import edu.unibw.se.gdp.graphics.GraphicsPanel;
import edu.unibw.se.gdp.graphics.Position;

import java.awt.*;

public class AppBalloon {
    public static void main(String[] args) {
        GraphicsPanel panel = new GraphicsPanel("Circles",
                Position.X_MAX, Position.Y_MAX);
        Graphics graphics = panel.createGraphics();
        Balloon balloon = new Balloon(150.0, 210.5, Color.CYAN, 0.5);
        while (true) {
            graphics.clearRect(0, 0, Position.X_MAX, Position.Y_MAX);
            balloon.drawOn(graphics);
            panel.showGraphics();
            balloon.move();
            balloon.move();
            GraphicsPanel.sleep(5); // pause the animation 5 millisecond
        }
    }
}
