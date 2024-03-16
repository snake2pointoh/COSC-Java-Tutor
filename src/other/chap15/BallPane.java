package src.other.chap15;

import javafx.application.Platform;
import javafx.scene.input.KeyCode;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;

import java.util.ArrayList;

class BallPane extends Pane
{
    private Ball obBall;
    private ArrayList<Ball> obList;
    private final int LIST_SIZE =2;
    private Paddle obPaddle;

    public BallPane()
    {
        super();
        setHeight(300);
        setWidth(300);
       // obBall = new Ball(this,10, "-fx-fill: red; -fx-stroke: black");
        positionBalls();
        obPaddle = new Paddle(this);
        getChildren().add(obPaddle);

        setOnKeyPressed(e -> {
            if (e.getCode() == KeyCode.DOWN)
            {
                Platform.runLater(() -> {
                    obPaddle.down();
                   requestFocus();
                });
            }
            if (e.getCode() == KeyCode.UP)
            {
                Platform.runLater(() -> {
                    obPaddle.up();
                    requestFocus();
                    e.consume();

                });
            }
        });


    }

    public void move()
    {
       // obBall.move();
        checkCollisions();
        obList.forEach(Ball::move);
        checkPaddle();
    }

    public void speedUp()
    {
        //obBall.speedUp();
        obList.forEach(Ball::speedUp);
    }

    public void slowDown()
    {
        obList.forEach(Ball::slowDown);
    }

    /**
     * We don not want to place balls on the screen if they are going to collide
     */
    public void positionBalls()
    {

        obList = new ArrayList<>();

        for (int i=0; i<LIST_SIZE; i++)
        {
            Ball obBall = new Ball(this,10,"-fx-fill: red; -fx-stroke:black");

            //We want to make sure that the ball is not touching any ball in the curent list
            while (isTouching(obBall))
            {
                obBall = new Ball(this,10,"-fx-fill: red; -fx-stroke:black");
            }

            obList.add(obBall);
            getChildren().add(obBall);

        }


    }

    public boolean isTouching(Ball obBall)
    {
        for (Ball obCkBall : obList)
        {
            if (collide(obBall,obCkBall))
            {
                return true;
            }
        }
        return false;
    }

    /**
     * This will look at all Balls currently on the screen and check to see if they are touching
     */
    public void checkCollisions()
    {
        for (int i=0; i<obList.size()-1; i++)
        {
            Ball obBall1 = obList.get(i);

            for (int j=i+1; j<obList.size(); j++)
            {
                Ball obBall2 = obList.get(j);
                if (collide(obBall1,obBall2))
                {
                    obBall1.reverseDir();
                    obBall2.reverseDir();
                    obBall1.setFill(Color.color(Math.random(),Math.random(),Math.random()));
                    obBall2.setFill(Color.color(Math.random(),Math.random(),Math.random()));
                }
            }
        }
    }

    /**
     * This method will determine if the distances betweent the 2 balls is less than
     * the sum of the radiuses of the two balls/
     * @param obBall1
     * @param obBall2
     * @return
     */
    public boolean collide(Ball obBall1, Ball obBall2)
    {
        double dDistanceX = Math.sqrt(Math.pow((obBall1.getCenterX()- obBall2.getCenterX()),2));
        double dDistanceY = Math.sqrt(Math.pow((obBall1.getCenterY()- obBall2.getCenterY()),2));
        double dRadTotal = obBall1.getRadius() + obBall2.getRadius();

        if (dDistanceX <= dRadTotal && dDistanceY <= dRadTotal)
        {
           return true;
        }

        return false;

    }

    /**
     * This method will go through and check to see if the paddle intersects with one of the bouncing
     * balls
     */
    public void checkPaddle()
    {
        obList.forEach(x -> {
            if (obPaddle.isTouching(x))
            {
                x.reverseDir();
            }
        });
    }


}
