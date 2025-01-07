package Lecture4_interfaces_abstract_classes;

/**
 * Represents a withdrawal transaction in the banking system.
 */
public class WithdrawalTransaction extends concreteBaseTransaction {
    /**
     * Lecture4_interfaces_abstract_classes.WithdrawalTransaction Constructor
     * @param amount: the amount to withdraw (must be a positive integer)
     * @return void
     * Initializes the `WithdrawalTransaction` object by calling the `concreteBaseTransaction` constructor
     * The `amount` parameter is passed to the superclass to initialize common transaction attributes
     */
    public WithdrawalTransaction(int amount) {
        super(amount);
    }

    /**
     * checkWithdrawalAmount(BankAccount account) Method
     * @param account: the bank account to check for sufficient funds
     * @return void
     * Validates the withdrawal amount and checks if the account has sufficient funds
     * @throws IllegalArgumentException if the withdrawal amount is less than or equal to zero
     * @throws InsufficientFundsException if the withdrawal amount exceeds the available account balance
     * Ensures that the withdrawal is valid and that there are sufficient funds in the account
     */
    public void checkWithdrawalAmount(BankAccount account) throws InsufficientFundsException {
        if (getAmount() <= 0) {
            throw new IllegalArgumentException("Withdrawal amount must be greater than zero.");
        }
        if (getAmount() > account.getBalance()) {
            throw new InsufficientFundsException("Insufficient funds for withdrawal. Available balance: " + account.getBalance());
        }
    }

    /**
     * apply(BankAccount account) Method
     * @param account: the bank account to apply the withdrawal to
     * @return void
     * Applies the withdrawal transaction to the specified bank account
     * Steps:
     * 1. Calls `checkWithdrawalAmount()` to validate the withdrawal
     * 2. Deducts the withdrawal amount from the account balance
     * 3. Prints transaction details, including transaction ID, amount, and date
     * 4. Prints the new balance of the bank account
     * If the withdrawal amount exceeds the available balance:
     * - Withdraws all available funds
     * - Prints the amount not available for withdrawal
     * - Sets the account balance to zero
     */
    @Override
    public void apply(BankAccount account) {
        try {
            checkWithdrawalAmount(account);
            account.setBalance(account.getBalance() - getAmount());
            printTransactionDetails();
            System.out.println("New Balance: " + account.getBalance());
        } catch (InsufficientFundsException e) {
            System.out.println("Withdrawal failed: " + e.getMessage());

            // If the withdrawal amount is greater than the balance, withdraw all available funds
            double availableBalance = account.getBalance();
            account.setBalance(0);
            double amountNotAvailable = getAmount() - availableBalance;

            printTransactionDetails();
            System.out.println("Withdrew all available funds: " + availableBalance);
            System.out.println("Amount not available for withdrawal: " + amountNotAvailable);
            System.out.println("New Balance: " + account.getBalance());
        } catch (IllegalArgumentException e) {
            System.out.println("Withdrawal failed: " + e.getMessage());
        }
    }

    /**
     * reverse(BankAccount account) Method
     * @param account: the bank account to reverse the withdrawal on
     * @return void
     * Reverses the withdrawal by restoring the withdrawn amount to the bank account balance
     * Prints a confirmation message with the updated balance
     * Note: The reverse operation may not fully restore funds if the withdrawal amount exceeds the original account balance
     */
    public void reverse(BankAccount account) {
        account.setBalance(account.getBalance() + getAmount());
        System.out.println("Withdrawal reversed. New Balance: " + account.getBalance());
    }
}
// Reverse doesn't really work when the amount requested for withdrawal is more than the balance

