package src.week20;

import javafx.application.Platform;
import javafx.scene.shape.Rectangle;

public class Paddle extends Rectangle {

    String name;

    double windowHeight;
    static final double MOVE_DISTANCE = 10;

    Paddle(double width, double height, double xPos, double yPos, double windowHeight, String paddleName) {
        super();
        this.name = paddleName;
        this.windowHeight = windowHeight;

        setHeight(height);
        setWidth(width);

        setX(xPos);
        setY(yPos);

        this.setStyle("-fx-fill: green");
    }

    public void moveUp() {
        Platform.runLater(()->{
            this.setY(this.getY() - MOVE_DISTANCE);

            if(this.getY() < 0) {
                this.setY(0);
            }
        });
    }

    public void moveDown() {
        Platform.runLater(()->{
            this.setY(this.getY() + MOVE_DISTANCE);

            if(this.getY() > windowHeight - this.getHeight()) {
                this.setY(windowHeight - this.getHeight());
            }
        });
    }
}
