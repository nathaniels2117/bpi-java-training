package M4_Activity7;

public class M4Activity7 {

    public static void main(String[] args) {
    	BankAccount2 account = new BankAccount2();
    	BankAccount2.runTest(() -> account.deposit(5_000), "Deposit");
    	BankAccount2.runTest(() -> account.withdraw(3_000), "Withdrawal");
    	BankAccount2.runTest(() -> account.deposit(-500), "Deposit");
    	BankAccount2.runTest(() -> account.withdraw(20_000), "Withdrawal");
    	BankAccount2.runTest(() -> account.deposit(60_000), "Deposit");
    }
}
