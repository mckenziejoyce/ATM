
public class Customer {
    private double money;
    private String name;
    private Checking checking;
    private Saving saving;
    private Security security;

    public Customer(int m, String n){
        money = m;
        name = n;
    }

    public void makeSavingAccount(double cash){
        this.saving = new Saving(cash);
    }

    public void makeCheckingAccount(double cash){
        this.checking = new Checking(cash);
    }

    public void buyStock(){}

    public void sellStock(){}

}