public class FixedDepositAccount extends Account {
    private static final double INTEREST_RATE = 0.07; // 7% annually
    private static final int LOCK_PERIOD_MONTHS = 12;

    public FixedDepositAccount(String holderName, double initialBalance) {
        super(holderName, initialBalance);
    }

    @Override
    public double calculateInterest() {
        return balance * INTEREST_RATE;
    }

    @Override
    public void withdraw(double amount) throws Exception {
        throw new Exception("Withdrawals not allowed until lock period of " + LOCK_PERIOD_MONTHS + " months");
    }
}
