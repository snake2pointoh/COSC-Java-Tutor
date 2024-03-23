package src.other;

import javafx.scene.layout.Pane;
import javafx.scene.shape.Line;

public class DrawPane extends Pane
{
	
	private double startX,startY;
	public String curStyle ="-fx-stroke:green";
	public double dSize = 1;
	private Line obLine;
	public DrawPane()
	{
		super();
		
		setOnMousePressed(e -> {
			startX = e.getX();
			startY = e.getY();
			obLine = new Line(startX,startY,startX+10,startY+10);
			getChildren().add(obLine);
			obLine.setStrokeWidth(dSize);
			obLine.setStyle(curStyle);
		}); 
		
		setOnMouseDragged(e -> {
			obLine.setEndX(e.getX());
			obLine.setEndY(e.getY());
		});
	}
}
