package edu.unibw.se.gdp.praktikum08;

import edu.unibw.se.gdp.graphics.GraphicsPanel;
import edu.unibw.se.gdp.graphics.Position;

import java.awt.*;

public class AppBilliardBall {
    public static void main(String[] args) {
        GraphicsPanel panel = new GraphicsPanel("Circles",
                Position.X_MAX, Position.Y_MAX);
        Graphics graphics = panel.createGraphics();
        BilliardBall ball = new BilliardBall(175.5, 210.5, 25.0, Color.ORANGE, 0.5, -0.3);
        while (true) {
            graphics.clearRect(0, 0, Position.X_MAX, Position.Y_MAX);
            ball.drawOn(graphics);
            panel.showGraphics();
            ball.move();
            GraphicsPanel.sleep(5); // pause the animation 5 milliseconds
        }
    }
}
