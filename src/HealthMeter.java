//Authors: Laith, Aaron, Ethan
import java.awt.Graphics2D;
import java.awt.geom.Rectangle2D;

import java.awt.Color;

import edu.macalester.graphics.CanvasWindow;
import edu.macalester.graphics.GraphicsObject;
import edu.macalester.graphics.Rectangle;

public class HealthMeter extends GraphicsObject{

    static Rectangle bar;

    /**
     * generates a health meter for the spaceship.
     * @param x x position for health meter.
     * @param y y position for health meter.
     * @param canvas canvas to add health meter.
     */
    public HealthMeter(double x, double y, CanvasWindow canvas){
        bar = new Rectangle(x, y, SpaceShip.getHealth() * 1.5, 20);
        bar.setFillColor(new Color(203, 49, 20));

        Rectangle border = new Rectangle(x, y, SpaceShip.getHealth() * 1.5, 20);
        border.setFilled(false);
        border.setStrokeColor(new Color(52, 206, 235));
        border.setStrokeWidth(3);

        canvas.add(bar);
        canvas.add(border);
    }

    public static void updateHealthMeter(){
        bar.setSize(SpaceShip.getHealth() * 1.5,20);
    }

    @Override
    protected void drawInLocalCoordinates(Graphics2D gc) {
    }

    @Override
    public boolean testHitInLocalCoordinates(double x, double y) {
        return false;
    }

    @Override
    public Rectangle2D getBounds() {
        return null;
    }

    @Override
    protected Object getEqualityAttributes() {
        return null;
    }

}
