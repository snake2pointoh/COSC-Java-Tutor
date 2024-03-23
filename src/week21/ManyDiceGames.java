package src.week21;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ManyDiceGames {

    private static final int GAME_NUM = 1;
    private static final int[] wins = new int[4];

    public static void main(String[] args) {
        ExecutorService executor = Executors.newFixedThreadPool(GAME_NUM);

        for (int i = 0; i < GAME_NUM; i++) {
            executor.execute(ManyDiceGames::gameThread);
        }

        executor.shutdown();
        while (!executor.isTerminated());

        for (int i = 0; i < wins.length; i++) {
            System.out.printf("player %d, won %d times\n", i+1, wins[i]);
        }

    }

    private static void gameThread() {
        int[] values = new int[4];

        Thread p1 = new Thread(() -> {
            playerThread(0, values);
        });

        Thread p2 = new Thread(() -> {
            playerThread(1, values);
        });

        Thread p3 = new Thread(() -> {
            playerThread(2, values);
        });

        Thread p4 = new Thread(() -> {
            playerThread(3, values);
        });

        p1.start();
        p2.start();
        p3.start();
        p4.start();

        try {
            p1.join();
            p2.join();
            p3.join();
            p4.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        int biggestIndex = 0;
        // check for winner
        for (int i = 0; i < values.length; i++) {
            if (values[i] > values[biggestIndex]) {
                biggestIndex = i;
            }
        }

        synchronized (wins) {
            wins[biggestIndex] += 1;
        }
    }


    private static void playerThread(int index, int[] values) {

        int rolls = (int)(Math.random()*10 + 1);
        int roll = 1;

        for (int i = 0; i < rolls; i++) {
            roll = (int)(Math.random()*6 + 1);;
        }

        synchronized (values) {
            values[index] = roll;
        }
    }
}
