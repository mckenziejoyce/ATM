package OOP;

public class Transactions extends BankAction{
    private String name; //Name of transaction

    public Transactions(String n, double m){
        super(m);
        name = n;
    }

    public Transactions(String n){
        name = n;
    }

    public String getName(){
        return name;
    }
    
}