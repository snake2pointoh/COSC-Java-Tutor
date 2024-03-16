package src.week20;

import javafx.scene.shape.Circle;

public class Ball extends Circle {

    double speed;
    double moveDirectionX = 1;
    double moveDirectionY = 0.5;
    double winHeight, widWidth;

    public Ball(double radius, double startX, double startY, double widWidth, double winHeight, double speed) {
        super(startX, startY, radius);
        this.speed = speed;
        this.widWidth = widWidth;
        this.winHeight = winHeight;

        this.setStyle("-fx-fill: blue");
    }

    public void move(Paddle p1, Paddle p2) {
        setCenterX(getCenterX() + speed * moveDirectionX);
        setCenterY(getCenterY() + speed * moveDirectionY);

        checkColliding(p1, p2);
    }

    public void checkColliding(Paddle p1, Paddle p2) {

        if(checkWallCollideX() || checkPaddleCollideX(p1) || checkPaddleCollideX(p2)) {
            moveDirectionX = moveDirectionX * -1;
        }

        if(checkWallCollideY() || checkPaddleCollideY(p1) || checkPaddleCollideY(p2)) {
            moveDirectionY = moveDirectionY * -1;
        }
    }

    private boolean checkWallCollideY() {
        double yPos = this.getCenterY();

        // up
        if(yPos - getRadius() < 0) {
            // un-collide the left wall and the ball
            this.setCenterY(0 + getRadius());
            return true;
        }

        // down
        if (yPos + getRadius() > winHeight) {
            this.setCenterY(winHeight - getRadius());
            return true;
        }

        return false;
    }

    private boolean checkWallCollideX() {
        double xPos = this.getCenterX();

        // left
        if(xPos - getRadius() < 0) {
            // un-collide the left wall and the ball
            this.setCenterX(0 + getRadius());
            return true;
        }

        // right
        if (xPos + getRadius() > widWidth) {
            this.setCenterX(widWidth - getRadius());
            return true;
        }

        return false;
    }

    private boolean checkPaddleCollideX(Paddle paddle) {
        double xPos = this.getCenterX();
        double yPos = this.getCenterY();

        if(yPos + getRadius() < paddle.getY()
                || yPos - getRadius() > paddle.getY() + paddle.getHeight())
        {
            return false;
        }

        // left
        if(xPos + getRadius() > paddle.getX()
                && xPos + getRadius() < paddle.getX() + paddle.getWidth() )
        {
            this.setCenterX(paddle.getX() - getRadius());
            return true;
        }

        // right
        if(xPos - getRadius() < paddle.getX() + paddle.getWidth()
            && xPos - getRadius() > paddle.getX())
        {
            this.setCenterX(paddle.getX() + paddle.getWidth() + getRadius());
            return true;
        }

        return false;
    }

    private boolean checkPaddleCollideY(Paddle paddle) {
        return false;
    }

}
