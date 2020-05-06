package OOP;
public class Stock{
    private double cost;
    private String name;

    public Stock(String n, double c){
        name = n;
        cost = c;
    }

    public double getCost(){
        return cost;
    }

    public String getName(){
        return name;
    }

}