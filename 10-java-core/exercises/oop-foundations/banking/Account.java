public abstract class Account {
    private static int nextAccountNumber = 1000; // static account number generator

    protected int accountNumber;
    protected String holderName;
    protected double balance;

    public Account(String holderName, double initialBalance) {
        this.accountNumber = nextAccountNumber++;
        this.holderName = holderName;
        this.balance = initialBalance;
    }

    // Abstract method
    public abstract double calculateInterest();

    // Concrete methods
    public void deposit(double amount) {
        if (amount > 0) {
            balance += amount;
            System.out.println("Deposited $" + amount + " to account " + accountNumber);
        } else {
            System.out.println("Deposit amount must be positive");
        }
    }

    public void withdraw(double amount) throws Exception {
        if (amount <= balance) {
            balance -= amount;
            System.out.println("Withdrew $" + amount + " from account " + accountNumber);
        } else {
            throw new Exception("Insufficient balance");
        }
    }

    public double getBalance() {
        return balance;
    }

    public int getAccountNumber() {
        return accountNumber;
    }

    public String getHolderName() {
        return holderName;
    }
}
