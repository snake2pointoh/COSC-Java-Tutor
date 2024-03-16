package src.other.chap15;

import javafx.scene.shape.Rectangle;

public class Paddle extends Rectangle
{
    Paddle(BallPane obPane)
    {
        super();

        setX(obPane.getWidth()-30);
        setY(obPane.getHeight()/2 -15);

        setWidth(10);
        setHeight(30);
        setStyle("-fx-fill:blue; -fx-stroke: black");

    }

    public void up()
    {
        setY(getY() -4);
    }

    public void down()
    {
        setY(getY() +4);
    }

    public boolean isTouching(Ball obBall)
    {
        if (obBall.getCenterX() + obBall.getRadius() >= getX() &&
        obBall.getCenterY() + obBall.getRadius() >= getY() &&
                obBall.getCenterY()+ obBall.getRadius() <= getY() + getHeight())
        {
            return true;
        }

        return false;
    }

}
