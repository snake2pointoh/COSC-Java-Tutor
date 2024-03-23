package src.week21;

import java.util.ArrayList;
import java.util.Random;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ThreadedGame {

    static final int THREADS = 1000;

    private static ArrayList<GameResult> scoreList = new ArrayList<>();

    public static void main(String[] args) {
        ExecutorService executor = Executors.newFixedThreadPool(THREADS);

        for (int i = 0; i < THREADS; i++) {
            final int num = i;

            executor.execute(() -> {
                gameThread("threadNo:" + num, scoreList);
            });
        }

        executor.shutdown();
        while (!executor.isTerminated());

        for ( GameResult result : scoreList ) {
            System.out.printf("The game: %s, had a value of: %d\n", result.getGameName(), result.getGameScore());
        }

        System.out.println("\n"+scoreList.size());
    }

    // roll two dice,
    // add the dice to the total,
    // end the game when the dice are the same value
    private static void gameThread(String gameName, ArrayList<GameResult> results) {
        boolean isGameOver = false;
        int gameScore = 0;

        Random rand = new Random();

        while (!isGameOver) {
            int die1 = rand.nextInt(1,7);
            int die2 = rand.nextInt(1,7);

            gameScore += (die1 + die2);

            if(die1 == die2) {
                isGameOver = true;
            }

        }

        // limits access the results object to only ONE thread
        synchronized (results) {
            results.add(new GameResult(gameName, gameScore));
        }

        // same as above, but locks on the method not an object
//        addToList(new GameResult(gameName, gameScore));
    }


    private static synchronized void addToList(GameResult gameResult) {
        scoreList.add(gameResult);
    }
}
