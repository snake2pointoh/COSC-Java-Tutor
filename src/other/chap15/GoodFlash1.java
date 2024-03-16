package src.other.chap15;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.scene.text.Font;
import javafx.scene.text.FontPosture;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class GoodFlash1 extends Application
{

    private Text obText;
    private int nIncrement = 5;
    @Override
    public void start(Stage stage) throws Exception
    {
        Pane obPane = new Pane();
        obText = new Text(30,30,"Welcome");
        obText.setFont(Font.font("Bookman Old Style", FontWeight.NORMAL, FontPosture.ITALIC, 30));
        obPane.getChildren().add(obText);

        stage.setScene(new Scene(obPane, 300,300));
        stage.show();

        new Thread( () -> {
            while (true)
            {
                try
                {
                    Thread.sleep(1000);
                    Platform.runLater( () -> {

                        obText.setText(obText.getText().length() == 0 ? "Welcome": "");
                    });

                }
                catch (InterruptedException ignored) {}

            }
        }).start();


        new Thread(() -> {
            while (true)
            {
                try
                {
                    Thread.sleep(100);
                    Platform.runLater(() -> {
                        if (obText.getY() < 30 || obText.getY() > obPane.getHeight() -30)
                        {
                            nIncrement *= -1;
                        }
                        obText.setY(obText.getY() + nIncrement);
                    });
                } catch (InterruptedException ignored){}
            }
        }).start();



    }

    public static void main(String[] args)
    {
        Application.launch(args);
    }
}
