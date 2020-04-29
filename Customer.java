import java.util.ArrayList;

public class Customer {
    protected String name;
    protected Checking checking;
    protected  Saving saving;
    protected  ArrayList<String> transactions; 
    protected  double realized; //Realized profit
    protected  double unrealized; //Unrealized profit
    protected  double loan; //The loan still left for the customer to pay

    public Customer(String n){
        name = n;
        transactions = new ArrayList<String>();
        realized = 0;
        unrealized = 0;
    }

    public double getLoan(){
        return loan;
    }

    public double getRealizedProfit(){
        return realized;
    }

    public double getUnrealizedProfit(){
        return unrealized;
    }

    //Customer creates a Savings account
    public void makeSavingAccount(double cash, String cur){
        this.saving = new Saving(cash, cur);
    }

    //Customer creates a Checkings account
    public void makeCheckingAccount(double cash, String cur){
        this.checking = new Checking(cash, cur);
    }

    //Withdrawal from the savings account
    public void savingWithdraw(double amount){
        this.saving.withdraw(amount);
        this.realized -= amount;
        this.transactions.add("Savings -" + amount);
    }

    //Deposit from the savings account
    public void savingdeposit(double amount){
        this.saving.deposit(amount);
        this.realized += amount;
        this.transactions.add("Savings +" + amount);
    }

    //Taking out a loan from the savings account
    public void savingLoan(double amount){
        this.loan += amount;
        this.savingdeposit(amount);
    }

    //Withdrawal from the checkings account
    public void checkingWithdraw(double amount){
        this.checking.withdraw(amount);
        this.realized -= amount;
        this.transactions.add("Checking -" + amount);
    }

    //Deposit from the checkings account
    public void checkingDeposit(double amount){
        this.checking.deposit(amount);
        this.realized += amount;
        this.transactions.add("Checking +" + amount);
    }

    //Taking out a loan from the checkings account
    public void checkingLoan(double amount){
        this.loan += amount;
        this.checkingDeposit(amount);
    }

    //Paying a portion or the whole loan. If the 
    //string is s then the money comes out of the
    //Savings account while c is checking account
    public void payLoan(double amount, String account){
        this.loan -= amount;

        if(account.equals("s")){
            if(this.loan < 0){
                this.savingWithdraw(amount + this.loan);
                this.loan = 0;
            }
            else{
                this.savingWithdraw(amount);
            }
        }
        else if(account.equals("c")){
            if(this.loan < 0){
                this.checkingWithdraw(amount + this.loan);
                this.loan = 0;
            }
            else{
                this.checkingWithdraw(amount);
            }
        }
    }

    //Returns a string of transactions
    public String getTransactions(){
        String ret = "";

        for(int i=0; i<this.transactions.size(); i++){
            ret += this.transactions.get(i);
        }
        
        return ret;
    }

}