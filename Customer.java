import java.util.ArrayList;

public class Customer {
    private String name;
    private Checking checking;
    private Saving saving;
    private ArrayList<String> transactions;

    public Customer(String n){
        name = n;
        transactions = new ArrayList<String>();
    }

    public void makeSavingAccount(double cash){
        this.saving = new Saving(cash);
    }

    public void makeCheckingAccount(double cash){
        this.checking = new Checking(cash);
    }

    public void savingWithdraw(double amount){
        this.saving.withdraw(amount);
        this.transactions.add("Savings -" + amount);
    }

    public void savingdeposit(double amount){
        this.saving.deposit(amount);
        this.transactions.add("Savings +" + amount);
    }

    public void checkingWithdraw(double amount){
        this.checking.withdraw(amount);
        this.transactions.add("Checking -" + amount);
    }

    public void checkingdeposit(double amount){
        this.checking.deposit(amount);
        this.transactions.add("Checking +" + amount);
    }

}