public class CheckingAccount extends Account {
    private static final double OVERDRAFT_LIMIT = 500;

    public CheckingAccount(String holderName, double initialBalance) {
        super(holderName, initialBalance);
    }

    @Override
    public double calculateInterest() {
        return 0; // No interest
    }

    @Override
    public void withdraw(double amount) throws Exception {
        if (amount <= balance + OVERDRAFT_LIMIT) {
            balance -= amount;
            System.out.println("Withdrew $" + amount + " from account " + accountNumber);
        } else {
            throw new Exception("Withdrawal exceeds overdraft limit");
        }
    }
}
