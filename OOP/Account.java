package OOP;
import java.util.Random;


public class Account{
    private double money;
    private String curr; //Currency for USD, EUR, and JPY
    private String aNumber; //Account number
    protected String type;
    
    public Account(double m){
        money = m;
        aNumber = "";
        type = "Account";

        Random rand = new Random();
        for(int i =0; i<9; i++){
            aNumber += rand.nextInt(10);
        }
    }

    public double getBalance(){
        return this.money;
    }

    public void setBalance(double balance){
        this.money = balance;
    }

    public String getAccountNumber(){
        return aNumber;
    }

    public String getCurrency(){
        return this.curr;
    }

    public String getType(){
        return type;
    }

    public void withdraw(double amount){
        money -= amount;
    }

    public void deposit(double amount){
        money += amount;
    }
}