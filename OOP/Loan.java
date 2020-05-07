package OOP;

public class Loan extends BankAction{
    private double interest;
    private boolean managerApprove;
    
    public Loan(double m, double i){
        super(m);
        interest = i;
        managerApprove = false;
    }

    public double getMoney(){
        return money;
    }

    public boolean getApproval(){
        return managerApprove;
    }

    public void approve(){
        managerApprove = true;
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