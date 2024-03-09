package chap15;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Line;
import javafx.stage.Stage;



public class DrawLines extends Application
{

    private  Line obLine;

    private  Color lineColor  =Color.BLUE;

    private HBox obBox;

    @Override
    public void start(Stage stage) throws Exception
    {

        BorderPane obBP = new BorderPane();

        Pane obPane = new Pane();

        obPane.setOnMousePressed(e -> {

            obLine = new Line(e.getX(), e.getY(), e.getX(), e.getY());

            obLine.setStrokeWidth(2);
            obLine.setStroke(lineColor);
            obPane.getChildren().add(obLine);
        });

        obPane.setOnMouseDragged( e -> {
            obLine.setEndX(e.getX());
            obLine.setEndY(e.getY());
        });

        obBP.setCenter(obPane);

        estButtons();
        obBP.setBottom(obBox);
        stage.setScene(new Scene(obBP, 300,300));
        stage.show();

    }


    public HBox estButtons()
    {
         String[] aColor = { "Red", "Green", "Blue", "Yellow"};
        Color[] aRColor = { Color.RED, Color.GREEN, Color.BLUE,Color.YELLOW};
        obBox = new HBox();
        obBox.setAlignment(Pos.CENTER);
        obBox.setSpacing(10);
        obBox.setPadding(new Insets(4,4,4,4));



        for (int i=0; i< aColor.length; i++)
        {
            Button aButton = new Button(aColor[i]);
            Color actColor  = aRColor[i];
            aButton.setOnAction(e -> {
                lineColor = actColor;


            });


            obBox.getChildren().add(aButton);
        }

        return obBox;
    }



    public static void main(String[] args)
    {
        Application.launch(args);
    }
}
