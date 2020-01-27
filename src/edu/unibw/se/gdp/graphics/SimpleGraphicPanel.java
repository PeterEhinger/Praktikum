package edu.unibw.se.gdp.graphics;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Frame;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Panel;
import java.awt.RenderingHints;
import java.awt.Shape;
import java.awt.event.MouseWheelEvent;
import java.awt.event.MouseWheelListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.geom.AffineTransform;
import java.awt.geom.Arc2D;
import java.awt.geom.Path2D;
import java.awt.image.BufferedImage;
import java.util.ArrayList;

/**
 * The SimpleGraphicPanel class can be used to draw simple two-dimensional geometric shapes, like
 * triangles, quadrilaterals, circles and lines. The shapes can have different colors.
 * <p>
 * Therefor the Color class must be imported:  <code>import java.awt.Color; </code>
 * <p>
 * If a shape has been successfully drawn (too small shapes are not shown), the graphic window opens.
 * The window has a white background. The width is 600 pixels and the height is 400 pixels.
 * The Cartesian coordinate systems origin is in the lower left corner.
 * The x-axis is to the right and the y-axis is oriented upwards. The units are pixels.
 */
public class SimpleGraphicPanel {
    private static final int WINDOW_WIDTH = 600;
    private static final int WINDOW_HEIGHT = 400;
    private static final Color WINDOW_BACKGROUND_COLOR = Color.WHITE;

    private static final double MIN_SIZE_OF_SHAPE = 1.0;

    /**
     * Draws a quadrilateral. To do this, the x and y values of the four corners must be
     * specified either clockwise or counterclockwise. You can also specify which color the quadrilateral should have
     * and whether it should be filled.
     * <p>
     * <code>SimpleGraphicPanel.drawQuadrilateral (Color.RED, true, 0, 0, 50, 0, 50, 50, 0, 50)</code> generates e.g. a red,
     * filled square with edge length 50 in the lower left corner of the window.
     *
     * @param color the color of the quadrilateral.
     * @param fill  if true, then the shape is filled, otherwise not.
     * @param x1    x-value of the first vertex.
     * @param y1    y-value of the first vertex.
     * @param x2    x-value of the second vertex.
     * @param y2    y-value of the second vertex.
     * @param x3    x-value of the third vertex.
     * @param y3    y-value of the third vertex.
     * @param x4    x-value of the fourth vertex.
     * @param y4    y-value of the fourth vertex.
     * @return true, if the shape is drawn, otherwise - if to small - false
     */
    static public boolean drawQuadrilateral(Color color, boolean fill,
                                            double x1, double y1, double x2, double y2,
                                            double x3, double y3, double x4, double y4) {

        if (color == null
                || !Double.isFinite(x1) || !Double.isFinite(y1)
                || !Double.isFinite(x2) || !Double.isFinite(y2)
                || !Double.isFinite(x3) || !Double.isFinite(y3)
                || !Double.isFinite(x4) || !Double.isFinite(y4)) {
            return false;
        }

        double area = Math.abs((y1 + y2) * (x1 - x2)
                + (y2 + y3) * (x2 - x3)
                + (y3 + y4) * (x3 - x4)
                + (y4 + y1) * (x4 - x1)) / 2.0;
        if (!Double.isFinite(area) || area < MIN_SIZE_OF_SHAPE)
            return false;

        Path2D path = new Path2D.Double();
        path.moveTo(x1, y1);
        path.lineTo(x2, y2);
        path.lineTo(x3, y3);
        path.lineTo(x4, y4);
        path.lineTo(x1, y1);
        SHAPES.add(path);
        COLORS.add(color);
        FILLS.add(fill);

        repaint();
        return true;
    }

    /**
     * Draws a circle. The bottom left corner (x, y) of the surrounding square and
     * the circles diameter are specified. You can also specify which color the circle should have
     * and whether it should be filled.
     * <p>
     * <code>SimpleGraphicPanel.drawCircle(Color.ORANGE, false, 100, 50, 50)</code> generates e.g. an orange,
     * not filled circle.
     *
     * @param color the color of the circle.
     * @param fill  if true, then the shape is filled, otherwise not.
     * @param x     x-value of the bottom left corner of the surrounding square.
     * @param y     y-value of the bottom left corner of the surrounding square.
     * @param dim   the circles diameter.
     * @return true, if the shape is drawn, otherwise - if to small - false
     */
    public static boolean drawCircle(Color color, boolean fill,
                                     double x, double y, double dim) {

        if (color == null
                || !Double.isFinite(x) || !Double.isFinite(y)
                || !Double.isFinite(dim)) {
            return false;
        }

        if (dim < MIN_SIZE_OF_SHAPE) {
            return false;
        }

        SHAPES.add(new Arc2D.Double(x, y, dim, dim, 0, 360,
                Arc2D.CHORD));
        COLORS.add(color);
        FILLS.add(fill);

        repaint();
        return true;
    }

