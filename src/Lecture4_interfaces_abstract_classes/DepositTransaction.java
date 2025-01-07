package Lecture4_interfaces_abstract_classes;

/**
 * Class for depositing funds
 */
public class DepositTransaction extends concreteBaseTransaction {
    /**
     * Lecture4_interfaces_abstract_classes.DepositTransaction Constructor
     * @param amount: the amount to deposit (must be a positive integer)
     * @return void
     * Initializes the `DepositTransaction` object by calling the `concreteBaseTransaction` constructor
     * The `amount` parameter is passed to the superclass to initialize common transaction attributes
     */
    public DepositTransaction(int amount){
        super(amount);
    }

    /**
     * checkDepositAmount() Method
     * @return void
     * Validates that the deposit amount is greater than zero
     * @throws IllegalArgumentException if the deposit amount is less than or equal to zero
     * Ensures that only valid deposit amounts are processed
     */
    public void checkDepositAmount() {
        if (getAmount() <= 0) {
            throw new IllegalArgumentException("Deposit amount must be greater than zero.");
        }
    }

    /**
     * apply(BankAccount account) Method
     * @param account: the bank account to apply the deposit transaction to
     * @return void
     * Applies the deposit to the specified bank account
     * Steps:
     * 1. Calls `checkDepositAmount()` to ensure the deposit amount is valid
     * 2. Increases the bank account balance by the deposit amount
     * 3. Prints transaction details, including transaction ID, amount, and date
     * 4. Prints the new balance of the bank account
     */
    @Override
    public void apply(BankAccount account) {
        checkDepositAmount();
        account.setBalance(account.getBalance() + getAmount());
        printTransactionDetails();
        System.out.println("New Balance: " + account.getBalance());
    }
}
