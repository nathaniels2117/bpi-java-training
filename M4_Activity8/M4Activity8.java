package M4_Activity8;

public class M4Activity8 {

    public static void main(String[] args) {
    	BankAccount3 account = new BankAccount3();
    	BankAccount3.runTest(() -> account.deposit(5_000), "Deposit");
    	BankAccount3.runTest(() -> account.withdraw(3_000), "Withdrawal");
    	BankAccount3.runTest(() -> account.deposit(-500), "Deposit");
    	BankAccount3.runTest(() -> account.withdraw(20_000), "Withdrawal");
    	BankAccount3.runTest(() -> account.deposit(60_000), "Deposit");
    }
}
