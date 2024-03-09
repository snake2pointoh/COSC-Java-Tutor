package src.week19;

import javafx.application.Application;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.input.KeyCode;
import javafx.scene.input.MouseButton;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class ButtonsAndEvents extends Application {

    Text lblText;
    
    @Override
    public void start(Stage stage) throws Exception {
        BorderPane bPane = new BorderPane();

        lblText = new Text("Key Events");
        Text lblBottomText = new Text(30, 30, "Bottom Text");

        Pane basePane = new Pane();
        basePane.setStyle("-fx-background-color: Grey");

        Scene myScene = new Scene(bPane, 400, 400);
        Button myButton = new Button("Button One");

        bPane.setTop(lblText);
        bPane.setCenter(myButton);
        bPane.setBottom(basePane);

        basePane.getChildren().add(lblBottomText);

        // Action Events
        myButton.setOnAction((e) -> {
            System.out.println("Button Was Pressed");
        });

        // Key Events
        lblText.setOnKeyPressed((e) -> {
            KeyCode code = e.getCode();
            System.out.println("KeyEvent:");

            switch (code) {
                case UP:
                    System.out.println("UP");
                    break;
                case DOWN:
                    System.out.println("DOWN");
                    break;
                case LEFT:
                    System.out.println("LEFT");
                    break;
                case RIGHT:
                    System.out.println("RIGHT");
                    break;
                default:
                    System.out.println(code);
                    break;
            }

        });

        // Mouse Click Event
        lblText.setOnMouseClicked(this::mouseClickEvent);

        // Moue Moved Event
        basePane.setOnMouseMoved(new MyMouseEvent());


        stage.setScene(myScene);
        stage.setTitle("Buttons And Events");
        stage.show();
    }

    // not needed with intellij
    public static void main(String[] args) {
        Application.launch(args);
    }

    public void mouseClickEvent(MouseEvent e) {
        MouseButton btn = e.getButton();

        System.out.println("Mouse Click Event:");
        System.out.println(btn);

        // Key Events will only be fired if the item they are attached to is the focused element
//        lblText.requestFocus();
        ((Node) e.getSource()).requestFocus();
    }
}
