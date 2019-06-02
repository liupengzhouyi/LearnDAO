package softTest;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class BankAccountGoldTest {

    private String AccountNumber;
    private String AccountName;
    private String ID;
    private String Password;
    private double TotalMoney;

    private BankAccountGold bankAccountGold = null;

    public void init() {
        this.setAccountNumber("14747219744");
        this.setAccountName("liupeng");
        this.setID("1000231");
        this.setPassword("123456");
        this.setTotalMoney(123.56);
    }

    public String getAccountNumber() {
        return AccountNumber;
    }

    public void setAccountNumber(String accountNumber) {
        AccountNumber = accountNumber;
    }

    public String getAccountName() {
        return AccountName;
    }

    public void setAccountName(String accountName) {
        AccountName = accountName;
    }

    public String getID() {
        return ID;
    }

    public void setID(String ID) {
        this.ID = ID;
    }

    public String getPassword() {
        return Password;
    }

    public void setPassword(String password) {
        Password = password;
    }

    public double getTotalMoney() {
        return TotalMoney;
    }

    public void setTotalMoney(double totalMoney) {
        TotalMoney = totalMoney;
    }

    public BankAccountGold getBankAccountGold() {
        return bankAccountGold;
    }

    public void setBankAccountGold(BankAccountGold bankAccountGold) {
        this.bankAccountGold = bankAccountGold;
    }

    @Before
    public void setUp() throws Exception {
        this.init();
        this.bankAccountGold = new BankAccountGold(this.getAccountNumber(), this.getAccountName(), this.getID(), this.getPassword());
    }

    @After
    public void tearDown() throws Exception {
    }

    @Test
    public void balance() {
        this.getBankAccountGold().Balance("14747219744");
    }

    @Test
    public void deposit() {
        this.getBankAccountGold().Deposit(123.34);
    }

    @Test
    public void withdraw() {
        this.getBankAccountGold().Withdraw(123.45);
    }

    @Test
    public void withdraw1() {
        this.getBankAccountGold().Withdraw(123.45, 123);
        this.getBankAccountGold().Withdraw(123.45, 0);
        this.getBankAccountGold().Withdraw(123.45, -1);
    }
}