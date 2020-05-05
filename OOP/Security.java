package OOP;
public class Stock {
    private double current_price;
    private String name;
    private int share;
    private double avg_price;
    private double available;



    public Stock(String n, double c){
        name = n;
        current_price = c;
    }

    public double getPrice(){
        return current_price;
    }

    public String getName(){
        return name;
    }

}
