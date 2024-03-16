package src.week20;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.scene.Scene;
import javafx.scene.input.KeyCode;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

import java.util.Random;

public class ThreadDemo extends Application {


    Pane mainPain;
    Paddle p1Paddle;
    Paddle p2Paddle;
    Scene mainScene;

    Random random = new Random();
    @Override
    public void start(Stage stage) throws Exception {
        mainPain = new Pane();
        mainScene = new Scene(mainPain, 400, 400);

        // two paddles and a ball, all on separate threads
        p1Paddle = new Paddle(20,60,40,170,400,"p1");
        p2Paddle = new Paddle(20,60,340,170,400,"p2");

        mainPain.getChildren().addAll(p1Paddle, p2Paddle);

        setupPaddleEvents(KeyCode.W, KeyCode.S, KeyCode.E, KeyCode.D);

        for (int i = 0; i < 2; i++) {
            double startX = random.nextDouble(100,301);
            double startY = random.nextDouble(100,301);
            double radius = random.nextDouble(10,20);

            Ball ball = new Ball(radius, startX, startY,400,400, 5);
            new Thread(() -> ballThread(ball)).start();

            mainPain.getChildren().add(ball);
        }

        stage.setScene(mainScene);
        stage.setTitle("Simple Pong");

        // kills all running application threads
        stage.setOnCloseRequest((e) -> { System.exit(0); });
        stage.show();

        // set focus for key events
        mainPain.requestFocus();
    }

    public void ballThread(Ball tBall) {
        try {
            while (true) {
                Platform.runLater(() -> {
                    tBall.move(p1Paddle, p2Paddle);
                });

                Thread.sleep(50);
            }
        } catch (InterruptedException error) {
            error.printStackTrace();
        }
    }

    public void setupPaddleEvents(KeyCode upKeyP1, KeyCode dowKeyP1, KeyCode upKeyP2, KeyCode dowKeyP2) {
        mainPain.setOnKeyPressed((event) -> {
            KeyCode currentKey = event.getCode();

            // P1 Events
            if(currentKey == upKeyP1) {
                p1Paddle.moveUp();
            }
            if(currentKey == dowKeyP1) {
                p1Paddle.moveDown();
            }

            // P2 Events
            if(currentKey == upKeyP2) {
                p2Paddle.moveUp();
            }
            if(currentKey == dowKeyP2) {
                p2Paddle.moveDown();
            }
        });
    }

    public static void main(String[] args) {
        Application.launch(args);
    }
}
