public class Account{
    private double money;
    
    public Account(double m){
        money = m;
    }

    public double getMoney(){
        return money;
    }

    public void withdraw(int amount){
        money -= amount;
    }

    public void deposit(int amount){
        money += amount;
    }
}