package src.week9;

public abstract class Shape {

    protected int[] center;
    public abstract double getArea();
    public abstract int[][] getPoints();
    public double distance(Shape other) {
        return Math.sqrt( Math.pow((other.center[0] - this.center[0]),2) +
                Math.pow( (other.center[1] - this.center[1]),2) );
    }
}
