package src.other.chap15;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.scene.text.Font;
import javafx.scene.text.FontPosture;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class KeyEventDemo extends Application
{

    @Override
    public void start(Stage stage) throws Exception
    {
        Pane obPane = new Pane();
        Text lblText = new Text(30,30,"Java Rocks");
        lblText.setFont(Font.font("Bookman Old Style", FontWeight.BOLD, FontPosture.ITALIC, 40));
        obPane.getChildren().add(lblText);

        lblText.setOnKeyPressed(e -> {
            switch (e.getCode())
            {
                case UP:
                    lblText.setY(lblText.getY() - 10);
                    break;
                case DOWN:
                    lblText.setY(lblText.getY() + 10);
                    break;
                case RIGHT:
                    lblText.setX(lblText.getX() + 10);
                    break;
                case LEFT:
                    lblText.setX(lblText.getX() - 10);
                    break;
            }
        });

        stage.setScene(new Scene(obPane, 300,300));
        stage.setTitle("KeyEventDemo");
        stage.show();

        lblText.requestFocus();



    }

    public static void main(String[] args)
    {
        Application.launch(args);
    }
}
