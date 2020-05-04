package OOP;
import java.util.Calendar;

public class Loan {
    private double money;
    private double interest;
    private Calendar date;

    public Loan(double m, double i){
        money = m;
        interest = i;
        date = Calendar.getInstance();
    }

    public double getMoney(){
        return money;
    }

    public void setMoney(double m){
        money = m;
    }

    public void increaseLoan(){
        money += money*interest;
    }

    public void decreaseLoan(double m){
        money -= m;
    }

    public boolean monthPass(){
        Calendar newDate = Calendar.getInstance();

        if(this.date.get(Calendar.MONTH) < newDate.get(Calendar.MONTH) && this.date.get(Calendar.DATE) <= newDate.get(Calendar.DATE)){
            this.date = newDate;
            return true;
        }
        else{ 
            return false;
        }
    }

}