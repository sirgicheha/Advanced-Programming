package Lecture4_interfaces_abstract_classes;
/**
 * Represents a bank account
 */
public class BankAccount {
    private String accountNumber;
    private double balance;

    /**
     * Constructs a BankAccount with the specified account number and initial balance.
     * @param accountNumber the account number
     * @param balance the initial balance
     */
    public BankAccount(String accountNumber, double balance)
    {
        this.accountNumber = accountNumber;
        this.balance = balance;
    }

    /**
     * Returns the current balance of the account.
     * @return the account balance
     */
    public double getBalance()
    {
        return balance;
    }

    /**
     * Sets the balance of the account.
     *
     * @param balance the new balance
     */
    public void setBalance(double balance)
    {
        this.balance = balance;
    }

    /**
     * Returns the account number.
     *
     * @return the account number
     */
    public String getAccountNumber() {
        return accountNumber;
    }
}
