package softTest;

public class BankAccount
{
    String AccountNumber;
    String AccountName;
    String ID;
    String Password;
    double TotalMoney;

    public BankAccount(String AccountNumber, String AccountName, String ID, String Password)
    {
        this.AccountNumber = AccountNumber;
        this.AccountName = AccountName;
        this.ID = ID;
        this.Password = Password;
    }

    public void Balance(String AccountNumber)
    {
        System.out.println("PLEASE FIND YOUR BALANCE INFORMATION");
        System.out.println("Account name:" + AccountName);
        System.out.println("Account number:" + AccountNumber);
        System.out.println("Your balance:" + TotalMoney);
    }

    public void Deposit(double AddMoney)
    {
        try {
            if(AddMoney < 0) throw new RuntimeException();
            this.TotalMoney += AddMoney;
        } catch(RuntimeException except) {
            System.out.println("Failed to deposite, money should be larger than 0");
        }
        System.out.println("Deposited money succeeded, the total money is:" + TotalMoney);
    }

    public void Withdraw(double GetMoney)
    {
        try
        {
            if(GetMoney > this.TotalMoney ) throw new RuntimeException();
            this.TotalMoney -= GetMoney;
            System.out.println("You have withdrawed money:" + GetMoney);
        }
        catch (RuntimeException except)
        {
            System.out.println("Error! you don't have enough balance");
        }
    }
}
