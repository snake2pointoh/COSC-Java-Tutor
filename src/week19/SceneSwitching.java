package src.week19;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class SceneSwitching extends Application {

    Scene sceneOne;
    Scene sceneTwo;
    Stage mainStage;

    @Override
    public void start(Stage stage) throws Exception {
        mainStage = stage;

        sceneOne = setupSceneOne();
        sceneTwo = setupSceneTwo();

        mainStage.setScene(sceneOne);
        mainStage.show();
    }

    private Scene setupSceneOne() {
        BorderPane bPane = new BorderPane();
        Scene scene = new Scene(bPane,400,400);

        Text lblText = new Text("Scene One");

        Button switchBtn = new Button("Switch to Scene Two");
        switchBtn.setOnAction((e)-> {

            // forces code to run in a safe way when the main jfx thread can handle the changes
            Platform.runLater(()->{
                mainStage.setScene(sceneTwo);
            });

        });

        bPane.setTop(lblText);
        bPane.setCenter(switchBtn);

        return  scene;
    }

    private Scene setupSceneTwo() {
        BorderPane bPane = new BorderPane();
        Scene scene = new Scene(bPane,400,400);

        Text lblText = new Text("Scene Two");

        Button switchBtn = new Button("Switch to Scene One");
        switchBtn.setOnAction((e)-> {

            // forces code to run in a safe way when the main jfx thread can handle the changes
            Platform.runLater(()->{
                mainStage.setScene(sceneOne);
            });

        });

        bPane.setTop(lblText);
        bPane.setCenter(switchBtn);

        return  scene;
    }
}
