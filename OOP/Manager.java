package OOP;
import java.util.ArrayList;

public class Manager {
    private Customer[] customers;
    private double money;
    private StockMarket stockMarket;
    private ArrayList<Transactions> transactions;


    public Manager(){
        money = 0;
        transactions = new ArrayList<Transactions>();
    }

    //Prints out the transactions of all the customers
    public void printTransactions(){
        int len = this.customers.length;

        for(int i = 0; i<len; i++){
            System.out.println(this.customers[i].getTransactions());
        }
    }

    //Account fee added to the manager when an account is
    //created or closed
    public void accountFee(double fee){
        this.money +=  fee;
    }
    
    public void setCustomers(Customer[] c){
        this.customers = c;
    }
    
    public void setStockMarket(StockMarket sm){
        stockMarket = sm;
    }

    public ArrayList<Transactions> getTransactions(){
        return transactions;
    }

    public int numOfStocks(){
        return stockMarket.getStockList().size();
    }
   

    //Increases all the customer loans after a month passes
    public void increaseLoans(){
        int len = this.customers.length;

        for(int i = 0; i<len; i++){
            Loan loan = this.customers[i].getLoan();

            if(loan.monthPass()){
                loan.increaseLoan();;
            }
        }
    }
    public StockMarket getStocks(){
        return stockMarket;
    }
    public Customer[] getCustomers(){
      return customers;
    }

}
