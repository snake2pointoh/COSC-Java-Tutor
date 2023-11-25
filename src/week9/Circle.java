package src.week9;

public class Circle extends Shape {


    private double radius;

    public Circle(int x, int y, double radius){
        center = new int[2];
        center[0] = x;
        center[1] = y;
        this.radius = radius;
    }

    @Override
    public double getArea() {
        return Math.PI * Math.pow(radius, 2);
    }
    @Override
    public int[][] getPoints() {
        int[][] points = new int[1][2];
        points[0] = center;

        return points;
    }
}
