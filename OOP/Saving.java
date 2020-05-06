package OOP;
public class Saving extends Account{
    private boolean main; //Checks to see if main saving account

    public Saving(double money, boolean m){
        super(5000);
        main = m;
        type = "Savings";
    }

    public boolean isMain(){
        return main;
    }


}