    /**
     * Draws a triangle. To do this, the x and y values of the three corners must be
     * specified either clockwise or counterclockwise. You can also specify which color the triangle should have
     * and whether it should be filled.
     * <p>
     * <code>SimpleGraphicPanel.drawTriangle (Color.GREEN, true, 200, 50, 300, 50, 250, 100)</code> generates e.g. a green
     * filled triangle.
     *
     * @param color the color of the triangle.
     * @param fill  if true, then the shape is filled, otherwise not.
     * @param x1    x-value of the first vertex.
     * @param y1    y-value of the first vertex.
     * @param x2    x-value of the second vertex.
     * @param y2    y-value of the second vertex.
     * @param x3    x-value of the third vertex.
     * @param y3    y-value of the third vertex.
     * @return true, if the shape is drawn, otherwise - if to small - false
     */
    public static boolean drawTriangle(Color color, boolean fill,
                                       double x1, double y1, double x2, double y2,
                                       double x3, double y3) {

        if (color == null
                || !Double.isFinite(x1) || !Double.isFinite(y1)
                || !Double.isFinite(x2) || !Double.isFinite(y2)
                || !Double.isFinite(x3) || !Double.isFinite(y3)) {
            return false;
        }

        double area = Math.abs((y1 + y2) * (x1 - x2)
                + (y2 + y3) * (x2 - x3)
                + (y3 + y1) * (x3 - x1)) / 2.0;
        if (!Double.isFinite(area) || area < MIN_SIZE_OF_SHAPE)
            return false;

        Path2D path = new Path2D.Double();
        path.moveTo(x1, y1);
        path.lineTo(x2, y2);
        path.lineTo(x3, y3);
        path.lineTo(x1, y1);
        SHAPES.add(path);
        COLORS.add(color);
        FILLS.add(fill);

        repaint();
        return true;
    }

    /**
     * Draws a line. To do this, the x and y values of the two endpoints must be
     * specified. You can also specify which color the line should have.
     * <p>
     * @param color the color of the line.
     * @param x1    x-value of the first point.
     * @param y1    y-value of the first point.
     * @param x2    x-value of the second point.
     * @param y2    y-value of the second point.
     * @return true, if the shape is drawn, otherwise - if to short - false
     */
    public static boolean drawLine(Color color,
                                   double x1, double y1, double x2, double y2) {

        if (color == null
                || !Double.isFinite(x1) || !Double.isFinite(y1)
                || !Double.isFinite(x2) || !Double.isFinite(y2)) {
            return false;
        }

        if (Math.hypot(x2 - x1, y2 - y1) < MIN_SIZE_OF_SHAPE) {
            return false;
        }

        Path2D path = new Path2D.Double();
        path.moveTo(x1, y1);
        path.lineTo(x2, y2);
        path.lineTo(x1, y1);
        SHAPES.add(path);
        COLORS.add(color);
        FILLS.add(true);

        repaint();
        return true;
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

    /**
     * Returns a bright random color.
     *
     * @return the bright random color.
     */
    public static Color getRandomBrightColor() {
        return Color.getHSBColor((float) Math.random(), 1.0f, 1.0f);
    }

    private static final ArrayList<Shape> SHAPES = new ArrayList<>();
    private static final ArrayList<Color> COLORS = new ArrayList<>();
    private static final ArrayList<Boolean> FILLS = new ArrayList<>();
    private static InternGraphicPanel internPanel = null;

    private SimpleGraphicPanel() {
        super();
    }

    private static void repaint() {
        if (internPanel == null) {
            internPanel = new InternGraphicPanel();
            internPanel.show(WINDOW_WIDTH, WINDOW_HEIGHT, WINDOW_BACKGROUND_COLOR);
        }

        internPanel.repaint();
    }

    private static class InternGraphicPanel extends Panel implements
            MouseWheelListener {

        private Frame frame = null;
        private int width = 0;
        private int height = 0;
        private double zoom = 1.0;
        private Color background = Color.white;

        public void show(int width, int height, Color background) {
            this.width = width;
            this.height = height;
            this.background = background;
            if (frame == null) {
                frame = new Frame();
                frame.setTitle("Graphic Panel");
                frame.addWindowListener(new InternWindowAdapter());
                frame.add(this);
                frame.pack();
                frame.setSize(width, height);
                frame.addMouseWheelListener(this);
                frame.setVisible(true);
            } else {
                if (frame.getSize().width != this.width
                        || frame.getSize().height != this.height) {
                    frame.setSize(width, height);
                }
            }
        }

        @Override
        public void paint(Graphics graphics) {

            Dimension vDimension = getSize();
            this.width = vDimension.width;
            this.height = vDimension.height;
            BufferedImage bufferedImage = (BufferedImage) createImage(
                    vDimension.width,
                    vDimension.height);

            Graphics2D graphics2d = bufferedImage.createGraphics();
            graphics2d.setBackground(background);
            graphics2d.clearRect(0, 0, vDimension.width,
                    vDimension.height);
            graphics2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING,
                    RenderingHints.VALUE_ANTIALIAS_ON);
            graphics2d.setRenderingHint(RenderingHints.KEY_RENDERING,
                    RenderingHints.VALUE_RENDER_QUALITY);

            graphics2d.setTransform(
                    new AffineTransform(zoom, 0, 0, -zoom, 0.0, height));
            for (int i = 0; i < SHAPES.size(); i++) {
                graphics2d.setColor(COLORS.get(i));
                graphics2d.draw(SHAPES.get(i));
                if (FILLS.get(i)) {
                    graphics2d.fill(SHAPES.get(i));
                }
            }
            graphics2d.dispose();

            graphics.drawImage(bufferedImage, 0, 0, vDimension.width,
                    vDimension.height,
                    this);
        }

        @Override
        public void mouseWheelMoved(MouseWheelEvent e) {

            if (e.getWheelRotation() > 0) {
                zoom = zoom * 1.1;
            }
            if (e.getWheelRotation() < 0) {
                zoom = zoom * 0.9;
            }
            if (zoom < 0.001) {
                zoom = 0.001;
            }
            if (zoom > 5.0) {
                zoom = 5.0;
            }
            repaint();
        }
    }

    private static class InternWindowAdapter extends WindowAdapter {

        @Override
        public void windowClosing(WindowEvent e) {
            e.getWindow().dispose();
            System.exit(0);
        }
    }
}
