package Lecture4_interfaces_abstract_classes;
import java.util.Date;
import java.text.SimpleDateFormat;

/**
 * This class acts as the backbone of all transactions with common methods and properties
 */
class concreteBaseTransaction implements TransactionInterface {

    private final int amount;
    private final String date;
    private final String transactionID;

    /**
     * Lecture4_interfaces_abstract_classes.concreteBaseTransaction Constructor
     * @param amount: an integer representing the amount involved in the transaction
     * @return void
     * Initializes the fields `amount`, `date`, and `transactionID`
     * The `date` is automatically set to the current date and time in "yyyy-MM-dd HH:mm:ss" format
     * The `transactionID` is generated using the `generateTransactionID` method
     */
    public concreteBaseTransaction(int amount)  {
        this.amount = amount;
        this.date = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date());
        this.transactionID = generateTransactionID();
    }

    /**
     * getAmount() Method
     * @return integer
     * Returns the transaction amount
     * Ensures immutability by returning the original amount
     */
    @Override
    public double getAmount() {
        return amount; // Because we are dealing with Value types we need not worry about what we return
    }

    /**
     * getDate() Method
     * @return String
     * Returns the transaction date as a formatted string
     * The format used is "yyyy-MM-dd HH:mm:ss"
     */
    @Override
    public String getDate()
    {
        return date;
    }

    /**
     * getTransactionID() Method
     * @return String
     * Returns the unique transaction ID for this transaction
     * The ID is generated automatically upon instantiation using the `generateTransactionID` method
     */
    @Override
    public String getTransactionID()
    {
        return  transactionID;
    }

    /**
     * generateTransactionID() Method
     * @return String
     * Generates a unique transaction ID by appending the current system time in milliseconds to the prefix "TXN"
     * Ensures that each transaction has a distinct identifier
     */
    protected String generateTransactionID()
    {
        return "TXN" + System.currentTimeMillis();
    }

    /**
     * printTransactionDetails() Method
     * @return void
     * Prints the details of the transaction, including:
     * - Transaction ID
     * - Amount
     * - Date
     */
    public void printTransactionDetails()
    {
        System.out.println("Transaction ID: " + getTransactionID());
        System.out.println("Amount: " + getAmount());
        System.out.println("Date: " + getDate());
    };

    /**
     * apply(BankAccount ba) Method
     * @param ba: a BankAccount object to which the transaction is applied
     * @return void
     * This method applies the transaction to the specified bank account
     * The implementation is left for subclasses to define specific behavior
     * Prints a confirmation message indicating the transaction was successful
     */
    public void apply(BankAccount ba)
    {
        //Very ambiguous apply method to be well implemented in subclasses
        System.out.println("Transaction done successfully.");
    };
}
