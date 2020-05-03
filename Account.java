public class Account{
    private double money;
    private String curr; //Currency for USD, EUR, and JPY
    
    public Account(double m, String c){
        money = m;
        curr = c;
    }

    public double getBalance(){
        return this.money;
    }

    public String getCurrency(){
        return this.curr;
    }

    public void withdraw(double amount){
        money -= amount;
    }

    public void deposit(double amount){
        money += amount;
    }

    //Converts the the first currency value to the second
    public static double exchangeRate(String cur1, String cur2, double amount){
        if(cur1.equals(cur2)){
            return amount;
        }
        else if(cur1.equals("USD") && cur2.equals("EUR")){
            amount = amount * 0.92;
        }
        else if(cur1.equals("EUR") && cur2.equals("USD")){
            amount = amount * 1.09;
        }
        else if(cur1.equals("USD") && cur2.equals("JPY")){
            amount = amount * 106.69;
        }
        else if(cur1.equals("JPY") && cur2.equals("USD")){
            amount = amount * 0.0094;
        }
        else if(cur1.equals("EUR") && cur2.equals("JPY")){
            amount = amount * 115.74;
        }
        else if(cur1.equals("JPY") && cur2.equals("EUR")){
            amount = amount * 0.0086;
        }
        return amount;
    }
}