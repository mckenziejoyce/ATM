package OOP;

import java.util.ArrayList;

public class StockMarket {
    private ArrayList<Stock> stockList;

    public StockMarket(){
        stockList = new ArrayList<Stock>();
    }
    public void addStock(Stock newStock){
        stockList.add(newStock);
    }
    public void removeStock(Stock stock){
        stockList.remove(stock);
    }
    public void setStockAvailability(int accountIndex,boolean avail){
        stockList.get(accountIndex-1).setAvailable(avail);
    }
    public void setStockPrice(int accountIndex,double value){
        stockList.get(accountIndex-1).setPrice(value);
    }

    public double getPriceByName(String name){
        for(Stock s:stockList){
            if(s.name == name) return s.getPrice();
        }
        return -1;
    }
}
