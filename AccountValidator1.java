package ph.com.bpi.hello;

public class AccountValidator1 {

    public static void main(String[] args) {

        System.out.println("=== Account Number Validation Test ===\n");
        testValidation("1 : Valid account (1234567890)", "1234567890");
        testValidation("2 : Too short (123)", "123");
        testValidation("3 : Contains letters (12345ABC90)", "12345ABC90");
        testValidation("4 : Contains space (1234 567890)", "1234 567890");
        testValidation("5 : Null value", null);
        
    }

    public static void testValidation(String testName, String accountNumber) {
        System.out.println("Test " + testName);

        try {
            validateAccountNumber(accountNumber);
        } catch (InvalidAccountNumberException e) {
            System.out.println("Error : " + e.getMessage());
        } catch (InvalidAccountFormatException e) {
            System.out.println("Warning : " + e.getMessage());
        } catch (NullPointerException e) {
            System.out.println("Warning : " + e.getMessage());
        }
    }
    
    public static void validateAccountNumber(String accountNumber) throws InvalidAccountNumberException {

        if (accountNumber == null) {
            throw new NullPointerException("Account number cannot be null\n");
        }

        for (char c : accountNumber.toCharArray()) {
            if (!Character.isDigit(c)) {
                throw new InvalidAccountFormatException("Account number must contain only digits\n");
            }
        }

        if (accountNumber.length() != 10) {
            throw new InvalidAccountNumberException("Account number must be exactly 10 digits\n");
        }

        System.out.println("Valid account number : " + accountNumber + "\n");
    }
}
