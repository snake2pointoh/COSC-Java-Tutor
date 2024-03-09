package src.other;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.input.MouseButton;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Line;
import javafx.scene.shape.Rectangle;
import javafx.scene.shape.Shape;
import javafx.stage.Stage;

public class MyPaint extends Application {

    private double startX, startY;
    private Circle obCirc;
    private Shape obShape;
    Pane obDraw;
    BorderPane obBP;
    private String obCurrentShape = "Circle";

    @Override
    public void start(Stage stage) throws Exception {
        obDraw = new Pane();
        obBP = new BorderPane();

        obDraw.setStyle("-fx-background-color: aliceblue");

        //When the mouse pressed down I want you start a circle with a background color of Red
        //and Radius 1 at the point where you are pressing down.  Also set startX, and startY to
        //that particular point. You be adding this to obDraw.

        obDraw.setOnMouseClicked(e -> {
            if (e.getButton().equals(MouseButton.SECONDARY)) {
                //Clears the screen
                obDraw.getChildren().clear();
            }
        });


        obDraw.setOnMousePressed(e -> {
            startX = e.getX();
            startY = e.getY();

            if (obCurrentShape.equals("Circle")) {
                obShape = new Circle(startX, startY, 1);
                obShape.setStyle("-fx-fill: Red");
            }

            if (obCurrentShape.equals("Line")) {
                obShape = new Line(startX, startY, startX, startY);
                obShape.setStyle("-fx-stroke: Red");

            }
            if (obCurrentShape.equals("Rectangle")) {
                obShape = new Rectangle(startX, startY, 1, 1);
                obShape.setStyle("-fx-fill: Red");

            }

            obDraw.getChildren().add(obShape);

        });

        obDraw.setOnMouseDragged(e -> {

            if (obShape instanceof Circle) {
                ((Circle) obShape).setRadius(Math.sqrt(Math.pow((e.getX() - startX), 2)
                        + Math.pow((e.getY() - startY), 2)));
            }

            if (obShape instanceof Line) {
                ((Line) obShape).setEndX(e.getX());
                ((Line) obShape).setEndY(e.getY());
            }

            if (obShape instanceof Rectangle) {
                double dWidth = Math.abs(startX - e.getX());
                double dHeight = Math.abs(startY - e.getY());
                ((Rectangle) obShape).setWidth(dWidth);
                ((Rectangle) obShape).setHeight(dHeight);

            }


        });

        obBP.setCenter(obDraw);
        obBP.setBottom(getColorOptions());
        obBP.setLeft(getShapes());

        stage.setScene(new Scene(obBP, 600, 600));
        stage.setTitle("MyPaint");
        stage.show();


    }

    /**
     * We are going to proivide three colors that we want all circles/shapes to take on
     * In other words all existing cricles will change color.
     *
     * @return
     */
    private HBox getColorOptions() {
        String[] aColors = {"Red", "Green", "Blue", "Yellow", "Orange", "Fuchsia"};
        HBox obBox = new HBox();
        obBox.setAlignment(Pos.CENTER);
        obBox.setPadding(new Insets(10, 10, 10, 10));
        obBox.setSpacing(10);

        for (String sColor : aColors) {
            Button obButton = new Button(sColor);
            obButton.setOnAction(e -> {
                //Change all of the current Circles to be the given color
                obDraw.getChildren().forEach(x -> {
                    if (x instanceof Circle || x instanceof Rectangle) {
                        x.setStyle("-fx-fill: " + sColor);
                    }
                    if (x instanceof Line) {
                        x.setStyle("-fx-stroke: " + sColor);
                    }

                });
            });
            obBox.getChildren().add(obButton);
        }

        return obBox;

    }


    private VBox getShapes() {
        String[] aShapes = {"Circle", "Line", "Rectangle"};

        VBox obBox = new VBox();
        obBox.setAlignment(Pos.CENTER);
        obBox.setSpacing(20);
        obBox.setPadding(new Insets(10, 10, 10, 10));
        obBox.setStyle("-fx-background-color: limegreen");

        for (String sShape : aShapes) {
            Button obButton = new Button(sShape);
            obButton.setOnAction(e -> {
                obCurrentShape = sShape;
            });

            obBox.getChildren().add(obButton);

        }
        return obBox;
    }
    public static void main(String[] args) {
        Application.launch();
    }
}