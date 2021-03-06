package OOP;

public class OpeningStock extends Stock {
    protected int share;

    public int getShare(){
        return share;
    }

    public void setShare(int newShare){
        this.share = newShare;
    }

    public OpeningStock(String n, double p, int share) {
        super(n, p);
        this.share = share;
    }
    public void buyStock(double current_price, int share){
        this.price = (this.share * this.price + current_price * share)/(this.share+share);
        this.share += share;
    }
    public void sellStock(double current_price, int share){
        //need error check here; check could not exceed current share
        this.price = (this.share * this.price - current_price * share)/(this.share-share);
        this.share -= share;
    }


}
