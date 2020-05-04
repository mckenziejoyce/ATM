package OOP;
import java.util.ArrayList;
import java.lang.Math;

public class Customer {
    protected String name;
    protected Checking checking;
    protected Saving saving;
    protected ArrayList<String> transactions;
    protected ArrayList<Account> accounts;  
    protected double realized; //Realized profit
    protected double unrealized; //Unrealized profit
    protected Loan loan; //The loan still left for the customer to pay
    protected String cur; //Currency 

    public Customer(String n){
        name = n;
        transactions = new ArrayList<String>();
        realized = 0;
        unrealized = 0;
        accounts = new ArrayList<Account>();
        cur = "USD";
    }

    public Loan getLoan(){
        return loan;
    }

    public Saving getSaving(){
        return saving;
    }

    public Checking getChecking(){
        return checking;
    }

    public String getCurrency(){
        return cur;
    }

    public void changeCurrency(String newCur){
        cur = newCur;
    }

    public ArrayList<Account> getAccounts(){
        return accounts;
    }

    public double getRealizedProfit(){
        return realized;
    }

    public double getUnrealizedProfit(){
        return unrealized;
    }

    public int numOfAccounts(){
        return this.accounts.size();
    }

    //Customer creates a Savings account
    public void makeSavingAccount(double cash, String cur){
        this.saving = new Saving(cash);
        this.accounts.add(this.saving);
    }

    //Customer creates a Checkings account
    public void makeCheckingAccount(double cash, String cur){
        this.checking = new Checking(cash);
        this.accounts.add(this.checking);
    }

    //Closes account
    public void closeAccount(int account){
        this.accounts.remove(account);
    }

    //Withdrawal from one of the accounts "s" for
    //the savings account and "c" for checking
    public void withdraw(double amount, String account){
        if(account.equals("s")){
            this.saving.withdraw(amount);
            this.realized -= amount;
            this.transactions.add("Savings -" + amount);
        }
        else if(account.equals("c")){
            this.checking.withdraw(amount);
            this.realized -= amount;
            this.transactions.add("Checking -" + amount);
        }
    }

    //Deposit from one of the accounts "s" for
    //the savings account and "c" for checking
    public void deposit(double amount, String account){
        if(account.equals("s")){
            this.saving.deposit(amount);
            this.realized += amount;
            this.transactions.add("Savings +" + amount);
        }
        else if(account.equals("c")){
            this.checking.deposit(amount);
            this.realized += amount;
            this.transactions.add("Checking +" + amount);
        }
    }

    //Taking out a loan
    public void applyLoan(double amount, double interest){
        this.loan = new Loan(amount, interest);
    }

    //Paying a portion or the whole loan. If the 
    //string is s then the money comes out of the
    //Savings account while c is checking account
    public void payLoan(double amount){
        this.loan.decreaseLoan(amount);
    }

    //Returns a string of transactions
    public ArrayList<String> getTransactions(){
        return transactions;
    }

    //Returns a string with the info of all the accounts and
    //loan balances
    public String accountInfo(){
        String ret = "";

        if(this.checking != null){
            ret += ("Checking " + checking.getAccountNumber() + " - " + "Balance " + checking.getBalance()+"/n");
        }

        if(this.saving != null){
            ret += ("Checking " + saving.getAccountNumber() + " - " + "Balance " + saving.getBalance()+"/n");
        }

        if(this.loan != null){
            ret += ("Loan " + " - " + "Balance " + loan.getMoney()+"/n");
        }

        return ret;
    }

    //Returns true if a customer is considered rich
    public boolean isRich(){
        return this.saving.getBalance() > 5000;
    }

    //Converts the the first currency value to the second
    public static double exchangeRate(String cur1, String cur2, double amount){
        if(cur1.equals("USD") && cur2.equals("EUR")){
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
        return Math.round(amount*100)/100;
    }

}