package src.week19;

import javafx.event.EventHandler;
import javafx.scene.input.MouseEvent;

public class MyMouseEvent implements EventHandler<MouseEvent> {

    @Override
    public void handle(MouseEvent e) {
        System.out.printf("Relative:\tX Pos: %.3f, Y Pos: %.3f\n", e.getX(), e.getY());
        System.out.printf("Scene:\tX Pos: %.3f, Y Pos: %.3f\n", e.getSceneX(), e.getSceneY());
        System.out.printf("Screen:\t X Pos: %.3f, Y Pos: %.3f\n", e.getScreenX(), e.getScreenY());
        System.out.println();
    }
}
