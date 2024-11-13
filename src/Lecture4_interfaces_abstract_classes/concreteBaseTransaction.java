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
     * @param amount is an integer
     * @param date
     */
    public concreteBaseTransaction(int amount)  {
        this.amount = amount;
        this.date = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date());
        this.transactionID = generateTransactionID();
    }

    /**
     * getAmount()
     * @return integer
     */
    @Override
    public double getAmount() {
        return amount; // Because we are dealing with Value types we need not worry about what we return
    }

    /**
     * getDate()
     * @return date Object
     */
    @Override
    public String getDate()
    {
        return date;
    }

    /**
     * getTransactionID()
     * @return transactionID
     */
    @Override
    public String getTransactionID()
    {
        return  transactionID;
    }

    /**
     * generateTransactionID
     * @return a unique transaction ID
     */
    protected String generateTransactionID()
    {
        return "TXN" + System.currentTimeMillis();
    }

    /**
     * Prints transaction details: transactionID, amount of transaction and date
     */
    public void printTransactionDetails()
    {
        System.out.println("Transaction ID: " + getTransactionID());
        System.out.println("Amount: " + getAmount());
        System.out.println("Date: " + getDate());
    };

    /**
     * Applies the transaction to the passed bank account
     * @param ba: the bank account to apply the transaction to
     */
    public void apply(BankAccount ba)
    {
        //Very ambiguous apply method to be well implemented in subclasses
        System.out.println("Transaction done successfully.");
    };
}
