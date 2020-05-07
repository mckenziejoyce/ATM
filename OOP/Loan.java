package OOP;

public class Loan extends BankAction{
    private double interest;
    
    public Loan(double m, double i){
        super(m);
        interest = i;
    }

    public double getMoney(){
        return money;
    }

    public void setMoney(double m){
        money = m;
    }

    public void increaseLoan(){
        this.money += this.money*interest;
    }

    public void decreaseLoan(double m){
        this.money -= m;
    }

}