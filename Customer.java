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

    public void savingWithdraw(int amount){
        this.saving.withdraw(amount);
    }

    public void savingdeposit(int amount){
        this.saving.deposit(amount);
    }

    public void checkingWithdraw(int amount){
        this.checking.withdraw(amount);
    }

    public void checkingdeposit(int amount){
        this.checking.deposit(amount);
    }

}