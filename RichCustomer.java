import java.util.ArrayList;

public class RichCustomer extends Customer{
    private Security security;

    public RichCustomer(String n, Checking c, Saving s, double r, double u, ArrayList<String> t){
        super(n);
        checking = c;
        saving = s;
        transactions = t;
        realized = r;
        unrealized = u;
    }

    //Create the Security account by transferring money
    //or transfer money to already existing account
    public void transferSecurity(double amount, String cur, String account){
        if(this.security == null){
            this.security = new Security(amount, cur);
        }
        else{
            this.securityDeposit(amount);
        }

        if(account.equals("s")){
            this.savingWithdraw(amount);
        }
        else if(account.equals("c")){
            this.checkingWithdraw(amount);
        }
    }

    //Withdraw money from their Security Account
    public void securityWithdraw(double amount){
        this.checking.withdraw(amount);
        this.realized -= amount;
        this.transactions.add("Savings -" + amount);
    }

    //Deposit money into their security account
    public void securityDeposit(double amount){
        this.checking.deposit(amount);
        this.realized += amount;
        this.transactions.add("Savings -" + amount);
    }

    public void buyStock(){}

    public void sellStock(){}

}