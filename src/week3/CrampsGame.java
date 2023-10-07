package src.week3;

public class CrampsGame {
    public static void main(String[] args) {

        int previousRoll = 0;

        while (true) {
            // roll 2 dice and add the values
            int diceVal = roll2Dice();
            System.out.println("Roll was " + diceVal);

            // if the values are 7 or 11 then you loose
            if (didLose(diceVal)) {
                System.out.println("You Lose!");
                break;
            }

            // if you roll the same sum 2 times in a row you win
            if(previousRoll == diceVal)
            {
                System.out.println("You Win!");
                break;
            }
            // if not roll again
            previousRoll = diceVal;
        }

    }
    public static boolean didLose(int diceValue)
    {
        if(diceValue == 7 || diceValue == 11)
        {
            return true;
        }
        return false;
    }

    public static int roll2Dice()
    {
        int die1 = (int)(Math.random() * 6) + 1;
        int die2 = (int)(Math.random() * 6) + 1;

        return die1 + die2;
    }

}
