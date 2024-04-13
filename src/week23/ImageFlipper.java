package src.week23;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

import java.util.Random;

public class ImageFlipper extends Application {

    Image[] images;
    int currentImgIndex = 0;
    ImageView imgVew;

    boolean isShuffle = false;

    @Override
    public void start(Stage stage) throws Exception {
        images = getImages();
        imgVew = new ImageView(images[currentImgIndex]);

        Button shuffleBtn = new Button("Shuffle");
        shuffleBtn.setOnAction((event) -> {
            // only run one shuffle thread at a time
            if (!isShuffle) {
                isShuffle = true;
                new Thread(this::shuffleImages).start();
            } else {
                System.out.println("already shuffling");
            }
        });

        Button showCurrentIndexBtn = new Button("Show Current");
        showCurrentIndexBtn.setOnAction((e)-> {
            System.out.println(currentImgIndex + 1);
        });

        BorderPane borderPane = new BorderPane();

        borderPane.setTop(showCurrentIndexBtn);
        borderPane.setCenter(imgVew);
        borderPane.setBottom(shuffleBtn);

        Scene scene = new Scene(borderPane, 300, 300);

        stage.setScene(scene);

        // kill all other running application threads
        stage.setOnCloseRequest((e)->{
            System.exit(0);
        });

        stage.show();
    }

    public Image[] getImages() {
        Image[] images = new Image[52];

        for (int i = 0; i < 52; i++) {
            Image currentImage = new Image("images/cards/" + (i + 1) + ".png");
            images[i] = currentImage;
        }

        return images;
    }

    public void shuffleImages() {
        Random random = new Random();
        int shuffles = random.nextInt(1,52);

        for (int i = 0; i < shuffles; i++) {
            int imgPicked = random.nextInt(0,52);
            currentImgIndex = imgPicked;

            Image newImg = images[imgPicked];

            Platform.runLater(() -> {
                imgVew.setImage(newImg);
            });

            try {
                Thread.sleep(200);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        isShuffle = false;
    }

    public static void main(String[] args) {
        Application.launch(args);
    }
}
