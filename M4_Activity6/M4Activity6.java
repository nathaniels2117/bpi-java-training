package M4_Activity6;

public class M4Activity6 {

    public static void main(String[] args) {
        BankAccount1 account = new BankAccount1();
        BankAccount1.runTest(() -> account.deposit(5_000), "Deposit");
        BankAccount1.runTest(() -> account.withdraw(3_000), "Withdrawal");
        BankAccount1.runTest(() -> account.deposit(-500), "Deposit");
        BankAccount1.runTest(() -> account.withdraw(20_000), "Withdrawal");
        BankAccount1.runTest(() -> account.deposit(60_000), "Deposit");
    }
}
