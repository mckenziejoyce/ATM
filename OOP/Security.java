package OOP;

import java.util.ArrayList;

public class Security extends Account{

    protected ArrayList<String> transactions;
    protected ArrayList<OpeningStock> opening;
    protected double realProfit;
    protected double unrealProfit;
    protected double totalProfit;
    protected double principle;

    public Security(double money)
    {
        super(money);
        type = "Security";
        realProfit = 0;
        unrealProfit = 0;
        totalProfit = 0;
        principle = money;
    }
    public ArrayList<OpeningStock> getOpening(){ return opening; }

    public void setOpening(ArrayList<OpeningStock> open) {this.opening = open;}
    public void buyStock(Stock stock,int share) {
        //Error handling here
        //if(price * share > this.getBalance()){
        //}
        String name = stock.getName();
        double price = stock.getPrice();
        if(hasStock(name)){
            OpeningStock s = getStockName(name);
            s.buyStock(price,share);
        }else{
            OpeningStock s = new OpeningStock(name,price,share);
            opening.add(s);
        }
        this.setBalance(this.getBalance()- price * share);
    }

    public void sellStock(int i, int share, double price) {
        //Error handling here
        //if(to sell share > current share ){
        //}
        OpeningStock stock = getStockIndex(i);
        stock.sellStock(price,share);
        if(stock.share!=0) opening.add(stock);
        this.setBalance(this.getBalance()+ price * share);
    }

    public void closeStock(int index){opening.remove(index-1);}

    public OpeningStock getStockIndex(int index){
        OpeningStock s = opening.get(index-1);
        return s;
    }

    public boolean hasStock(String name){
        for (OpeningStock s:opening){
            if (s.name == name) return true;
        }
        return false;
    }

    public OpeningStock getStockName(String name){
        for (OpeningStock s:opening){
            if (s.name == name)
                return s;
        }
        return null;
    }

    public int numOfStocks(){
        return this.opening.size();
    }

    public double getPrinciple(){
        return principle;
    }

    public double getTotalProfit(){
        return totalProfit;
    }

    public double getRealizedProfit(){
        return realProfit;
    }

    public double getUnrealizedProfit(){
        return unrealProfit;
    }

    public void undapteTotalProfit(StockMarket market){
        double currentValue = 0;
        for (OpeningStock s:opening){
            currentValue += s.share * market.getPriceByName(s.name);
        }
        totalProfit = currentValue + this.getBalance() - this.principle;
    }

    public void updateUnrealProfit(StockMarket market){
        double currentValue = 0;
        double cost = 0;
        for (OpeningStock s:opening){
            cost += s.share*s.price;
            currentValue += s.share * market.getPriceByName(s.name);
        }
        totalProfit = currentValue -cost;
    }

    public double updateRealProfit(StockMarket market){
        undapteTotalProfit(market);
        updateUnrealProfit(market);
        realProfit = totalProfit - unrealProfit;
        return realProfit;
    }

}