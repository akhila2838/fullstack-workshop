public class SavingsAccount extends Account {
    private static final double INTEREST_RATE = 0.04; // 4% annually
    private static final double MIN_BALANCE = 100;

    public SavingsAccount(String holderName, double initialBalance) {
        super(holderName, initialBalance);
    }

    @Override
    public double calculateInterest() {
        return balance * INTEREST_RATE;
    }

    @Override
    public void withdraw(double amount) throws Exception {
        if (balance - amount >= MIN_BALANCE) {
            super.withdraw(amount);
        } else {
            System.out.println("Withdrawal failed: Balance cannot go below minimum $" + MIN_BALANCE);
        }
    }
}
