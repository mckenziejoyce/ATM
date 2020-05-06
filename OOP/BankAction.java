package OOP;
import java.util.Calendar;

public class BankAction {
    protected double money;
    protected Calendar date;
    protected Calendar paymentDate; //The date that keep tracks of last payment

    public BankAction(){
        date = Calendar.getInstance();
        paymentDate = Calendar.getInstance();
    }

    public BankAction(double m){
        money = m;
        date = Calendar.getInstance();
        paymentDate = Calendar.getInstance();
    }

    public double getMoney(){
        return money;
    }

    public void setMoney(double m){
        money = m;
    }

    public int getYear(){
        return this.date.get(Calendar.YEAR);
    }

    public int getDay(){
        return this.date.get(Calendar.DATE);
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

    public boolean monthPass(){
        Calendar newDate = Calendar.getInstance();

        if(this.date.get(Calendar.MONTH) < newDate.get(Calendar.MONTH) && this.date.get(Calendar.DATE) <= newDate.get(Calendar.DATE)){
            this.paymentDate = newDate;
            return true;
        }
        else{ 
            return false;
        }
    }
}