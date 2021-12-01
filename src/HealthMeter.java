import java.awt.Graphics2D;
import java.awt.geom.Rectangle2D;

import javax.swing.border.Border;

import java.awt.Color;

import edu.macalester.graphics.CanvasWindow;
import edu.macalester.graphics.GraphicsObject;
import edu.macalester.graphics.Rectangle;

public class HealthMeter extends GraphicsObject{
    public HealthMeter(double d, double e, CanvasWindow canvas){
        Rectangle bar = new Rectangle(d, e, 150, 20);
        bar.setFillColor(new Color(203, 49, 20));

        Rectangle border = new Rectangle(d, e, 150, 20);
        border.setFilled(false);
        border.setStrokeColor(new Color(52, 206, 235));
        border.setStrokeWidth(3);


        canvas.add(bar);
        canvas.add(border);

    }

    @Override
    protected void drawInLocalCoordinates(Graphics2D gc) {
        // TODO Auto-generated method stub
        
    }

    @Override
    public boolean testHitInLocalCoordinates(double x, double y) {
        // TODO Auto-generated method stub
        return false;
    }

    @Override
    public Rectangle2D getBounds() {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    protected Object getEqualityAttributes() {
        // TODO Auto-generated method stub
        return null;
    }

}
