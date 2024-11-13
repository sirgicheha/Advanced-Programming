package Lecture4_interfaces_abstract_classes;

/**
 * Throws an exception when an amount above the balance is tried to be withdrawn
 */
public class InsufficientFundsException extends Exception{
    public InsufficientFundsException(String message) {
        super(message);
    }
}
