package src.other.chap15;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

public class BouncingBalls extends Application
{

    private BallPane obPane;

    public static void main(String[] args)
    {

        Application.launch(args);

    }

    @Override
    public void start(Stage stage) throws Exception
    {
       obPane = new BallPane();
        BorderPane obBP = new BorderPane();
        obBP.setCenter(obPane);
        obBP.setBottom(controlMovement());

        stage.setScene(new Scene(obBP,350,350));
        stage.setTitle("Bouncing Balls");

        stage.show();

        obPane.requestFocus();




        //Let the bouning begin
        new Thread(() -> {
            while (true)
            {
                try
                {
                    Thread.sleep(20);
                    Platform.runLater(() -> {
                        obPane.move();
                    });
                }
                catch (InterruptedException ignored) {}
            }
        }).start();

    }

    private HBox controlMovement()
    {
        HBox obBox = new HBox();
        obBox.setSpacing(10);
        obBox.setPadding( new Insets(10,10,10,10));
        obBox.setAlignment(Pos.CENTER);

        Button cmdUp = new Button("Speed Up");
        Button cmdDown = new Button("Slow Down");

        cmdUp.setOnAction(e -> {
            obPane.speedUp();
            obPane.requestFocus();
        });

        cmdDown.setOnAction(e -> {
            obPane.slowDown();
            obPane.requestFocus();

        });

        obBox.getChildren().addAll(cmdUp,cmdDown);
        return obBox;

    }
}
