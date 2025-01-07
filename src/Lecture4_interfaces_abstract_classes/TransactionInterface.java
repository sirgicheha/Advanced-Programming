package Lecture4_interfaces_abstract_classes;

/**
 * Lecture4_interfaces_abstract_classes.TransactionInterface
 * This interface defines the structure for any transaction-related class.
 * Any class implementing this interface must provide concrete implementations for the methods declared here.
 */
public interface TransactionInterface {

    /**
     * getAmount() Method
     * @return double
     * Returns the amount involved in the transaction
     * The method must be implemented by any class that represents a transaction
     */
    double getAmount();

    /**
     * getDate() Method
     * @return String
     * Returns the date and time of the transaction as a string
     * The method must be implemented by any class that represents a transaction
     * The format of the date is expected to be provided by the implementing class
     */
    String getDate();

    /**
     * getTransactionID() Method
     * @return String
     * Returns a unique identifier for the transaction
     * The method must be implemented by any class that represents a transaction
     * The transaction ID is expected to be unique for each transaction instance
     */
    String getTransactionID();

}


