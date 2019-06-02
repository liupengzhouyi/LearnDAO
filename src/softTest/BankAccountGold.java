package softTest;

class BankAccountGold extends BankAccount
{
    public BankAccountGold(String AccountNumber, String AccountName, String ID, String Password)
    {
        super(AccountNumber,AccountName,ID,Password);
    }

    public void Withdraw(double GetMoney, double overdraft)
    {
        overdraft = this.TotalMoney - GetMoney;
        if(overdraft > 0)
        {
            this.TotalMoney = overdraft;
            System.out.println("Succeeded to withdraw. your balance is" + this.TotalMoney);
        }
        else if((overdraft < 0)&&(overdraft > -1000))
        {
            this.TotalMoney = overdraft + overdraft * 0.05; // The interest is 5% of the overdraft
            System.out.println("Succeeded to withdraw. your balance is" + this.TotalMoney);
        }
        else
        {
            System.out.println("Failed to withdraw, you can not overdraft more than 1000!");
        }
    }
}
