package Lecture4_interfaces_abstract_classes;

/**
 * Class for depositing funds
 */
public class DepositTransaction extends concreteBaseTransaction {
    /**
     * constructor for this class
     * @param amount: the amount to deposit
     */
    public DepositTransaction(int amount){
        super(amount);
    }

    /**
     * check if the deposit amount is greater than zero
     * @throws IllegalArgumentException if the amount is less than 0
     */
    public void checkDepositAmount() {
        if (getAmount() <= 0) {
            throw new IllegalArgumentException("Deposit amount must be greater than zero.");
        }
    }

    /**
     * applies the deposit transaction to the passed account
     * @param account: the bank account to apply the deposit transaction to
     */
    @Override
    public void apply(BankAccount account) {
        checkDepositAmount();
        account.setBalance(account.getBalance() + getAmount());
        printTransactionDetails();
        System.out.println("New Balance: " + account.getBalance());
    }
}
