package src.week10;

public class BSubClass extends AbstractSuper {
    public BSubClass() {
        super(10);
    }

    public void printValue() {
        System.out.println(this.getValue());
    }
}
