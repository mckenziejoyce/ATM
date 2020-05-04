package OOP;
import java.util.ArrayList;

public class Customer {
    protected String name;
    protected Checking checking;
    protected Saving saving;
    protected ArrayList<String> transactions;
    protected ArrayList<Account> accounts;  
    protected double realized; //Realized profit
    protected double unrealized; //Unrealized profit
    protected Loan loan; //The loan still left for the customer to pay

    public Customer(String n){
        name = n;
        transactions = new ArrayList<String>();
        realized = 0;
        unrealized = 0;
        accounts = new ArrayList<Account>();
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
        this.saving = new Saving(cash, cur);
        this.accounts.add(this.saving);
    }

    //Customer creates a Checkings account
    public void makeCheckingAccount(double cash, String cur){
        this.checking = new Checking(cash, cur);
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
    public void applyLoan(double amount, double interest, String account){
        this.loan = new Loan(amount, interest);
        this.transactions.add("Apply Loan +" + amount);
        if(account.equals("s")){
            this.deposit(amount, account);
        }
        else if(account.equals("c")){
            this.deposit(amount, account);
        }
    }

    //Paying a portion or the whole loan. If the 
    //string is s then the money comes out of the
    //Savings account while c is checking account
    public void payLoan(double amount, String account){
        this.loan.decreaseLoan(amount);

        if(account.equals("s")){
            if(this.loan.getMoney() < 0){
                this.withdraw(amount + this.loan.getMoney(), account);
                this.loan = null;
            }
            else{
                this.withdraw(amount, account);
            }
        }
        else if(account.equals("c")){
            if(this.loan.getMoney() < 0){
                this.withdraw(amount + this.loan.getMoney(), account);
                this.loan = null;
            }
            else{
                this.withdraw(amount, account);
            }
        }

        this.transactions.add("Loan Payment +" + amount);
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

}