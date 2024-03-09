package src.week19;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.paint.Paint;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Line;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;


public class ShapesAndImages extends Application {

    @Override
    public void start(Stage stage) throws Exception {
        Pane pane = new Pane();
        Scene mainScene = new Scene(pane,400,400);
        pane.setStyle("-fx-background-color: white");

        Rectangle rectangle = new Rectangle(20,20, 40,40);
        rectangle.setStyle("-fx-fill: white");

        Circle circle = new Circle(80, 40, 20);

        Line line = new Line(0,0,60,80);
        Color color = new Color(1,0,1,1);
        line.setStroke(color);
        line.setStrokeWidth(10);

//        pane.getChildren().addAll(rectangle, circle, line);

        Image baseImage = new Image("images/BaseTile.png",100,100,true,false);
        ImageView baseViewer = new ImageView(baseImage);

        Image bombImage = new Image("images/Bomb.png",100,100,true,false);
        ImageView bombViewer = new ImageView(bombImage);

        pane.getChildren().add(baseViewer);
        pane.getChildren().add(bombViewer);

        bombViewer.setX(100);


        stage.setTitle("Shapes And Images");
        stage.setScene(mainScene);
        stage.show();
    }

    public static void main(String[] args) {
        Application.launch(args);
    }
}
