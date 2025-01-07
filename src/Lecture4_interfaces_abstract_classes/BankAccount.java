package Lecture4_interfaces_abstract_classes;
/**
 * Lecture4_interfaces_abstract_classes.BankAccount Class
 * Represents a bank account with an account number and a balance.
 * This class provides methods to get and set the account balance and retrieve the account number.
 */
public class BankAccount {
    private String accountNumber;
    private double balance;

    /**
     * BankAccount Constructor
     * @param accountNumber: a string representing the unique account number
     * @param balance: a double representing the initial balance of the account
     * @return void
     * Initializes a new instance of the `BankAccount` class with the specified account number and initial balance
     * Ensures that each bank account has a unique account number and an initial balance
     */
    public BankAccount(String accountNumber, double balance)
    {
        this.accountNumber = accountNumber;
        this.balance = balance;
    }

    /**
     * getBalance() Method
     * @return double
     * Returns the current balance of the bank account
     * Ensures that the balance is accurately retrieved when queried
     */
    public double getBalance()
    {
        return balance;
    }

    /**
     * setBalance(double balance) Method
     * @param balance: a double representing the new balance to be set
     * @return void
     * Updates the balance of the bank account to the specified amount
     * Allows the balance to be modified based on transactions (deposits, withdrawals, etc.)
     */
    public void setBalance(double balance)
    {
        this.balance = balance;
    }

    /**
     * getAccountNumber() Method
     * @return String
     * Returns the account number of the bank account
     * Ensures that the account number can be retrieved when needed
     * The account number uniquely identifies the bank account
     */
    public String getAccountNumber() {
        return accountNumber;
    }
}
