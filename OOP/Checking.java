package OOP;

public class Checking extends Account{
    
    public Checking(double money, String cur){
        super(money, cur);
        type = "Checking";
    }
}