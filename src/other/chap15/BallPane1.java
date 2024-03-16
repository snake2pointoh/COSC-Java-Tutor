package src.other.chap15;

import javafx.scene.layout.Pane;

import java.util.ArrayList;

public class BallPane1 extends Pane
{

    private Ball obBall;
    private ArrayList<Ball> obList;
    private final int LIST_SIZE= 10;

    public BallPane1()
    {
        super();
        setHeight(300);
        setWidth(300);
        loadList();


    }

    public void move()
    {
        checkCollisions();
        obList.forEach(Ball::move);

    }

    public void speedUp()
    {
        obList.forEach(Ball::speedUp);
    }

    public void slowDown()
    {
        obList.forEach(Ball::slowDown);
    }

    /**
     * Helper method to establish the ball position
     */
    private void loadList()
    {

        obList = new ArrayList<>();

        for (int i=0; i<LIST_SIZE; i++)
        {
            Ball obBall = new Ball(this,10,"-fx-fill:red; -fx-stroke:black");
            while (!canPlace(obBall))
            {
                obBall = new Ball(this,10,"-fx-fill:red; -fx-stroke:black");
            }
            obList.add(obBall);
        }

    }


    /**
     * Helper method for allowing us to not initially overlap balls when placing balls.
     * @param obBall
     * @return
     */
    public boolean canPlace(Ball obBall)
    {
        for (Ball obCkBall: obList)
        {
            if (isOverlapping(obBall, obCkBall))
            {
                return false;
            }
        }
        return true;
    }





    /**
     * This method will go through and check to see if any of the balls in the list are overlapping
     * If this is the case we will reverse the direction the balls are moving in
     */
    private void checkCollisions()
    {
        for (int i=0; i< obList.size() -1; i++)
        {
            Ball obBall1 = obList.get(i);
            for (int j = i+1; j<obList.size(); j++)
            {
                Ball obBall2 = obList.get(j);
                if (isOverlapping(obBall1, obBall2))
                {
                    obBall1.reverseDir();
                    obBall2.reverseDir();
                }
            }
        }
    }

    /**
     * This method will determine if bally is overlapping with respect to ball2
     * @param obBall1
     * @param obBall2
     * @return
     */
    public boolean isOverlapping(Ball obBall1, Ball obBall2)
    {

        double dXOffset = Math.sqrt(Math.pow((obBall1.getCenterX() - obBall2.getCenterX()),2));
        double dYOffset = Math.sqrt(Math.pow((obBall1.getCenterY() - obBall2.getCenterY()),2));
        double dRadOffset = obBall1.getRadius() + obBall2.getRadius();

        if (dXOffset <= dRadOffset && dYOffset <= dRadOffset)
        {
            return true;
        }
        else
        {
            return false;
        }


    }







}
