package src.other.chap15;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

public class MyEvent extends Application
{

    @Override
    public void start(Stage stage) throws Exception
    {
        StackPane obPane = new StackPane();
        Button cmdOk = new Button("OK");
        //OkHandlerClass hand1 = new OkHandlerClass();
        //cmdOk.setOnAction(hand1);

        //Preferred way to do event handling
        cmdOk.setOnAction(e -> {
            System.out.println("Lambda OK");
        });


        obPane.getChildren().add(cmdOk);

        stage.setScene(new Scene(obPane,200,200));
        stage.show();


    }



    public static void main(String[] args)
    {
        Application.launch(args);
    }
}


class OkHandlerClass implements EventHandler<ActionEvent> {
    @Override
    public void handle(ActionEvent actionEvent) {
        System.out.println("Ok Was Pressed");
    }
}