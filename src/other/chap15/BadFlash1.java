package src.other.chap15;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.scene.text.Font;
import javafx.scene.text.FontPosture;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class BadFlash1 extends Application
{

    private Text obText;
    @Override
    public void start(Stage stage) throws Exception
    {
        Pane obPane = new Pane();
        obText = new Text(30,30,"Welcome");
        obText.setFont(Font.font("Bookman Old Style", FontWeight.NORMAL, FontPosture.ITALIC, 30));
        obPane.getChildren().add(obText);

        stage.setScene(new Scene(obPane, 300,300));
        stage.show();

        while (true)
        {
            Thread.sleep(1000);
            obText.setText(obText.getText().length() == 0? "Welcome": "");


        }




    }

    public static void main(String[] args)
    {
        Application.launch(args);
    }
}
