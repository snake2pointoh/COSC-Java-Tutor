package src.week18;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

public class simpleFX extends Application {

    Stage mainStage = null;

    @Override
    public void start(Stage stage) throws Exception {
        mainStage = stage;

        BorderPane obPane = new BorderPane();
        Button myButton = new Button("My Button");

        obPane.setBackground();

        obPane.setCenter(myButton);

        Scene mainScene = new Scene(obPane,500,500);

        mainStage.setScene(mainScene);

        mainStage.setTitle("Simple FX");

        mainStage.setMinHeight(100);
        mainStage.setMinWidth(100);

        mainStage.show();

    }

}
