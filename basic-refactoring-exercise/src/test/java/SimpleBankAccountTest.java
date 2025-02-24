import example.model.AccountHolder;
import example.model.BankAccount;
import example.model.SimpleBankAccount;

import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;

/**
 * The test suite for testing the SimpleBankAccount implementation
 */
class SimpleBankAccountTest {

    private AccountHolder accountHolder;
    private BankAccount bankAccount;
    private final int WRONG_USER_ID =2;
    private final int INITIAL_BALANCE=100;
    private final int WITHDRAW_AMOUNT=50;

    @BeforeEach
    void beforeEach(){
        accountHolder = new AccountHolder("Mario", "Rossi", 1);
        bankAccount = new SimpleBankAccount(accountHolder, 0);
    }

    @Test
    void testInitialBalance() {
        assertEquals(0, bankAccount.getBalance());
    }

    void depositInitialBalance(){
        bankAccount.deposit(accountHolder.getId(), INITIAL_BALANCE);
    }

    @Test
    void testDeposit() {
        depositInitialBalance();
        assertEquals(INITIAL_BALANCE, bankAccount.getBalance());
    }

    @Test
    void testWrongDeposit() {
        depositInitialBalance();
        bankAccount.deposit(WRONG_USER_ID, WITHDRAW_AMOUNT);
        assertEquals(INITIAL_BALANCE, bankAccount.getBalance());
    }

    @Test
    void testWithdraw() {
        depositInitialBalance();
        bankAccount.withdraw(accountHolder.getId(), WITHDRAW_AMOUNT);
        assertEquals(INITIAL_BALANCE-WITHDRAW_AMOUNT, bankAccount.getBalance());
    }

    @Test
    void testWrongWithdraw() {
        depositInitialBalance();
        bankAccount.withdraw(WRONG_USER_ID, WITHDRAW_AMOUNT);
        assertEquals(INITIAL_BALANCE, bankAccount.getBalance());
    }
}
