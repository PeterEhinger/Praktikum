package edu.unibw.se.gdp.graphics;

import java.awt.Canvas;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Frame;
import java.awt.Graphics;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.image.BufferStrategy;

/**
 * The <code>GraphicsPanel</code> class can be used to create an instance of class {@link java.awt.Graphics}.
 * {@link java.awt.Graphics} itself has a lot of methods for drawing simple two-dimensional geometric shapes.
 * The class can be used as follows: <br><br>
 * <code>
 * GraphicsPanel panel = new GraphicsPanel("My Graphics Panel", 600, 400); <br>
 * Graphics g = panel.createGraphics(); <br>
 * g.setColor(Color.red); <br>
 * g.drawOval(250, 150, 100, 100); <br>
 * g.fillRect(50, 50, 100, 20); <br>
 * panel.showGraphics();
 * </code>
 *
 * @see java.awt.Graphics
 * @author Andrea Baumann
 */
public class GraphicsPanel {

    private final String frameTitle;
    private final int frameWidth;
    private final int frameHeight;
    private boolean frameIsOpen = false;

    private BufferStrategy bufferStrategy = null;
    private Graphics graphics = null;

    /**
     * Creates a <code>GraphicPanel</code>.
     *
     * @param title title of the frame.
     * @param width width of the frame.
     * @param height height of the frame.
     */
    public GraphicsPanel(String title, int width, int height) {
        super();
        frameTitle = title;
        frameWidth = width;
        frameHeight = height;
    }

    /**
     * Shows all painted elements without deleting anything.
     */
    public void showGraphics() {
        initFrame();
        if (bufferStrategy.contentsLost())
            bufferStrategy.contentsRestored();
        if (!bufferStrategy.contentsLost()) {
            bufferStrategy.show();
        }
    }

    /**
     * Creates a {@link java.awt.Graphics} for drawing.
     *
     * @return the {@link java.awt.Graphics}.
     */
    public Graphics createGraphics() {
        initFrame();
        if (graphics != null) {
            graphics.dispose();
        }
        graphics = bufferStrategy.getDrawGraphics();
        return graphics;
    }

    /**
     * Interrupts the current execution for the specified milliseconds.
     *
     * @param duration time in milliseconds.
     */
    public static void sleep(long duration) {
        try {
            Thread.sleep(duration);
        } catch (InterruptedException ex) {
        }
    }

    /**
     * Returns a random color.
     *
     * @return the random color.
     */
    public static Color getRandomColor() {
        return new Color((float) Math.random(),
                (float) Math.random(),
                (float) Math.random());
    }

    private synchronized void initFrame() {
        if (!frameIsOpen) {
            Canvas canvas = new InnerCanvas();
            canvas.setPreferredSize(new Dimension(frameWidth, frameHeight));

            Frame frame = new Frame();
            frame.setTitle((frameTitle == null) ? "Graphic Frame" : frameTitle);
            frame.addWindowListener(new InternWindowAdapter());

            frame.add(canvas);
            frame.pack();
            frame.setResizable(false);
            frame.setVisible(true);

            canvas.createBufferStrategy(2);
            bufferStrategy = canvas.getBufferStrategy();

            frameIsOpen = true;
        }
    }

    private static class InternWindowAdapter extends WindowAdapter {

        @Override
        public void windowClosing(WindowEvent e) {
            System.exit(0);
        }
    }

    private class InnerCanvas extends Canvas {

        @Override
        public void paint(Graphics g) {
            super.paint(g);
            showGraphics();
        }
    }
}
