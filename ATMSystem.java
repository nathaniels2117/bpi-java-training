package ph.com.bpi.hello;

public class ATMSystem {

    public static double[] accounts = {10000, 15000, 20000};
    
    public static void main(String[] args) {

        System.out.println("=== ATM Withdrawal System ===\n");

        System.out.println("--- Test 1 : Valid Withdrawal ---\n");
        processWithdrawal("1", "5000");

        System.out.println("--- Test 2 : Invalid Amount Input ---\n");
        processWithdrawal("abc", "5000");

        System.out.println("--- Test 3 : Account Not Found ---\n");
        processWithdrawal("10", "5000"); 

        System.out.println("--- Test 4 : Insufficient Funds ---\n");
        processWithdrawal("1", "20000"); 

        System.out.println("=== All tests completed! ===\n");
    } 

    public static void processWithdrawal(String accountIndex, String amountInput) {

        try {
            int index = Integer.parseInt(accountIndex);
            double balance = accounts[index];
            double amount = Double.parseDouble(amountInput);

            System.out.printf("Account = %d, Amount = ₱%.2f%n", index, amount);
            System.out.printf("Current balance : ₱%.2f%n", balance);

            if (amount > balance) {
                System.out.printf("Insufficient funds! Cannot withdraw ₱%.2f%n \n", amount);
            } else {
                double newBalance = balance - amount;
                System.out.printf("Withdrawal : ₱%.2f%n", amount);
                System.out.printf("New balance: ₱%.2f%n", newBalance);
                System.out.println("Withdrawal successful!\n");
            }

        } catch (NumberFormatException e) {
        	System.out.println("Account = " + accountIndex + ", Amount = ₱" + amountInput);
            System.out.println("Error : Invalid input!");
            System.out.println("Please enter valid numbers.\n");
        } catch (ArrayIndexOutOfBoundsException e) {
        	System.out.println("Account = " + accountIndex + ", Amount = ₱" + amountInput);
            System.out.println("Error : Account not found!");
            System.out.println("Invalid account index.\n");
        } catch (Exception e) {
            System.out.println("Transaction failed");
        }
        
    } // end of processWithdrawal
}
