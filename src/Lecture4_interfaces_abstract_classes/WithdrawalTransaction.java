package Lecture4_interfaces_abstract_classes;

/**
 * Represents a withdrawal transaction in the banking system.
 */
public class WithdrawalTransaction extends concreteBaseTransaction {
    /**
     * Constructs a Withdrawal transaction  with the specified amount.
     *
     * @param amount the amount to withdraw
     */
    public WithdrawalTransaction(int amount) {
        super(amount);
    }

    /**
     * Checks if the withdrawal amount is valid and if there are sufficient funds.
     *
     * @param account the bank account to check
     * @throws InsufficientFundsException if there are insufficient funds for the withdrawal
     * @throws IllegalArgumentException if the withdrawal amount is less than or equal to zero
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
     * Applies the withdrawal transaction to the specified bank account.
     *
     * @param account the bank account to apply the withdrawal to
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
     * Reverses the withdrawal transaction, restoring the withdrawn amount to the bank account.
     *
     * @param account the bank account to reverse the withdrawal on
     */
    public void reverse(BankAccount account) {
        account.setBalance(account.getBalance() + getAmount());
        System.out.println("Withdrawal reversed. New Balance: " + account.getBalance());
    }
}
// Reverse doesn't really work when the amount requested for withdrawal is more than the balance

