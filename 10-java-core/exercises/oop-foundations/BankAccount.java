public class BankAccount {

    // static fields (shared by all accounts)
    private static String bankName = "MyBank";
    private static int totalAccounts = 0;
    private static int accountCounter = 1000;

    // instance fields (unique per account)
    private int accountNumber;
    private String holderName;
    private double balance;

    // constructor
    public BankAccount(String holderName, double balance) {
        this.holderName = holderName;
        this.balance = balance;
        this.accountNumber = ++accountCounter;
        totalAccounts++;
    }

    // static method
    public static String getBankInfo() {
        return bankName + " - Total Accounts: " + totalAccounts;
    }

    // instance methods
    public void deposit(double amount) {
        if (amount > 0) {
            balance += amount;
        }
    }

    public void withdraw(double amount) {
        if (amount > 0 && amount <= balance) {
            balance -= amount;
        }
    }

    public double getBalance() {
        return balance;
    }

    // main method for testing
    public static void main(String[] args) {
        BankAccount acc1 = new BankAccount("Alice", 1000);
        BankAccount acc2 = new BankAccount("Bob", 500);

        acc1.deposit(500);
        acc2.withdraw(200);

        System.out.println(BankAccount.getBankInfo());
        System.out.println("Alice Balance: " + acc1.getBalance());
        System.out.println("Bob Balance: " + acc2.getBalance());
    }
}
