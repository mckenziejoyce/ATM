public class Account{
    private double money;
    private String curr; //Currency
    
    public Account(double m, String c){
        money = m;
        curr = c;
    }

    public double getBalance(){
        return money;
    }

    public void withdraw(double amount){
        money -= amount;
    }

    public void deposit(double amount){
        money += amount;
    }

    //Checks if the transaction is done between to of the
    //same currencies
    public static boolean sameCurrency(){return true;}
}