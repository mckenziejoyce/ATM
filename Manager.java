
public class Manager {
    private Customer[] customers;
    private double money;

    public Manager(double m){
        money = m;
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
}