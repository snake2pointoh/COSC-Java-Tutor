package src.week9;

public class Square extends Shape {


    int size;

    public Square(int x, int y, int size) {
        center = new int[2];
        center[0] = x;
        center[1] = y;
        this.size = size;

    }


    @Override
    public double getArea() {
        return size * size;
    }

    @Override
    public int[][] getPoints() {
        int[][] points = new int[4][2];
        // center is 1,1
        // width is 2
        // points are 0,0 0,2 2,2 2,0

        // top left
        points[0][0] = center[0] - size/2;
        points[0][1] = center[1] + size/2;

        // top right
        points[1][0] = center[0] + size/2;
        points[1][1] = center[1] + size/2;

        // bottom left
        points[2][0] = center[0] - size/2;
        points[2][1] = center[1] - size/2;

        // bottom right
        points[3][0] = center[0] + size/2;
        points[3][1] = center[1] - size/2;

        return points;
    }
}
