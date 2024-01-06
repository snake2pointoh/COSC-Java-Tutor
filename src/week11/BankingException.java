package src.week11;

public class BankingException {
    private static double balance = 100.0;

    public static void main(String[] args) {

        System.out.printf("Before Withdraw %.2f\n", balance);

        try {
            withdraw(120.0);

        } catch (Exception e) {
            e.printStackTrace();
        }

        System.out.printf("After Withdraw %.2f\n", balance);
    }

    private static void withdraw(double value) throws Exception {
        if(value > balance) {
            throw new Exception("Invalid Withdraw Amount");
        }

        balance -= value;
    }
}
