package src.week9;

public class Triangle extends Shape {

    int width;
    int height;

    public Triangle(int x, int y, int width, int height) {
        this.center = new int[2];
        center[0] = x;
        center[1] = y;

        this.width = width;
        this.height = height;
    }

    @Override
    public double getArea() {
        return (width * height) / 2.0;
    }

    @Override
    public int[][] getPoints() {
        int[][] points = new int[3][2];

        // top
        points[0][0] = center[0];
        points[0][1] = center[1] + height/2;

        // left
        points[1][0] = center[0] - width/2;
        points[1][1] = center[1] - height/2;

        // right
        points[2][0] = center[0] + width/2;
        points[2][1] = center[1] - height/2;

        return points;
    }
}
