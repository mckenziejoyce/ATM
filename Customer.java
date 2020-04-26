import java.util.ArrayList;

public class Customer {
    private String name;
    private Checking checking;
    private Saving saving;
    private ArrayList<String> transactions;
    private double realized; //Realized profit
    private double unrealized; //Unrealized profit

    public Customer(String n){
        name = n;
        transactions = new ArrayList<String>();
        realized = 0;
        unrealized = 0;
    }

    public double getRealizedProfit(){
        return realized;
    }

    public double getUnrealizedProfit(){
        return unrealized;
    }

    public void makeSavingAccount(double cash){
        this.saving = new Saving(cash);
    }

    public void makeCheckingAccount(double cash){
        this.checking = new Checking(cash);
    }

    public void savingWithdraw(double amount){
        this.saving.withdraw(amount);
        this.realized -= amount;
        this.transactions.add("Savings -" + amount);
    }

    public void savingdeposit(double amount){
        this.saving.deposit(amount);
        this.realized += amount;
        this.transactions.add("Savings +" + amount);
    }

    public void checkingWithdraw(double amount){
        this.checking.withdraw(amount);
        this.realized -= amount;
        this.transactions.add("Checking -" + amount);
    }

    public void checkingdeposit(double amount){
        this.checking.deposit(amount);
        this.realized += amount;
        this.transactions.add("Checking +" + amount);
    }

}