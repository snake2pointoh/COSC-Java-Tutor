package src.other.chap15;

import javafx.scene.layout.Pane;
import javafx.scene.shape.Circle;

public class Ball extends Circle
{
    private Pane obParent;
    private int dX; //Change in xPosition
    private int dY; // Change in yPosition;

    public Ball(Pane prn, double dRad, String sStyle)
    {
        super();
        obParent = prn;
        double x = Math.random() * obParent.getWidth();
        double y = Math.random() * obParent.getHeight();

        //make sure that the ball is not intersecting with a boarder of the pane
        x = x > obParent.getWidth() -dRad ? obParent.getWidth() - dRad -1 : x;
        x = x< dRad ? dRad +1 : x;

        y= y > obParent.getHeight() - dRad ? obParent.getHeight() - dRad -1 : y;
        y = y < dRad ? dRad + 1: y;

        //Set up our Initial movement factors
        dX = Math.random() > .5 ? 1 : -1;
        dY = Math.random() > .5 ? 1 : -1;

        setCenterX(x);
        setCenterY(y);
        setRadius(dRad);
        setStyle(sStyle);
        //obParent.getChildren().add(this);


    }

    public void move()
    {
        if (getCenterX() < getRadius() || getCenterX() > obParent.getWidth() - getRadius())
        {
            dX *= -1;
        }

        if (getCenterY() < getRadius() || getCenterY() > obParent.getHeight() - getRadius())
        {
            dY *=-1;
        }
        setCenterX(getCenterX() + dX);
        setCenterY(getCenterY() + dY);
    }

    public void speedUp()
    {
        dX = dX > 0? dX+1 : dX-1;
        dY = dY > 0? dY+1 : dY-1;
    }

    public void slowDown()
    {
        dX = dX >0 ? dX -1 : dX +1;
        dY = dY > 0 ? dY -1 : dY + 1;
    }

    public void reverseDir()
    {
        dX *=-1;
        dY *=-1;
    }

}
