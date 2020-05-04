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

    public String getMonth(){
        int month = this.date.get(Calendar.MONTH);
        String ret = "";

        if(month == 0){
            ret = "January";
        }
        else if(month == 1){
            ret = "February";
        }
        else if(month == 2){
            ret = "March";
        }
        else if(month == 3){
            ret = "April";
        }
        else if(month == 4){
            ret = "May";
        }
        else if(month == 5){
            ret = "June";
        }
        else if(month == 6){
            ret = "July";
        }
        else if(month == 7){
            ret = "August";
        }
        else if(month == 8){
            ret = "September";
        }
        else if(month == 9){
            ret = "October";
        }
        else if(month == 10){
            ret = "November";
        }
        else if(month == 11){
            ret = "December";
        }

        return ret;
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