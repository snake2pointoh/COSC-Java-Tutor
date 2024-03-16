package src.other.chap15;

import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;

public class Ball1 extends Circle
{
    private Pane obParent ;
    private int dX, dY;

    public Ball1( Pane obPane, double dRad, String sStyle)
    {
        super();

        double x = Math.random() * obPane.getWidth();
        double y = Math.random() * obPane.getHeight();

        //We don't want to start a circle that overlaps a border

        x  = x > obPane.getWidth() - dRad ? obPane.getWidth() - dRad - 1 : x;
        x = x < dRad ? dRad + 1: x;

        y= y> obPane.getHeight() - dRad ? obPane.getHeight()-dRad-1: y;
        y = y < dRad ? dRad + 1: y;

        //Set up the inital movement paramaters
        dX  = Math.random() > .5 ? 1 : -1;
        dY = Math.random() > .5 ? 1 : -1;

        obParent = obPane;
        setCenterX(x);
        setCenterY(y);
        setRadius(dRad);
        setStyle(sStyle);
        obParent.getChildren().add(this);

        new Thread(() -> {

            while (true)
            {
                try
                {
                    Thread.sleep(4000);
                    this.setFill(Color.color(Math.random(),Math.random(), Math.random()));
                }
                catch (InterruptedException ignored) {}
            }



        }).start();




    }

    /**
     * this method will give the apperance of moving the ball on the pane.
     */
    public void move()
    {
        if (getCenterX() < this.getRadius() || getCenterX() > obParent.getWidth() - getRadius())
        {
            dX *= -1;
        }

        if (getCenterY() < getRadius() || getCenterY() > obParent.getHeight() - getRadius())
        {
            dY *= -1;
        }

        setCenterX(getCenterX() + dX);
        setCenterY(getCenterY() + dY);


    }

    /**
     * THis will have the effect of increasing the speed of the ball's movement.
     */
    public void speedUp()
    {
        dX += dX > 0 ? 1 : -1;
        dY += dY > 0 ? 1 : -1;

    }

    public void slowDown()
    {
        dX += dX > 0 ? -1 : 1;
        dY += dY > 0 ? -1 : 1;

    }

    public void reverseDir()
    {
        dX *= -1;
        dY *= -1;

    }



}
