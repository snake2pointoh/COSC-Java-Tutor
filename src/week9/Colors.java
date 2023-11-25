package src.week9;

public enum Colors {
    RED(255,0,0),
    GREEN(0,255,0),
    BLUE(0,0,255);

    public int red;
    public int green;
    public int blue;

    Colors(int red, int green, int blue) {
        this.red = red;
        this.green = green;
        this.blue = blue;
    }
}
