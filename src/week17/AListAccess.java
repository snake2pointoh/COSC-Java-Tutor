package src.week17;

import java.util.ArrayList;

public class AListAccess implements Runnable {

    final ArrayList<String> list;
    String name;

    AListAccess(String name, ArrayList<String> list) {
        this.list = list;
        this.name = name;
    }

    @Override
    public void run() {
        for (int i = 0; i < 10; i++) {
            synchronized (list) {
                list.add(name + " " + i);
            }

            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
