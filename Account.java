public class Account{
    private double money;
    
    public Account(double m){
        money = m;
    }

    public double getMoney(){
        return money;
    }

    public void withdraw(double amount){
        money -= amount;
    }

    public void deposit(double amount){
        money += amount;
    }
}