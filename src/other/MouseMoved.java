package chap15;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.stage.Stage;

public class MouseMoved extends Application
{
    @Override
    public void start(Stage stage) throws Exception
    {
        Pane obPane = new Pane();

        obPane.setOnMouseClicked(e -> {
            Circle obCirc = new Circle();
            obCirc.setCenterX(e.getX());
            obCirc.setCenterY(e.getY());
            obCirc.setRadius(2);
            obCirc.setFill(Color.color(Math.random(),Math.random(), Math.random()));
            obPane.getChildren().add(obCirc);

        });

        obPane.setOnMouseMoved(e -> {
            System.out.printf("(%d, %d)\n", (int)e.getX(), (int)e.getY());
        });


        stage.setScene(new Scene(obPane, 300,300));
        stage.show();


    }

    public static void main(String[] args)
    {
        Application.launch(args);
    }
}
