package src.other.chap15;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

public class SimpleExit extends Application
{
    public static void main(String[] args)
    {
        Application.launch(args);
    }

    @Override
    public void start(Stage stage) throws Exception
    {

        StackPane obPane = new StackPane();
        Button cmdExit = new Button("Bye Bye");
        obPane.getChildren().add(cmdExit);



        stage.setScene(new Scene(obPane, 200,200));
        stage.show();;

        cmdExit.setOnAction(e -> {
            Platform.exit();
        });

    }
}
