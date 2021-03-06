package edu.ninjaapps.recognizer;

import javax.swing.*;
import java.awt.*;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Rectangle2D;

@SuppressWarnings("serial")
public class ShapePreview extends JLabel {
    public static final int DEFAULT_WIDTH = 180;
    public static final int DEFAULT_HEIGHT = 150;
    private Shape form;

    public ShapePreview(ShapePreview.Shape aForm) {
        super("", SwingConstants.CENTER);
        setPreferredSize(new Dimension(DEFAULT_WIDTH, DEFAULT_HEIGHT));
        setBorder(BorderFactory.createEtchedBorder());
        form = aForm;
    }

    public void loadImage(String name) {
        ImageIcon icon = new ImageIcon(name);
        if (icon.getIconWidth() > getPreferredSize().width)
            icon = new ImageIcon(icon.getImage().getScaledInstance(
                    (getPreferredSize().width == 0) ? (-1) : getPreferredSize().width, (-1),
                    Image.SCALE_DEFAULT));
        if (icon != null) setIcon(icon);
        repaint();
    }

    public void setForm(Shape aShape) {
        form = aShape;
        repaint();
    }

    public void paintComponent(Graphics g) {
        Graphics2D g2 = (Graphics2D) g;
        double side = 70;
        double leftX = getWidth() / 2 - side / 2;
        double topY = getHeight() / 2 - side / 2;
        Rectangle2D rectangle = new Rectangle2D.Double(leftX, topY, side, side);
        switch (form) {
            case BOX:
                g2.setPaint(Color.BLACK);
                g2.fill(rectangle);
                g2.setPaint(Color.RED);
                g2.setStroke(new BasicStroke(3.5F));
                g2.draw(rectangle);
                break;
            case CIRCLE:
                Ellipse2D ellipse = new Ellipse2D.Double();
                ellipse.setFrame(rectangle);
                g2.setPaint(Color.BLACK);
                g2.fill(ellipse);
                g2.setPaint(Color.RED);
                g2.setStroke(new BasicStroke(3.5F));
                g2.draw(ellipse);
                break;
            case TRIANGLE:
                Point p1 = new Point(getWidth() / 2, (int) (getHeight() / 2 - (2 * side / 3)));
                Point p2 = new Point((int) (getWidth() / 2 + (side / 2)),
                        (int) (getHeight() / 2 + (side / 3)));
                Point p3 = new Point((int) (getWidth() / 2 - (side / 2)),
                        (int) (getHeight() / 2 + (side / 3)));
                Polygon triangle = new Polygon(new int[]{p1.x, p2.x, p3.x},
                        new int[]{p1.y, p2.y, p3.y}, 3);
                g2.setPaint(Color.BLACK);
                g2.fillPolygon(triangle);
                g2.setPaint(Color.RED);
                g2.setStroke(new BasicStroke(3.5F));
                g2.drawPolygon(triangle);
        }
    }
    public enum Shape {
        BOX, CIRCLE, TRIANGLE
    }
}