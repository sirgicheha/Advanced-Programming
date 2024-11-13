import Lecture4_interfaces_abstract_classes.BankAccount;
import Lecture4_interfaces_abstract_classes.DepositTransaction;
import Lecture4_interfaces_abstract_classes.WithdrawalTransaction;


public class Main {
    public static void main(String[] args) {
        BankAccount account = new BankAccount("acc1", 1000.0);

        // Testing Deposit
        DepositTransaction deposit = new DepositTransaction(200);
        deposit.apply(account);

        // Testing Withdrawal
        WithdrawalTransaction withdrawal = new WithdrawalTransaction(400);
        withdrawal.apply(account);

        //Testing Special Withdrawal
        WithdrawalTransaction withdrawal2 = new WithdrawalTransaction(1000);
        withdrawal2.apply(account);

        //Reversing the last withdrawal
        withdrawal.reverse(account);
    }

}