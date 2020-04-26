
public class RichCustomer extends Customer{
    private Checking checking;
    private Saving saving;
    private Security security;

    public RichCustomer(String n, Checking c, Saving s){
        super(n);
        checking = c;
        saving = s;
    }

    public void securityWithdraw(int amount){
        this.checking.withdraw(amount);
    }

    public void securitydeposit(int amount){
        this.checking.deposit(amount);
    }

    public void buyStock(){}

    public void sellStock(){}

}