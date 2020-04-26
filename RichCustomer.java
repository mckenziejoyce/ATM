import java.util.ArrayList;

public class RichCustomer extends Customer{
    private Checking checking;
    private Saving saving;
    private Security security;
    private ArrayList<String> transactions;
    private double realized;
    private double unrealized;

    public RichCustomer(String n, Checking c, Saving s, double r, double u, ArrayList<String> t){
        super(n);
        checking = c;
        saving = s;
        transactions = t;
        realized = r;
        unrealized = u;
    }

    public void securityWithdraw(int amount){
        this.checking.withdraw(amount);
        this.realized -= amount;
        this.transactions.add("Savings -" + amount);
    }

    public void securitydeposit(int amount){
        this.checking.deposit(amount);
        this.realized += amount;
        this.transactions.add("Savings -" + amount);
    }

    public void buyStock(){}

    public void sellStock(){}

}