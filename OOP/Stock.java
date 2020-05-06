package OOP;
public class Stock {
    protected double price;
    protected String name;
    protected boolean available;

    public Stock(String n, double p){
        name = n;
        price = p;
    }

    public double getPrice() {return price;}
    public String getName(){return name;}
    public boolean available(){return available; }

    public void setPrice(int price){ this.price = price;}
    public void setAvailable(boolean available){ this.available = available;}



}