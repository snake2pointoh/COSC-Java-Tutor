package src.week9;

public class TestShapes {
    public static void main(String[] args) {
        Shape[] shapes = {
                new Circle(1,2,2.5),
                new Square(2,4, 4),
                new Triangle(4,4, 5, 7)
        };

        for (Shape shape: shapes) {
            System.out.println(shape.getArea());
        }

        System.out.println( shapes[0].distance(shapes[1]) );
    }
}
