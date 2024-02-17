package src.week17;

public class MyRunnable implements Runnable{

    String name;

    MyRunnable(String name) {
        this.name = name;
    }

    @Override
    public void run() {
        for (int i = 0; i < 10; i++) {
            System.out.printf("%s is at %d\n", name, i);
        }
    }
}
