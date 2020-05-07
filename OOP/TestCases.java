package OOP;

import java.util.ArrayList;
import java.util.List;

public class TestCases {
    private Manager m;
    private Customer c;

    public TestCases() {
    }

    public Customer customer1() {
        Customer c = new Customer("Anthony");
        c.makeSavingAccount(5000);
        c.makeCheckingAccount(1000);
        c.makeCheckingAccount(20);
        c.makeSecurityAccount(2000);
        return c;
    }
    public Customer customer2() {
        Customer c = new Customer("Mckenzie");
        c.makeSavingAccount(1000);
        c.makeSavingAccount(5000);
        c.makeCheckingAccount(1000);
        c.makeCheckingAccount(20);
        return c;
    }
    public Customer customer3() {
        Customer c = new Customer("Connie");
        c.makeSavingAccount(1000);
        c.makeCheckingAccount(1000);
        c.makeCheckingAccount(20);
        return c;
    }
    public static StockMarket market(){
        StockMarket market = new StockMarket();
        market.getStockList().add(new Stock("stock a",10));
        market.getStockList().add(new Stock("stock b",3));
        market.getStockList().add(new Stock("stock c",9));
        market.getStockList().add(new Stock("stock d",11));
        market.getStockList().add(new Stock("stock e",5));
        return market;
    }
    public ArrayList<OpeningStock> opening(){
        ArrayList<OpeningStock> open = new ArrayList<OpeningStock>();
        open.add(new OpeningStock("stock a",10,3));
        return open;
    }

    public Manager manager(){
        Manager m = new Manager();
        return m;
    }
    
}
