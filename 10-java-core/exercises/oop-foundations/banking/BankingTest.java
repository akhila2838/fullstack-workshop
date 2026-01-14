public class BankingTest {
    public static void main(String[] args) {
        Bank bank = new Bank("MyBank");

        Account savings = new SavingsAccount("Alice", 1000);
        Account checking = new CheckingAccount("Bob", 500);
        Account fd = new FixedDepositAccount("Charlie", 10000);

        bank.addAccount(savings);
        bank.addAccount(checking);
        bank.addAccount(fd);

        // Deposit and Withdraw
        savings.deposit(500);
        try {
            checking.withdraw(800);  // Uses overdraft
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        System.out.println("Total deposits: $" + bank.getTotalDeposits());

        // Print interest for all accounts
        for (Account acc : bank.getAllAccounts()) {
            System.out.println(acc.getHolderName() + " interest: $" + acc.calculateInterest());
        }

        // Try withdrawing from FD
        try {
            fd.withdraw(1000);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
