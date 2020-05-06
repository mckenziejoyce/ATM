package OOP;
import java.util.Random;
import java.util.Calendar;


public class Account{
    private double money;
    private String curr; //Currency for USD, EUR, and JPY
    private String aNumber; //Account number
    protected String type;
    protected Calendar date;
    
    public Account(double m){
        money = m;
        aNumber = "";
        type = "Account";
        date =  Calendar.getInstance();

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

    public boolean equals(Account a){
      boolean ret = true;
      if(this.money != a.getBalance()){
        ret = false;
      }
      if(this.getAccountNumber() != a.getAccountNumber()){
        ret = false;
      }
      if(this.getType() != a.getType()){
        ret = false;
      }
      return ret;
    }
    
}
