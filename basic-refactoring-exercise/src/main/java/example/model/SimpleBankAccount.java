package example.model;

/**
 * This class represent a particular instance of a BankAccount.
 * In particular, a Simple Bank Account allows always the deposit
 * while the withdrawal is allowed only if the balance greater or equal the withdrawal amount
 */
public class SimpleBankAccount implements BankAccount {

    private double balance;
    private final AccountHolder holder;
    private final double fee;

    private final static double DEFAULT_FEE=-1;

    public SimpleBankAccount(final AccountHolder holder, final double balance) {
        this(holder, balance, DEFAULT_FEE);
    }

    public SimpleBankAccount(final AccountHolder holder, final double balance, final double fee) {
        this.holder = holder;
        this.balance = balance;
        this.fee=fee;
    }

    @Override
    public AccountHolder getHolder(){
        return this.holder;
    }

    @Override
    public double getBalance() {
        return this.balance;
    }

    @Override
    public void deposit(final int userID, final double amount) {
        if (checkUser(userID)) {
            this.balance += amount;
        }
    }

    @Override
    public void withdraw(final int userID, final double amount) {
        if (checkUser(userID)) {
            if(isWithdrawAllowed(amount)) {
                this.balance -= amount + fee;
            }
            else{
                throw new IllegalArgumentException("Not enough balance on the account");
            }
        }
    }

    private boolean isWithdrawAllowed(final double amount){
        return this.balance >= amount+this.fee;
    }

    private boolean checkUser(final int id) {
        return this.holder.getId() == id;
    }
}
