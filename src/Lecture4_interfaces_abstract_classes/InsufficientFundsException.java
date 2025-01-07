package Lecture4_interfaces_abstract_classes;

/**
 * Lecture4_interfaces_abstract_classes.InsufficientFundsException Class
 * This exception is thrown when a withdrawal amount exceeds the available balance in a bank account.
 * It extends the `Exception` class to provide custom error messages for insufficient funds scenarios.
 */
public class InsufficientFundsException extends Exception{

    /**
     * InsufficientFundsException Constructor
     * @param message: a string containing the error message to be displayed when the exception is thrown
     * @return void
     * Initializes a new instance of the `InsufficientFundsException` class with the specified error message.
     * The message provides details about the insufficient funds error.
     */
    public InsufficientFundsException(String message) {
        super(message);
    }
}
