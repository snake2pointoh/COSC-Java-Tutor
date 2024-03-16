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

public class BouncingBalls1 extends Application
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
        obBP.setBottom(estMoveControls());

        stage.setScene(new Scene(obBP, 350,350));
        stage.setTitle("Bouncing Balls");
        stage.show();

        //The thread to drive the motion

        new Thread(() -> {
            while(true)
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

    private HBox estMoveControls()
    {
        HBox obBox = new HBox();
        obBox.setSpacing(20);
        obBox.setAlignment(Pos.CENTER);
        obBox.setPadding(new Insets(10,10,10,10));

        Button cmdSpeedUp = new Button("Speed up");
        Button cmdSlowDown = new Button("Slow Down");

        cmdSpeedUp.setOnAction(e -> {
            obPane.speedUp();
        });

        cmdSlowDown.setOnAction(e -> {
            obPane.slowDown();

        });

        obBox.getChildren().addAll(cmdSpeedUp,cmdSlowDown);
        return obBox;

    }






}
