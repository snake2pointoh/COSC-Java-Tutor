package src.week6;

public class PairPrimes {
    public static void main(String[] args) {
        String listOfPairPrimes = getPairPrimes(19);

        System.out.println(listOfPairPrimes);
    }

    public static String getPairPrimes(int max) {
        String primePairs = "";

        int lastPrime = 0;
        int currentPrime = getNextPrime(0); // 2

        while (true) {
            // create a pair of primes to compare
            lastPrime = currentPrime;
            currentPrime = getNextPrime(currentPrime);

            // exit statement for the loop
            if(currentPrime > max) {
                break;
            }

            // compare the primes
            if(lastPrime == currentPrime-2) {
                primePairs += String.format("(%d,%d)", lastPrime, currentPrime);
            }
        }

        return primePairs;
    }

    public static int getNextPrime(int start) {
        int checkNum = start + 1;
        if(start < 1) {
            checkNum = 2;
        }

        while (!isPrime(checkNum)) {
            checkNum++;
        }

        return checkNum;
    }

    public static boolean isPrime(int number) {
        boolean isPrime = true;

        for (int i = 2; i < number; i++) {
            if(number%i == 0) {
                isPrime = false;
            }
        }

        return isPrime;
    }
}
