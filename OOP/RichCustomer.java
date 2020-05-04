package OOP;
import java.util.ArrayList;

public class RichCustomer extends Customer{
    private Security security;
    protected ArrayList<Stock> stocks; 

    public RichCustomer(String n, Checking c, Saving s, double r, double u, ArrayList<String> t){
        super(n);
        checking = c;
        saving = s;
        transactions = t;
        realized = r;
        unrealized = u;
        stocks = new ArrayList<Stock>();
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

        this.withdraw(amount, account);
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

    public String accountInfo(){
        String ret = super.accountInfo();

        if(this.security != null){
            ret += ("Security " + security.getAccountNumber() + " - " + "Balance " + security.getBalance()+"/n");
        }

        return ret;
    }
}